package nz.ac.auckland.se281.Difficulties;

import java.util.List;

import nz.ac.auckland.se281.Strategies.Average;

public class Hard extends Ai {

    @Override
    public void getStrategy(int roundNumber, List<Integer> inputs) {
        
        if (roundNumber > 3) {
            setStrategy(new Average(inputs));
        }

    }
}