/*
 * Woodbury Shortridge
 */
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatRadio extends JRadioButton {
    private boolean state;

    protected CatRadio(boolean initState) {
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
                    System.out.println("you like cats");
                } else {
                    System.out.println("you don't like cats");
                }
            }
        });
    }

    private void setNewState () {
        if (state) {
            this.setText("cats");
        } else {
            this.setText("dogs");
        }
    }
}