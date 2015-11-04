
class IntIntEx extends Exception {
    private int a;
    private int b;
    public IntIntEx(int i, int j) {
      a = i;
      b = j;
    }
  }

public class egen {

  public static void main(String[] args) {
    egen e = new egen();
  }
  public egen(){
    int i = 0;
    int j = 4;
    boolean ejKlar = true;
    do {
    try {
      if (i > j) {
        throw new IntIntEx(i, j);
      } else {
        System.out.println("Det här går ju bra");
        i++;
      }
    } catch (IntIntEx e) {
      System.out.println("e.a = " + e.a + "\ne.b = " + e.b);
      ejKlar = false;
    }
  } while (ejKlar);
  }

}
