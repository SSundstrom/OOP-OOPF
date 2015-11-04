public class Luffarschack {

  public enum Cell { X, O, EMPTY };

  int width;
  int height;
  Cell[][] board;
  boolean xTurnNext;

  public Luffarschack(int width, int height) {

    xTurnNext = true;
    this.width = width;
    this.height = height;
    board = new Cell[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        board[i][j] = Cell.EMPTY;
      }
    }
  }

  public void choose(int i, int j) throws IllegalArgumentException {

    if (i > width || i < 0 || j > height || j < 0) {
      throw new IllegalArgumentException("Out of bounds");
    }

    if (board[i][j] != Cell.EMPTY) {
      throw new IllegalArgumentException("Space taken");
    }

    if (xTurnNext) {
      board[i][j] = Cell.X;
    } else {
      board[i][j] = Cell.O;
    }

    xTurnNext = !xTurnNext;

    if(winner(i, j)) {
      System.out.println(hasFiveInARow());
    }

  }

  public boolean winner (int i, int j) {

    Cell mark = board[i][j];
    int horizontal = 0;
    int vertical = 0;
    int diagonal1 = 0;
    int diagonal2 = 0;

    int x1 = -4;
    int x2 = 5;
    int y1 = -4;
    int y2 = 5;

    if (i+x1 < 0) {
      x1 = 0 - i;
    }
    if (i+x2 > width) {
      x2 = width - i;
    }
    if (j+y1 < 0) {
      y1 = 0 - j;
    }
    if (j+y2 > height) {
      y2 = height - j;
    }
    System.out.println("x1 = " + x1);
    System.out.println("y1 = " + y1);
    System.out.println("x2 = " + x2);
    System.out.println("y2 = " + y2);

    for (int a = x1; a < x2; a++) {
      for (int b = y1; b < y2; b++) {
        if (mark == board[i][j+b]) {
          horizontal++;
        } else {
          horizontal = 0;
        }
        if (mark == board[i+a][j+b]) {
          diagonal1++;
        } else {
          diagonal1 = 0;
        }
        if (mark == board[i-a][j+b]) {
          diagonal2++;
        } else {
          diagonal2 = 0;
        }
        if (horizontal > 4 || diagonal1 > 4 || diagonal2 > 4) {
          System.out.println("horizontal = " + horizontal);
          System.out.println("diagonal1 = " + diagonal1);
          System.out.println("diagonal2 = " + diagonal2);
          return true;
        }
      }
      if (mark == board[i+a][j]) {
        vertical++;
        if (vertical > 4) {
          System.out.println("vertical = " + vertical);
          return true;
        }
      } else {
        vertical = 0;
      }
    }
    return false;

  }
  public boolean hasFiveInARow() {
    return true;
  }

  public void printBoard() {
    System.out.println();
    for (int i = 0; i < width; i++) {
      String a = "";
      String b = "";

      for (int j = 0; j < height; j++) {

        if (board[i][j] == Cell.X) {
          a = a + "| x ";
          b = b + "----";
        } else if (board[i][j] == Cell.O) {
          a = a + "| o ";
          b = b + "----";
        } else {
          a = a + "|   ";
          b = b + "----";
        }
      }
      a = a + "|";
      b = b + "-";
      System.out.println(a);
      System.out.println(b);
    }
    System.out.println();
  }
}
