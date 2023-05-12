package nz.ac.auckland.se281;

public class Input {

    private boolean isValid;
    private String fingers;
    private String sum;
    private String name;

    public Input(String name) {
        isValid = false;
        fingers = null;
        sum = null;
        this.name = name;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getFingers() {
        int intFingers = Integer.parseInt(fingers);
        return intFingers;
    }

    public int getSum() {
        int intSum = Integer.parseInt(sum);
        return intSum;
    }

    public String getName() {
        return name;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public void setFingers(String fingers) {
        this.fingers = fingers;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void isValidInput(String input) {

        int spaceIndexNum = 0;

        if (!Character.isDigit(input.charAt(0))) {
            setValid(false);
            return;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                spaceIndexNum = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < spaceIndexNum; i++) {
            if (Character.isDigit(input.charAt(i))) {
                sb.append(input.charAt(i));
            } else {
                setValid(false);
                return;
            }
        }

        StringBuilder sb2 = new StringBuilder();

        for (int i = spaceIndexNum + 1; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sb2.append(input.charAt(i));
            } else {
                setValid(false);
                return;
            }
        }

        String fingers = sb.toString();
        String sum = sb2.toString();

        if (Integer.parseInt(fingers) < 1 || Integer.parseInt(fingers) > 5 || Integer.parseInt(sum) < 1
                || Integer.parseInt(sum) > 10) {
            setValid(false);
            return;
        }

        setValid(true);
        setFingers(fingers);
        setSum(sum);
    }
}
