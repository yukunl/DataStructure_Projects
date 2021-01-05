//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Jungle Park
// Files:           JunglePark.java, ParkGUI.java, Animal.java, Tiger.java,
//                  JungleParkTests.java,Deer.java,Account.java, Button.java,
//                  AddAnimalButton.java
// Course:          CS300, Fall, 2018
//
// Author:          Yukun Li
// Email:           yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

// TODO You MUST comment well this code
// TODO  Javadoc method header to every method, and in-line commenting

/**
 * This class extends class Button
 * implements the interface ParkGUI
 * This a super class for any Button that can be added to a PApplet application
 * creates button that can do modifications in the park
 *
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to 
                            // the display window 
  protected String label;   // text/label that represents the button

  /**
   * constructor of the class, 
   * Creates a new button object positioned at a given position of the display window
   * @param x position of button
   * @param y position of button
   * @param processing PApplet object that represents the display window
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing;
    // set button position
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    // set button label
    this.label = "Button";
  }
/**
 * Draws the buttons to the display window.
 * @see ParkGUI#draw()
 **/
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); 
    // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); 
    // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); 
    // set the fill color to black
    processing.text(label, position[0], position[1]); 
    // display the text of the current button
  }

  /**
   * Checks if the mouse is pressed while mouse is over if so,
   * modifies isDragging to true
   * @see ParkGUI#mousePressed()
   **/
  @Override
  public void mousePressed() {
    if (isMouseOver()) // when mouse is over on the button
      System.out.println("A button was pressed.");
  }
  
  /**
   * Checks if the mouse is released if so, modifies isDragging to false
   * @see ParkGUI#mouseReleased()
   */
  @Override
  public void mouseReleased() {
    // mouseReleased later been override 
    //by AddAnimalButton and ClearButton
  }
 /**
  * checks if the mouse is over the object
  * @see ParkGUI#isMouseOver()
  *  @param tiger reference to a given Button object
  * @return true if mouse is over a button object
  **/
  @Override
  public boolean isMouseOver() {
 // checks if the mouse is over the button
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}