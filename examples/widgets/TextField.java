import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TextField extends JTextField implements ActionListener {
    public TextField () {
	super ("Initial value", 20); 
	addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) { 
	System.out.println ("Text: " + e.getActionCommand()); 
    }
}

