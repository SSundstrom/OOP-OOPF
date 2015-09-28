public class CounterModel {
    private int value;
    private int modulus;
    private static int NbrOfCounters;

    /**
     * Initialize defualt values
     */
    public CounterModel(){

        this(10);
    }

    /**
     * Initialize with modulus value
     * IF parameter less then one, throw IllegalArgumentException
     * @param modulus Modulus value, must be bigger then 0
     */
    public CounterModel(int modulus){
        if(modulus < 0){
            throw new IllegalArgumentException();
        }
        this.modulus = modulus;
        this.value = 0;
        this.NbrOfCounters++;
    }

    /**
     * Increase instance variable
     * Wraps around with modulus value
     */
    public void increment(){
        this.value = ((value + 1)%modulus);
    }

    /**
     * Decrease instance variable
     * Wraps around to modulus if negative
     */
    public void decrement(){
        if(this.value == 0){
            this.value = this.modulus - 1;
        }else {
            this.value = this.value - 1;
        }

    }

    /**
     * Resets instance variable
     */
    public void reset(){
        this.value = 0;

    }
    /**
     * Returns value as string
     * @return Current value as string
     */
    public String toString(){
        return Integer.toString(this.getValue());
    }

    /**
     * Checks if two counters are equal
     * @param cm Object to compare with
     * @return True if objects are equal otherwise false
     */
    public boolean equals(Object cm){
        if(this == cm){
            return  true;
        }else if (cm == null || this.getClass() != cm.getClass()){
            return false;
        }else{
            CounterModel n = (CounterModel)cm;
            return (n.getValue() == this.getValue()) && (n.getModulus() == this.getModulus());
        }
    }

    /**
     * Return modulus value
     * @return counters modulus value
     */
    public int getModulus(){
        return this.modulus;
    }

    /**
     * Return current Counter value
     * @return return current counter value
     */
    public int getValue(){
        return this.value;

    }

    /**
     * Return number of counters created
     * @return number of counters created
     */
    public static int getNbrOfCounters(){
        return NbrOfCounters;

    }
}
