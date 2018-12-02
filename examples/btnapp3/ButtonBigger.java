import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonBigger extends JButton implements ActionListener {
    private Square square;

    public ButtonBigger (Square square) {
	this.square = square;
	setText ("Bigger");
	setFont (new Font("SansSerif", Font.ITALIC, 14));
	setForeground (Color.BLUE);
	setBorder (new LineBorder(Color.GREEN, 2));
	addActionListener (this);
    }

    public void actionPerformed(ActionEvent e) {
        square.doAction (Square.ButtonAction.BIGGER);
    }
}

