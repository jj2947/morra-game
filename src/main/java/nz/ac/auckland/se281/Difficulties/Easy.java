package nz.ac.auckland.se281.Difficulties;

import java.util.List;
import java.util.Random;

import nz.ac.auckland.se281.Strategies.Ai;
import nz.ac.auckland.se281.Strategies.Average;
import nz.ac.auckland.se281.Strategies.Strategy;

public class Easy implements Difficulty {

    Ai aiMove = new Ai((Strategy) new Random());

    @Override
    public void changeStrategy(int roundNumber, List<Integer> inputs) {
        
        if (roundNumber > 3) {
            aiMove.setStrategy(new Average(inputs));
        }

    }
}