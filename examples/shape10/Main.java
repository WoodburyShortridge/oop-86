/*
 * Note that the other *.java files don't change
 */

class Main {

	// The main program
	public static void main (String args[]) {

		/*
		 * Data definitions
		 */
		Shape[] s; 
		s = new Shape[3]; 

		/*
		 * And now, instantiate the objects
		 */
		s[0] = new Rect (10, 10, 50, 50); 
		s[1] = new Rect (80, 10, 10, 100); 
		s[2] = new Circle (35, 90, 10); 

		/*
		 * "Draw" them
		 */
		for (int i=0; i<3; i++) s[i].draw(); 
		
		for (int i=0; i<s.length; i++) s[i].draw(); 

		for (Shape item: s) item.draw(); 

		/*
		 * Compute and print total area
		 */
		float tot = 0;
		for (Shape item: s) tot += item.area(); 
		System.out.println ("Total area = " + tot);
	}
}
