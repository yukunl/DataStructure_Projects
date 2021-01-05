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
 * This class represents a Canvas object can be edited and printed.
 * @author Will and Yukun
 *
 */
public class Canvas {
  private final int width;  // width of the canvas
  private final int height; // height of the canvas
   
  private char [][] drawingArray; // 2D character array to store the drawing
   
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  /**
   * Creates a Canvas object.
   * @param width is an int that represents the width of the Canvas object.
   * @param height is an int that represents the height of the Canvas object.
   */
  public Canvas(int width, int height) {
    if (width <= 0 || height <= 0) { 
      throw new IllegalArgumentException();
    }
 
    this.width = width;
    this.height = height;
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
    this.drawingArray = new char [height][width];
    
    // Make every spot in the array ' '
    for (int i=0; i< this.height; i++) {
      for (int j=0; j < this.width; j++) {
        this.drawingArray[i][j] = ' ';
      }
    }
    
  } 
  
  /**
   * This method places a character onto the drawingArray where the use specifies and adds
   * this drawing the the undoStack.
   * @param row is an int represent the row the user would like to draw to.
   * @param col is an int represent the column the user would like to draw to.
   * @param c is a char that is the character the user would like to draw.
   */
  public void draw(int row, int col, char c) {
    
    // Check to see if valid input
    if (row < 0 || col < 0 || row >= this.height || col >= this.width) {
      throw new IllegalArgumentException();
    }
    
    // Add char to drawingArray at specified position.
    char tempVal = this.drawingArray[row][col];
    this.drawingArray[row][col] = c;
    
    // Add this change to the undoStack.
    DrawingChange undoChange = new DrawingChange(col, row, tempVal, c);
    this.undoStack.push(undoChange);
  }
/**
 * This method allows a user to undo the most previous change, and puts that change to the 
 * redo stack
 * @return a boolean that is true if undo was successful and false if otherwise.
 */
public boolean undo() {
  boolean undobool = true;
  
  int sizeBefore = this.undoStack.size();
  
  DrawingChange undoDraw = this.undoStack.pop();
  this.drawingArray[undoDraw.y][undoDraw.x] = undoDraw.prevChar;
  
  if(this.undoStack.size() != sizeBefore - 1) {
    undobool = false;
  }
  
  this.redoStack.push(undoDraw);
  
  return undobool;
  
  
} 
  /**
   * This method always a user to redo a change that they undid, and posts the redone change
   * onto the undo stack.
   * @return a boolean that is true if redo was successful and false if otherwise.
   */
  public boolean redo() {
    boolean redobool = true;

    int sizeBefore = this.redoStack.size();

    DrawingChange redoDraw = this.redoStack.pop();
    this.drawingArray[redoDraw.y][redoDraw.x] = redoDraw.newChar;

    if (this.redoStack.size() != sizeBefore - 1) {
      redobool = false;
    }

    this.undoStack.push(redoDraw);

    return redobool;
  } // Redo the most recent undone drawing change. Return true if successful. False otherwise.
    // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if
    // needed.
  
  /**
   * This method prints drawingArray.
   */
  public String toString() {
    String printString = "";
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.height; j++) {
        printString = printString + String.valueOf(this.drawingArray[i][j]);
      }
      System.lineSeparator();
    }
    return printString;
  } // Return a printable string version of the Canvas.
  /*
   * Format example: [_ is blank. Use System.lineSeparator() to put a newline character between
   * rows] X___X _X_X_ __X__ _X_X_ X___X
   */

}
