package nz.ac.auckland.se281.Strategies;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Top implements Strategy {

  List<Integer> fingers;
  int top;

  public Top(List<Integer> fingers) {
    this.fingers = fingers;
  }

  private int getTop() {
    int count;
    int highestCount = 0;
    int top = fingers.get(0);

    for (int i = 0; i < fingers.size(); i++) {
      count = 0;
      for (int j = 0; j < fingers.size(); j++) {
        if (fingers.get(i) == fingers.get(j)) {
          count++;

          if (count > highestCount) {
            top = fingers.get(i);
            highestCount = count;
          }
        }
      }
    }
    return top;
  }

  @Override
  public Input strategy() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = fingers + getTop();
    Input input = new Input("Jarvis");
    input.setFingers(String.valueOf(fingers));
    input.setSum(String.valueOf(sum));
    input.setValid(true);
    MessageCli.PRINT_INFO_HAND.printMessage(
        input.getName(), String.valueOf(input.getFingers()), String.valueOf(input.getSum()));
    return input;
  }
}
