package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Random;

// Class used to represent the easy difficulty of the game
public class EasyDifficulty extends AiDifficulty {

  // Constructor for the easy difficulty
  public EasyDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
