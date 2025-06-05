/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author a
 */
public class GameObject {
    public float x,y;
    public float width, height;
    protected PImage image;
    protected PApplet app;
    public float speed;
    GameObject(PApplet p, float x,float y, String path){
        app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(path);
        
        height = image.pixelHeight;
        width = image.pixelWidth;
    }
    public void move(int dx,int dy) {
        x+=dx*speed;
        y+=dy*speed;
    }
    public void update(){
        x-=speed;
    }
    public void setSpeed(float s) {
            speed = s;}
    public void display(){
        app.image(image,x,y);
    }
    
    public boolean isRectCollidingWith(GameObject other){
        boolean a = x < other.x + other.width;
        boolean b = x + width > other.x;
        boolean c = y< other.y + other.height;
        boolean d = y + height> other.y;
        
        return a && b && c&&d;
    }
}
