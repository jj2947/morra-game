package nz.ac.auckland.se281.Strategies;
import nz.ac.auckland.se281.Utils;
import nz.ac.auckland.se281.Input;

public class Random implements Strategy{

    @Override
    public Input strategy() {
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
        Input input = new Input();
        input.setFingers(String.valueOf(fingers));
        input.setSum(String.valueOf(sum));
        input.setValid(true);
        return input;
    }
}
