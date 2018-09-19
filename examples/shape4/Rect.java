/*
 * Definition of class Rect
 */

class Rect { 

	public int x, y, wid, ht; 

	public void draw() { 
		System.out.println ("Drawing rectangle at "
			+ x + ", " + y + ", " + wid + ", " + ht);
	}

	public float area() { 
		return (float) (wid * ht);
	}
}
