/*
 * Woodbury Shortridge
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
        JFrame frameBtn = new JFrame("UI button Layout");

        PrintButton printButton = new PrintButton("<html><font color=red>don't click me</font>");
        printButton.buttonPrint("ouch, you clicked me!");

        CountButton countButton = new CountButton(0,"cats");

        StateButton stateButton = new StateButton(true);

        PrintButton resetButton = new PrintButton("Reset");
        resetButton.buttonPrint("OK, you reset the UI");
        resetButton.setToolTipText("Click this button to reset the count and enable disabled button");

        // event listener on the reset button to enable the state button
        // and set the count button back to 0
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                stateButton.newState(true);
                countButton.setCount(0);
            }
        });

        JPanel panelRadio = new JPanel();

        CatRadio catRadio1 = new CatRadio(false);
        CatRadio catRadio2 = new CatRadio(false);
        ButtonGroup catGroup = new ButtonGroup();
        catGroup.add(catRadio1);
        catGroup.add(catRadio2);

        frameBtn.add(printButton, BorderLayout.NORTH);
        frameBtn.add(countButton, BorderLayout.SOUTH);
        frameBtn.add(stateButton, BorderLayout.WEST);
        frameBtn.add(resetButton, BorderLayout.EAST);
        panelRadio.add(catRadio1);
        panelRadio.add(catRadio2);
        // add radio button pannel to center of button frame
        frameBtn.add(panelRadio, BorderLayout.CENTER);

        frameBtn.setSize(300,300);
        frameBtn.setVisible(true);
    }
}