package nz.ac.auckland.se281;

public class Players {

  private int pointsToWin;

  public Players(int pointsToWin) {
    this.pointsToWin = pointsToWin;
  }

  public boolean getWin(int aiWins, int humanWins, int roundNumber, String name) {
    if (aiWins == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundNumber));
      return true;
    } else if (humanWins == pointsToWin) {
      MessageCli.END_GAME.printMessage(name, String.valueOf(roundNumber));
      return true;
    }
    return false;
  }

  public String getRoundsToWin(int wins) {
    int roundsToWin = pointsToWin - wins;
    return String.valueOf(roundsToWin);
  }

  public String getResults(Input humanInput, Input aiInput) {

    if (humanInput.getSum() == aiInput.getSum()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return "DRAW";
    } else if (aiInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      return "AI";
    } else if (humanInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      return "HUMAN";
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return "DRAW";
    }
  }
}
