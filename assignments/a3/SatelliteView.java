/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The satellite view class extends JPanel and creates a paint method for graphics.
 * This class implements mouse listner for click events. The pain method is called on Each
 * click to either place a new satellite in space, or activate an existing satellite by
 * turning it green.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class SatelliteView extends JPanel implements MouseListener {
    private ArrayList<Point> points = new ArrayList<Point>();
    private boolean newSatellite = true;
    private Point selectedPoint;

    public SatelliteView() {
        addMouseListener (this);
    }

    // This is where the draw callback will be
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Point p : points) {

          if (p == selectedPoint ) {
            // draw wings
            g2.setColor(Color.green);
            g2.fill(new RoundRectangle2D.Double(p.x-40,p.y-10,25,15,5,5));

            g2.setColor(Color.green);
            g2.fill(new RoundRectangle2D.Double(p.x+15,p.y-10,25,15,5,5));

            // draw body
            g2.setColor(Color.green);
            g2.fill(new RoundRectangle2D.Double(p.x-10,p.y-15,20,30,5,5));

            // draw connection
            g2.setColor(Color.green);
            g2.setStroke(new BasicStroke(4));
            g2.draw(new Line2D.Double(p.x-14, p.y-2.5, p.x+14, p.y-2.5));
          } else {
            // draw wings
            g2.setColor(Color.blue);
            g2.fill(new RoundRectangle2D.Double(p.x-40,p.y-10,25,15,5,5));

            g2.setColor(Color.blue);
            g2.fill(new RoundRectangle2D.Double(p.x+15,p.y-10,25,15,5,5));

            // draw body
            g2.setColor(Color.red);
            g2.fill(new RoundRectangle2D.Double(p.x-10,p.y-15,20,30,5,5));

            // draw connection
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));
            g2.draw(new Line2D.Double(p.x-14, p.y-2.5, p.x+14, p.y-2.5));
          }

          // // rotation
          // g2.rotate(Math.toRadians(45));

        }
    }

    // Listener callback
    public void mousePressed (MouseEvent event) {
        newSatellite = true;
        // check if satellite is here
        for (Point p : points) {
          if (Math.abs(event.getPoint().x - p.x) < 50) {
            if (Math.abs(event.getPoint().y - p.y) < 50) {
              System.out.println ("oops");
              newSatellite = false;
              selectedPoint = p;
              // points.remove(p);
              System.out.println ("Satellite engaged at " + p.x + ", " + p.y);
              this.repaint();
              break;
            }
          }
        }

        if (newSatellite) {
          points.add (event.getPoint());
          selectedPoint = null;
          this.repaint();
          System.out.println ("Added satellite at " + event.getPoint().x + ", " + event.getPoint().y);
        }
    }

    // MouseListener defines all of these, so we must supply them
    public void mouseReleased (MouseEvent event) {}
    public void mouseClicked (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}

    // method to destoy Satellite
    protected void clearSpace() {
        points.clear();
        System.out.println ("Space Cleared");
        this.repaint();
    }
}
