public class CounterModel {

    private int value = 0;

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


}