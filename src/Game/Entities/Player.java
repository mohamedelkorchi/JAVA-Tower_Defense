package Game.Entities;

public class Player {

  protected static int life = 20;
  protected static int gold = 10;
  protected static int score;

  public static boolean onEnemyExit(int scoreMalus) {
    life -= 1;
    score -= scoreMalus;
    if (life == 0) {
      return true;
    }
    return false;
  }

  public static void initPlayer() {
    life = 20;
    gold = 10;
    score = 0;
  }

  public static void addGold(int goldToAdd) {
    gold += goldToAdd;
    if (goldToAdd > 0) {
      score += goldToAdd;
    }
  }

  public static int getLife() {
    return life;
  }

  public static int getGold() {
    return gold;
  }

  public static int getScore() {
    return score;
  }
}
