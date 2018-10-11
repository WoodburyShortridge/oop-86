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

public class Model extends JPanel {
    // data model to build graphics
    protected int satelliteCount;
    private ArrayList<Integer> satelliteList = new ArrayList<Integer>();
    private ArrayList<String> satelliteType = new ArrayList<String>();
    private ArrayList<Point> satellitePos = new ArrayList<Point>();

    public Model() {
      satelliteCount = 10;
      for (int i=0; i < satelliteCount; i++) {
        satelliteList.add(i);
        satelliteType.add("Research");
        Point pos = new Point(100 + 100*i,100 + 100*i);
        satellitePos.add(pos);
      }
    }

    // This is the draw callback is
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // first set background
        g2.setColor(Color.black);
        g2.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));

        // then draw random stars
        for (int i=0; i < 1000; i++) {
          g2.setColor(Color.white);
          g2.fill(new Ellipse2D.Double(randomInteger(0,this.getWidth()),randomInteger(0,this.getHeight()),randomInteger(1,3),randomInteger(1,3)));
        }

        // finally add satellites
      	for(int id : satelliteList) {
          if (satelliteType.get(id) == "Research") {
            new ResearchSatellite((int)satellitePos.get(id).getX(), (int)satellitePos.get(id).getY(), id).paintComponent(g);
          }
        }
    }

    private static int randomInteger(int min, int max) {
      int randNum = (int)(Math.random() * ((max - min) + 1)) + min;
      return randNum;
    }

    protected void clearSpace() {
      // empty data stores
      satelliteList.clear();
      satelliteType.clear();
      satellitePos.clear();
      
      System.out.println ("Space Cleared");
      this.repaint();
    }
}
