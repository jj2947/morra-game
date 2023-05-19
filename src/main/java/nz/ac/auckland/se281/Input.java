package nz.ac.auckland.se281;

// Class for the player's input
public class Input {

  private boolean isValid;
  private String fingers;
  private String sum;
  private String name;

  // Constructor for each players input
  public Input(String name) {
    isValid = false;
    fingers = null;
    sum = null;
    this.name = name;
  }

  // Returns if a move is valid or not
  public boolean isValid() {
    return isValid;
  }

  // Returns the number of fingers the player wants to put out
  public int getFingers() {
    int intFingers = Integer.parseInt(fingers);
    return intFingers;
  }

  // Returns the sum the player wants to guess
  public int getSum() {
    int intSum = Integer.parseInt(sum);
    return intSum;
  }

  // Returns the name of the player
  public String getName() {
    return name;
  }

  // Sets the validity of the move
  public void setValid(boolean isValid) {
    this.isValid = isValid;
  }

  // Sets the number of fingers the player wants to put out
  public void setFingers(String fingers) {
    this.fingers = fingers;
  }

  // Sets the sum the player wants to guess
  public void setSum(String sum) {
    this.sum = sum;
  }

  // Checks if the player's input is valid
  public void isValidInput(String input) {

    int spaceIndexNum = 0;

    // If the first character isn't a digit, the input is invalid
    if (!Character.isDigit(input.charAt(0))) {
      setValid(false);
      return;
    }

    // Finds the first space in the input
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        spaceIndexNum = i;
        break;
      }
    }

    // Creates new string builder object for all characters before the space
    StringBuilder sb = new StringBuilder();

    // Appends the digits before the space to the string builder object if they are digits
    for (int i = 0; i < spaceIndexNum; i++) {
      if (Character.isDigit(input.charAt(i))) {
        sb.append(input.charAt(i));
      } else { // If the character isn't a digit, the input is invalid
        setValid(false);
        return;
      }
    }

    // Creates new string builder object for all characters after the space
    StringBuilder sb2 = new StringBuilder();

    // Appends the digits after the space to the string builder object if they are digits
    for (int i = spaceIndexNum + 1; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        sb2.append(input.charAt(i));
      } else { // If the character isn't a digit, the input is invalid
        setValid(false);
        return;
      }
    }

    // Converts the string builder objects to strings
    String fingers = sb.toString();
    String sum = sb2.toString();

    // If the strings are empty, the input is invalid
    if (fingers.length() == 0 || sum.length() == 0) {
      setValid(false);
      return;
    }

    // If the strings are not empty, check if their values are valid
    if (Integer.parseInt(fingers) < 1
        || Integer.parseInt(fingers) > 5
        || Integer.parseInt(sum) < 1
        || Integer.parseInt(sum) > 10) {
      setValid(false);
      return;
    }

    // If the strings are valid, set the fingers and sum and set the input to valid
    setValid(true);
    setFingers(fingers);
    setSum(sum);
  }
}
