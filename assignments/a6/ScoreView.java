/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The score view display extends Jpanel by adding two labels, one for score and one for top score. There
 * are two protected methods for updating these scores.
 *
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ScoreView extends JPanel {
    private Main parent;
    private ScoreState scoreState;
    private int score;
    private JLabel scoreLabel;
    private int topScore;
    private JLabel topScoreLabel;
    public ScoreView(Main parent) {
        // This frame is used to organize the controls
        this.parent = parent;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GREEN);

        EmptyBorder border1 = new EmptyBorder(new Insets (50,10,10,10));
        EmptyBorder border2 = new EmptyBorder(new Insets (10,10,10,10));

        this.scoreLabel = new JLabel ("Score: " + this.score );
        this.scoreLabel.setBorder(border1);
      	add (this.scoreLabel);

        this.topScoreLabel = new JLabel ("Top Score: " + this.topScore );
        this.topScoreLabel.setBorder(border2);
      	add (this.topScoreLabel);
    }

    protected void setScore(int score) {
      this.score = score;
      this.scoreLabel.setText("Score: " + this.score );
      System.out.println ("new score: " + score);
    }

    protected void setTopScore(int topScore) {
      this.topScore = topScore;
      this.topScoreLabel.setText("Top Score: " + this.topScore );
      System.out.println ("new top score: " + topScore);
    }
}
