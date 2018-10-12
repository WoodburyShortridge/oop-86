/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The Satellite abstract class extends Jpanel and creates the base data store and paint method for all three
 * satellites. It draws the satellite bodies and ID tags.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

abstract class Satellite extends JPanel {
    protected int posX;
    protected int posY;
    protected int sID;
    protected int sFrame;

    public Satellite(int x, int y, int id, int frame) {
      posX = x;
      posY = y;
      sID = id;
      sFrame = frame;
    }

    // This is the draw callback
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw body
        RoundRectangle2D.Double body = new RoundRectangle2D.Double(posX-10,posY-15,20,30,5,5);
        AffineTransform bodyTrans = new AffineTransform ();
  	    bodyTrans.setToRotation (Math.toRadians(sFrame), posX, posY);
  	    Shape bodyShape = bodyTrans.createTransformedShape (body);
        g2.setColor(Color.red);
        g2.fill(bodyShape);

        // draw connection
        Line2D.Double connect = new Line2D.Double(posX-14, posY-2.5, posX+14, posY-2.5);
        AffineTransform connectTrans = new AffineTransform ();
  	    connectTrans.setToRotation (Math.toRadians(sFrame), posX, posY);
  	    Shape connectShape = connectTrans.createTransformedShape (connect);
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(4));
        g2.draw(connectShape);

        // draw ID
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawString(Integer.toString(sID), posX - 5, posY + 5);
    }
}
