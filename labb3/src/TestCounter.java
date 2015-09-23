public class TestCounter {
 public static void main(String[] args) {

     CounterModel counterA = new CounterModel();
     CounterModel counterB = new CounterModel();
     CounterModel counterC = new CounterModel();
     System.out.println(CounterModel.getNbrOfCounters());
     CounterModel counterD = new CounterModel();
     CounterModel counterE = new CounterModel();
     CounterModel counterF = new CounterModel();

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
     System.out.println("Counter C (after decrements) = " + counterC.getValue());
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

     System.out.println("Counter A = " + counterA.getValue());
     System.out.println("Counter B = " + counterB.getValue());
     System.out.println("Counter C = " + counterC.getValue());
     System.out.println("Counter D = " + counterD.getValue());
     System.out.println("Counter E = " + counterE.getValue());
     System.out.println("Counter F = " + counterF.getValue());

     if (test(counterA, 6)
             && test(counterB, -10)
             && test(counterC, 0) && test(counterD, 10) && test(counterE, 20) && test(counterF, 0)) {
         System.out.println("All test cleared");
     } else {
         System.out.println("FAILED! somewhere");
     }
     System.out.println(CounterModel.getNbrOfCounters());

 }
    public static boolean test(CounterModel counter, int ans) {
       return ans == counter.getValue();
    }
}
