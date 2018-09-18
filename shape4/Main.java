/*
 * Just a main program for testing our objects
 */

class Main {

	// The main program
	public static void main (String args[]) { 

		/*
		 * Data definitions
		 */
		Rect r1, r2; 
		Circle c1; 

		/*
		 * Instantiate the objects (could have done in defs above)
		 */
		r1 = new Rect (); 
		r2 = new Rect (); 
		c1 = new Circle (); 

		/*
		 * Set the locations of the 3 objects
		 */
		r1.x = 10; r1.y = 10; 
		r1.wid = 50; r1.ht = 50; 

		r2.x = 80; r2.y = 10; 
		r2.wid = 10; r2.ht = 100; 

		c1.x = 35; c1.y = 90; 
		c1.rad = 10; 

		/*
		 * "Draw" them
		 */
		r1.draw(); 
		r2.draw(); 
		c1.draw(); 

		/*
		 * Compute and print total area
		 */
		System.out.println ("Total area = " + 
			(r1.area() + r2.area() + c1.area())); 
	}
}
