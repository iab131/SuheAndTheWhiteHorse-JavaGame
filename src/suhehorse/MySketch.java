/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suhehorse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import processing.core.PApplet;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class MySketch extends PApplet {
    
    GameManager gm;
    BackgroundManager bg;
    float baseSpeed = 3;
    float news = 0;
    double score = 0;
    double scoreInc = .1;
    boolean gg = false;
    
    
    public void settings(){
	   //sets the size of the window
        size (1280 ,720);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(100,100,100);
        textSize(50);
        gm = new GameManager(this);
        bg = new BackgroundManager(this, this.loadImage("images/background.png"), baseSpeed);
    }
    
    public void draw(){
        if (!gg){
            if (frameCount%(120- (int)(score/10))==0){
                System.out.println(";aldjfa;kdjf");
                gm.spawnEnemy();
            }
            //new speed
            score += scoreInc;
            news = baseSpeed + (int)score/60 ;
            GameObject.speed = news;
            // set speed for gameobjects

            if (keyPressed) {
                if (keyCode == UP) {
                  gm.suheMove(true);
                } else if (keyCode == DOWN) {
                  gm.suheMove(false);
                }
            }
            //Background
            bg.update();
            bg.display();
            bg.setSpeed(news);

            gm.updateAll();
            gm.displayAll();

            //Score
            textAlign(CENTER,CENTER);
            fill(255);
            this.text(String.format("%.1f", score),640  ,50);

            if (gm.checkGG()){
                    System.out.println("GGS");
                    textAlign(CENTER,CENTER);
                    double highestScore = getHighestScore();
                    highestScore = Math.max(highestScore,score);
                    fill(255);
                    this.text("GGS YOU LOST \n BEST SCORE: " + String.format("%.1f", highestScore) + "\nYOUR SCORE: " + String.format("%.1f", score),640  ,360);
                    gg = true;
                    //record best score
                    recordScore(highestScore);
            }
        }
        
        
    }
    
    public void recordScore(double score){
        try {
            // create printwriter
            PrintWriter writer = new PrintWriter (new FileWriter("Score.txt", false));
            // write to file
            writer.print(String.format("%.1f",score));
            // close writer
            writer.close();
        }
        // catch exception errors
        catch(IOException e){
            System.out.println("Java Exception: " + e);
        }
    }
    
    public double getHighestScore(){
        try {
            Scanner myReader = new Scanner(new File("Score.txt"));
            String score = myReader.nextLine();
            System.out.println(score);
            return Double.parseDouble(score);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return 0;
        }   
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

