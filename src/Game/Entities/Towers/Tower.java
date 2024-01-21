package Game.Entities.Towers;

import Game.Entities.Enemies.Enemy;
import Game.Main.Models.AUnit;

import java.awt.Image;

public abstract class Tower extends AUnit {

  public enum Type {
    RANGE,
    MELEE,
    AIR,
  }

  protected int damage;
  protected int fireRate;
  protected int range;
  protected boolean antiAir;
  protected int towerLevel;
  protected int price;
  protected long lastShotTime = 0;
  protected Type type;

  public Tower(
    int damage,
    int fireRate,
    int range,
    boolean antiAir,
    int price,
    Image sprite,
    double x,
    double y,
    Type type
  ) {
    super(x, y, sprite);
    this.damage = damage;
    this.fireRate = fireRate;
    this.range = range;
    this.antiAir = antiAir;
    towerLevel = 1;
    this.price = price;
    this.type = type;
  }

  public boolean isEnemyInRange(Enemy enemy) {
    int range = GetDistance(getX(), getY(), enemy.getX(), enemy.getY());
    return range < getRange();
  }

  private int GetDistance(double x1, double y1, double x2, double y2) {
    double xDiff = Math.abs(x1 - x2);
    double yDiff = Math.abs(y1 - y2);
    return (int) Math.hypot(xDiff, yDiff);
  }

  public int getDamage() {
    return damage;
  }

  public int getFireRate() {
    return fireRate;
  }

  public int getRange() {
    return range;
  }

  public boolean getantiAir() {
    return antiAir;
  }

  public int getTowerLevel() {
    return towerLevel;
  }

  public int getPrice() {
    return price;
  }

  public Tower.Type getType() {
    return type;
  }

  public long getLastShotTime() {
    return lastShotTime;
  }

  public void setLastShotTime(long lastShotTime) {
    this.lastShotTime = lastShotTime;
  }
}
