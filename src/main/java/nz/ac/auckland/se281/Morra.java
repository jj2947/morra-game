package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Strategies.Random;
import nz.ac.auckland.se281.Strategies.Strategy;

public class Morra {

  int roundNumber;
  String name;

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    roundNumber = 0;
  }

  public void play() {

    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    Human human = new Human(name);
    Input humanInput = human.play();

    AI ai = new AI(new Random());
    Input aiInput = ai.play();

    printResults(humanInput, aiInput);
  }

  private void printResults(Input humanInput, Input aiInput) {

    if (humanInput.getSum() == aiInput.getSum()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (aiInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else if (humanInput.getSum() == aiInput.getFingers() + humanInput.getFingers()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void showStats() {
  }
}
