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

public class CommunicationSatellite extends Satellite {

  public CommunicationSatellite(int x, int y, int id) {
    super(x, y, id);
  }

  // This is the draw callback
  public void paintComponent (Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // draw wings
      g2.setColor(Color.yellow);
      g2.fill(new Ellipse2D.Double(posX-30,posY-20,15,30));

      g2.setColor(Color.yellow);
      g2.fill(new Ellipse2D.Double(posX+15,posY-20,15,30));
  }
}
