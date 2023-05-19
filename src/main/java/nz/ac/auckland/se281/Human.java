package nz.ac.auckland.se281;

// Class for the human player
public class Human {

  private String name;

  // Constructor
  public Human(String name) {
    this.name = name;
  }

  // Gets and returns the name of the player and their input
  public Input play() {

    // Asks the player for their input
    MessageCli.ASK_INPUT.printMessage();

    // Gets the player's input
    String input = Utils.scanner.nextLine();

    // Creates a new input object
    Input playerInput = new Input(name);

    // Checks if the player's input is valid
    playerInput.isValidInput(input);
    boolean isValid = playerInput.isValid();

    // If the player's input is not valid, print error message and ask for input again
    while (!isValid) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      playerInput.isValidInput(input);
      isValid = playerInput.isValid();
    }

    // If the player's input is valid, print the player's name, number of fingers and sum
    MessageCli.PRINT_INFO_HAND.printMessage(
        name, String.valueOf(playerInput.getFingers()), String.valueOf(playerInput.getSum()));
    return playerInput;
  }
}
