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
    protected int posX;
    protected int posY;

    public Model() {

    }

    // This is the draw callback is
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Satellite researchSatellite = new ResearchSatellite(100,100);
        researchSatellite.paintComponent(g);

        Satellite weatherSatellite = new WeatherSatellite(200,200);
        weatherSatellite.paintComponent(g);

        Satellite weatherSatellite2 = new WeatherSatellite(400,300);
        weatherSatellite2.paintComponent(g);
    }
}
