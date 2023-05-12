package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.strategies.Ai;
import nz.ac.auckland.se281.strategies.Random;

public class HardDifficulty implements AiDifficulty {

  private Ai ai = new Ai(new Random());

  @Override
  public Input getAiInput(int roundNumber, List<Integer> inputs) {
    ai.changeStrategy(Difficulty.HARD, roundNumber, inputs);
    return ai.play();
  }
}
