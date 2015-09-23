public class TestCounter {
 public static void main(String[] args) {

     CounterModel counterA = new CounterModel();
     CounterModel counterB = new CounterModel();
     CounterModel counterC = new CounterModel();
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
     System.out.println("Counter C (after increments) = " + counterC.getValue());
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
 }
}
