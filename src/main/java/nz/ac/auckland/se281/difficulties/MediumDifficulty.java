package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Random;

public class MediumDifficulty extends AiDifficulty {

  public MediumDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    if (roundNumber == 4) {
      strategy = new Average(inputs);
    }
    return strategy.getAction();
  }
}
