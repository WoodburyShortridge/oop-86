/*
 * Woodbury Shortridge
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StateButton extends JButton {

    private boolean state;

    protected StateButton(boolean initState) {
        state = initState;
        setNewState();
        statePrint();
    }

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

    protected void newState (boolean newState) {
        state = newState;
        setNewState();
    }

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