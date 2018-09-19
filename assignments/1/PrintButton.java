/*
 * Woodbury Shortridge
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintButton extends JButton {

    protected PrintButton(String label) {
        this.setText(label);
    }

    protected void buttonPrint(String print) {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                System.out.println(print);
            }
        });
    }
}