/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame and adds an ActionListener. This is the main frame for the satellite view and control interface.
 * the main frame contains the clear space method and adds it to the layout. I also controls the satellite model graphics with a timer and
 * has methods for getting frame number, and adding satellites.
 * And it adds the control view to the bottom of the layout.
 *
 */

 import java.awt.*;
 import java.awt.event.*;
 import java.awt.geom.*;
 import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private int frame = 1;
    private Model model;

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
        ClearButton clearSpace = new ClearButton("Clear space", this);
        this.add(clearSpace, BorderLayout.NORTH);

        // add control view
        ControlView controlView = new ControlView(this);
        this.add(controlView, BorderLayout.SOUTH);

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
}
