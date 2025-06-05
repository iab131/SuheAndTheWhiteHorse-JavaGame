/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 350326790
 */
public class BackgroundTile {
    PImage img;
    protected float x,y;
    protected float speed;
    protected PApplet app;
    
    BackgroundTile(PApplet p,PImage img, float x, float y, float s){
        app = p;
        this.img = img;
        this.x = x;
        this.y = y;
        speed = s;
    }
    void update(){
        x -= speed;
    }
    void display(){
        app.image(img,x,y);
    }
    boolean isOffScreen(){
        return x + img.width < 0;
    }
    void resetX(float newX){
        x = newX;
    }
    void setSpeed(float s){
        speed = s;
    }
            
}
