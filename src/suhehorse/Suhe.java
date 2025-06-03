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
public class Suhe extends GameObject{
    public int health;
    
    Suhe(PApplet p, float x, float y){
        super(p,x,y, "images/suhe.png");
        health = 100;
    }
    @Override
    public void draw(){
        app.image(image,x,y);
    }
    @Override
    public void move(int dx,int dy){
        
        x += dx;
        float nextY = y + dy;
        if (nextY >= 0 && nextY + height<= 720){
            y = nextY;
        }
    }
}
