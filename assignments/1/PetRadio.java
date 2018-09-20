/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The cat radio class extends JRadioButton by adding an event listener that prints to the terminal.
 * The listener can be set using a protected method with a string arg for the message to be printed when selected.
 * A boolean arg is used to set initial selection state.
 *
 */
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetRadio extends JRadioButton {
    private String label;
    private boolean state;

    // Initial state and label
    protected PetRadio(boolean initState, String initLabel) {
        state = initState;
        label = initLabel;
        setNewState();
        statePrint();
    }

    // Print selected state
    private void statePrint() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                state = !state;
                System.out.println("you like " + label);
            }
        });
    }

    // Set state on click
    private void setNewState () {
        this.setText(label);
        if (state) {
            this.setSelected(true);
        } else {
            this.setSelected(false);
        }
    }
}