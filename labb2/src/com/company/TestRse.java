public class TestRse {

    public static void main(String[] args) {
        
        int[][] a = {
                {1,2,1,2,1,2},
                {4,0,0,2,2,1},
                {1,1,1,1,1,4}};
        int[][] b = {
                {1,2,3,4},
                {5,6,7,8},
                {1,1,1,1}};
        int[][] c = null;
        int[][] d = {{0},null};
        int[][] e = {{1,1,1},
                    {2,2,2},
                    {3,3,3},
                    {1,1,1}};
        int[][] f = {};
        int[][] g = {{},{}};
        int[][] h = {{1,1,0},
                    null,
                    {}};

        Rse rse = new Rse();


        String right = " returns the correct boolean!";
        String wrong = " returns the wrong boolean!";
        if (rse.allRowSumsEqual(a)) {
            System.out.println("a" + right);
        } else { System.out.println("a" + wrong);
        } if (rse.allRowSumsEqual(b)) {
            System.out.println("b" + wrong);
        } else { System.out.println("b" + right);
        } if (rse.allRowSumsEqual(c)) {
            System.out.println("c" + right);
        } else { System.out.println("c" + wrong);
        } if (rse.allRowSumsEqual(d)) {
            System.out.println("d" + right);
        } else { System.out.println("d" + wrong);
        } if (rse.allRowSumsEqual(e)) {
            System.out.println("e" + wrong);
        } else { System.out.println("e" + right);
        } if (rse.allRowSumsEqual(f)) {
            System.out.println("f" + right);
        } else { System.out.println("f" + wrong);
        } if (rse.allRowSumsEqual(g)) {
            System.out.println("g" + right);
        } else { System.out.println("g" + wrong);
        } if (rse.allRowSumsEqual(h)) {
            System.out.println("h" + wrong);
        } else { System.out.println("h" + right);
        }    
    }
}
