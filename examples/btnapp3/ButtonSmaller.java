import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonSmaller extends JButton implements ActionListener {
    private Square square;

    public ButtonSmaller (Square square) {
	this.square = square;
	setText ("Smaller");
	setFont (new Font("SansSerif", Font.ITALIC, 14));
	setForeground (Color.BLUE);
	setBorder (new LineBorder(Color.GREEN, 2));
	addActionListener (this);
    }

    public void actionPerformed(ActionEvent e) {
        square.doAction (Square.ButtonAction.SMALLER);
    }
}

