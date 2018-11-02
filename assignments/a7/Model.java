/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The model class extends creates a data store for each satellite as well as various states.
 * The data stores for ID, Type, Possition, direction, and Rotation speed/directionList, and if selected or if removed.
 * The model class also has methods for adding satellites, changing position, checking for a collison,
 * as well as a method to get or set data and a helper method for random integers.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class Model {
    // pointers
    private Main parent;
    private ScoreState scoreState;
    // data model to build graphics
    private ArrayList<Integer> satelliteList = new ArrayList<Integer>();
    private ArrayList<String> satelliteType = new ArrayList<String>();
    private ArrayList<Point> satellitePos = new ArrayList<Point>();
    private ArrayList<Integer> randomList = new ArrayList<Integer>();
    private ArrayList<Integer> directionList = new ArrayList<Integer>();
    private ArrayList<Boolean> removedList = new ArrayList<Boolean>();
    private Point selectedPoint;
    private int zoom = 1;
    private boolean engaged;
    private boolean thisEngaged;
    public Model(Main parent, ScoreState scoreState) {
      this.parent = parent;
      this.scoreState = scoreState;
    }

    protected static int randomInteger(int min, int max) {
      int randNum = (int)(Math.random() * ((max - min) + 1)) + min;
      return randNum;
    }

    // method to add satellites
    protected void addSatellite(String selectedSatellite) {
      int size = satelliteList.size();
      satelliteList.add(size);
      satelliteType.add(selectedSatellite);
      Point pos = new Point(parent.getCanvasWidth() - randomInteger(1, parent.getCanvasWidth()),parent.getCanvasHeight() - randomInteger(1,parent.getCanvasHeight()));
      satellitePos.add(pos);
      randomList.add(randomInteger(-5,5));
      directionList.add(1);
      removedList.add(false);
      System.out.println (selectedSatellite + " Satellite Added");
      if (selectedSatellite == "Research") {
        scoreState.updateScore(1);
      }
      else if (selectedSatellite == "Communication") {
        scoreState.updateScore(2);
      }
      else if (selectedSatellite == "Weather") {
        scoreState.updateScore(3);
      }
      parent.repaintCanvas();
    }

    protected void changeRotation(int selectedSpeed) {
      for(int id : satelliteList) {
        if (satellitePos.get(id) == selectedPoint ) {
          randomList.set(id, selectedSpeed);
          System.out.println ("Speed changed to " + selectedSpeed);
          parent.repaintCanvas();
        }
      }
    }

    protected void updatePos(int frame) {
      for(int id : satelliteList) {
        if ((satellitePos.get(id).getX() < 0) || (satellitePos.get(id).getY() < 0)) {
          directionList.set(id, 1);
        }
        if ((satellitePos.get(id).getX() > parent.getCanvasWidth()) || (satellitePos.get(id).getY() > parent.getCanvasHeight())) {
          directionList.set(id, -1);
        }
        Point pos = new Point((int)satellitePos.get(id).getX() + directionList.get(id), (int)satellitePos.get(id).getY() + directionList.get(id));
        if (satellitePos.get(id) == this.selectedPoint) {
          this.selectedPoint = pos;
        }
        satellitePos.set(id, pos);
      }
    }

    protected void setZoom(int zoom) {
      this.zoom = zoom;
    }

    protected void checkCollide() {
      OUTER:for(int id : satelliteList) {
        for(int otherId : satelliteList) {
          if ((id != otherId) && removedList.get(id) == false && removedList.get(otherId) == false ) {
            if ((Math.abs(satellitePos.get(id).getX() - satellitePos.get(otherId).getX()) < 50) && (Math.abs(satellitePos.get(id).getY() - satellitePos.get(otherId).getY()) < 50)) {
              if (satelliteType.get(id) == "Research") {
                removedList.set(otherId, true);
                if (satelliteType.get(otherId) == "Research") {
                  scoreState.updateScore(-1);
                }
                else if (satelliteType.get(otherId) == "Communication") {
                  scoreState.updateScore(-2);
                }
                else {
                  scoreState.updateScore(-3);
                }
              }
              else if ((satelliteType.get(id) == "Communication") && (satelliteType.get(otherId) != "Research")) {
                removedList.set(otherId, true);
                if (satelliteType.get(otherId) == "Communication") {
                  scoreState.updateScore(-2);
                }
                else {
                  scoreState.updateScore(-3);
                }
              }
              else if ((satelliteType.get(id) == "Weather") && (satelliteType.get(otherId) != "Research") && (satelliteType.get(otherId) != "Communication")) {
                removedList.set(otherId, true);
                scoreState.updateScore(-3);
              }
            }
          }
        }
      }
    }

    protected ArrayList<Integer> getArrayInt(String which) {
      if (which == "satelliteList") {
        return this.satelliteList;
      }
      if (which == "randomList") {
        return this.randomList;
      }
      else {
        return this.randomList;
      }
    }

    protected ArrayList<Point> getArrayPoint(String which) {
      if (which == "satellitePos") {
        return this.satellitePos;
      }
      else {
        return this.satellitePos;
      }
    }

    protected ArrayList<String> getArrayString(String which) {
      if (which == "satelliteType") {
        return this.satelliteType;
      }
      else {
        return this.satelliteType;
      }
    }

    protected ArrayList<Boolean> getArrayBool(String which) {
      if (which == "removedList") {
        return this.removedList;
      }
      else {
        return this.removedList;
      }
    }

    protected Point getPoint(String which) {
      if (which == "selectedPoint") {
        return this.selectedPoint;
      }
      else {
        return this.selectedPoint;
      }
    }

    protected boolean getBool(String which) {
      if (which == "engaged") {
        return this.engaged;
      }
      if (which == "thisEngaged") {
        return this.thisEngaged;
      }
      else {
        return this.thisEngaged;
      }
    }

    protected void setBool(String which, boolean value) {
      if (which == "engaged") {
        this.engaged = value;
      }
      if (which == "thisEngaged") {
        this.thisEngaged = value;
      }
    }

    protected void setPoint(String which, Point value) {
      if (which == "selectedPoint") {
        this.selectedPoint = value;
      }
    }

    protected int getZoom() {
      return this.zoom;
    }

}
