package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

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

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    Input inputInfo = new Input();
    inputInfo.isValidInput(input);
    boolean isValid = inputInfo.isValid();

    while (!isValid) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      inputInfo.isValidInput(input);
      isValid = inputInfo.isValid();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(name, inputInfo.getFingers(), inputInfo.getSum());
  }

  public void showStats() {
  }
}
