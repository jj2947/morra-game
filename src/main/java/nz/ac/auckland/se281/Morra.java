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
  private List<Integer> inputs;

  // Constructor
  public Morra() {
    fingers = new ArrayList<>();
    startedGame = false;
  }

  // Implements the new_game command
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
    aiDifficulty = AiFactory.createAi(difficulty, this);
  }

  // Implements the play command
  public void play() {

    // If the game hasn't started print error message
    if (!startedGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // If the game has started, increment the round number and print the round number
    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    // Create a new human object and get the human's input for the game
    Human human = new Human(name);
    Input humanInput = human.play();

    // Inputs for the AI to use
    inputs = fingers;

    // The aiDifficulty object takes the aiStrategy object as a parameter to select the right
    // strategy and get the ai's input for the game
    Input aiInput = aiDifficulty.getAiInput();

    // Add the human's input to the fingers list
    fingers.add(humanInput.getFingers());

    // Checks if there is a winner and prints the outcome of the round
    String winner = players.getResults(humanInput, aiInput);

    // Adds to their win counters if a plyer wins
    if (winner.equals("AI")) {
      aiWins++;
    } else if (winner.equals("HUMAN")) {
      humanWins++;
    }

    // Checks if there is a winner of the game and exits the game
    if (players.getWin(aiWins, humanWins, roundNumber, name)) {
      startedGame = false;
    }
  }

  // Implements the show_stats command
  public void showStats() {

    // If the game hasn't started print error message
    if (!startedGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Prints the stats of each player
    players.printWins(name, humanWins);
    players.printWins("Jarvis", aiWins);
  }

  // Gets the round number
  public int getRoundNumber() {
    return roundNumber;
  }

  // Gets the list of fingers for the AI
  public List<Integer> getFingers() {
    return inputs;
  }
}
