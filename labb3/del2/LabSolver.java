import java.math.BigInteger;

public class LabSolver {
    private static int preX = 0;
    private static int preY = 0;
    public static void main(String[] args) {
        int width = 20;
        int height = 10;
        if (args.length > 1) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        Labyrinth l = new Lab(width,height);
        System.out.println("\nCreated a random labyrinth:");
        System.out.println(l);
        boolean success = findPath(0,0,width-1,height-1,l);
        if (success) {
            System.out.println("Solution found:");
            System.out.println(l);
        } else {
            System.out.println("Failed to find a solution. (Bug in LabSolver.java)");
            System.out.print(l);
        }
    }

    public static boolean findPath(int x0, int y0, int x1, int y1, Labyrinth l) {
        System.out.println("Current xo= " + x0 +"\nCurrent y0= " + y0);
        System.out.println("xo to reach= " +  x1 +"\ny0 to reach= " + y1);
        if ((x0 == x1) && (y0 == y1)) {
            return true;
        }

        if(l.canMove(Labyrinth.Direction.RIGHT, x0 ,y0) && !(l.getMark(x0 + 1, y0))){
            LabSolver.setPreX(x0);
            LabSolver.setPreY(y0);
            System.out.println("MOVE RIGHT");
            System.out.println("Can move right: " + l.canMove(Labyrinth.Direction.RIGHT, x0 ,y0));
            System.out.println("Move to xo= " + (x0 + 1) + " from " + x0 +"\n#################################");
            //System.out.println(l+"\n#################################");
            findPath(x0 + 1, y0, x1, y1, l);
        }
        else if(l.canMove(Labyrinth.Direction.LEFT, x0, y0) && !l.getMark(x0 - 1, y0) && ((x0 - 1 != LabSolver.getPreX()))){
            LabSolver.setPreX(x0);
            LabSolver.setPreY(y0);
            System.out.println("MOVE LEFT, move right failed");
            System.out.println("Can move left: " + l.canMove(Labyrinth.Direction.LEFT, x0, y0));
            System.out.println("Move to xo= " + (x0 - 1) + " from +"+ x0 +"\n#################################");
            //System.out.println(l+"\n#################################");
            findPath(x0 - 1, y0, x1, y1, l);
        }
        else if(l.canMove(Labyrinth.Direction.UP, x0, y0) && !l.getMark(x0, y0 - 1) && ((y0 - 1 != LabSolver.getPreY()))){
            LabSolver.setPreY(y0);
            LabSolver.setPreY(y0);
            System.out.println("MOVE UP, move right and left failed");
            System.out.println("Can move up: " + l.canMove(Labyrinth.Direction.UP, x0, y0));
            System.out.println("Move to yo= " + (y0 - 1) + " from " + y0 +"\n#################################");
            //System.out.println(l+"\n#################################");
            findPath(x0, y0 - 1, x1, y1, l);
        }
        else if(l.canMove(Labyrinth.Direction.DOWN, x0, y0) && !l.getMark(x0, y0 + 1)){
            LabSolver.setPreY(y0);
            LabSolver.setPreY(y0);
            System.out.println("MOVE DOWN, move right, left and up failed");
            System.out.println("Can move Down: " + l.canMove(Labyrinth.Direction.DOWN, x0, y0));
            System.out.println("Move to yo= " + (y0 + 1) + " from " + y0 +"\n#################################");
            //System.out.println(l+"\n#################################");
            findPath(x0, y0 + 1, x1, y1, l);
        }else{
            if(x0 != 0 && y1 != 0) {
                System.out.println("Set marked on x0 " + x0 + " and y0 " + y0);
                System.out.println(l);
                l.setMark(x0, y0, true);
                findPath(0, 0, x1, y1, l);
            }
        }
        return false;
    }

    public static int getPreX(){
        return LabSolver.preX;
    }
    public static int getPreY(){
        return LabSolver.preY;
    }

    public static void setPreX(int preX) {
        LabSolver.preX = preX;
    }

    public static void setPreY(int preY) {
        LabSolver.preY = preY;
    }
}

