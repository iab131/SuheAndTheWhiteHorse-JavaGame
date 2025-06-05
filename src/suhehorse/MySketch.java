/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import processing.core.PApplet;

public class MySketch extends PApplet {
    
    GameObject suhe;
    BackgroundManager bg;
    float baseSpeed = 3;
    float news = 0;
    double score = 0;
    double scoreInc = .1;
    
    
    
    public void settings(){
	   //sets the size of the window
        size (1280 ,720);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(100,100,100);
        textSize(50);
        suhe = new Suhe(this, 600,360);
        bg = new BackgroundManager(this, this.loadImage("images/background.png"), baseSpeed);
    }
    
    public void draw(){
        //new speed
        score += scoreInc;
        news = baseSpeed + (int)score/30 ;
        
        //Background
        bg.update();
        bg.display();
        System.out.println(news);
        bg.setSpeed(news);
        
        textAlign(CENTER,CENTER);
        fill(255);
        this.text(String.format("%.1f", score),640  ,50);
        
        if (keyPressed) {
            if (keyCode == UP) {
              suhe.move(0, -5);
            } else if (keyCode == DOWN) {
              suhe.move(0, 5);
            }
        }
        
        suhe.draw();
    }
//    public void drawCollisions(){
//        if (car.isRectCollidingWith(car2)){
//            fill(255,0,0);
//            this.text("oouch",car2.x,car2.y);
//        }
//    }
////
//    public void mousePressed(){
////        car.moveTo(mouseX, mouseY);
//        if(car2.isClicked(mouseX, mouseY)){
//            showInfo = !showInfo;
//        }
//        else{
//            showInfo = false;
//        }
//    }
//        public void keyPressed(){
//        if (stage == 0){
//            if (keyCode == ENTER){
//                stage = 1;
//                car = new Car(this, 0,0, Integer.parseInt(userInput));
//            }
//            else if (key != CODED){
//                userInput += key;
//            }
//            
//        }
//    }
}

