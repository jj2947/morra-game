package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulties.AiDifficulty;
import nz.ac.auckland.se281.difficulties.AiFactory;

public class Morra {

  private int roundNumber;
  private String name;
  private Difficulty difficulty;
  private List<Integer> fingers;
  private boolean startedGame;
  private int aiWins;
  private int humanWins;
  Players players;

  public Morra() {
    fingers = new ArrayList<>();
    startedGame = false;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    fingers.clear();
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    roundNumber = 0;
    this.difficulty = difficulty;
    startedGame = true;
    aiWins = 0;
    humanWins = 0;
    players = new Players(pointsToWin);
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

    AiDifficulty aiDifficulty = AiFactory.createAi(difficulty);
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

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(humanWins), players.getRoundsToWin(humanWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", String.valueOf(aiWins), players.getRoundsToWin(aiWins));
  }
}
