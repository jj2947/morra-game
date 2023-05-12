package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.AiStrategy;

public class MasterDifficulty implements AiDifficulty {

  private AiStrategy ai = new AiStrategy(this);

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {
    ai.changeStrategy(roundNumber, inputs);
    return ai.play();
  }
}
