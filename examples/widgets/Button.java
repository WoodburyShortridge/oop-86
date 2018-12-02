import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class Button extends JButton implements ActionListener {
    public Button (String label) { 
	setText (label); 
	setFont (new Font("Serif", Font.ITALIC, 18)); 
	setForeground (Color.RED); 
	setBorder (new LineBorder(Color.GREEN, 2)); 
	addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) { 
	System.out.println (getText() + " Button was pushed"); 
    }
}

