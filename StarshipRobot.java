//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    StarshipRobot
// Course:   CS 300 Spring 2023
//
// Author:   Emili Robles
// Email:    ejrobles@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:  na  (name of your pair programming partner)
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
// Persons: IWinHa from discord helped with go method, my starships werent moving..
// helped me realized I was supposed to call moveTowardsDestination in the go method, 
// they basically helped me with everything on debugging my moveTowardsDestination, go , and
// isOver methods.
// Online Sources:  
// the hints on 4.4 math instructions was a good visual to know what computations I was supposed to do
// Piazza helped me do the swap on starship to go back and forth: 
// https://piazza.com/class/lcp0lbttsm43ml/post/583
// ++ Piazza also helped with realizing to look and compare to isMOuseOver : 
// https://piazza.com/class/lcp0lbttsm43ml/post/565
//
// 
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models Starship Robot objects delivering food to badger fans
 * Were going to import the starship images, draw them, set them, and move them
 * left to right of the target shopping counter.
 */
public class StarshipRobot {
  private Thing destination;
  private PImage image;
  private static PApplet processing;
  private Thing source;
  private int speed;
  private float x;
  private float y;

  /**
   * StarshipRobot creates a new StarshipRobot and sets its source, destination, and speed. 
   * The (x,y) position of this StarshipRobot is set to the (x,y) position of source.
   * 
   * Need to initialize all param positions to be able to load in the starship
   *
   * @param source , represents the starting position of the starship 
   * @param destination , represents the destination poistion of the starship
   * @param speed , this is the speed of how fast the starship is moving toward the 
   * destination
   */
  public StarshipRobot(Thing source, Thing destination, int speed) {
    // load starship
    image = processing.loadImage("Images" + File.separator + "starshipRobot.png");

    // set source
    this.source = source;
    // set dest
    this.destination = destination;
    // set speed
    this.speed = speed;

    // initialize pos. of starship to pos of source
    x = source.getX();
    y = source.getY();
  }

  /**
   * image returns a reference to the image of the starship robot to be able 
   * to load it in
   * 
   * @return image of type PImage of the starship robot object
   */
  public PImage image() {
    return image;
    
  }

  /**
   *  getX returns the x-position of the current StarshipRobot object
   *  into the display window
   *  
   *  @return x , the coordinate of the starship robot position
   */
  public float getX() {
    return x;
   
  }

  /**
   * getY returns the y-position of the current StarshipRobot object
   * into the display window
   * 
   * @return y , the coordinate of the starship robot
   */
  public float getY() {
    return y;
    
  }

  /**
   * sets the x-position of the current StarshipRobot object
   * Initialize the x position to set the starship at
   * 
   */
  public void setX(float x) {
    
    this.x = x;
  }

  /**
   * sets the y-position of the current StarshipRobot object
   * Initialize the y position to set the starship at
   * 
   */
  public void setY(float y) {
    
    this.y = y;
  }

  /**
   * Sets the PApplet object display window where this StarshipRobot will be drawn. 
   * The processing PApplet data field is set to Badger.processing since Badger and 
   * StarshipRobot objects are going to be displayed to the same screen.
   * 
   * Same implementation as Thinig class
   */
  public static void setProcessing() {
    
    StarshipRobot.processing = Badger.getProcessing();
  }

  /**
   * draws this StarshipRobot to the display window at its current
   * (x,y) position by calling processing.image() method
   * 
   * this is the same implementation as badger and thing class
   * have to call go() method in here to draw the starship moveing back and forth 
   * 
   */
  public void draw() {
    
    processing.image(image, x, y);
    go();
  }
  
  /**
   * Checks whether this StarshipRobot is over a specific Thing
   * Used Piazza https://piazza.com/class/lcp0lbttsm43ml/post/565 
   * 
   * @param thing , the thing object
   * @return true , if the starship robot is over the thing object passed as input
   * @return false , if not
   */
  public boolean isOver(Thing thing) {
    float thingX = thing.getX();
    float thingY = thing.getY();
    
    float distance = (float) Math.sqrt((thingX - x) * (thingX - x) + (thingY - y) * (thingY - y));
    // this check if the distance between the StarshipRobot and the Thing
    // is less than the sum 
    if(distance < image.width / 2 + thing.image().width / 2) {
      //refered back to isMouseOver
      return true;
    }
    return false;
  }
  
  /**
   * Helper method to move this StarshipRobot towards its destination
   * Used the math guide in from the instructions
   * 
   * this was much more simpler than I thought, just referenced straight from
   * the equation given to us in the instructions, declared it variables, set them
   * and computated them. 
   * 
   */
  private void moveTowardsDestination() {
    float dx = destination.getX() - x;
    float dy = destination.getY() - y;
    float d = (float) Math.sqrt(dx * dx + dy * dy);
    //imported/initialized variables and math from hints on the instr. sheet
    
    float moveDistance = speed;
    //set moveDistance to speed to finish implementation of hint equation

    float newX = x + moveDistance * dx / d;
    float newY = y + moveDistance * dy / d;
    
    // to set to a new x an y after starship does one move
    setX(newX);
    setY(newY);
    
    
  }
  
  /**
   * Implements the behavior of this StarshipRobot 
   * going back-and-forth between its source and destination.
   * 
   * Move the StarshipRobot ONE step towards its destination
   * if destination is reached (meaning the StarshipRobot is over its destination),
   * switch source and destination
   * 
   * https://piazza.com/class/lcp0lbttsm43ml/post/583
   */
  public void go() {
 // Move the starship towards its destination
    if(!isOver(destination)) {
      moveTowardsDestination();
    }
    else {
    Thing temp = source;
    source = destination;
    destination = temp;
    }
    //I didn't know how to move the robot back and forth.. 
    //so I made a sort of zig zag on swapping the vars with 
    //eachother like Ashley said and it worked!
   
  }
  
}
