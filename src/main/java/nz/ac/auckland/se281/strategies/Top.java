package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

// Implements the Top strategy
public class Top implements Strategy {

  private List<Integer> fingers;

  // Constructor
  public Top(List<Integer> fingers) {
    this.fingers = fingers;
  }

  // Returns the most common number in the list
  private int getTop() {
    int count;
    int highestCount = 0;
    int top = fingers.get(0);

    // Loop through the list and count the number of times each number appears
    for (int i = 0; i < fingers.size(); i++) {
      count = 0;
      for (int j = 0; j < fingers.size(); j++) {

        // If the number appears more than the current highest count, set it as the new highest
        if (fingers.get(i) == fingers.get(j)) {
          count++;

          // If the number appears more times than the top, set it as the new top
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
  public Input useStrategy() {

    // Get a random number between 1 and 5 for the number of fingers
    int fingers = Utils.getRandomNumber(1, 5);

    // Get the top value and add it to the number of fingers for the sum
    int sum = fingers + getTop();

    // Create a new input object and set the values
    Input input = new Input("Jarvis");
    input.setFingers(String.valueOf(fingers));
    input.setSum(String.valueOf(sum));
    input.setValid(true);

    // Print the AI's input
    MessageCli.PRINT_INFO_HAND.printMessage(
        input.getName(), String.valueOf(input.getFingers()), String.valueOf(input.getSum()));
        
    return input;
  }
}
