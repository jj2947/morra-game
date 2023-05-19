package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Random;

// Class used to represent the medium difficulty of the game
public class MediumDifficulty extends AiDifficulty {

  // Constructor for the medium difficulty
  public MediumDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    // If the round number is greater than 3, then the strategy is changed to the average strategy
    if (roundNumber == 4) {
      strategy = new Average(inputs);
    }

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
