/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame. This is the main frame for the control interface.
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        // main frame
        JFrame mainFrame = new JFrame("Satellite Control UI");

        Model model = new Model();
        mainFrame.add(model, BorderLayout.CENTER);

        // Button to clear space
        JButton clearSpace = new JButton("Clear space");
        clearSpace.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
    				model.clearSpace();
    			}
        });

        mainFrame.add(clearSpace, BorderLayout.NORTH);

        // set size and visible
        mainFrame.setSize(600,600);
        mainFrame.setVisible(true);

        // close on exit
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
