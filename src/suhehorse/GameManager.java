package suhehorse;

import processing.core.PApplet;
import java.util.*;
import static processing.core.PConstants.CENTER;

/**
 * Manages Suhe and all enemies/obstacles in the game.
 */
public class GameManager {
    public Suhe suhe; // The player character
    public ArrayList<GameObject>[] enemies = new ArrayList[3]; // 0: long obs, 1: short obs, 2: soldiers
    protected PApplet p;
    private Random random;

    /**
     * Initializes Suhe and enemy lists.
     */
    GameManager(PApplet p) {
        this.p = p;
        suhe = new Suhe(p, 600, 360); // Create Suhe at start position

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new ArrayList<>(); // Initialize each list
        }

        random = new Random();
    }

    /**
     * Spawns a new enemy or obstacle randomly.
     */
    public void spawnEnemy() {
        if (Math.random() >= 0.7) {
            // 30% chance: add soldier
            enemies[2].add(new Enemy(p, 1300, random.nextInt(621)));
        } else {
            // 70% chance: add obstacle
            if (Math.random() >= 0.5) {
                enemies[0].add(new ObstacleLong(p, 1300, random.nextInt(521))); // Long
            } else {
                enemies[1].add(new ObstacleShort(p, 1350, random.nextInt(621))); // Short
            }
        }
    }

    /**
     * Updates all game objects and handles collisions.
     */
    public void updateAll() {
        for (int i = 0; i < enemies.length; i++) {
            for (int j = 0; j < enemies[i].size(); j++) {
                GameObject obj = enemies[i].get(j);

                if (suhe.isRectCollidingWith(obj) && i != 2) {
                    suhe.push(); // Collided with obstacle
                }

                if (suhe.isRectCollidingWith(obj) && i == 2) {
                    suhe.health -= 20; // Hit by soldier
                    enemies[i].remove(j); // Remove soldier
                    j--; // Adjust index
                }

                if (obj.x < -100) {
                    enemies[i].remove(j); // Remove off-screen object
                    j--;
                }

                obj.update(); // Move object
            }
        }
    }

    /**
     * Checks game over condition.
     * @return true if Suhe is out of bounds or has no health.
     */
    public boolean checkGG() {
        return suhe.x < 0 || suhe.health <= 0;
    }

    /**
     * Moves Suhe up or down.
     */
    public void suheMove(boolean up) {
        if (up) {
            suhe.move(0, -5); // Move up
        } else {
            suhe.move(0, 5); // Move down
        }
    }

    /**
     * Displays all game objects.
     */
    public void displayAll() {
        for (ArrayList<GameObject> list : enemies) {
            for (GameObject obj : list) {
                obj.display(); // Draw enemy/obstacle
            }
        }

        suhe.display(); // Draw player
        suhe.healthBar(); // Draw health bar
    }
}
