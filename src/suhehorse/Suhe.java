package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Suhe player character.
 */
public class Suhe extends GameObject {
    public int health; // Suhe's health

    /**
     * Sets position and image, health = 100.
     */
    Suhe(PApplet p, float x, float y) {
        super(p, x, y, null); // Base constructor
        super.setImage(p.loadImage("images/suhe.png")); // Set image
        health = 100;
    }

    /**
     * Override: move Suhe, clamp to screen.
     */
    @Override
    public void move(int dx, int dy) {
        x += dx;
        float nextY = y + dy;
        // Stay in screen bounds
        if (nextY >= 0 && nextY + height <= 720) {
            y = nextY;
        }
    }

    /**
     * Pushes Suhe left.
     */
    public void push() {
        x -= speed;
    }

    /**
     * Draws health bar.
     */
    public void healthBar() {
        app.fill(255); // white background
        app.rect(50, 35, 200, 30);
        app.fill(255, 0, 0); // red bar
        app.rect(50, 35, health * 2, 30);
    }
}
