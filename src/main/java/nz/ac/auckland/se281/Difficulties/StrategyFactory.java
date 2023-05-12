package nz.ac.auckland.se281.Difficulties;

public class StrategyFactory {
    
    public Difficulty createAi(Difficulty difficulty) {
        if (difficulty instanceof Easy) {
            return new Easy();
        } else if (difficulty instanceof Medium) {
            return new Medium();
        } else if (difficulty instanceof Hard) {
            return new Hard();
        } else {
            return null;
        }
    }
}
