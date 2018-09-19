/*
 * Woodbury Shortridge
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CountButton extends JButton {
    private int clicks;

    protected CountButton(int count, String label) {
        clicks = count;
        changeText(count, label);
        addCount(label);
    }

    private void addCount(String label) {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                clicks ++;
                System.out.println(clicks);
                changeText(clicks, label);
            }
        });
    }

    private void changeText(int count, String label) {
        String countString = Integer.toString(count);
        String concatString = countString + " " + label;
        this.setText(concatString);
    }
}