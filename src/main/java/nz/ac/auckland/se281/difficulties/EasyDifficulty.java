package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Strategy;

// Class used to represent the easy difficulty of the game
public class EasyDifficulty extends AiDifficulty {

  // Constructor for the easy difficulty
  public EasyDifficulty(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public Input getAiInput() {

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
