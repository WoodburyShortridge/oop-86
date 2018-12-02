import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ScrollBar extends JScrollBar implements AdjustmentListener {
    public ScrollBar () { 
	setOrientation (HORIZONTAL); 
	addAdjustmentListener (this);
    }

    public void adjustmentValueChanged (AdjustmentEvent event) { 
        System.out.println ("Scrollbar: " + getValue()); 
    }
}

