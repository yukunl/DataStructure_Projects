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
/**
 * This class extends class Button
 * and contains button that can clear out animals in park
 *
 */
public class ClearButton extends Button implements ParkGUI{

  /**
   * @param x position of Button
   * @param y position of Button
   * @param park calling from super class
   * processing PApplet object that represents the display window
   */
  public ClearButton(float x, float y, JunglePark park) {
    // calls for super class Button to set position
    // and name displayed on button
    super(x, y, park);
    this.label = "Clear Park";
}
 
  /**
   * overrides mousePressed in Button
   * Checks if the mouse is pressed on  clear button 
   * while mouse is over if so,
   * clears the park 
   **/
@Override
public void mousePressed() {
  if (isMouseOver()) {
    // if instance is an animal object, clear  
   processing.clear();
  }
}
  
}
