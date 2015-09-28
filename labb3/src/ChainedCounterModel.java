
public class ChainedCounterModel extends CounterModel implements  CounterInterface {
    private CounterInterface next;

    ChainedCounterModel(int init, int modulus, CounterInterface next) {
        super(modulus);
        for(int i = 0; i < init; i++){
            super.increment();
        }
        this.next = next;
    }

    public void increment() {
        super.increment();
        if (super.getValue() == 0 && this.next != null) {
            next.increment();
        }
    }

    public void decrement() {
        super.decrement();
    }

    public void reset() {
        super.reset();
    }

}
