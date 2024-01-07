package Game.Main;

import Game.Entities.Enemies.Enemy;
import Game.Main.Models.AUnit;
import Game.Main.Models.Tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;

public class GraphicsRenderer {

  public static final int rows = 16;
  public static final int cols = 30;
  public static final int spriteSize = 50;
  public static final int panelWidth = 1500;

  public static void drawMap(Graphics g, Tile[][] map) {
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        if (i < map.length && j < map[i].length) {
          draw(g, map[i][j]);
        }
      }
    }
  }

  public static void draw(Graphics g, AUnit u) {
    int gridWidth = cols * spriteSize;
    int xOffset = (panelWidth - gridWidth) / 2;
    int yOffset = 100;
    int x = (int) Math.floor(xOffset + u.getX() * spriteSize);
    int y = (int) Math.floor(yOffset + u.getY() * spriteSize);
    g.drawImage(u.getSprite(), x, y, spriteSize, spriteSize, null);
  }

  public static void drawLifeBar(Graphics g, Enemy e) {
    int gridWidth = cols * spriteSize;
    int xOffset = (panelWidth - gridWidth) / 2;
    int yOffset = 100;
    int x = (int) Math.floor(xOffset + e.getX() * spriteSize);
    int y = (int) Math.floor(yOffset + e.getY() * spriteSize);
    int barWidth = spriteSize;
    int barHeight = 5;
    int barX = x;
    int barY = y - barHeight - 2;
    g.setColor(Color.RED);
    g.fillRect(barX, barY, barWidth, barHeight);
    g.setColor(Color.GREEN);
    int remainingBarWidth = (int) (
      barWidth * ((float) e.getLife() / e.getMaxLife())
    );
    g.fillRect(barX, barY, remainingBarWidth, barHeight);
  }
}
