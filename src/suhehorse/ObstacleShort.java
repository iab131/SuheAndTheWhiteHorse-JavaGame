package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Short obstacle Suhe must avoid.
 */
public class ObstacleShort extends GameObject {
    PImage img; // Obstacle image

    /**
     * Constructor: loads and sets a short obstacle image.
     */
    ObstacleShort(PApplet p, float x, float y) {
        super(p, x, y, null); // Call base class
        img = p.loadImage("images/obstacle.png"); // Load image
        img.resize(0, 100); // Resize height to 100
        super.setImage(img); // Set in base class
    }
}
