package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Input {
    
    private boolean isValid;
    private String fingers;
    private String sum;
    private List<String> InputList;

    public Input() {
        isValid = false;
        fingers = "";
        sum = "";
        InputList = new ArrayList<>();
    }

    public boolean isValid() {
        return isValid;
    }

    public String getFingers() {
        return fingers;
    }

    public String getSum() {
        return sum;
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

    public List<String> getInputList() {
        return InputList;
    }
}
