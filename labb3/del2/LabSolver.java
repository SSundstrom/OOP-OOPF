public class LabSolver {

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
        if(l.getMark(x0,y0)){
            return false;
        }
        l.setMark(x0, y0, true);
        if(x1 == x0 && y1 == y0 ){
            return true;
        }
        if(l.canMove(Labyrinth.Direction.DOWN, x0, y0)){
            if(findPath(x0, y0 +1, x1, y1, l)){
                return true;
            }
        }
        if(l.canMove(Labyrinth.Direction.UP, x0, y0)){
            if(findPath(x0, y0 - 1, x1, y1, l)){
                return true;
            }
        }
        if(l.canMove(Labyrinth.Direction.LEFT, x0, y0)){
            if(findPath(x0 - 1, y0, x1, y1, l)){
                return true;
            }
        }
        if(l.canMove(Labyrinth.Direction.RIGHT, x0, y0)){
            if(findPath(x0 + 1 , y0, x1, y1, l)){
                return true;
            }
        }
        l.setMark(x0,y0,false);
        return false;
    }
}

