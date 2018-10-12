/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The Communication satellite class extends the parent Satellite class and creates a paint method specific for
 * Communication satellite graphics by adding two yellow round wings.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class CommunicationSatellite extends Satellite {

  public CommunicationSatellite(int x, int y, int id, int frame) {
    super(x, y, id, frame);
  }

  // This is the draw callback
  public void paintComponent (Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // draw wings
      Ellipse2D.Double wing1 = new Ellipse2D.Double(posX-30,posY-20,15,30);
      AffineTransform wing1Trans = new AffineTransform ();
      wing1Trans.setToRotation (Math.toRadians(sFrame), posX, posY);
      Shape wing1Shape = wing1Trans.createTransformedShape (wing1);
      g2.setColor(Color.yellow);
      g2.fill(wing1Shape);

      Ellipse2D.Double wing2 = new Ellipse2D.Double(posX+15,posY-20,15,30);
      AffineTransform wing2Trans = new AffineTransform ();
      wing2Trans.setToRotation (Math.toRadians(sFrame), posX, posY);
      Shape wing2Shape = wing2Trans.createTransformedShape (wing2);
      g2.setColor(Color.yellow);
      g2.fill(wing2Shape);
  }
}
