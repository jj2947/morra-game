package nz.ac.auckland.se281.Strategies;

import java.util.List;

import nz.ac.auckland.se281.Input;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Average implements Strategy {

    private double avg = 0;

    public Average(List<Integer> inputs) {

        for (Integer fingers : inputs) {
            avg += fingers;
        }

        avg = avg / inputs.size();
        avg = Math.round(avg);
    }

    @Override
    public Input strategy() {
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = fingers + (int) avg;
        Input input = new Input("Jarvis");
        input.setFingers(String.valueOf(fingers));
        input.setSum(String.valueOf(sum));
        input.setValid(true);
        MessageCli.PRINT_INFO_HAND.printMessage(input.getName(), String.valueOf(input.getFingers()),
                String.valueOf(input.getSum()));
        return input;
    }

}
