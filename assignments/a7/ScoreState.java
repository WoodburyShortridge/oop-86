/*
 * Woodbury Shortridge
 * woodbury.shortridge@tufts.edu
 *
 * The score state class stores the data for keeping track on game play and provides methods for updating
 * the score view display.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;

public class ScoreState {
    // pointers
    private Main parent;
    private ScoreView scoreView;
    private int score;
    private int topScore;

    public ScoreState(Main parent, ScoreView scoreView) {
      this.parent = parent;
      this.scoreView = scoreView;
      this.score = 0;
      this.topScore = 0;
      scoreView.setScore(this.score);
    }

    protected int getScore() {
      return this.score;
    }

    protected void updateScore(int update) {
      System.out.println ("update " + update);
      this.score += update;
      scoreView.setScore(this.score);
      checkTopScore();
    }

    private void checkTopScore() {
      if (this.score > this.topScore) {
        this.topScore = this.score;
        scoreView.setTopScore(this.topScore);
      }
    }
}
