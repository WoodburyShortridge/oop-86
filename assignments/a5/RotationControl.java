/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The rotation control class extends JPanel and organized the rotation controls in a boarder layout.
 * The border layout contains a label, RotationButton, and SpeedSelector.
 * It also has the method for sending the selected rotation speed value to parent,
 * when the add button is pressed. And it contains method to set input to disabled when
 * no satellite is selected
 *
 */

import java.awt.*;
import javax.swing.*;

public class RotationControl extends JPanel {
    Main parent;
    private SpeedSelector ss;
    private RotationButton rb;

    public RotationControl(Main parent) {
        // This frame is used to organize the controls
        this.parent = parent;
        setLayout(new BorderLayout());

        ss = new SpeedSelector ();
      	add (ss,BorderLayout.CENTER);

        JLabel label = new JLabel ("Click a satellite to engage");
      	add (label, BorderLayout.WEST);

        rb = new RotationButton ("Set rotation speed", this);
      	add (rb, BorderLayout.EAST);

        rb.setEnabled(false);
        ss.setEnabled(false);
    }

    protected void changeRotation() {
      int selectedSpeed = Integer.valueOf(String.valueOf(ss.getSelectedItem()));
      parent.changeRotation(selectedSpeed);
    }

    protected void changeEnabled(boolean isEngaged) {
      if (isEngaged == false ) {
        rb.setEnabled(false);
        ss.setEnabled(false);
      } else {
        rb.setEnabled(true);
        ss.setEnabled(true);
      }
    }
}
