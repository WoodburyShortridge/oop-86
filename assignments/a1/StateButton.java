/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The state class extends JButton by adding an event listener that toggles enabled/disabled.
 * The listener also changes the button text and prints the new stateto the terminal.
 * It includes protected method to reset the state.
 *
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StateButton extends JButton {

    private boolean state;

    // Init state
    protected StateButton(boolean initState) {
        state = initState;
        setNewState();
        statePrint();
    }

    // Listener for printing
    private void statePrint() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                state = !state;
                setNewState();
                if (state) {
                    System.out.println("you enabled me");
                } else {
                    System.out.println("you disabled me");
                }
            }
        });
    }

    // Set method
    protected void newState (boolean newState) {
        state = newState;
        setNewState();
    }

    // Toggle method for button text and state
    private void setNewState () {
        if (state) {
            this.setText("enabled");
            this.setEnabled(true);
        } else {
            this.setText("disabled");
            this.setEnabled(false);
        }
    }
}