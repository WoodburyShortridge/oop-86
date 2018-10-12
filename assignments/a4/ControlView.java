/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The control view class extends JPanel and organized the controls in a boarder layout.
 *
 */

import java.awt.*;
import javax.swing.*;

public class ControlView extends JPanel {
        Main parent;
    public ControlView(Main parent) {
        // This frame is used to organize the controls
        this.parent = parent;
        setLayout(new BorderLayout());

        // create destry button and use html for red color
        ActionButton destroyButton = new ActionButton("<html><font color=red>Destroy</font>");
        // Method to add listener for printing
        destroyButton.buttonPrint("Destroyed");

        // create engage button and use html for red color
        ActionButton engageButton = new ActionButton("<html><font color=green>Engage</font>");
        // Method to add listener for printing
        engageButton.buttonPrint("Engaged");

        // add controls to layout
        this.add(destroyButton, BorderLayout.SOUTH);
        this.add(engageButton, BorderLayout.CENTER);
    }
}
