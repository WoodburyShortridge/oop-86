import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Note: On older versions of Java, use "JList" not "JList<String>"
public class List extends JList<String> implements ListSelectionListener {
    public List () {
	String[] items = {"un", "deux", "trois", "quatre"}; 
	setListData (items); 
	setSelectionMode (ListSelectionModel.SINGLE_SELECTION); 
	addListSelectionListener (this);
    }

    public void valueChanged (ListSelectionEvent e) { 
	if (! e.getValueIsAdjusting()) { 
	    System.out.println ("List: " + getSelectedValue()); 
	}
    }
}

