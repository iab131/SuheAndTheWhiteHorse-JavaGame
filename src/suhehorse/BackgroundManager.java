/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import processing.core.PImage;

/**
 *
 * @author a
 */
public class BackgroundManager {
    BackgroundTile[] tiles;
    PImage bgImg;
    float speed;
    
    BackgroundManager(PImage img, float s){
        bgImg = img;
        speed = s;
        
        tiles = new BackgroundTile[2];
        tiles[0] = new BackgroundTile(img,0,0,speed);
        tiles[1] = new BackgroundTile(img,img.width,0,speed);
    }
    
    void update(){
        for (BackgroundTile tile : tiles){
            tile.setSpeed(speed);
            tile.update();
        }
    }
    
}
