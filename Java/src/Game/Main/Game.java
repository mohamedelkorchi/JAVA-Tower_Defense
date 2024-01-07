package Game.Main;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFrame;

public class Game extends JFrame {

  private PlayPage game;

    private static final List<List<List<Entry<Integer, Integer>>>> ROUTES = Arrays.asList(
    Arrays.asList(
      Arrays.asList(
        new SimpleEntry<Integer, Integer>(1, 7),
        new SimpleEntry<Integer, Integer>(28, 7)
      )
    )
  );

  public Game() {
    setSize(1500, 950);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    game = new PlayPage(this,ROUTES.get(0));
    setGame();
  }

  public void setGame() {
    setContentPane(game);
    game.setVisible(true);
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.setVisible(true);
  }
}
