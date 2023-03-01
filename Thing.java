//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Thing
// Course:   CS 300 Spring 2023
//
// Author:   Emili Robles
// Email:    ejrobles@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:   na (name of your pair programming partner)
// Partner Email:   na(email address of your programming partner)
// Partner Lecturer's Name: na(name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// 
// Online Sources: Java docs helped complete my methods + the java ide since it was already recommending
// to use set and get. 
// - I also basically just made this whole class on the influence from Badger class
// since it was stated that they were both very similar.
// - Piazza helped me correct how I was importing my images, and realize that I was 
// initializing my processing field wrong. (https://piazza.com/class/lcp0lbttsm43ml/post/606)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is what imports the thing images starship and shopping counter to 
 * the display window in their respected positions (each corner of the window), (x,y)
 * 
 * java docs helped me set everything up for methods + java ide since it kept
 * recommending to add the methods + return statements etc.
 * 
 */
public class Thing {
  private static PApplet processing;
  private PImage image;

  private float x;
  private float y;

  /**
   * Thing method is what created the graphic into the display window in the (x,y) 
   * position
   * 
   * Had to initialize the x & y position of 'this Thing' 
   * Had to initialize the filename to be able to actually load in to window
   * 
   * I was stuck on loading image for a good hour b/c I was copying from badger class 
   * and thought that we were supposed to do "Target.png" instead of imageFilename
   * 
   * @param x float, gets the x position for the image
   * @param y float, gets the y position for the image
   * @param imageFilename String, uploads the image you want into display window
   */
  public Thing(float x, float y, String imageFilename) {
    this.x = x; 
    this.y = y;
    this.image = processing.loadImage("Images" + File.separator + imageFilename);
    // Mohit(Piazza) helped me realize on piazza that we actually ARE supposed to be initializing
    // from filename - not the actual images...

  }
  
  /**
   * setProcessing method works with import PApplet, so this is where the thing is 
   * drawn, but it has to be connected to the Badger get processing.. so you have to also 
   * make a method in Badger class named getProcessing
   * 
   * received help from GradeScope feedback on test Badger immediate
   */
  public static void setProcessing() {
    //Thing.processing = processing ; learning moment...
    Thing.processing = Badger.getProcessing();
    
    //when I ran through gradescopee - it said badger method was missing so 
    // I realized we were supposed to do a getProcessing method in badger class to then
    // do = badge.get ....
      
  }
  
  /**
   * draw is what draws the image with PApplet at the current (x,y) position
   * connects to the DancingBadgers.draw()
   * 
   * didnt have any problems on this.. line of code was influenced from Badger.draw()
   */
  public void draw() {
    
    processing.image(image, x, y); 

  }
  
  /**
   * image return the reference to the image of this thing
   * this was straighforward, java ide also rec. return
   * @return image of PImage of the thing object (target or shoppingCounter)
   */

  public PImage image() {
    return image;
  }
  
  /**
   * getX returns x pos. of this thing in display window for images
   * this was straighforward, java ide also rec. return
   * @return X coord. of the thing position called
   */
  public float getX() {
    return x;
  }
  
  /**
   * getY returns Y pos. of this thing in display window for images
   * this was straighforward, java ide also rec. return
   * @return Y coord. of the thing position called
   */
  public float getY() {
    return y;
  }
  
  /**
   * setX sets x pos. of this thing in display window for images
   * 
   * @param x to set its position
   */
  public void setX(float x) {
    this.x = x;
  }
  
  /**
   * setY sets y pos. of this thing in display window for images
   * 
   * @param y to set its position
   */
  public void setY(float y) {
    this.y = y;
  }

}