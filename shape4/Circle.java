/*
 * Definition of class Circle
 */

class Circle { 

	public int x, y, rad; 

	public void draw() { 
		System.out.println ("Drawing circle at " + x + ", " + y
			+ ", radius = " + rad);
	}

	public float area() { 
		return (float) (rad * rad * 3.14159);
	}
}
