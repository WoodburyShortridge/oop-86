/*
 * Drawing in a Canvas
 * RIGHT WAY -- Does drawing in a callback
 */

import java.awt.*; 
import javax.swing.*; 

public class Draw extends JFrame {
    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Draw ();
            }
        });
    }

    public Draw () {
	// Window setup
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	setSize (300, 300);
	
	// Put a Canvas in
	Canvas canvas = new Canvas ();
	add (canvas);
    
	// Show the window
	setVisible (true); 

	// No drawing here, do it in Canvas callback
	
    }
}

