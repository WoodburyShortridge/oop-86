import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JPanel {
  private Timeout parent;
  private int w;
  private int h;

  public Canvas (Timeout parent) {
    this.parent = parent;
  }
  public void paintComponent (Graphics g) {
	super.paintComponent(g);
    w = this.getSize().width;
    h = this.getSize().height;

    if (w < parent.getFrame()) {
      g.drawArc (
    		// Moves by 2 pixels on each frame
    		10 - 2 * parent.getFrame(),
    		10 - 2 * parent.getFrame(),
    		// size
    		100, 100,
    		// degrees
    		0, 360);
    } else {
      g.drawArc (
    		// Moves by 2 pixels on each frame
    		10 + 2 * parent.getFrame(),
    		10 + 2 * parent.getFrame(),
    		// size
    		100, 100,
    		// degrees
    		0, 360);
    }

    g.drawArc (
  		// Moves by 2 pixels on each frame
  		300 - 3 * parent.getFrame(),
  		300 - 5 * parent.getFrame(),
  		// size
  		50, 50,
  		// degrees
  		0, 360);
    }
}
