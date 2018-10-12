/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The add button class extends JButton by adding an event listener that prints to the terminal.
 * The listener also calls the parent add satellite method.
 *
 */
 
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements ActionListener {
    ControlView parent;
    // set button label on init
    protected AddButton(String label, ControlView parent) {
        this.setText(label);
        this.parent = parent;
        addActionListener (this);
    }
    // add listener with clear space callback
    public void actionPerformed (ActionEvent e) {
      parent.addSatellite();
    }
}
