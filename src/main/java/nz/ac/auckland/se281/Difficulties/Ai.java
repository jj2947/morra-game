package nz.ac.auckland.se281.Difficulties;

import java.util.List;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Strategies.Average;
import nz.ac.auckland.se281.Strategies.Strategy;
import nz.ac.auckland.se281.Strategies.Top;

public abstract class Ai {

    private Strategy strategy;
    
    public Ai(){
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    /*public void changeStrategy(Difficulty difficulty, int roundNumber, List<Integer> inputs) {
        if (difficulty == Difficulty.MEDIUM && roundNumber > 3) {
            setStrategy(new Average(inputs));
        } else if (difficulty == Difficulty.HARD && roundNumber > 3) {
            setStrategy(new Top(inputs));
        } else if (difficulty == Difficulty.MASTER && roundNumber > 3 && roundNumber % 2 == 0) {
            setStrategy(new Average(inputs));
        } else if (difficulty == Difficulty.MASTER && roundNumber > 3 && roundNumber % 2 != 0) {
            setStrategy(new Top(inputs));
        }
    }*/

    abstract public void getStrategy(int roundNumber, List<Integer> inputs);

    public Input play(){
        return strategy.strategy();
    }
}
