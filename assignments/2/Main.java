/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame. This is the main frame for the control interface.
 *
 */
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        
        // main frame
        JFrame mainFrame = new JFrame("Satellite Control UI");

        // add zoom slider
        mainFrame.add(new ZoomSlider (1), BorderLayout.EAST);

        // add control view
        ControlView controlView = new ControlView(600, 300);
        mainFrame.add(controlView, BorderLayout.SOUTH);

        // add  graphics to center of frame
        SatelliteView satelliteView = new SatelliteView();
        mainFrame.add(satelliteView, BorderLayout.CENTER);

        // set size and visible
        mainFrame.setSize(600,600);
        mainFrame.setVisible(true);

        // close on exit
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}