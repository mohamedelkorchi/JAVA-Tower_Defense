package Game.Entities.Towers.TowerType;

import Game.Entities.Towers.Tower;
import java.awt.Image;
import java.io.File;

public class Air extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/air.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Air(double x, double y) {
    super(3, 5, 5, true, 10, sprite, x, y, Type.AIR);
  }

  public static Image getImage() {
    return sprite;
  }
}
