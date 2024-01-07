package Game.Entities.Enemies;

import Game.Entities.Player;
import Game.Entities.Towers.Tower;
import Game.Main.Models.AUnit;
import Game.Main.Models.IMovable;
import java.awt.Image;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Enemy extends AUnit implements IMovable {

  protected int life;
  protected double speed;
  protected boolean fly;
  protected int income;
  protected int maxLife;
  protected double maxSpeed;

  private Image sprite;

  private List<Entry<Integer, Integer>> route;
  private int currentIndex = 0;

  public Enemy(
    int life,
    double speed,
    boolean fly,
    int income,
    List<Entry<Integer, Integer>> route,
    Image sprite
  ) {
    super(route.get(0).getKey(), route.get(0).getValue(), sprite);
    this.sprite = sprite;
    this.life = life;
    this.speed = speed;
    this.fly = fly;
    this.income = income;
    this.route = route;
    this.maxLife = life;
    this.maxSpeed = speed;
  }

  public Image getImage() {
    return sprite;
  }

  public void move() {
    if (currentIndex >= route.size()) {
      return;
    }
    Entry<Integer, Integer> nextPosition = route.get(currentIndex);
    double nextX = nextPosition.getKey();
    double nextY = nextPosition.getValue();
    double deltaX = nextX - getX();
    double deltaY = nextY - getY();
    double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    if (distance <= speed * .2) {
      setX(nextX);
      setY(nextY);
      currentIndex++;
    } else {
      double ratio = speed * .2 / distance;
      double moveX = ratio * deltaX;
      double moveY = ratio * deltaY;
      setX(getX() + moveX);
      setY(getY() + moveY);
    }
  }

  public void dealDamage(Tower tower) {
    int remainingLife = getLife() - tower.getDamage();
    setLife(Math.max(0, remainingLife));
    if (getLife() == 0) {
      rewardPlayer();
    }
  }

  public void reset(List<Map.Entry<Integer, Integer>> route) {
    this.route = route;
    setX(route.get(0).getKey());
    setY(route.get(0).getValue());
    this.life = maxLife;
    this.speed = maxSpeed;
  }

  public void upgradeEnemy() {
    this.maxLife *= 2;
    this.maxSpeed *= 2;
  }

  public void rewardPlayer() {
    Player.addGold(getIncome());
  }

  public boolean hasReachedEnd() {
    return currentIndex >= route.size();
  }

  public void setLife(int life) {
    this.life = life;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public int getLife() {
    return life;
  }

  public double getSpeed() {
    return speed;
  }

  public boolean getFly() {
    return fly;
  }

  public int getIncome() {
    return income;
  }

  public int getMaxLife() {
    return maxLife;
  }

  public boolean isDead() {
    return life <= 0;
  }
}
