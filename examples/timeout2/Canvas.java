import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JPanel {
    /**
     * Our basic shape, in canonical orientation, centered at 0, 0
     */
    private Rectangle2D rect = new Rectangle2D.Double (-25, -25, 50, 50);

    private Timeout parent;

    public Canvas (Timeout parent) {
	     this.parent = parent;
    }

    public void paintComponent (Graphics g) {
  	super.paintComponent(g);
  	Graphics2D g2 = (Graphics2D) g;

  	int nboxes = parent.getFrame();

  	for (int ibox=0; ibox<nboxes; ibox++) {
  	    // First rotate about its center
  	    AffineTransform trans = new AffineTransform ();
  	    trans.setToRotation (ibox/10.);
  	    Shape s = trans.createTransformedShape (rect);

  	    // Then move it somewhere
  	    trans = new AffineTransform ();
  	    trans.setToTranslation (100+2*ibox, 100+2*ibox);
  	    s = trans.createTransformedShape (s);

  	    g2.draw (s);
	   }
    }
}
