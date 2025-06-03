/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import processing.core.PApplet;

public class MySketch extends PApplet {
    
    GameObject suhe;
    
    public void settings(){
	   //sets the size of the window
        size (1280 ,720);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(100,100,100);
        textSize(20);
        
        suhe = new Suhe(this, 100,360);
        
    }
    
    public void draw(){
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

