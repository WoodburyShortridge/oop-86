import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Timeout extends JFrame
implements ActionListener, KeyListener {
    /**
     * State of the animation, just a counter
     */
    private int frame = 1;

    private Canvas canvas;

    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Timeout ();
            }
        });
    }

    public Timeout () {
	// Window setup
	setSize (500, 500);
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	addKeyListener (this);

	// Put a Canvas in
	canvas = new Canvas (this);
	add (canvas);

	setVisible (true);

	// Start timer
	Timer timer = new Timer (100, this); // 100 milliseconds
	timer.start();
    }

    public int getFrame () {       System.out.println (frame);
return frame; } 

    // Like a clock tick
    public void actionPerformed (ActionEvent e) {
	frame++;
	canvas.repaint ();
    }

    // Methods for KeyListener
    public void keyPressed (KeyEvent e) {
	if (e.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit (0);
    }
    public void keyReleased (KeyEvent e) { }
    public void keyTyped (KeyEvent e) { }

}
