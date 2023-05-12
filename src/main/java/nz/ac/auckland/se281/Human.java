package nz.ac.auckland.se281;

public class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void play() {
        MessageCli.ASK_INPUT.printMessage();

        String input = Utils.scanner.nextLine();
        Input playerInput = new Input();

        playerInput.isValidInput(input);
        boolean isValid = playerInput.isValid();

        while (!isValid) {
            MessageCli.INVALID_INPUT.printMessage();
            MessageCli.ASK_INPUT.printMessage();
            input = Utils.scanner.nextLine();
            playerInput.isValidInput(input);
            isValid = playerInput.isValid();
        }

        MessageCli.PRINT_INFO_HAND.printMessage(name, playerInput.getFingers(), playerInput.getSum());
    }
}
