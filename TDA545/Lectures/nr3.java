import java.util.Random;
public class FastCar {
    private String name;
    private int speed;
    private int pos;
    private Random t;
    public FastCar(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.pos = 0;
        this.t = new Random();
    }
    public int getPos() {
        return pos;
    }
    public void go() {
        if (t.nextInt(5) == 0) {
            System.out.println(name + 
               " got a boost from the wind!");
            pos = pos + 10;
        }
        pos = pos + speed;
    }
    public String toString() {
        return name + " is at " + pos + " from origin.";
    }
}