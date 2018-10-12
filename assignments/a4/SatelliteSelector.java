import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Note: On older versions of Java, use "JComboBox" not "JComboBox<String>"
public class SatelliteSelector extends JComboBox<String> implements ItemListener {
  public SatelliteSelector () {
  	addItem ("Research");
  	addItem ("Communication");
  	addItem ("Weather");
  	setSelectedItem ("Research");
  	addItemListener (this);
  }

  public void itemStateChanged (ItemEvent e) {
  	if (e.getStateChange()==ItemEvent.SELECTED) {
  	    System.out.println ("Satellite Selector: " + e.getItem());
  	}
  }
}
