package Game.Entities.Towers.TowerType;

import Game.Entities.Towers.Tower;
import java.awt.Image;
import java.io.File;

public class Melee extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/melee.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Melee(double x, double y) {
    super(4, 2, 2, false, 10, sprite, x, y, Type.MELEE);
  }

  public static Image getImage() {
    return sprite;
  }
}
