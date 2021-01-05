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

import java.util.Iterator;
/**
 * This class represents an iterator that iterates through a DrawingStack object
 * @author Will and Yukun
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  
  private Node<DrawingChange> current;
  
  /**
   * Creates a DrawingStackIterator
   * @param top is a Node of type DrawingChange that is at the top of the DrawingStack.
   */
  public DrawingStackIterator(Node<DrawingChange> top) {
    this.current = top;
  }
  
  /**
   * This method checks to see if there is another Node to iterate to
   */
  @Override
  public boolean hasNext() {
    boolean hasNext = true;
    if(current.getNext() == null) {
      hasNext = false;
    }
    return hasNext;
  }
  
  /**
   * This method returns the Node that will be iterated to next.
   */
  @Override
  public DrawingChange next() {
    if(!this.hasNext()) {
      return null;
    }
    DrawingChange nextData = this.current.getData();
    current = current.getNext();
    return nextData;
  }
  
  

}
