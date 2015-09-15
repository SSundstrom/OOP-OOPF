public class TestRse {

    private static int amountFails = 0;

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

        test("a", rse.allRowSumsEqual(a) == true, a);
        test("b", rse.allRowSumsEqual(b) == false, b);
        test("c", rse.allRowSumsEqual(c) == true, c);
        test("d", rse.allRowSumsEqual(d) == true, d);
        test("e", rse.allRowSumsEqual(e) == false, e);
        test("f", rse.allRowSumsEqual(f) == true, f);
        test("g", rse.allRowSumsEqual(g) == true, g);
        test("h", rse.allRowSumsEqual(h) == false, h);
        
        if (amountFails > 0) {
            System.out.println("You have " + amountFails + " failed Matrix");
        } else {
            System.out.println("All matrix correct");
        }
    }
    private static void test(String name, boolean correct, int[][] matris) {
        
        String right = " returns the correct boolean!  ";
        String wrong = " returns the wrong boolean!    ";
        if (correct) {
            System.out.print("Matris " + name + right);
        } else {
            amountFails++;
            System.out.print("Matris " + name + wrong);
        }
        print(matris);
    }

    static void print(int[][] m) {
    if ( m==null ) {
        System.out.println("[ null ]");
    } else if ( m.length == 0 ) {
        System.out.println("[ - ]");
    } else {
        System.out.print("[ ");
        for ( int row=0; row<m.length; row++ ) {
            if ( m[row]==null ) {
                System.out.print("null ");
            } else {
                System.out.print("{ ");
                if ( m[row].length == 0 ) {
                    System.out.print("- ");
                } else {
                    for ( int col=0; col<m[row].length; col++ ) {
                        System.out.print( m[row][col] + " " ) ;
                    }
                }
            System.out.print("} ");
            }
        }
    System.out.println("]");
    }
}
}
