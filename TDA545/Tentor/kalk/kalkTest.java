public class kalkTest {

  public static void main(String[] args) {

    kalk c = new kalk();
    kalk c1 = new kalk();
    kalk c2 = new kalk();

    c.pressKey("C");
    System.out.println("display = " + c.getDisplayText());
    c.pressKey("1");
    System.out.println("display = " + c.getDisplayText());
    c.pressKey("2");
    System.out.println("display = " + c.getDisplayText());
    c.pressKey("+");
    System.out.println("display = " + c.getDisplayText());
    c.pressKey("5");
    System.out.println("display = " + c.getDisplayText());
    c.pressKey("=");
    System.out.println("answer = " + c.getDisplayText());
    System.out.println();

    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("C");
    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("1");
    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("2");
    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("+");
    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("5");
    System.out.println("display = " + c1.getDisplayText());
    c1.pressKey("C");
    System.out.println("answer = " + c1.getDisplayText());
    System.out.println();

    c2.pressKey("C");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("1");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("+");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("2");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("*");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("3");
    System.out.println("display = " + c2.getDisplayText());
    c2.pressKey("=");
    System.out.println("answer = " + c2.getDisplayText());

  }
}
