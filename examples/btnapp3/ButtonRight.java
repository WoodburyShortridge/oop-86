import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonRight extends JButton implements ActionListener {
    private Square square;
    
    public ButtonRight (Square square) {
	this.square = square;
	setIcon (new ImageIcon ("rightArrow.gif"));
	setBorder (new LineBorder(Color.GREEN, 2));
	addActionListener (this);
    }
    
    public void actionPerformed(ActionEvent e) {
        square.doAction (Square.ButtonAction.RIGHT);
    }
}
