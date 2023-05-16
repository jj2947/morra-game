package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulties.AiDifficulty;
import nz.ac.auckland.se281.difficulties.AiFactory;

public class Morra {

  private int roundNumber;
  private String name;
  private List<Integer> fingers;
  private boolean startedGame;
  private int aiWins;
  private int humanWins;
  private Players players;
  private AiDifficulty aiDifficulty;

  public Morra() {
    fingers = new ArrayList<>();
    startedGame = false;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    fingers.clear();
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    roundNumber = 0;
    startedGame = true;
    aiWins = 0;
    humanWins = 0;
    players = new Players(pointsToWin);

    // Creates Ai instance based on difficulty level given by player
    aiDifficulty = AiFactory.createAi(difficulty);
  }

  public void play() {

    if (!startedGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    Human human = new Human(name);
    Input humanInput = human.play();

    // The aiDifficulty object takes the aiStrategy object as a parameter to select the right
    // strategy and get the ai's input for the game
    Input aiInput = aiDifficulty.getAiInput(roundNumber, fingers);

    fingers.add(humanInput.getFingers());
    String winner = players.getResults(humanInput, aiInput);

    if (winner.equals("AI")) {
      aiWins++;
    } else if (winner.equals("HUMAN")) {
      humanWins++;
    }

    if (players.getWin(aiWins, humanWins, roundNumber, name) == true) {
      startedGame = false;
    }
  }

  public void showStats() {
    if (!startedGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    players.printWins(name, humanWins);
    players.printWins("Jarvis", aiWins);
  }
}
