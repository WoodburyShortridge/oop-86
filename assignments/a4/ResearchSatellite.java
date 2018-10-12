/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The research satellite class extends the parent Satellite class and creates a paint method specific for
 * reaserch satellite graphics by adding two blue rectangle wings.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class ResearchSatellite extends Satellite {

  public ResearchSatellite(int x, int y, int id, int frame) {
    super(x, y, id, frame);
  }

  // This is the draw callback
  public void paintComponent (Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      RoundRectangle2D.Double wing1 = new RoundRectangle2D.Double(posX-40,posY-10,25,15,5,5);
      AffineTransform wing1Trans = new AffineTransform ();
      wing1Trans.setToRotation (Math.toRadians(sFrame), posX, posY);
      Shape wing1Shape = wing1Trans.createTransformedShape (wing1);
      g2.setColor(Color.blue);
      g2.fill(wing1Shape);

      RoundRectangle2D.Double wing2 = new RoundRectangle2D.Double(posX+15,posY-10,25,15,5,5);
      AffineTransform wing2Trans = new AffineTransform ();
      wing2Trans.setToRotation (Math.toRadians(sFrame), posX, posY);
      Shape wing2Shape = wing2Trans.createTransformedShape (wing2);
      g2.setColor(Color.blue);
      g2.fill(wing2Shape);
  }
}
