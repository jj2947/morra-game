package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

// Implements the average strategy
public class Average implements Strategy {

  private double avg = 0;

  // Finds the average of the human players fingers inputs
  public Average(List<Integer> inputs) {

    // Loops through all the fingers inputs and adds them to the avg variable
    for (Integer fingers : inputs) {
      avg += fingers;
    }

    // Divides the avg variable by the number of inputs to find the average
    avg = avg / inputs.size();
    avg = Math.round(avg);
  }

  @Override
  public Input useStrategy() {

    // Generates a random number between 1 and 5 for the fingers
    int fingers = Utils.getRandomNumber(1, 5);

    // Adds the fingers to the average to get the sum
    int sum = fingers + (int) avg;

    // Creates a new input object and sets the values
    Input input = new Input("Jarvis");
    input.setFingers(String.valueOf(fingers));
    input.setSum(String.valueOf(sum));
    input.setValid(true);

    // Prints the AI's input
    MessageCli.PRINT_INFO_HAND.printMessage(
        input.getName(), String.valueOf(input.getFingers()), String.valueOf(input.getSum()));

    return input;
  }
}
