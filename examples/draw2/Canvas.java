import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JPanel {
    // This is the draw callback
    public void paintComponent (Graphics g) { 
	super.paintComponent(g); 
	g.drawLine (50, 50, 100, 50);
	// g.setColor(Color blue);
	g.drawString("Hello", 10, 10);
	g.drawOval(25, 35, 25, 35);
	setBackground(GREEN); 
    }
}
