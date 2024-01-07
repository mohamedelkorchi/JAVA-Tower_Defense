package Game.Main.Models.Tiles;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Route extends Tile {

  private static Image sprite = null;

  static {
    try {
      String imagePath = "src/Resource/Images/Map/image_2.png";
      File imageFile = new File(imagePath);
      sprite = ImageIO.read(imageFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Route(int x, int y) {
    super(x, y, true, false, sprite);
  }
}
