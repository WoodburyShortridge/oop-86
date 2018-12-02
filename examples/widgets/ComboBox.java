import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Note: On older versions of Java, use "JComboBox" not "JComboBox<String>"
public class ComboBox extends JComboBox<String> implements ItemListener {
    public ComboBox () {
	addItem ("one"); 
	addItem ("two"); 
	addItem ("three"); 
	addItem ("four"); 
	setSelectedItem ("three"); 
	addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) { 
	if (e.getStateChange()==ItemEvent.SELECTED) { 
	    System.out.println ("Combo: " + e.getItem()); 
	}
    }
}
