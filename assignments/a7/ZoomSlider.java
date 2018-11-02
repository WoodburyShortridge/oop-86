/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The zoom slider extends JSlider and adds a change listener for scaling the zoom
 *
 */

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.util.Hashtable;


public class ZoomSlider extends JSlider implements ChangeListener {
    private Main parent;
    private Model model;

    public ZoomSlider (Main parent, Model model) {
        this.parent = parent;
        this.model = model;
        // Customize properties of Zoom Slider
        setMinimum (0);
        setMaximum (100);
        setMajorTickSpacing(10);
        setPaintTicks(true);
        setPaintLabels(true);
        Hashtable<Integer,JLabel> position = new Hashtable<Integer,JLabel>();
        position.put(0, new JLabel("0"));
        position.put(25, new JLabel("25"));
        position.put(50, new JLabel("50"));
        position.put(75, new JLabel("75"));
        position.put(100, new JLabel("100"));
        setValue (1);
        setOrientation(VERTICAL);

        // Label
        JLabel sliderLabel = new JLabel("Zoom", JLabel.CENTER);
        sliderLabel.setVerticalTextPosition(JLabel.BOTTOM);
        add(sliderLabel);
        addChangeListener(this);
    }

    public void stateChanged(ChangeEvent event) {
        model.setZoom(getValue());
        System.out.println ("Zoom : new value = " + getValue());
    }
}
