/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The rotation butto  class extends JButton by adding an event listener that prints to the terminal.
 * The listener also calls the parent change rotation method.
 *
 */

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class RotationButton extends JButton implements ActionListener {
    RotationControl parent;
    // set button label on init
    protected RotationButton(String label, RotationControl parent) {
        this.setText(label);
        this.parent = parent;
        addActionListener (this);

        this.setMargin(new Insets(10,10,10,10));
    }
    // add listener with callback
    public void actionPerformed (ActionEvent e) {
      parent.changeRotation();
    }
}
