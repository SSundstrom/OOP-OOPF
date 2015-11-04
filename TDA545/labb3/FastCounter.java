public class FastCounter extends CounterModel {

    private int step;

    /**
     * Initialize default values
     */
    public FastCounter(){
        this(5);

    }

    /**
     * Initialize default and own value
     * @param step How many times methods goes
     */
    public FastCounter(int step){
        super(15);
        this.step = step;
    }

    /**
     * Initialize with input values values
     * @param step How many x you want to increment with
     * @param  modulus The counters modulus value
     */
    public FastCounter(int step, int modulus){
        super(modulus);
        this.step = step;
    }

    /**
     * Increase value x times
     */
    public void upMany(){
        for(int i = 0; i < step; i++){
           super.increment();
        }

    }

    /**
     * Decrease value x times
     */
    public void downMany() {
        for (int i = 0; i <= step; i++) {
            super.decrement();
        }
    }

    /**
     * Getter for Steps
     * @return How many times increment or decrement goes
     */
    public int getStep(){

        return step;
    }
}
