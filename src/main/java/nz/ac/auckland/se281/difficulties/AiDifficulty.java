package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Strategy;

// Abstract class used to represent the difficulty of the game
public abstract class AiDifficulty {

  protected Strategy strategy;

  // Method that returns the AI's input
  public abstract Input getAiInput(int roundNumber, List<Integer> inputs);
}