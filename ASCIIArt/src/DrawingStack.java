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
 * This class represents a stackADT that stores DrawingChange objects
 * @author Will and Yukun
 *
 */
public class DrawingStack implements StackADT<DrawingChange> {
  private Node<DrawingChange> top;
  private int size;

  /**
   * Creates a DrawingStack object
   */
  public DrawingStack() {
    this.top = null;
    this.size = 0;
  }
  /**
   * This method adds a new DrawingChange object to the top of the DrawingStack.
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // Add new Node<DrawingChange> to the stack
    Node<DrawingChange> AddNode = new Node<DrawingChange>(element, this.top);

    this.top = AddNode;
    AddNode = null;
    this.size++;
    
  }
  
  /**
   * This methods returns the top DrawingChange object on the DrawingStack and removes
   * that DrawingChange object from the stack.
   */
  @Override
  public DrawingChange pop() {
    // Return the DrawingChange in this node and remove it from the stack
    if (this.isEmpty()) {
      return null;
    }

    DrawingChange tempVal = this.top.getData();
    this.top = this.top.getNext();
    this.size--;
    return tempVal;

  }
  
  /**
   * This method returns the top DrawingChange object on the stack without removing it 
   * from the stack.
   */
  @Override
  public DrawingChange peek() {
    // Return the DrawingChange in this node but keep it in the stack
    
    if (this.isEmpty()) {
      return null;
    }
    
    return this.top.getData();
  }
  
  /**
   * This method checks to see if there are any DrawingChange objects on the stack.
   */
  @Override
  public boolean isEmpty() {
    boolean isEmpty = false;
    if(this.top == null) {
      isEmpty = true;
    }
    return isEmpty;
  }
  
  /**
   * This method returns the number of DrawingChange objects in the stack.
   */
  @Override
  public int size() {
    return this.size;
  }
  
  /**
   * This method creates an iterator to iterate through the DrawingStack.
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    // TODO Auto-generated method stub
    return new DrawingStackIterator(this.top);
  }

}
