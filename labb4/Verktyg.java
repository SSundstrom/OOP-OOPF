import java.util.Random;

public class Verktyg {

    /**
     * Method to randomize an array
     * @param ar The array to randomize
     */
    public static void slumpOrdning(Object[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Object a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
