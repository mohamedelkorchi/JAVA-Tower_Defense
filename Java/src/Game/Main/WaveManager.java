package Game.Main;

import Game.Entities.Enemies.Enemy;
import Game.Entities.Enemies.EnemyType.Air;
import Game.Entities.Enemies.EnemyType.Fast;
import Game.Entities.Enemies.EnemyType.Slow;
import Game.Entities.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class WaveManager {

  private List<Enemy> currentWave = new LinkedList<Enemy>();
  private List<List<Enemy>> waves;
  private List<List<Entry<Integer, Integer>>> routes;
  private int spawnInterval = 500;
  private long lastSpawnTime = System.currentTimeMillis();
  private int enemySpawned = 0;
  private int currentWaveIndex = 0;
  public static int waveIndex = 1;
  private long waveStartTime = System.currentTimeMillis();
  private boolean wavePlaying = true;

  public WaveManager(List<List<Entry<Integer, Integer>>> routes) {
    this.routes = routes;
    init();
  }

  private List<Entry<Integer, Integer>> getRandomRoute() {
    if (routes.isEmpty()) {
      return null;
    }
    return routes.get((int) Math.floor(Math.random() * routes.size()));
  }

public void init() {
    this.currentWave = new LinkedList<Enemy>();
    this.enemySpawned = 0;
    this.currentWaveIndex = 0;
    waveIndex = 1;

    this.waves = new ArrayList<List<Enemy>>();

    for (int i = 0; i < 5; i++) {
        List<Enemy> wave = new ArrayList<>();
        int numberOfEnemiesInWave = 3;

        for (int j = 0; j < numberOfEnemiesInWave; j++) {
            Enemy enemy;
            if (i % 2 == 0) {
                enemy = new Slow(getRandomRoute());
            } else if (i % 2 == 1) {
                enemy = new Fast(getRandomRoute());
            } else {
                enemy = new Air(getRandomRoute());
            }
            wave.add(enemy);
        }

        waves.add(wave);
    }
}

  public boolean onUpdate() {
    boolean isGameOver = false;

    if (currentWaveIndex == 0 && enemySpawned == 0) {
      if (System.currentTimeMillis() - waveStartTime >= 7000) {
        waveStartTime = System.currentTimeMillis();
      } else {
        return false;
      }
    }

    if (enemySpawned == waves.get(currentWaveIndex).size()) {
      if (wavePlaying) {
        waveStartTime = System.currentTimeMillis();
        wavePlaying = false;
      }
      if (System.currentTimeMillis() - waveStartTime >= 5000) {
        currentWaveIndex++;
        waveIndex++;
        enemySpawned = 0;
        wavePlaying = true;
      }
    }

    if (wavePlaying) {
      spawnEnemyIfNeeded();
    }

    Iterator<Enemy> iterator = currentWave.iterator();

    while (iterator.hasNext()) {
      Enemy enemy = iterator.next();
      enemy.move();
      if (enemy.hasReachedEnd()) {
        iterator.remove();
        isGameOver = isGameOver || Player.onEnemyExit(enemy.getLife());
      }
    }

    return isGameOver;
  }

  private void spawnEnemyIfNeeded() {
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastSpawnTime >= spawnInterval) {
      if (currentWaveIndex == 10) {
        upgradeEnemies();
        currentWaveIndex = 0;
      }
      Enemy enemy = waves.get(currentWaveIndex).get(enemySpawned);
      currentWave.add(enemy);
      lastSpawnTime = currentTime;
      enemySpawned++;
    }
  }

  private void upgradeEnemies() {
    for (List<Enemy> wave : waves) {
      for (Enemy enemy : wave) {
        enemy.upgradeEnemy();
        enemy.reset(getRandomRoute());
      }
    }
  }

  public List<Enemy> getCurrentWave() {
    return currentWave;
  }

  public void removeEnemy(Enemy enemy) {
    currentWave.remove(enemy);
  }

  public static int getWaveIndex() {
    return waveIndex;
  }
}
