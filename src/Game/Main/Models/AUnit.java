package Game.Main.Models;

import java.awt.Image;

public abstract class AUnit extends APosition implements IDrawable {

  private Image sprite;

  public Image getSprite() {
    return sprite;
  }

  public AUnit(double x, double y, Image sprite) {
    super(x, y);
    this.sprite = sprite;
  }
}
