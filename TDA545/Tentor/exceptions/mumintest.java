public class mumintest {
  public static void main(String[] args) {
    System.out.println(f(4));
}
  public static String f(int k) {
    if (k < 1) {
      return "";
    } else {
      return f(k-1) + k + f(k-1);
    }
  }
}
