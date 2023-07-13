package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.Morra;
import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Strategy;

// Class used to represent the medium difficulty of the game
public class MediumDifficulty extends AiDifficulty {

  private Morra game;
  private List<Integer> inputs;
  private int roundNumber;

  // Constructor for the medium difficulty
  public MediumDifficulty(Strategy strategy, Morra game) {
    this.strategy = strategy;
    this.game = game;
  }

  @Override
  public Input getAiInput() {

    // Gets the round number and the list of inputs from the game object
    roundNumber = game.getRoundNumber();
    inputs = game.getFingers();

    // If the round number is greater than 3, then the strategy is changed to the average strategy
    if (roundNumber > 3) {
      setStrategy(new Average(inputs));
    }

    // Returns the AI's input using the correct strategy
    return strategy.useStrategy();
  }
}
