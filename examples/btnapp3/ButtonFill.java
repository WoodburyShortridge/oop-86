import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonFill extends JButton implements ActionListener {
    private Square square;
    private boolean buttonState = false;
    
    public ButtonFill (Square square) {
	this.square = square;
	setText ("Filled");
	setFont (new Font("SansSerif", Font.ITALIC, 14));
	setForeground (Color.BLUE);
	setBorder (new LineBorder(Color.GREEN, 2));
	addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
	buttonState = ! buttonState;
	if (buttonState) square.doAction (Square.ButtonAction.FILL);
	else square.doAction (Square.ButtonAction.EMPTY);

	// Also update button label
	if (buttonState) setText ("Empty");
	else setText ("Filled");
    }
}
