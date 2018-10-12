/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame. This is the main frame for the control interface.
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
        JButton clearSpace = new JButton("Clear space");
        clearSpace.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
    				model.clearSpace();
    			}
        });
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

    // Like a clock tick
    public void actionPerformed (ActionEvent e) {
	     frame++;
       model.repaint ();
    }
}
