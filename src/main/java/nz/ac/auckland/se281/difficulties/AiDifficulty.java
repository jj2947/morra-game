package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.strategies.Strategy;

public abstract class AiDifficulty {

  protected Strategy strategy;

  public abstract Input getAiInput( int roundNumber, List<Integer> inputs);
}
