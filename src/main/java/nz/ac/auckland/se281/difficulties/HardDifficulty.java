package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Top;

public class HardDifficulty extends AiDifficulty {

  public HardDifficulty() {
    this.strategy = new Random();
  }

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {

    if (roundNumber > 3) {
      strategy = new Top(inputs);
    }
    return strategy.getAction();
  }
}
