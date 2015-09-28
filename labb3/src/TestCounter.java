import java.util.LinkedList;
import java.util.List;

public class TestCounter {

    public static void main(String[] args) {

        List<CounterModel> counters = new LinkedList<>();


        CounterModel counterA = new CounterModel();
        counters.add(counterA);
        CounterModel counterB = new CounterModel();
        counters.add(counterB);
        CounterModel counterC = new CounterModel();
        counters.add(counterC);
        CounterModel counterD = new CounterModel();
        counters.add(counterD);
        CounterModel counterE = new CounterModel();
        counters.add(counterE);
        CounterModel counterF = new CounterModel();
        counters.add(counterF);
        Object counterG = new CounterModel();
        counters.add((CounterModel)counterG);
        CounterModel counterH = new CounterModel();
        counters.add(counterH);



        //     Changes in counterA
        for (int i = 0; i < 6; i++) {
            counterA.increment();
        }
        //     Changes in counterB
        for (int i = 0; i < 10; i++) {
            counterB.decrement();
        }
        //     Changes in counterC
        for (int i = 0; i < 5; i++) {
            counterC.decrement();
        }
        counterC.reset();
        //     Changes in counterD
        for (int i = 0; i < 19; i++) {
            counterD.increment();
        }
        //     Changes in counterE
        while (counterE.getValue() < counterE.getModulus() - 4) {
            counterE.decrement();
            counterE.increment();
            counterE.increment();
        }
        //     Changes in counterF
        counterF.increment();
        while (counterF.getValue() > 0)
            counterF.reset();




        if (test("A", counterA, 6) &&
                test("B", counterB, 0) &&
                test("C", counterC, 0) &&
                test("D", counterD, 9) &&
                test("E", counterE, 6) &&
                test("F", counterF, 0) &&
                test("A", counterA,"B", counterB, false) &&
                test("H", counterH,"G", counterG, true) &&
                test("E", counterE,"G", counterG, false) &&
                test("D", counterD) &&
                test("F", counterF) &&
                test("A", counterA) &&
                testNbrOfCounters(counters)) {
            System.out.println("All tests cleared.");
            CounterModel[] countersArray = counters.toArray(new CounterModel[counters.size()]);
            printCounters(countersArray);
        }
        changeValue(counterA);

        FastCounter fastA = new FastCounter();
        FastCounter fastB = new FastCounter();
        if(fastA.equals(fastB)){
            System.out.println("Counters are equals");
        }
        else{
            System.out.println("Counters are not equals");
        }
    }






    public static boolean test(String nr, CounterModel counter, int ans) {
        if (ans == counter.getValue()) {
            System.out.println("counter" + nr + " test cleared\t" + ans + " == " + counter.getValue());
            return true;
        }
        System.out.println("Wrong answer in counter" + nr + "\t" + ans + " != " + counter.getValue());
        return false;
    }
    public static boolean test(String os1, Object o1, String os2, Object o2, boolean b) {
        System.out.print("Equals test for counter" + os1 + " and counter" + os2);
        CounterModel cmo1 = (CounterModel) o1;
        CounterModel cmo2 = (CounterModel) o2;
        String s = " == ";
        if (o1.equals(o2) == b) {
            System.out.print(" cleared");
            b = true;
        } else {
            System.out.print(" failed");
            b = false;
        }
        if (!o1.equals(o2)) {
            s = " != ";
        }
        System.out.println("\t" + cmo1.getValue() + s + cmo2.getValue());
        return b;
    }
    public static boolean test(String s, Object o) {
        if (o.toString().getClass() == String.class) {
            System.out.println("counter" + s + " successfully converted to string");
            return true;
        }
        System.out.println("counter" + s + " successfully converted to string");
        return false;
    }
    public static void printCounters(CounterModel[] arrayOfCMs) {
        int i = 0;
        for (CounterModel cm : arrayOfCMs) {
            if (cm != null) {
                i++;
                System.out.println("Counter number " + i + "\thas counter value " + cm.toString());
            }
        }
    }

    public static boolean testNbrOfCounters(List counters) {
        if (CounterModel.getNbrOfCounters() == counters.size()) {
            System.out.println("Number of counters test cleared\t NbrOfCounters from class: " + CounterModel.getNbrOfCounters() + " == " + counters.size() + " instans variabel");
            return true;
        }
        System.out.println("Not picking up the correct amount of counters: " + CounterModel.getNbrOfCounters() + " != " + counters.size());
        return false;
    }
    public static void changeValue(CounterModel m){
        System.out.println("Start value: " + m.toString());
        m.increment();
        System.out.println("Value after add: " + m.toString());
    }
}
