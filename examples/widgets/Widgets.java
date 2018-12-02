import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Widgets extends JFrame {
    private ComboBox c1; 
    private List l1; 
    private ScrollBar s1; 

    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Widgets ();
            }
        });
    }

    public Widgets () {
	// Window setup
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	setLocation (100, 100);
	setSize (300, 300);
	setLayout (new FlowLayout());

	// Make various widgets and add them
	Button b1 = new Button ("Push me"); 
	add (b1);

	// Some are local variables, we don't save
	Button b2 = new Button ("Push me too"); 
	add (b2);

	// Some we save in ivars for showData()
	c1 = new ComboBox (); 
	add (c1);

	l1 = new List (); 
	add (l1);

	Radio r1 = new Radio (); 
	add (r1);

	s1 = new ScrollBar (); 
	add (s1);

	TextField t1 = new TextField (); 
	add (t1);

	// This button reports the data from several other widgets
	GetButton b = new GetButton (this); 
	add (b);

	// A label widget, no interaction
	JLabel label = new JLabel ("This is a label"); 
	add (label);

	// Finally, put our window on the screen
	setVisible (true);
    }

    // GetButton calls back to us cause we have the objects with the data
    public void showData() { 
	System.out.println ("Values: " + c1.getSelectedItem() + 
	    ", " + l1.getSelectedValue() + 
	    ", " + s1.getValue()); 
    }
}

