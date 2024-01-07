package Game.Main;

import Game.Entities.Player;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPage extends JPanel {

  public GameOverPage(Game game) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JLabel messageLabel = new JLabel("Game Over");
    messageLabel.setFont(new Font("Arial", Font.BOLD, 50));
    messageLabel.setAlignmentX(CENTER_ALIGNMENT);

    JLabel scoreLabel = new JLabel("Your score : " + Player.getScore());
    scoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
    scoreLabel.setForeground(Color.RED);
    scoreLabel.setAlignmentX(CENTER_ALIGNMENT);

    JLabel waveLabel = new JLabel("Wave : " + WaveManager.getWaveIndex());
    waveLabel.setFont(new Font("Arial", Font.BOLD, 50));
    waveLabel.setForeground(Color.BLUE);
    waveLabel.setAlignmentX(CENTER_ALIGNMENT);

    Player.initPlayer();
    WaveManager.waveIndex = 1;

    add(Box.createVerticalStrut(20));
    add(messageLabel);
    add(Box.createVerticalStrut(20));
    add(waveLabel);
    add(Box.createVerticalStrut(20));
    add(scoreLabel);
  }
}
