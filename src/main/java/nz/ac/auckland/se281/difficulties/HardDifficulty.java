package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Top;

// Class used to represent the hard difficulty of the game
public class HardDifficulty extends AiDifficulty {

  // Constructor for the hard difficulty
  public HardDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    // If the round number is greater than 3, then the strategy is changed to the top strategy
    if (roundNumber > 3) {
      strategy = new Top(inputs);
    }

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
