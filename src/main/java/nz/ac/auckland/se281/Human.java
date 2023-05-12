package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private List<Input> inputs = new ArrayList<>();

    public Human(String name) {
        this.name = name;
    }

    public Input play() {
        MessageCli.ASK_INPUT.printMessage();

        String input = Utils.scanner.nextLine();
        Input playerInput = new Input(name);

        playerInput.isValidInput(input);
        boolean isValid = playerInput.isValid();

        while (!isValid) {
            MessageCli.INVALID_INPUT.printMessage();
            MessageCli.ASK_INPUT.printMessage();
            input = Utils.scanner.nextLine();
            playerInput.isValidInput(input);
            isValid = playerInput.isValid();
        }

        inputs.add(playerInput);
        MessageCli.PRINT_INFO_HAND.printMessage(name, String.valueOf(playerInput.getFingers()), String.valueOf(playerInput.getSum()));
        return playerInput;
    }
}
