package Game.Main.Models.Tiles;

import java.awt.Image;
import java.io.File;

public class Empty extends Tile {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Map/image_0.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  

  public Empty(int x, int y) {
    super(x, y, false, false, sprite);
  }
}
