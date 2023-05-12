package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Strategies.Strategy;

public class AI {

    private Strategy strategy;
    
    public AI(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy() {
        this.strategy = strategy;
    }
    
    public Input play(){
        return strategy.strategy();
    }
}
