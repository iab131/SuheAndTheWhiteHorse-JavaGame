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
public class Enemy extends GameObject{
    PImage img;
    Enemy(PApplet p, float x, float y){
        super(p,x,y, null);
        img = p.loadImage("images/enemy.png");
        img.resize(0,120);
        super.setImage(img);
    }
}
