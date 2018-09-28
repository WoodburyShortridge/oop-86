/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The scroll bar extends JScroll and adds a listener for printing
 *
 */

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar implements AdjustmentListener {
    // scroll id
    private int id;

    public ScrollBar (int id) {
        setOrientation (HORIZONTAL);
        setMinimum (0);
        setMaximum (100);
        setValue (25);

        this.id = id;
        addAdjustmentListener (this);
    }

    public void adjustmentValueChanged (AdjustmentEvent event) {
        System.out.println ("Scrollbar " + id + ": new value = " + getValue());
    }
}