package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Strategy;

// Abstract class used to represent the difficulty of the game
public abstract class AiDifficulty {

  protected Strategy strategy;

  // Method that sets the strategy
  protected void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  // Method that returns the AI's input
  public abstract Input getAiInput();
}
