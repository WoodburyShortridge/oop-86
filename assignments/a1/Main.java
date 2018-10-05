/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame. This program creates a frame and places various buttons in the border layout.
 * It also creates a JPanel composed of a radio button group and places it in the center of the layout.
 * A listner is added to the reset button that calls set methods on the state and count buttons.
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
        JFrame frameBtn = new JFrame("UI button Layout");

        // create basic print button and use html for color and the method to add listener for printing
        PrintButton printButton = new PrintButton("<html><font color=red>don't click me</font>");
        printButton.buttonPrint("ouch, you clicked me!");
        
        // create a count button for cats, starting at 0
        CountButton countButton = new CountButton(0,"cats");

        // create a state button that is enabled
        StateButton stateButton = new StateButton(true);

        // reuse the print button class to create a reset button
        PrintButton resetButton = new PrintButton("Reset");
        resetButton.buttonPrint("OK, you reset the UI");
        resetButton.setToolTipText("Click this button to reset the count and enable disabled button");

        // event listener on the reset button to re-enable the state button (if disabled)
        // and set the count button count back to 0
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                stateButton.newState(true);
                countButton.setCount(0);
            }
        });

        // create panel for radio buttons
        JPanel panelRadio = new JPanel();

        // create and group two pet radio buttons
        PetRadio petRadio1 = new PetRadio(true, "cats");
        PetRadio petRadio2 = new PetRadio(false, "dogs");
        ButtonGroup catGroup = new ButtonGroup();
        catGroup.add(petRadio1);
        catGroup.add(petRadio2);

        // add buttons to frame
        frameBtn.add(printButton, BorderLayout.NORTH);
        frameBtn.add(countButton, BorderLayout.SOUTH);
        frameBtn.add(stateButton, BorderLayout.WEST);
        frameBtn.add(resetButton, BorderLayout.EAST);

        // add radio buttons to panel
        panelRadio.add(petRadio1);
        panelRadio.add(petRadio2);
        // add  panel to center of frame
        frameBtn.add(panelRadio, BorderLayout.CENTER);

        // set size and visible
        frameBtn.setSize(600,600);
        frameBtn.setVisible(true);
    }
}