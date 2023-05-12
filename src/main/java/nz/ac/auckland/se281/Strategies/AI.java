package nz.ac.auckland.se281.Strategies;

import java.util.List;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.Main.Difficulty;

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
        } else if (difficulty == Difficulty.HARD && roundNumber > 3) {
            setStrategy(new Top(inputs));
        }
    }

    public Input play(){
        return strategy.strategy();
    }
}
