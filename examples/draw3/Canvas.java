import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener {
    private int mx;
    private int my;
 
    Canvas () {
	    addMouseListener (this); 
    }

    // This is the draw callback
    public void paintComponent (Graphics g) {
	super.paintComponent(g);
	g.drawOval (mx, my, 100, 50);
    }

    // Listener callback
    public void mousePressed (MouseEvent event) {
	mx = event.getPoint().x;
	my = event.getPoint().y;
	this.repaint(); 
        System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y); 
    }

    // MouseListener defines all of these, so we must supply them 
    public void mouseReleased (MouseEvent event) {} 
    public void mouseClicked (MouseEvent event) {} 
    public void mouseEntered (MouseEvent event) {} 
    public void mouseExited (MouseEvent event) {} 
}
