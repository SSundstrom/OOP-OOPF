public class kalk {
  private String displayText = "0";
  private String operand;
  private String memory = null;
  private boolean mvOnNextInt = false;

  public String getDisplayText() {
    return displayText;
  }

  public void pressKey(String key) {

    switch (key) {
      case "+" :
      case "-" :
      case "*" :
      case "/" :
        if (operand == null) {
          operand = key;
          mvOnNextInt = true;
        } else {
          pressKey("=");
          operand = key;
          mvOnNextInt = true;

        }
        break;

      case "=" :
        calculate();
        break;

      case "C" :
        displayText = "0";
        operand = null;
        memory = null;
        break;

      default :
        if (mvOnNextInt) {
          memory = displayText;
          displayText = "";
          mvOnNextInt = false;
        }
        if (displayText.equals("0")) {
          displayText = "";
        }
        displayText = displayText + "" + key;
    }
  }

  private void calculate() {

    if (memory == null) {
      return;
    }
    int firstNbr = parse(memory);
    int secondNbr = parse(displayText);
    int answer = 0;

    switch (operand) {
      case "+" :
        answer = firstNbr + secondNbr;
        break;
      case "-" :
        answer = firstNbr - secondNbr;
        break;
      case "*" :
        answer = firstNbr * secondNbr;
        break;
      case "/" :
        answer = firstNbr / secondNbr;
        break;
    }
    displayText = "" + answer;
    operand = null;

  }

  private int parse(String s) {
    return Integer.parseInt(s);
  }
}
