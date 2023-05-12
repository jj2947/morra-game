package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.AiStrategy;

public class EasyDifficulty implements AiDifficulty {

  @Override
  public Input getAiInput(AiStrategy ai, int roundNumber, List<Integer> inputs) {
    return ai.play();
  }
}
