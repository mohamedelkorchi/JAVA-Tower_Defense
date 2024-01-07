package Game.Main.Models.Tiles;

import java.awt.Image;
import java.io.File;

public class End extends Tile {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Map/image_3.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public End(int x, int y) {
    super(x, y, true, false, sprite);
  }
}
