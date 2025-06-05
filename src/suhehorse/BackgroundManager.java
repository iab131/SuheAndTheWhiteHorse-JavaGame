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
public class BackgroundManager {
    protected BackgroundTile[] tiles;
    protected PImage bgImg;
    protected float speed;
    protected PApplet app;
    
    BackgroundManager(PApplet p, PImage img, float s){
        app = p;
        bgImg = img;
        speed = s;
        
        tiles = new BackgroundTile[2];
        tiles[0] = new BackgroundTile(p,img,0,0,speed);
        tiles[1] = new BackgroundTile(p, img,img.width,0,speed);
    }
    
    public void update(){
        for (BackgroundTile tile : tiles){
            tile.setSpeed(speed);
            tile.update();
        }
        
        if (tiles[0].isOffScreen()){
            tiles[0].resetX(tiles[1].x + bgImg.width);
            swapTiles();
        }
    }
    
    public void display(){
        for (BackgroundTile tile : tiles){
            tile.display();
        }
    }
    
    public void setSpeed(float s){
        speed = s;
    }
    
    private void swapTiles(){
        BackgroundTile temp = tiles[0];
        tiles[0] = tiles[1];
        tiles[1] = temp;
    }
}
