package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Top;

// Class used to represent the master difficulty of the game
public class MasterDifficulty extends AiDifficulty {

  // Constructor for the master difficulty
  public MasterDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    // If the round number is greater than 3 and an even number, then the strategy is changed to the
    // average strategy
    if (roundNumber > 3 && roundNumber % 2 == 0) {
      setStrategy(new Average(inputs));
      // If the round number is greater than 3 and an odd number, then the strategy is changed to
      // the top strategy
    } else if (roundNumber > 3 && roundNumber % 2 == 1) {
      setStrategy(new Top(inputs));
    }

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
