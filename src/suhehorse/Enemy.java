package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Enemy character extending GameObject.
 */
public class Enemy extends GameObject {
    PImage img; // Enemy image

    /**
     * Create an enemy at given position.
     */
    Enemy(PApplet p, float x, float y) {
        super(p, x, y, null);
        img = p.loadImage("images/enemy.png");
        img.resize(0, 120); // Set height to 120, keep aspect ratio
        super.setImage(img);
    }
}
