//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 ASCII Art
// Files: AsciiArt.java, AsciiTest.java, Canvas.java DrawingChange.java,
//        DrawingStack.java, DrawingStackIterator.java
// Course: CS 300, Fall 2018
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: William Cady
// Partner Email: wcady@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x_ Write-up states that pair programming is allowed for this assignment.
// _x_ We have both read and understand the course Pair Programming Policy.
// _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Online Sources: http://cs300-www.cs.wisc.edu/wp/index.php/2018/10/29/week09
//                 -stacks-and-queues/
//                 These notes helped us to create the DrawingStack class
//
//                 https://dzone.com/articles/prefer-systemlineseparator-for-writing
//                 -system-depe
//                 This link was used to help understand how to use
//                 System.linesepartor
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class represents a change made to the canvas drawing.
 * @author Will and Yukun
 *
 */
public class DrawingChange {


  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)
  
  /**
   * This creates a DrawingChange object.
   * @param x is an int that represents the x position of the change to be made.
   * @param y is an int that represents the y position of the change to be made.
   * @param prevChar is the char at (x,y) prior to the change.
   * @param newChar is the char at (x,y) after teh change.
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x;
    this.y = y;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }

}
