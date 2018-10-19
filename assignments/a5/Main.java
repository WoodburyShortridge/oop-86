/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame and adds an ActionListener. This is the main frame for the satellite view and control interface.
 * It controls the satellite model graphics with a timer and
 * has methods for getting frame number, adding satellites, and changing rotation speed.
 * And it adds the two control views to the layout, add controls and rotation controls.
 *
 */

 import java.awt.*;
 import java.awt.event.*;
 import java.awt.geom.*;
 import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private int frame = 1;
    private Model model;
    private RotationControl rotationControl;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater (new Runnable() {
          public void run() {
 		         new Main();
           }
       });
    }

    public Main() {

        // set size and visible
        this.setSize(600,600);
        this.setVisible(true);

        // close on exit
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        model = new Model(this);
        this.add(model, BorderLayout.CENTER);

        // Button to clear space
        rotationControl = new RotationControl(this);
        this.add(rotationControl, BorderLayout.SOUTH);

        // add control view
        AddControl addControl = new AddControl(this);
        this.add(addControl, BorderLayout.NORTH);

        Timer timer = new Timer (100, this); // 100 milliseconds
      	timer.start();
    }

    protected int getFrame () {
      return frame;
    }

    // timer
    public void actionPerformed (ActionEvent e) {
	     frame++;
       model.repaint ();
    }

    protected void clearSpace () {
       model.clearSpace();
    }

    protected void addSatellite(String selectedSatellite) {
       model.addSatellite(selectedSatellite);
    }

    protected void changeRotation(int selectedSpeed ) {
       model.changeRotation(selectedSpeed);
    }

    protected void changeEnabled(boolean isEngaged) {
       rotationControl.changeEnabled(isEngaged);
    }
}
