
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: JunglePark.java
// Course: CS300
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Will Cady
// Partner Email: wcady@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// NONE
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

public class JunglePark {

  private static PApplet processing; // PApplet object that represents the graphic
                                     // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
                                         // background image
  private static Tiger[] tigers; // Array storing the current tigers present
                                 // in the Jungle Park
  private static Random randGen; // Generator of random numbers

  /**
   * Defines the initial environment properties of the application
   * 
   * @param processingObj represents a reference to the graphical interface of the application
   */
  public static void setup(PApplet processingObj) {

    processing = processingObj; // initialize the processing field to the one passed into
    // the input argument parameter

    // Set the color used for the background of the Processing window
    processing.background(245, 255, 250); // Mint cream color

    // Initialize and load the background image
    backgroundImage = processing.loadImage("images/background.png");

    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: system variable of the processing library that stores
    // the width
    // [resp. height] of the display window.

    // Create tigers array with 8 null references
    tigers = new Tiger[8];

    // Create randGen object
    randGen = new Random();

  }

  /**
   * Updates the display by recreating the background and redraws the appropriate number of tigers
   * to their assigned location
   */
  public static void update() {
    // Set the color used for the background of the Processing window
    processing.background(245, 255, 250); // Mint cream color

    // Initialize and load the background image
    backgroundImage = processing.loadImage("images/background.png");

    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: system variable of the processing library that stores
    // the width
    // [resp. height] of the display window.

    // Redraw the tigers on the background in new position
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        tigers[i].draw();
      }
    }
  }

  /**
   * Checks to the see if the user has clicked on a tiger image on the display window.
   * 
   * @param tiger is a Tiger object that is stored in the array tigers[].
   * @return a boolean mouseOverTiger. Returns true when the mouse is found to be over the tiger
   *         image location, and false when the mouse is not over the tiger image.
   */
  public static boolean isMouseOver(Tiger tiger) {
    boolean mouseOverTiger = false;
    if (tiger != null) {
      // Defines the area which the tiger image is in.
      float xLow = tiger.getPositionX() - tiger.getImage().width / 2;
      float xHigh = tiger.getPositionX() + tiger.getImage().width / 2;

      float yLow = tiger.getPositionY() - tiger.getImage().height / 2;
      float yHigh = tiger.getPositionY() + tiger.getImage().height / 2;
      // Checks to see if the mouse is over the tiger image
      if (processing.mouseX <= xHigh && processing.mouseX >= xLow && processing.mouseY <= yHigh
          && processing.mouseY >= yLow) {
        mouseOverTiger = true;
      }
    }
    return mouseOverTiger;
  }

  /**
   * Loops through the tigers array and calls isMouseOver on each tiger object to see if the mouse
   * is over the tiger image, and if it is isDragging is set to true.
   */
  public static void mouseDown() {
    // Loop through Tigers array and call isMouseOver on each tiger
    boolean mouseOverTiger = false;
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        mouseOverTiger = isMouseOver(tigers[i]);
        if (mouseOverTiger == true) {
          tigers[i].setDragging(true);
          break;
        }
      }
    }
  }

  /**
   * Loops through the tigers array and sets isDragging property to false for each tiger object.
   */
  public static void mouseUp() {
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        tigers[i].setDragging(false);
      }
    }
  }

  /**
   * Checks to see if the key property of the processing library is equal to upper or lower case T
   * or upper and lower case R. Adds a tiger for each time T is pressed and removes the tiger the
   * mouse is over every time R is pressed.
   */
  public static void keyPressed() {
    // Check to see if the key property is t or T
    if (processing.key == 't' || processing.key == 'T') {
      for (int i = 0; i < tigers.length; i++) {
        if (tigers[i] == null) {
          tigers[i] = new Tiger(processing, randGen.nextInt(processing.width),
              randGen.nextInt(processing.height));
          break;
        }
      }
    }
    // Check to see if the key property is r or R
    if (processing.key == 'r' || processing.key == 'R') {
      for (int i = 0; i < tigers.length; i++) {
        if (isMouseOver(tigers[i])) {
          tigers[i] = null;
          break;
        }
      }
    }
  }

  /**
   * Calls and runs the application.
   * 
   * @param args allows for command line inputs to this method.
   */
  public static void main(String[] args) {
    Utility.startApplication();
  }

}
