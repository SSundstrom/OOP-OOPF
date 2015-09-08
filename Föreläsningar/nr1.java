import java.awt.*;
public class nr1 {
	public static void main(String[] args) {
		
		Rectangle a = new Rectangle(5,10,20,30);
		
		boolean con = a.contains(10,15);

		System.out.println(a);

		System.out.println(con);
		
		a.translate(6,15);

		System.out.println(a);

		//System.out.println(rect);
	}
}