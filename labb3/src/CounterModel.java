import java.util.IllegalFormatException;
import java.util.Objects;

public class CounterModel {
    private int value;
    private int modulus;
    private static int NbrOfCounters;

    public CounterModel(){
        this(10);
    }
    public CounterModel(int max){
        if(max+1 < 0){
            throw new IllegalArgumentException();
        }
        this.modulus = max;
        this.value = 0;
        this.NbrOfCounters++;
    }

    public void increment(){
        this.value = ((value + 1)%modulus);
    }
    public void decrement(){
        if(this.value == 0){
            this.value = this.modulus - 1;
        }else {
            this.value = this.value - 1;
        }

    }
    public void reset(){
        this.value = 0;

    }
    public String toString() {
        return Integer.toString(getValue());
    }
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

    public int getModulus(){
        return this.modulus;
    }
    public int getValue(){
        return this.value;

    }
    public static int getNbrOfCounters(){
        return NbrOfCounters;

    }
}
