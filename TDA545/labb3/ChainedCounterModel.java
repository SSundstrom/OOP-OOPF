
public class ChainedCounterModel extends CounterModel implements  CounterInterface {
    private CounterInterface next;

    /**
     * Initialize with start value, modulus value and next CounterInterface
     * @param init Start value for clock
     * @param modulus Value for  modulus
     * @param next next CounterInterface
     */
    ChainedCounterModel(int init, int modulus, CounterInterface next) {
        super(modulus);
        for(int i = 0; i < init; i++){
            super.increment();
        }
        this.next = next;
    }

    /**
     * Increase counter value
     * calls next counters increment if value is zero and next increment is not null
     */
    public void increment() {
        super.increment();
        if (super.getValue() == 0 && this.next != null) {
            next.increment();
        }
    }
}
