package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Strategies.Average;
import nz.ac.auckland.se281.Strategies.Strategy;

public class AI {

    private Strategy strategy;
    
    public AI(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void changeStrategy(Difficulty difficulty, int roundNumber, List<Integer> inputs) {
        if (difficulty == Difficulty.MEDIUM && roundNumber > 3) {
            setStrategy(new Average(inputs));
        }
    }

    public Input play(){
        return strategy.strategy();
    }
}
