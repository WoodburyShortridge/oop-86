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

abstract class Satellite extends JPanel {
    protected int posX;
    protected int posY;

    public Satellite(int x, int y) {
      posX = x;
      posY = y;
    }

    // This is where the draw callback will be
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw body
        g2.setColor(Color.red);
        g2.fill(new RoundRectangle2D.Double(posX-10,posY-15,20,30,5,5));


        // draw connection
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(4));
        g2.draw(new Line2D.Double(posX-14, posY-2.5, posX+14, posY-2.5));
    }
}
