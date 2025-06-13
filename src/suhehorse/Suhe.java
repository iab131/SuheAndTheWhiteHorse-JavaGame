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
        super(p,x,y, null);
        super.setImage(p.loadImage("images/suhe.png"));
        health = 100;
    }
    
    @Override
    public void move(int dx,int dy){
        
        x += dx;
        float nextY = y + dy;
        if (nextY >= 0 && nextY + height<= 720){
            y = nextY;
        }
    }
    public void push(){
        x-=speed;
    }
    
    public void healthBar(){
        app.fill(255);
        app.rect(50,35,200,30);
        app.fill(255,0,0);//red
        app.rect(50,35, health*2, 30);
    }
    
}
