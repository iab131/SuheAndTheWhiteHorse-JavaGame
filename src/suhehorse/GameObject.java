package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Base class for all visible game objects.
 */
public class GameObject {
    public float x, y;            // Object position
    public float width, height;   // Object dimensions
    protected PImage image;       // Image/sprite of object
    protected PApplet app;        // Reference to main sketch
    public static float speed;    // Shared speed for all objects
    protected int size;           // Used for resizing image height

    /**
     * Basic constructor with image.
     */
    GameObject(PApplet p, float x, float y, PImage i) {
        app = p;
        this.x = x;
        this.y = y;
        this.image = i;
    }

    /**
     * Constructor that also resizes the image by height.
     */
    GameObject(PApplet p, float x, float y, PImage i, int size) {
        this(p, x, y, i);             // Call basic constructor
        this.size = size;
        image.resize(0, size);        // Resize image by height
    }

    /**
     * Sets a new image and updates dimensions.
     */
    public void setImage(PImage i) {
        image = i;
        height = image.pixelHeight;   // Update height
        width = image.pixelWidth;     // Update width
    }

    /**
     * Moves the object by dx and dy, scaled by speed.
     */
    public void move(int dx, int dy) {
        x += dx * speed;              // Move horizontally
        y += dy * speed;              // Move vertically
    }

    /**
     * Moves the object in x-direction only.
     */
    public void move(int dx) {
        x += dx * speed;
    }

    /**
     * Default update method: move left based on speed.
     * Can be overridden.
     */
    public void update() {
        x -= speed;
    }

    /**
     * Sets the movement speed.
     */
    public void setSpeed(float s) {
        speed = s;
    }

    /**
     * Draws the object to the screen.
     */
    public void display() {
        app.image(image, x, y);
    }

    /**
     * Checks rectangular collision with another GameObject.
     */
    public boolean isRectCollidingWith(GameObject other) {
        boolean a = x < other.x + other.width;
        boolean b = x + width > other.x;
        boolean c = y < other.y + other.height;
        boolean d = y + height > other.y;
        return a && b && c && d;      // All sides overlapping
    }
}
