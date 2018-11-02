/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The add control class extends JPanel and organized the controls in a boarder layout.
 * The border layout contains a label, AddButton, and SatelliteSelector.
 * It also has the method for sending the selected satellite value to parent,
 * when the add button is pressed.
 *
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddControl extends JPanel {
    private Main parent;
    private SatelliteSelector ss;
    public AddControl(Main parent) {
        // This frame is used to organize the controls
        this.parent = parent;
        setLayout(new BorderLayout());

        EmptyBorder border = new EmptyBorder(new Insets (10,10,10,10));

        ss = new SatelliteSelector ();
        ss.setBorder(border);
      	add (ss,BorderLayout.CENTER);

        JLabel label = new JLabel ("Add Satellite Type:");
        label.setBorder(border);
      	add (label, BorderLayout.WEST);

        AddButton ab = new AddButton ("Launch Satellite", this);
      	add (ab, BorderLayout.EAST);
    }

    protected void addSatellite() {
      String selectedSatellite = String.valueOf(ss.getSelectedItem());
      parent.addSatellite(selectedSatellite);
    }
}
