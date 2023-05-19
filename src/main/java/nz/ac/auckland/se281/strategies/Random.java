package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

// Strategy that returns a random number of fingers and a random sum
public class Random implements Strategy {

  @Override
  public Input useStrategy() {

    // Generate random numbers for fingers and sum
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

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
