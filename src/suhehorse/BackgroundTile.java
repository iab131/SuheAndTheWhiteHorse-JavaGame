package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents one scrollable background tile.
 */
public class BackgroundTile {
    PImage img;          // Background image
    protected float x, y; // Tile position
    protected float speed; // Scroll speed
    protected PApplet app; // Reference to sketch

    /**
     * Constructor to initialize tile position and speed.
     */
    BackgroundTile(PApplet p, PImage img, float x, float y, float s) {
        app = p;
        this.img = img;
        this.x = x;
        this.y = y;
        speed = s;
    }

    /**
     * Update tile position based on speed.
     */
    void update() {
        x -= speed;
    }

    /**
     * Draw the tile image.
     */
    void display() {
        app.image(img, x, y);
    }

    /**
     * Check if tile has fully moved off screen.
     */
    boolean isOffScreen() {
        return x + img.width < 0;
    }

    /**
     * Reset tile x-position to given value.
     */
    void resetX(float newX) {
        x = newX;
    }

    /**
     * Set new speed for this tile.
     */
    void setSpeed(float s) {
        speed = s;
    }
}
