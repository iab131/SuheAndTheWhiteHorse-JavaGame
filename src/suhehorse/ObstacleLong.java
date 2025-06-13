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
public class ObstacleLong extends GameObject{
    PImage img;
    ObstacleLong(PApplet p, float x, float y){
        super(p,x,y, null);
        img = p.loadImage("images/obstacle2.png");
        img.resize(0,200);
        super.setImage(img);
    }
    
    
}
