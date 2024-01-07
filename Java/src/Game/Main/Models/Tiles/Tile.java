package Game.Main.Models.Tiles;

import java.awt.Image;

import Game.Main.Models.AUnit;

public abstract class Tile extends AUnit {

  private boolean isWalkable;
  private boolean isBuildable;

  public Tile(
    int x,
    int y,
    boolean isWalkable,
    boolean isBuildable,
    Image sprite
  ) {
    super(x, y, sprite);
    this.isWalkable = isWalkable;
    this.isBuildable = isBuildable;
  }

  public boolean isWalkable() {
    return isWalkable;
  }

  public boolean isBuildable() {
    return isBuildable;
  }
}
