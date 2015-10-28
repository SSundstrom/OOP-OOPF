public class sort {

  public static void main(String[] args) {
    int[] a = generateRandomArray();
    printIntArray(a);
    a = sorting(a);
    printIntArray(a);

  }
  public static int[] sorting(int[] a) {
    for (int i = 0; i < a.length -1; i++) {
      for (int j = 0; j < a.length -1; j++) {
        if (a[j+1] < a[j]) {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
        }
      }
    }
    return a;
  }

// a)
  public static int[] generateRandomArray() {

    int randomLength = (int)(Math.random()*10);
    int[] array = new int[randomLength];
    System.out.println(randomLength);

    for (int i = 0; i < randomLength; i++) {
      array[i] = (int)(Math.random()*100);
    }
    return array;
  }

// b)
  public static boolean isInOrder(int[] array) {
    int temp = 0;
    for (int i : array) {
      if (i < temp) {
        return false;
      }
      temp = i;
    }
    return true;
  }

  public static void printIntArray(int[] array) {
    String a  = "";
    for (int i : array) {
      a = a + "[ " + i + " ]  ";
    }
    System.out.println(a);
    System.out.println(isInOrder(array));
  }

}
