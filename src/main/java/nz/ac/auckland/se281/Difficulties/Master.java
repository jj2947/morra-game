package nz.ac.auckland.se281.Difficulties;

import java.util.List;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.Strategies.Ai;
import nz.ac.auckland.se281.Strategies.Random;
import nz.ac.auckland.se281.Main.Difficulty;

public class Master implements AiDifficulty {

    Ai ai = new Ai(new Random());

    @Override
    public Input getAiInput(int roundNumber, List<Integer> inputs) {
        ai.changeStrategy(Difficulty.MASTER, roundNumber, inputs);
        return ai.play();
    }
}
