/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The model class extends JPanel and creates a data store for each satellite.
 * This class contains the main draw callback which creates the background
 * and adds satellites based on the data stores for ID, Type, Possition, and Rotation speed/direction.
 * The model class also has methods for adding satellites and clearing space along with a helper method
 * for random integers.
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
    private Main parent;
    protected int satelliteCount;
    private ArrayList<Integer> satelliteList = new ArrayList<Integer>();
    private ArrayList<String> satelliteType = new ArrayList<String>();
    private ArrayList<Point> satellitePos = new ArrayList<Point>();
    private ArrayList<Integer> randomList = new ArrayList<Integer>();

    public Model(Main parent) {
      this.parent = parent;

      // start with 3 satellites
      satelliteList.add(0);
      satelliteType.add("Research");
      Point posInit = new Point(250,250);
      satellitePos.add(posInit);
      randomList.add(randomInteger(-5,5));

    }

    // This is the draw callback
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // first set background
        g2.setColor(Color.black);
        g2.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));

        // then draw random stars
        for (int i=0; i < 100; i++) {
          g2.setColor(Color.white);
          g2.fill(new Ellipse2D.Double(randomInteger(0,this.getWidth()),randomInteger(0,this.getHeight()),randomInteger(1,3),randomInteger(1,3)));
        }

        // finally add satellites from data store
      	for(int id : satelliteList) {
          if (satelliteType.get(id) == "Research") {
            new ResearchSatellite((int)satellitePos.get(id).getX(), (int)satellitePos.get(id).getY(), id, parent.getFrame()*randomList.get(id)).paintComponent(g);
          }
          if (satelliteType.get(id) == "Weather") {
            new WeatherSatellite((int)satellitePos.get(id).getX(), (int)satellitePos.get(id).getY(), id, -parent.getFrame()*randomList.get(id)).paintComponent(g);
          }
          if (satelliteType.get(id) == "Communication") {
            new CommunicationSatellite((int)satellitePos.get(id).getX(), (int)satellitePos.get(id).getY(), id, -parent.getFrame()*randomList.get(id)).paintComponent(g);
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
    // method to add satellites
    protected void addSatellite(String selectedSatellite) {
      int size = satelliteList.size();
      satelliteList.add(size);
      satelliteType.add(selectedSatellite);
      Point pos = new Point(this.getWidth() - randomInteger(1,this.getWidth()),this.getHeight() - randomInteger(1,this.getHeight()));
      satellitePos.add(pos);
      randomList.add(randomInteger(-5,5));

      System.out.println (selectedSatellite + " Satellite Added");
      this.repaint();
    }
}
