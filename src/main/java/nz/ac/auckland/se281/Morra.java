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
    roundNumber = 1;
  }

  public void play() {

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    roundNumber++;

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    while (!isValidInput(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      isValidInput(input);
    }

    MessageCli.PRINT_INFO_HAND.printMessage(name, );
  }

  private boolean isValidInput(String input) {

    int spaceIndexNum = 0;

    if (!Character.isDigit(input.charAt(0))) {
      return false;
    }

    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        spaceIndexNum = i;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < spaceIndexNum; i++) {
      if (Character.isDigit(input.charAt(i))) {
        sb.append(input.charAt(i));
      } else {
        return false;
      }
    }

    StringBuilder sb2 = new StringBuilder();

    for (int i = spaceIndexNum + 1; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        sb2.append(input.charAt(i));
      } else {
        return false;
      }
    }

    String fingers = sb.toString();
    String sum = sb2.toString();

    if (Integer.parseInt(fingers) < 1 || Integer.parseInt(fingers) > 5 || Integer.parseInt(sum) < 1
        || Integer.parseInt(sum) > 10) {
          return false;
    }

    return true;
  }

  public void showStats() {
  }
}
