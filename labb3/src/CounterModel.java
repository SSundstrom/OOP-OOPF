public class CounterModel {

    private int value = 0;
    private static int nbrOfCounters;

    public CounterModel() {
        nbrOfCounters++;
    }

    public void increment () {
        value++;
    }
    public void decrement() {
        value--;
    }
    public void reset() {
        value = 0;
    }
    public int getValue() {
        return value;
    }
    public static int getNbrOfCounters() {
        return nbrOfCounters;
    }


}