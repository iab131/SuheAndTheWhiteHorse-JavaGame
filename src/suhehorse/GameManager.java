/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;

import processing.core.PApplet;
import java.util.*;
import static processing.core.PConstants.CENTER;
/**
 *
 * @author a
 */
public class GameManager {
    public Suhe suhe;
    public ArrayList<GameObject>[] enemies = new ArrayList[3]; //long is 0, short is 1, soldier is 2
    protected PApplet p;
    private Random random;
    GameManager(PApplet p){
        this.p=p;
        suhe = new Suhe(p, 600,360);
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new ArrayList<>();
        }
        random = new Random();
    }
    
    public void spawnEnemy(){
        if (Math.random() >= 0.7){
            enemies[2].add(new Enemy(p,1300,random.nextInt(621)));
        }
        else{ // spown obstacle
            // long obstacle
            if (Math.random() >= 0.5){
                enemies[0].add(new ObstacleLong(p, 1300,random.nextInt(521)));
            }
            // short 
            else{
                enemies[1].add(new ObstacleShort(p, 1350,random.nextInt(621)));
            }
        }
    }
    public void updateAll(){
        for(int i = 0; i <enemies.length;i++){
            for(int j = 0; j < enemies[i].size();j++){
                GameObject obj = enemies[i].get(j);
                if(suhe.isRectCollidingWith(obj) && i != 2){
                    suhe.push();
                }
                if(suhe.isRectCollidingWith(obj) && i==2){
                    suhe.health -= 20;
                    enemies[i].remove(j);
                    j--;
                }
                //delete obj that is out
                if (obj.x <-100){
                    enemies[i].remove(j);
                    j--;
                }
                obj.update();
                
            }
        }
    }
    public boolean checkGG(){
        if(suhe.x<0 || suhe.health <= 0){
            return true;
        }
        return false;
    }
    public void suheMove(boolean up){
        if (up){
            suhe.move(0,-5);
        }
        else{
            suhe.move(0,5);
        }
    }
    public void displayAll(){
        for(ArrayList<GameObject> l:enemies){
            for(GameObject obj: l){
                obj.display();
            }
        }
       
        suhe.display();
        suhe.healthBar();
    }
}
