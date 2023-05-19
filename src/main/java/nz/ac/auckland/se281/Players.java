package nz.ac.auckland.se281;

// Class used to represent the players of the game
public class Players {

  private int pointsToWin;

  // Constructor for the players
  public Players(int pointsToWin) {
    this.pointsToWin = pointsToWin;
  }

  // Method that returns whether or not a player has won the game
  public boolean getWin(int aiWins, int humanWins, int roundNumber, String name) {

    // If the AI has won the game, then print AI wins and return true
    if (aiWins == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundNumber));
      return true;

      // If the human has won the game, then print human wins and return true
    } else if (humanWins == pointsToWin) {
      MessageCli.END_GAME.printMessage(name, String.valueOf(roundNumber));
      return true;
    }

    // If neither the AI nor the human has won the game, then return false
    return false;
  }

  // Method that returns the number of rounds left to win the game
  public String getRoundsToWin(int wins) {

    // Finds the rounds to win and returns it as a string
    int roundsToWin = pointsToWin - wins;
    return String.valueOf(roundsToWin);
  }

  // Method that returns the results of the round
  public String getResults(Input humanInput, Input aiInput) {

    // If the AI and human guess the same sum, then print draw and return draw
    if (humanInput.getSum() == aiInput.getSum()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return "DRAW";
      // If the AI guesses the sum correctly, then print AI wins and return AI
    } else if (aiInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      return "AI";
      // If the human guesses the sum correctly, then print human wins and return human
    } else if (humanInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      return "HUMAN";
      // If neither the AI nor the human guesses the sum correctly, then print draw return draw
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return "DRAW";
    }
  }

  // Method that prints the number of wins for the AI
  public void printWins(String name, int playerWins) {
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(playerWins), getRoundsToWin(playerWins));
  }
}
