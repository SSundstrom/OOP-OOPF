public class nr2 {
	public static void main(String[] args) {
		System.out.println(reverse("Hello!"));
	}
	public static String reverse(String y) {
	String reversed = "";
		for (int i = y.length() - 1 ; i >= 0 ; i--){
		
		reversed = reversed + y.charAt(i);
		
		}
	return reversed;
	}
}
