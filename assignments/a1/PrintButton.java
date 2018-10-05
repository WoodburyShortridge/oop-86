/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The print button class extends JButton by adding an event listener that prints to the terminal.
 * The listener can be set using a protected method with a string arg for the message to be printed.
 *
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintButton extends JButton {
    // set button label on init
    protected PrintButton(String label) {
        this.setText(label);
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