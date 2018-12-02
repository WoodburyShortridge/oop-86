import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class Radio extends JPanel implements ItemListener { 
    public Radio () {
	// Border around our JPanel
	setBorder (new LineBorder(Color.BLUE, 1)); 

	ButtonGroup g = new ButtonGroup (); 

	JRadioButton rb = new JRadioButton ("I", false); 
	add (rb); 
	g.add (rb); 
	rb.addItemListener (this); 

	rb = new JRadioButton ("II", true); 
	add (rb); 
	g.add (rb); 
	rb.addItemListener (this); 

	rb = new JRadioButton ("III", false); 
	add (rb); 
	g.add (rb); 
	rb.addItemListener (this); 

	rb = new JRadioButton ("IV", false); 
	add (rb); 
	g.add (rb); 
	rb.addItemListener (this); 
    }
    
    public void itemStateChanged (ItemEvent e) {
	// Reports every select or deselect, we filter out
	if (e.getStateChange()==ItemEvent.SELECTED) {
	    System.out.println ("Radio: " + ((JRadioButton)e.getItem()).getText()); 
	}
    }
}
