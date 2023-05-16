package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Top;

public class MasterDifficulty extends AiDifficulty {

  public MasterDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    if (roundNumber > 3 && roundNumber % 2 == 0) {
      strategy = new Average(inputs);
    } else if (roundNumber > 3 && roundNumber % 2 == 1) {
      strategy = new Top(inputs);
    }
    return strategy.getAction();
  }
}
