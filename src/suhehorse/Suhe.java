/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import processing.core.PApplet;
import static processing.core.PConstants.DOWN;
import static processing.core.PConstants.UP;
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
    public void move(int dx,int dy){
        
        x += dx;
        float nextY = y + dy;
        if (nextY >= 0 && nextY + height<= 720){
            y = nextY;
        }
    }
    @Override
    public void update(){
        if (keyPressed) {
            if (keyCode == UP) {
              suhe.move(0, -5);
            } else if (keyCode == DOWN) {
              suhe.move(0, 5);
            }
        }
    }
    
}
