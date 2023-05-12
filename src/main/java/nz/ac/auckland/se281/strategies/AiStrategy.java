package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.difficulties.AiDifficulty;
import nz.ac.auckland.se281.difficulties.HardDifficulty;
import nz.ac.auckland.se281.difficulties.MasterDifficulty;
import nz.ac.auckland.se281.difficulties.MediumDifficulty;

public class AiStrategy {

  private Strategy strategy;
  private AiDifficulty difficulty;

  public AiStrategy(AiDifficulty difficulty, Strategy strategy) {
    this.difficulty = difficulty;
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public void changeStrategy(int roundNumber, List<Integer> inputs) {
    if (difficulty instanceof MediumDifficulty) {
      setStrategy(new Average(inputs));
    } else if (difficulty instanceof HardDifficulty) {
      setStrategy(new Top(inputs));
    } else if (difficulty instanceof MasterDifficulty && roundNumber % 2 == 0) {
      setStrategy(new Average(inputs));
    } else if (difficulty instanceof MasterDifficulty && roundNumber % 2 != 0) {
      setStrategy(new Top(inputs));
    }
  }

  public Input play() {
    return strategy.getAction();
  }
}
