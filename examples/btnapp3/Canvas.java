import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Canvas object
 */
public class Canvas extends JPanel implements MouseListener {
    private ButtonApp parent; 

    public Canvas (ButtonApp parent) {
	this.parent = parent; 
	setBorder (new LineBorder(Color.BLUE));
	addMouseListener (this);
    }

    /** Tell parent to do the job */
    public void paintComponent (Graphics g) { 
	super.paintComponent(g);
	parent.drawSquares (g); 
    }

    /** MouseListener callbacks */
    public void mousePressed (MouseEvent event) {	
	System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
    }
    public void mouseClicked (MouseEvent event) {}
    public void mouseReleased (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
}
