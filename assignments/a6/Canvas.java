/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The model class extends JPanel and uses a mouse listener.
 * This class contains the main draw callback which creates the background
 * and adds satellites based on the data stores in model. The canvas is responsible for creating
 * each satellite.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class Canvas extends JPanel implements MouseListener {
  private Main parent;
  private Model model;

  public Canvas(Main parent, Model model) {
    this.parent = parent;
    this.model = model;
    addMouseListener (this);
  }

  public void paintComponent (Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // first set background
      g2.setColor(Color.black);
      g2.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));

      // then draw random stars
      for (int i=0; i < 100; i++) {
        g2.setColor(Color.white);
        g2.fill(new Ellipse2D.Double(model.randomInteger(0,this.getWidth()),model.randomInteger(0,this.getHeight()),model.randomInteger(1,3),model.randomInteger(1,3)));
      }

      // finally add satellites from data store
      for(int id : model.getArrayInt("satelliteList")) {

        if (model.getArrayBool("removedList").get(id) == false ) {
          if (model.getArrayPoint("satellitePos").get(id) == model.getPoint("selectedPoint")) {
            model.setBool("thisEngaged", true);
          } else {
            model.setBool("thisEngaged", false);
          }
          if (model.getArrayString("satelliteType").get(id) == "Research") {
            new ResearchSatellite(
              (int)model.getArrayPoint("satellitePos").get(id).getX(),
              (int)model.getArrayPoint("satellitePos").get(id).getY(),
              id,
              parent.getFrame()* (model.getArrayInt("randomList").get(id)),
              model.getBool("thisEngaged")
            ).paintComponent(g);
          }
          if (model.getArrayString("satelliteType").get(id) == "Weather") {
            new WeatherSatellite(
              (int)model.getArrayPoint("satellitePos").get(id).getX(),
              (int)model.getArrayPoint("satellitePos").get(id).getY(),
              id,
              parent.getFrame()* (model.getArrayInt("randomList").get(id)),
              model.getBool("thisEngaged")
            ).paintComponent(g);
          }
          if (model.getArrayString("satelliteType").get(id) == "Communication") {
            new CommunicationSatellite(
              (int)model.getArrayPoint("satellitePos").get(id).getX(),
              (int)model.getArrayPoint("satellitePos").get(id).getY(),
              id,
              parent.getFrame()* (model.getArrayInt("randomList").get(id)),
              model.getBool("thisEngaged")
            ).paintComponent(g);
          }
        }
      }
  }

  public void mousePressed (MouseEvent event) {
      // check if satellite is here
      Point p = new Point(0,0);
      for(int id : model.getArrayInt("satelliteList")) {
        if (model.getArrayBool("removedList").get(id) == false) {
          p = model.getArrayPoint("satellitePos").get(id);
          if (Math.abs(event.getPoint().x - p.x) < 50) {
            if (Math.abs(event.getPoint().y - p.y) < 50) {
              model.setPoint("selectedPoint", p);
              model.setBool("engaged", true);
              parent.changeEnabled(model.getBool("engaged"));
              System.out.println ("Satellite engaged at " + p.x + ", " + p.y);
              this.repaint();
              break;
            }
            else {
              model.setBool("engaged", false);
              parent.changeEnabled(model.getBool("engaged"));
              model.setPoint("selectedPoint", event.getPoint());
            }
          }
          else {
            model.setBool("engaged", false);
            parent.changeEnabled(model.getBool("engaged"));
            model.setPoint("selectedPoint", event.getPoint());
          }
        }
      }
  }

  // MouseListener defines all of these, so we must supply them
  public void mouseReleased (MouseEvent event) {}
  public void mouseClicked (MouseEvent event) {}
  public void mouseEntered (MouseEvent event) {}
  public void mouseExited (MouseEvent event) {}
}
