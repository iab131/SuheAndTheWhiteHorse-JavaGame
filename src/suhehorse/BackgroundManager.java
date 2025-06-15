package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Manages scrolling background tiles.
 */
public class BackgroundManager {
    protected BackgroundTile[] tiles; // Holds two scrolling tiles
    protected PImage bgImg;           // Background image
    protected float speed;            // Scroll speed
    protected PApplet app;            // Reference to main sketch

    /**
     * Constructor to initialize tiles and set speed.
     */
    BackgroundManager(PApplet p, PImage img, float s) {
        app = p;
        bgImg = img;
        speed = s;

        // Create two tiles side by side
        tiles = new BackgroundTile[2];
        tiles[0] = new BackgroundTile(p, img, 0, 0, speed);
        tiles[1] = new BackgroundTile(p, img, img.width, 0, speed);
    }

    /**
     * Update tile positions and reset if off screen.
     */
    public void update() {
        for (BackgroundTile tile : tiles) {
            tile.setSpeed(speed); // Ensure speed is current
            tile.update();        // Move tile left
        }

        // If first tile is off screen, move it to the right
        if (tiles[0].isOffScreen()) {
            tiles[0].resetX(tiles[1].x + bgImg.width);
            swapTiles(); // Maintain correct order
        }
    }

    /**
     * Display both background tiles.
     */
    public void display() {
        for (BackgroundTile tile : tiles) {
            tile.display();
        }
    }

    /**
     * Set scrolling speed.
     */
    public void setSpeed(float s) {
        speed = s;
    }

    /**
     * Swap tile references to maintain scrolling order.
     */
    private void swapTiles() {
        BackgroundTile temp = tiles[0];
        tiles[0] = tiles[1];
        tiles[1] = temp;
    }
}
