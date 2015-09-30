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
        //If this position is mark this is wrong way
        if(l.getMark(x0,y0)){
            return false;
        }
        //Set this way as correct
        l.setMark(x0, y0, true);
        //Checks if we reached correct position
        if(x1 == x0 && y1 == y0 ){
            return true;
        }
        //Checks if possible to move down
        if(l.canMove(Labyrinth.Direction.DOWN, x0, y0)){
            if(findPath(x0, y0 +1, x1, y1, l)){
                return true;
            }
        }
       //Checks if possible to move up
        if(l.canMove(Labyrinth.Direction.UP, x0, y0)){
            if(findPath(x0, y0 - 1, x1, y1, l)){
                return true;
            }
        }
       //Checks if possible to move left
        if(l.canMove(Labyrinth.Direction.LEFT, x0, y0)){
            if(findPath(x0 - 1, y0, x1, y1, l)){
                return true;
            }
        }
        //Checks if possible to move right
        if(l.canMove(Labyrinth.Direction.RIGHT, x0, y0)){
            if(findPath(x0 + 1 , y0, x1, y1, l)){
                return true;
            }
        }
        //Sets way to false because right way already found, no possible way or is in a dead end
        l.setMark(x0,y0,false);
        return false;
    }
}

