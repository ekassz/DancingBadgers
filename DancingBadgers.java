//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Dancing Badgers
// Course: CS 300 Spring 2023
//
// Author: Emili Robles
// Email: ejrobles@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: n/a
// Partner Email: n/a
// Partner Lecturer's Name: n/a
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Kestrel L Gregorich-Trevor helped me understand what I was supposed to do
// in my keypressed method by showing me an outline of how im supposed to update each index and
// turn it null.
// Michelle Jenson helped me realize that i wasn't drawing the badgers correctly so I had to call
//////////////// them
// in draw method. She also helped understand why my set up was wrong. My run configs. got messed up
// and she recommended starting it over and I did and then it worked.
//
// Online Sources: https://www.geeksforgeeks.org/break-statement-in-java/ , this helped
//////////////// make/understand
// the mouse pressed method since i forgot what the "break;" did
// Used piazza for basic correction like badgers instead Badger badger, corrected my in bound if
//////////////// statement
// Used Discord because I didn't realize Utility.key was what had to be used to call b or r
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.io.File;
// import processing.core.PApplet; //doesnt get used
import processing.core.PImage;

public class DancingBadgers {
  public static void main(String[] args) {
    Utility.runApplication(); // starts the application
  }

  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Badger[] badgers; // perfect size array storing the badgers
  // present in this application
  private static Random randGen; // Generator of random numbers

  /**
   * sets up the window display by load background and declaring random object. this is where the
   * array is created for 5 null elements to draw on display
   * 
   * this part had me confused because some steps on guide said to remove code and put it in draw
   * and then to remove that too but I kept this so the badger could actually get displayed in the
   * window
   * 
   */
  public static void setup() { // takes no input arg/ no return value
    // new Random();
    randGen = new Random();

    // load the image of the background
    backgroundImage = Utility.loadImage("images" + File.separator + "background.png");

    badgers = new Badger[5]; // used piazza to correct this instead of doing Badger[] badgers
    for (int i = 0; i < badgers.length; i++) {
      if (badgers[i] != null) {
        badgers[i].draw();
      }
    }

  }

  /**
   * Draws and updates the application display window This callback method called in an infinite
   * loop
   * 
   * loaded in background color then image then drew the badgers as they came in (this was also from
   * set up
   */
  public static void draw() { // also takes no input arg/ no return value
    Utility.background(Utility.color(255, 218, 185));

    // draw the background image to the center of the screen
    Utility.image(backgroundImage, Utility.width() / 2, Utility.height() / 2);
    for (int i = 0; i < badgers.length; i++) {
      if (badgers[i] != null) {
        badgers[i].draw();
      }
    }

  }



  /**
   * Checks if the mouse is over a specific Badger whose reference is provided as input parameter
   * had to check if it was within bounds by width/2 & height/2
   * ^^ that i kinda just implemented as best as I could from https://piazza.com/class/lcp0lbttsm43ml/post/260
   * @param Badger reference to a specific Badger object
   * @return true if the mouse is over the specific Badger object passed as input (i.e. over the
   *         image of the Badger), false otherwise
   */
  public static boolean isMouseOver(Badger Badger) {
    PImage badgers = Badger.image();
    float x = Badger.getX();
    float y = Badger.getY();

    if (Utility.mouseX() >= x - badgers.width / 2 && Utility.mouseX() <= x + badgers.width / 2
        && Utility.mouseY() >= y - badgers.height / 2
        && Utility.mouseY() <= y + badgers.height / 2) {
      // used piazza for the above since I was just checking one corner instead of doing in bounds
      return true;
    }
    return false;


  }

  /**
   * Callback method called each time the user presses the mouse
   * for loop to check if elements are null and mouse is over badgers to start dragging
   * 
   * Used piazza to and geeks for geeks to set up my for loop
   * 
   */
  public static void mousePressed() {
    for (int i = 0; i < badgers.length; i++) {
      if (badgers[i] != null && isMouseOver(badgers[i])) {
        badgers[i].startDragging();
       break;
        // i had no idea what the pdf said but piazza rec. this and it made more sense
        // so I added and followed the format https://www.geeksforgeeks.org/break-statement-in-java/

      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   * straigforward, copied from mouse pressed but this time i change to stop dragging so it releases badger
   */
  public static void mouseReleased() {
    for (int i = 0; i < badgers.length; i++) {
      if (badgers[i] != null) {
        badgers[i].stopDragging();
        
        //break; //-- i did this first but did not work
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    if (Utility.key() == 'B' || Utility.key() == 'b') { // went on discord because I didn't know how
                                                        // to make
      // the user add by pressing B/b.... didn't realize it was part of utility :) thank you discord
      for (int i = 0; i < badgers.length; i++) { // copied from setup
        if (badgers[i] == null) {
          float x = randGen.nextFloat() * Utility.width();
          float y = randGen.nextFloat() * Utility.height();
          badgers[i] = new Badger(x, y);
          badgers[i].draw();
          System.out.println("Badger successfully added");
          break;
        }
      }
    }
    if (Utility.key() == 'R' || Utility.key() == 'r') { /// Kestrel helped understand this part
                                                        /// where
      // i didn't know how to check if the element is not null to remove it
     // int last = 0;
      for (int i = 0; i < badgers.length; i++) {
        //if (badgers[i] != null) {
         if( badgers[i] != null && isMouseOver(badgers[i])) {
           badgers[i] = null;
         break;
        }

        //last = i; // last keeps track of what comes in

      }

     // badgers[last] = null; // int last = 0 connects

    }
  }
  }

//}
//
//int last = 0;
//for (int i = 0; i < badgers.length; i++) {
//  //if (badgers[i] != null) {
//  if (badgers[i] == null) {
//    break;
//  }
//
//  last = i; // last keeps track of what comes in
//
//}
//
//badgers[last] = null; // int last = 0 connects
//
//}
//}
//}
////}


      
    
 
  


