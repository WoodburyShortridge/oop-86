/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The arrow button class extends JButton with an event listener that prints to the terminal.
 * The arg direction determines what unicode arrow to display on the arrow button.
 *
 */

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrowButton extends JButton {
    private String arrow;
    // set button unicode on init
    protected ArrowButton(String direction) {
        if (direction == "RIGHT") {
            arrow = "\u25BA";
        }
        if (direction == "LEFT") {
            arrow = "\u25C4";
        }
        this.setText(arrow);
    }

    // add listener with print message
    protected void buttonPrint(String print) {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                System.out.println(print);
            }
        });
    }
}