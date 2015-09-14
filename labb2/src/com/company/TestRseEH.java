
//jag har mixtrat med denna kolla att det fungerar

//	This is TestRseEH 
// Your class must be named "Rse" and be public
// The signature of allRowSumsEqual needs to be
// public static boolean allRowSumsEqual(int[][] m) 

// Put this program in the same folder as your Rse class
// and compile this program.

// to run the test call: ([] mean that it is something voluntary)
// java TestRseEH [-vx]
// x=0 => guru mode => print only errors (they are always written)
// x=1,2 => normal printout (default)


	// this is experimental code, not for you too read :-)
	// it is also generic i.e. not everything is actually used to something (yet)

	// Version 2012-11-12


public class TestRseEH {
	
	// both false = only errors
	private static boolean verbose	= true; //default values
	private static boolean verbose2 = true;
	private static boolean debug	= false;
	
	static void print(int[][] m) {
		if ( m==null ) {
			System.out.print("[ null ]");
		} else if ( m.length == 0 ) {
			System.out.print("[ - ]");
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
			System.out.print("]");
		}
	}
	
	/*
A note on the ?-operator
You don't need to know about this operator (and should probably not use it) 
but in order to be able to understand this test program, here is a short explanation:
A statement like
System.out.print(tmp?" correct (T) ":" WRONG (T) ");
is eqvivalent to 
if (tmp) {
	System.out.print(" correct (T) ");
} else {
	System.out.print(" WRONG (T) ");
}
*/
	private static boolean testFunction(String str, int[][] matrix, boolean correct) {
		String bool = correct?"T":"F"; 
		boolean tmp = Rse.allRowSumsEqual(matrix); 
		boolean resultOk = (tmp==correct);
		//System.out.print( resultOk?" correct ("+bool+") ":" WRONG ("+bool+") " );
		if (resultOk ) {
			if (verbose) {
				System.out.print(str);
				System.out.print( " correct ("+bool+") " );
				print(matrix); 
				System.out.println();
			}
		} else {
			System.out.print(str);
			System.out.print( " WRONG ("+bool+") " );
			print(matrix); 
			System.out.println();
		} 
		//print(matrix); 
		//System.out.println(); 
		return resultOk;
	}
		
	// ---------- ---------- ---------- ----------
	public static void main(String[] args) {

	// Viktors testmatriser
	// en "tom matris/rad" finns men innehÃ¥ller inga tal, 
	// m.lenght gÃ¥r att anropa och ger alltsÃ¥ 0
	// en null matris/rad finns inte ens, 
	// m.length fÃ¥r inte anropas (ger nullPointerException)
	// ska ge true
			int[][] aa = {{1, 2, 1, 2, 1, 2},
						 {4, 0, 0, 2, 2, 1},
						 {1, 1, 1, 1, 1, 4}};
	// ska ge false
			int[][] bb = {{1, 2, 3, 4},
						 {5, 6, 7, 8},
						 {1, 1, 1, 1}};
	// ska ge true
			int[][] cc = {{1},{2,-1},{3,-1,-1}};
	// bÃ¶r ge true, men gÃ¥r att motivera annat svar
			int[][] dd = null;			// en null matris
			int[][] ee = {null, null, null}; // matris med 3 null rader 
			int[][] ff = {};				// matris med tom rad
	// ska ge true
			int[][] gg = {{}};			// en matris med tom kolumn
			int[][] hh = {{1,2,3}};
	// ska ge false
			int[][] ii = {{1},{2},{3}};
	// ska ge true
			int[][] jj = {{0}};
	// ska ge false
			int[][] kk = {{1,2,3}, {3,2,1},	  {4,4,4}};
			int[][] ll = {{1,2,3}, {3,-2,-1}, {4,4,4}}; 
	// ska ge true
			int[][] mm ={{0, 0, 0, 0}, null, {5, 5, -5, -5}};
	// ska ge true
			int[][] nn ={{0, 0, 0, 0}, null, {}};
	// ska ge false
			int[][] oo ={{0, 0, 3, 0}, null, {}};
	// ska ge false -  bara fÃ¶rsta och sista lika
			int[][] pp ={{1,2,3},{4,5,6},{7,8,9},{1,2,3}};
	// ska ge false -  bara tvÃ¥ sista lika
			int[][] qq ={{1,2,3},{4,5,6},{7,8,9},{7,8,9}};

			// ########## ########## ########## ########## ########## 
			//	take care of arguments
			int j = 0; // count arguments
			String oneArg = ""; // temporary storage for one argument
			int numberFlagValue = -1;
			int groupNbr = -1; // not used
			String lab = "Rse";
			// flags starting with "-"
			while  ( j < args.length && args[j].startsWith("-") )  {
				oneArg = args[j++]; // only shorter
				if ( oneArg.length() <= 1 ) { 
					System.err.println(lab + ": not '-' alone");
					System.exit(1);
				}
				// check -vx
				// check if there is a number in x
				try {
					numberFlagValue	 = Integer.parseInt(oneArg.substring(2));
				} catch ( NumberFormatException e ) {
					System.err.println(lab + ": number reqired for this flag: " + oneArg);
					System.exit(2);
				}
				switch ( oneArg.charAt(1) ) {
					case 'v': {
						switch (numberFlagValue) {
						case 0:
						// only errors
							verbose  = false;
							verbose2 = false;
							break;
						case 1:
							// no print of "normal output" 
							verbose  = true;
							verbose2 = false;
							break;
						case 2:
							// default, print a lot
							verbose  = true;
							verbose2 = true;
							break;
						case 3:
							// debug only
							verbose  = true;
							verbose2 = true;
							debug	 = true;
							break;
						default:
							System.err.println(lab + ": unknown number for this flag: " + oneArg);
							System.exit(3);
						} // end case numberFlagValue
					break;
					} // end case v
					case 'g': { // not used here
						groupNbr = numberFlagValue;
					break;
					} // end case g
					// another case perhaps
					default:
						System.err.println(lab + ": unknown flag: " + oneArg);
						System.exit(4);
				} // end switch oneArg
			} // end while
			if ( j < args.length ) {
				System.err.println(lab + ": unknown argument: " + args[j]);
				System.exit(5);
			}
			// ########## ########## ########## ########## ##########
// tester
		boolean tmp;
		boolean ok = true;
		if (verbose) System.out.println("");
		
		tmp = testFunction("1)  a= ", aa, true); // ska ge true
		ok = ok && tmp;
		tmp = testFunction("2)  b= ", bb, false); // ska ge false
		ok = ok && tmp;
		tmp = testFunction("3)  c= ", cc, true); // ska ge true
		ok = ok && tmp;
		tmp = testFunction("4)  d= ", dd, true); // true, men gÃ¥r att motivera annat svar
		ok = ok && tmp;
		tmp = testFunction("5)  e= ", ee, true); // true, men gÃ¥r att motivera annat svar
		ok = ok && tmp;
		tmp = testFunction("6)  f= ", ff, true); // true, men gÃ¥r att motivera annat svar
		ok = ok && tmp;
		tmp = testFunction("7)  g= ", gg, true);
		ok = ok && tmp;
		tmp = testFunction("8)  h= ", hh, true); 
		ok = ok && tmp;
		tmp = testFunction("9)  i= ", ii, false);
		ok = ok && tmp;
		tmp = testFunction("10) j= ", jj, true);
		ok = ok && tmp;
		tmp = testFunction("11) k= ", kk, false); 
		ok = ok && tmp;
		tmp = testFunction("12) l= ", ll, false);
		ok = ok && tmp;
		tmp = testFunction("13) m= ", mm, true);
		ok = ok && tmp;
		tmp = testFunction("14) n= ", nn, true);
		ok = ok && tmp;
		tmp = testFunction("15) o= ", oo, false);
		ok = ok && tmp;
		tmp = testFunction("16) p= ", pp, false);
		ok = ok && tmp;
		tmp = testFunction("17) q= ", qq, false);		
		ok = ok && tmp;
		
		if (ok) {
			if (verbose) System.out.println("Rse: All tests passed");
			System.exit(0);
		} else {
			if (verbose) System.out.println("Rse: Did not pass the test");
			System.exit(6);
		}
		
	} // end main
} // end RseTestmatriser		
