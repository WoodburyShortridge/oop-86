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
import java.awt.*;
import javax.swing.*;

public class AddButton extends JButton implements ActionListener {
    AddControl parent;
    // set button label on init
    protected AddButton(String label, AddControl parent) {
        this.setText(label);
        this.parent = parent;
        addActionListener (this);
        this.setMargin(new Insets(10,10,10,10));
    }
    // add listener with clear space callback
    public void actionPerformed (ActionEvent e) {
      parent.addSatellite();
    }
}
