package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Random implements Strategy {

  @Override
  public Input getInput() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    Input input = new Input("Jarvis");
    input.setFingers(String.valueOf(fingers));
    input.setSum(String.valueOf(sum));
    input.setValid(true);
    MessageCli.PRINT_INFO_HAND.printMessage(
        input.getName(), String.valueOf(input.getFingers()), String.valueOf(input.getSum()));
    return input;
  }
}
