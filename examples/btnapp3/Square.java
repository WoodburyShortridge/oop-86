import java.awt.*;

/**
 * Square holds the "model" data for one square
 */
public class Square {
    /** Enumerated type for which action to take */
    public enum ButtonAction {LEFT, RIGHT, BIGGER, SMALLER, FILL, EMPTY}; 

    /** The model data */
    private Rectangle loc = new Rectangle (100, 50, 50, 50); 
    private boolean filled = false; 

    private Canvas canvas;

    public Square (Canvas canvas) {
	this.canvas = canvas;
    }

    public void draw (Graphics g) { 
	Graphics2D g2 = (Graphics2D) g;

	if (filled) g2.fill (loc); 
	else g2.draw (loc); 
    }

    public void doAction (ButtonAction action) { 
	if (action==ButtonAction.LEFT) loc.x -= 10; 
	else if (action==ButtonAction.RIGHT) loc.x += 10; 
	else if (action==ButtonAction.BIGGER) { loc.width += 10; loc.height += 10; } 
	else if (action==ButtonAction.SMALLER) { loc.width -= 10; loc.height -= 10; } 
	else if (action==ButtonAction.FILL) filled = true; 
	else if (action==ButtonAction.EMPTY) filled = false; 

	canvas.repaint(); 
    }
}

