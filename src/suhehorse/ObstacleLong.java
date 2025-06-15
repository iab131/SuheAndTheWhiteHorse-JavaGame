package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Long obstacle that Suhe must avoid.
 */
public class ObstacleLong extends GameObject {
    PImage img; // Obstacle image

    /**
     * Constructor: loads and sets a tall image.
     */
    ObstacleLong(PApplet p, float x, float y) {
        super(p, x, y, null); // Call base constructor
        img = p.loadImage("images/obstacle2.png"); // Load image
        img.resize(0, 200); // Resize height to 200
        super.setImage(img); // Set image in parent
    }
}
