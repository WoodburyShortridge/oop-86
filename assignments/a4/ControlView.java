/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The control view class extends JPanel and organized the controls in a boarder layout.
 * The border layout contains a label, AddButton, and SatelliteSelector.
 * It also has the method for sending the selected satellite value to parent,
 * when the add button is pressed.
 *
 */

import java.awt.*;
import javax.swing.*;

public class ControlView extends JPanel {
        Main parent;
        SatelliteSelector ss;
    public ControlView(Main parent) {
        // This frame is used to organize the controls
        this.parent = parent;
        setLayout(new BorderLayout());

        ss = new SatelliteSelector ();
      	add (ss,BorderLayout.CENTER);

        JLabel label = new JLabel ("Add Satellite Type:");
      	add (label, BorderLayout.WEST);

        AddButton ab = new AddButton ("Launch Satellite", this);
      	add (ab, BorderLayout.EAST);
    }

    protected void addSatellite() {
      String selectedSatellite = String.valueOf(ss.getSelectedItem());
      parent.addSatellite(selectedSatellite);
    }
}
