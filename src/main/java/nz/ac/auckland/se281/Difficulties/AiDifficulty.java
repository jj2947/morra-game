package nz.ac.auckland.se281.Difficulties;

import java.util.List;

import nz.ac.auckland.se281.Input;

public interface AiDifficulty {

    Input getAiInput(int roundNumber, List<Integer> inputs);

}