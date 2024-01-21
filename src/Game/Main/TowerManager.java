package Game.Main;

import Game.Entities.Enemies.Enemy;
import Game.Entities.Towers.Tower;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TowerManager {

  private List<Tower> towers = new ArrayList<>();

  public TowerManager() {}

  public void onUpdate(List<Enemy> enemies, long currentTime) {
    for (Tower tower : towers) {
      if (currentTime - tower.getLastShotTime() >= 1000 / tower.getFireRate()) {
        tower.setLastShotTime(currentTime);
        Optional<Enemy> enemy = enemies
          .stream()
          .filter(e ->
            tower.isEnemyInRange(e) && (tower.getantiAir() || !e.getFly())
          )
          .findFirst();
        if (enemy.isPresent()) {
          var enemyValue = enemy.get();
          enemyValue.dealDamage(tower);
          if (enemyValue.isDead()) {
            enemies.remove(enemyValue);
          }
        }
      }
    }
  }

  public List<Tower> getTowers() {
    return towers;
  }

  public Tower getTower(double x, double y) {
    Optional<Tower> optionalTower = towers
      .stream()
      .filter(t -> t.getX() == x && t.getY() == y)
      .findFirst();

    return optionalTower.orElse(null);
  }

  public void addTower(Tower towerToAdd) {
    towers.add(towerToAdd);
  }

}
