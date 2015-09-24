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
        for (int i = 0; i < 10; i++) {
            counterD.increment();
        }
        //     Changes in counterE
        while (counterE.getValue() < 20) {
            counterE.decrement();
            counterE.increment();
            counterE.increment();
        }
        //     Changes in counterF
        counterF.increment();
        while (counterF.getValue() > 0)
            counterF.reset();

        if (test("A", counterA, 6) &&
            test("B", counterB, -10) &&
            test("C", counterC, 0) &&
            test("D", counterD, 10) &&
            test("E", counterE, 20) &&
            test("F", counterF, 0) &&
            testNbrOfCounters(counters))
            {

            System.out.println("All tests cleared.");
        }

    }

        public static boolean test(String nr, CounterModel counter, int ans) {
            if (ans == counter.getValue()) {
                System.out.println("counter" + nr + " test cleared");
                return true;
            }
            System.out.println("Wrong answer in counter" + nr);
            return false;
        }
    public static boolean testNbrOfCounters(List counters) {
        if (CounterModel.getNbrOfCounters() == counters.size()) {
            System.out.println("Number of counters test cleared");
            return true;
        }
        System.out.println("Not picking up the correct amount of counters");
        return false;
    }
}
