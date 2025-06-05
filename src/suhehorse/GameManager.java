/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;

import processing.core.PApplet;
import java.util.*;
/**
 *
 * @author a
 */
public class GameManager {
    public Suhe suhe;
    public ArrayList<GameObject> enemies;
    protected PApplet p;
    private Random random;
    GameManager(PApplet p){
        this.p=p;
        suhe = new Suhe(p, 600,360);
        enemies = new ArrayList<GameObject>();
         random = new Random();
    }
    
    public void spawnEnemy(){
        // long obstacle
        if (Math.random() >= 0.5){
            enemies.add(new ObstacleLong(p, 1350,random.nextInt(721)));
        }
        // short 
        else{
            enemies.add(new ObstacleShort(p, 1350,random.nextInt(721)));
        }
    }
    public void updateAll(){
        suhe.update();
        for(GameObject obj: enemies){
            obj.update();
        }
    }
    public void displayAll(){
        suhe.display();
        for(GameObject obj: enemies){
            obj.display();
        }
    }
}
