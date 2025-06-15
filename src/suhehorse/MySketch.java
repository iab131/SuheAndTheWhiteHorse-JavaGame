package suhehorse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import processing.core.PApplet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main game loop for SuheHorse runner game.
 * Manages gameplay, background scrolling, and scoring.
 */
public class MySketch extends PApplet {

    GameManager gm;                 // handles game logic and objects
    BackgroundManager bg;          // handles background scrolling
    float baseSpeed = 3;           // starting speed
    float news = 0;                // current speed
    double score = 0;              // current score
    double scoreInc = 0.1;         // score increase per frame
    boolean gg = false;            // game over flag

    public void settings() {
        size(1280, 720);           // set game window size
    }

    public void setup() {
        background(100, 100, 100); // grey background at start
        textSize(50);              // score and text size

        gm = new GameManager(this);   // create GameManager
        bg = new BackgroundManager(this, loadImage("images/background.png"), baseSpeed); // load scrolling bg
    }

    public void draw() {
        if (!gg) {
            // spawn new enemy based on frame rate and score
            if (frameCount % (120 - (int)(score / 10)) == 0) {
                gm.spawnEnemy();
            }

            score += scoreInc;             // increase score
            news = baseSpeed + (int)score / 60; // scale speed
            GameObject.speed = news;       // update all object speed

            // move player up/down
            if (keyPressed) {
                if (keyCode == UP) {
                    gm.suheMove(true);
                } else if (keyCode == DOWN) {
                    gm.suheMove(false);
                }
            }

            bg.setSpeed(news);    // set bg scroll speed
            bg.update();          // update bg position
            bg.display();         // draw background

            gm.updateAll();       // move + handle collisions
            gm.displayAll();      // draw player/enemies

            // draw score
            fill(255);
            textAlign(CENTER, CENTER);
            text(String.format("%.1f", score), 640, 50);

            // if game over
            if (gm.checkGG()) {
                double highestScore = Math.max(getHighestScore(), score);
                gg = true;                  // freeze game
                recordScore(highestScore);  // save best score

                // display game over message
                text("GGS YOU LOST\nBEST SCORE: " + String.format("%.1f", highestScore) +
                     "\nYOUR SCORE: " + String.format("%.1f", score), 640, 360);
            }
        }
    }

    /**
     * Saves highest score to file.
     */
    public void recordScore(double score) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Score.txt", false));
            writer.print(String.format("%.1f", score)); // write score
            writer.close();                             // save and close
        } catch (IOException e) {
            System.out.println("Save error: " + e);
        }
    }

    /**
     * Loads the highest score from file.
     */
    public double getHighestScore() {
        try {
            Scanner reader = new Scanner(new File("Score.txt"));
            return Double.parseDouble(reader.nextLine()); // read score
        } catch (FileNotFoundException e) {
            System.out.println("No score file found.");
            return 0;
        }
    }
}
