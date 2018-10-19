/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The speed selector class extends J ComboBox by adding an event listener that prints to the terminal.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SpeedSelector extends JComboBox<Integer> implements ItemListener {
  public SpeedSelector () {
  	addItem (5);
  	addItem (4);
  	addItem (3);
    addItem (2);
  	addItem (1);
  	addItem (0);
    addItem (-1);
  	addItem (-2);
  	addItem (-3);
    addItem (-4);
  	addItem (-5);
  	addItemListener (this);
  }

  public void itemStateChanged (ItemEvent e) {
  	if (e.getStateChange()==ItemEvent.SELECTED) {
  	    System.out.println ("Rotation Speed: " + e.getItem());
  	}
  }
}
