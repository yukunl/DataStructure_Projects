
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: JunglePark.java, ParkGUI.java, Animal.java, Tiger.java,
// JungleParkTests.java,Deer.java,Account.java, Button.java,
// AddAnimalButton.java
// Course: CS300, Fall, 2018
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * This class represents the park that put together animals 
 * and buttons It extends hidden class in
 * library PApplet
 * 
 * 
 * @author Yukun Li
 */
public class JunglePark extends PApplet {
  // PImage object that represents the background image
  private PImage backgroundImage;
  // ArrayList storing the current graphical objects (animals present
  // in the Jungle Park and buttons)
  protected ArrayList<ParkGUI> listGUI;



  /**
   * CallBack method Defines initial environment properties 
   * such as screen size and to load
   * background images and fonts as the program starts 
   * Initializes the backgroundImage and listGUI
   * instance fields.
   */
  @Override
  public void setup() {
    // Displays text in the title of the display window
    this.getSurface().setTitle("Jungle Park");
    // Sets the current alignment for drawing text to CENTER
    this.textAlign(PApplet.CENTER, PApplet.CENTER);
    // Sets the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER); 
    // Sets the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS); 
    // rectMode(CORNERS) interprets the first two 
    //parameters of rect() method as the location of one
    // corner, and the third and fourth parameters 
    //as the location of the opposite corner.
    // rect() method draws a rectangle to the display window
    this.focused = true; 
    // Confirms that our Processing program is "focused," meaning that
    // it is active and will accept mouse or keyboard input.
    // load the background image
    backgroundImage = this.loadImage("images/background.png"); 

    listGUI = new ArrayList<ParkGUI>(); 
    // create the listGUI ArrayList that would store all the
    // graphic objects (animals and buttons) 
    //that would be drawn on the display window
    AddAnimalButton tiger = new AddAnimalButton("Tiger", 43, 16, this);
    AddAnimalButton deer = new AddAnimalButton("Deer", 129, 16, this);
    ClearButton clearButton = new ClearButton(215, 16, this);
    listGUI.add(clearButton);
    listGUI.add(tiger);
    listGUI.add(deer);

  }

  /**
   * Sets the size of the application display window
   */
  @Override
  public void settings() {
    // sets the size of the display window to 800 x 632 pixels
    size(800, 632);
  }


  /**
   * Callback method called in an infinite loop. 
   * It draws the Jungle Park's window display
   */
  @Override
  public void draw() {
    // Set the color used for the background of the Processing window
    this.background(245, 255, 250); 
    // Set the mint cream color background
    this.image(backgroundImage, this.width / 2, this.height / 2); 
    // draw the background image at
    // the center of the display window
    // traverse the tigers array and draw each stored tiger
    for (int i = 0; i < listGUI.size(); i++)
      listGUI.get(i).draw();

  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // traverse listGUI and call mousePressed() of the
    // first graphical object which the mouse is over
    for (int i = 0; i < listGUI.size(); i++)
      if (listGUI.get(i).isMouseOver()) {
        listGUI.get(i).mousePressed();
        break;
      }
  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // traverse listGUI and call mouseReleased() 
    // method defined for every graphic object
    for (int i = 0; i < listGUI.size(); i++)
      listGUI.get(i).mouseReleased();
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) {
      case 'T': // add new tiger to the Jungle Park
        listGUI.add(new Tiger(this));
        break;
      case 'D': // add new tiger to the Jungle Park
        listGUI.add(new Deer(this));
        break;
      case 'R': // remove an animal from the 
        //Jungle Park if the mouse is over it
        // traverse the listGUI list and consider 
        //only animal objects to be removed if any
        for (int i = 0; i < listGUI.size(); i++) {
          if (listGUI.get(i) instanceof Animal 
              && listGUI.get(i).isMouseOver()) {
            listGUI.remove(i);
            break; // remove the first animal which 
            //the mouse is over it while the r-key is pressed
          }
        }

    }

  }

  /**
   * Removes all the animals from the park
   */
  public void clear() {
    // loops through the list of objects and search for animals
    for (int i = 0; i < listGUI.size(); i++) {
      if (listGUI.get(i) instanceof Animal) {
        // remove animal
        listGUI.remove(i);
        i--;
      }
    }
  }



  /**
   * This main method starts the application
   * 
   * @param args
   */
  public static void main(String[] args) {
    // starts the application 
    //(calls PApplet main() method with the name
    // of the PApplet class to run as parameter)
    PApplet.main("JunglePark");
  }
}
