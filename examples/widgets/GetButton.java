import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GetButton extends JButton implements ActionListener {
    private Widgets parent; 

    public GetButton (Widgets parent) { 
	this.parent = parent; 

	setText ("Get Data");
	addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) { 
	parent.showData(); 
    }
}
