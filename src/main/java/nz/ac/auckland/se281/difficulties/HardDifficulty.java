package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.AiStrategy;

public class HardDifficulty implements AiDifficulty {

  @Override
  public Input getAiInput(AiStrategy ai, int roundNumber, List<Integer> inputs) {
    if (roundNumber == 4) {
      ai.changeStrategy(roundNumber, inputs);
    }
    return ai.play();
  }
}
