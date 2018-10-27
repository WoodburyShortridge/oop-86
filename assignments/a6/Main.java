/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * Main class extends JFrame and adds an ActionListener. This is the main frame for the satellite view,
 * control interface, canvas and score view.
 * It controls the satellite model data with a timer and
 * has methods for getting frame number, adding satellites, changing rotation speed, and various get methods for children.
 * And it adds the two control views to the layout, scores, and the main canvas.
 *
 */

 import java.awt.*;
 import java.awt.event.*;
 import java.awt.geom.*;
 import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private int frame = 1;
    private Model model;
    private Canvas canvas;
    private ScoreState scoreState;
    private ScoreView scoreView;
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

        scoreView = new ScoreView(this);
        this.add(scoreView, BorderLayout.WEST);

        scoreState = new ScoreState(this, scoreView);

        model = new Model(this, scoreState);

        canvas = new Canvas(this, model);
        this.add(canvas, BorderLayout.CENTER);

        // rotation control view
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
       model.updatePos(frame);
       model.checkCollide();
       canvas.repaint();
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

    protected void repaintCanvas() {
      canvas.repaint();
    }

    protected Integer getCanvasWidth() {
      return canvas.getWidth();
    }
    protected Integer getCanvasHeight() {
      return canvas.getHeight();
    }
}
