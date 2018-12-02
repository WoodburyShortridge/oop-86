import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Main program for Button3
 */
public class ButtonApp extends JFrame {
    /** The squares */
    private Square square1, square2;

    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new ButtonApp ();
            }
        });
    }

    public ButtonApp () {
	// Window setup
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	setSize (500, 500);
	setLayout (new BorderLayout());

	// Our canvas
	Canvas canvas = new Canvas (this);
	add (canvas, BorderLayout.CENTER);

	/*
	 * Now create the square and its associated buttons
	 */
	square1 = new Square (canvas); 

	// Control panel for the square
	JPanel controls1 = new JPanel ();
	controls1.setBorder (new LineBorder(Color.BLUE));
	controls1.setLayout (new FlowLayout());

	// Create our buttons by instantiating them
	// turns out we don't need to remember them,
	// just to add() them to panel layout
	controls1.add (new ButtonLeft (square1)); 
	controls1.add (new ButtonRight (square1)); 
	controls1.add (new ButtonBigger (square1)); 
	controls1.add (new ButtonSmaller (square1)); 
	controls1.add (new ButtonFill (square1)); 

	/*
	 * Another square
	 */
	square2 = new Square (canvas); 
	
	JPanel controls2 = new JPanel ();
	controls2.setBorder (new LineBorder(Color.BLUE));
	controls2.setLayout (new FlowLayout());
	
	// Create our buttons
	controls2.add (new ButtonLeft (square2)); 
	controls2.add (new ButtonRight (square2)); 
	controls2.add (new ButtonBigger (square2)); 
	controls2.add (new ButtonSmaller (square2)); 
	controls2.add (new ButtonFill (square2)); 

	// Need a grid container to hold our 2 panels
	JPanel controls = new JPanel ();
	controls.setLayout (new GridLayout(2, 1));
	controls.add (controls1);
	controls.add (controls2);
	add (controls, BorderLayout.SOUTH);

	setVisible (true);
    }

    public void drawSquares (Graphics g) { 
	// For each square (this could be an array)
	square1.draw (g); 
	square2.draw (g); 
    }
}

