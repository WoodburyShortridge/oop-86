/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The clear button class extends JButton by adding an event listener that prints to the terminal.
 * The listener also calls the parent clear space method.
 *
 */

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClearButton extends JButton implements ActionListener {
    Main parent;
    // set button label on init
    protected ClearButton(String label, Main parent) {
        this.setText(label);
        this.parent = parent;
        addActionListener (this);
    }
    // add listener with clear space callback
    public void actionPerformed (ActionEvent e) {
      parent.clearSpace();
    }
}
