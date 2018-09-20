/*
 * Woodbury Shortridge
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CountButton extends JButton {

    // count and label varibles
    private int count;
    private String label;

    protected CountButton(int initCount, String initLabel) {
        count = initCount;
        label = initLabel;
        // set btn text
        changeText();
        // set count event listner
        addCount();
    }

    // event listener to add to count
    private void addCount() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                count ++;
                String msg = "you have " + writeMsg();

                // log msg
                System.out.println(msg);

                // call button label change
                changeText();
            }
        });
    }

    // private function to change button label
    private void changeText() {
        String msg = writeMsg();
        this.setText(msg);
    }

    //  helper function for dynamic string in both terminal message
    //  and button label
    private String writeMsg() {
        String countString = Integer.toString(count);
        String concatString = countString + " " + label;
        return concatString;
    }

    protected void setCount(int newCount) {
        count = newCount;
        changeText();
    }
}