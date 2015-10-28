public class test {
  public static void main(String[] args) {
    Luffarschack l = new Luffarschack(10,10);
/*
    l.printBoard();

    for (int i = 0; i < 6; i++) {
      l.choose(i,i);
    }
    l.printBoard();

    for (int j = 5; j < 8; j++) {
    for (int i = 0; i < 4; i++) {
      l.choose(i, j);
    }
    }
    */
    l.printBoard();
    l.choose(5,5);
    l.choose(6,5);
    l.choose(0,3);
    l.printBoard();

  }
}
