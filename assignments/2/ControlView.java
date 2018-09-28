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
    public ControlView(int height, int width) {
        // This frame is used to organize the controls
        setSize(height, width);
        setLayout(new BorderLayout());
        // create scroll bar
        ScrollBar scrollBar = new ScrollBar(1);

        // create destry button and use html for red color
        ActionButton destroyButton = new ActionButton("<html><font color=red>Destroy</font>");
        // Method to add listener for printing
        destroyButton.buttonPrint("Destroyed");

        // create engage button and use html for red color
        ActionButton engageButton = new ActionButton("<html><font color=green>Engage</font>");
        // Method to add listener for printing
        engageButton.buttonPrint("Engaged");

        // create arrow buttons
        ArrowButton rightArrow = new ArrowButton("RIGHT");
        rightArrow.buttonPrint("next");
        ArrowButton leftArrow = new ArrowButton("LEFT");
        leftArrow.buttonPrint("previous");

        // add controls to layout
        this.add(destroyButton, BorderLayout.SOUTH);
        this.add(scrollBar, BorderLayout.NORTH);
        this.add(rightArrow, BorderLayout.EAST);
        this.add(leftArrow, BorderLayout.WEST);
        this.add(engageButton, BorderLayout.CENTER);
    }


}