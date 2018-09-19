/*
 * Woodbury Shortridge
 */
import javax.swing.JFrame;
import java.awt.Container;
//import javax.swing.JSlider;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setSize(300,300);
        Container content = getContentPane();

//        PrintButton b1 = new PrintButton("click me");
//        b1.buttonPrint("you clicked me fool");

        CountButton b1 = new CountButton(0,"cats");

        content.add(b1);
        setVisible(true);
    }
}