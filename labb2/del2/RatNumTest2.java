
class RatNumTest2 {

	private static void fel(int nr) {
		System.out.println("RatNumTest2: Fel nummer " + nr);
		System.exit(1);
	}    

	public static void divTester() {
		LischRatNum r;

		// test av konstruktor
		r = new LischRatNum(9);
		if (r.getNumerator() != 9 || r.getDenominator() != 1)
			fel(1);
		r = new LischRatNum(4, 9);
		if (r.getNumerator() != 4 || r.getDenominator() != 9)
			fel(2);      
		r = new LischRatNum(49, 168);
		if (r.getNumerator() != 7 || r.getDenominator() != 24)
			fel(3);
		LischRatNum r2 = new LischRatNum(r);
		if (r2.getNumerator() != 7 || r2.getDenominator() != 24)
			fel(4);    
		LischRatNum x = new LischRatNum();
		if (x.getNumerator() != 0 || x.getDenominator() != 1)
			fel(5); 
		if (r2.getNumerator() == 0 || r2.getDenominator() == 1)
			fel(6);     
		LischRatNum y = new LischRatNum(5);
		if (y.getNumerator() != 5 || y.getDenominator() != 1)
			fel(7);      
		LischRatNum z = new LischRatNum(20, 4);
		if (z.getNumerator() != 5 || z.getDenominator() != 1)
			fel(8);      
		LischRatNum w = new LischRatNum(0,1);
		if (w.getNumerator() != 0 || w.getDenominator() != 1)
			fel(9);      
		LischRatNum q = new LischRatNum(y);
		if (q.getNumerator() != 5 || q.getDenominator() != 1)
			fel(10); 

		// test av negativa parametrar
		r = new LischRatNum(-49, 168);
		if (r.getNumerator() != -7 || r.getDenominator() != 24)
			fel(11);
		r = new LischRatNum(49, -168);
		if (r.getNumerator() != -7 || r.getDenominator() != 24)
			fel(12);
		r = new LischRatNum(-49, -168);
		if (r.getNumerator() != 7 || r.getDenominator() != 24)
			fel(13);

		// Test av exception
		boolean ok = false;
		try {
			q = new LischRatNum(5,0);
		}
		catch (NumberFormatException e1) {ok = true;} 
		catch (Exception e2) {}
		if (!ok)
			fel(14);
	}     

	public static void main(String[] arg) {
		testLisch();

		/*
		divTester();
		RatNum h;
		h = new RatNum(32, -12);
		System.out.println(h.toString());
		System.out.println(h.toDouble());
		System.out.println("Inga fel!"); */
	}
	
	public static void testLisch(){
		LischRatNum r = new LischRatNum("12");
	}

}



