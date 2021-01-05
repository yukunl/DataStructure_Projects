//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BadgersSettleDown
// Files: Badger.java, Sett.java, P9Tests.java, BadgersSettleDown.java
// Course: CS300, Fall 2018
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
// Online Sources: https://www.geeksforgeeks.org/write-a-c-program-to-find-the-
//                 maximum-depth-or-height-of-a-tree/
//                 Used the above to link to learn about the logic of finding 
//                 the height of a tree.
//                 https://stackoverflow.com/questions/13756605/counting-the-
//                 nodes-in-a-binary-search-tree
//
//                 Used the above link to determine how to count the number of 
//                 Badgers in the sett.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class represents a Badger object that stores an int and two neighbors.
 * @author Will and Yukun
 *
 */
public class Badger {

  private final int size; // size of badger
  private Badger leftLowerNeighbor; // left neighbor
  private Badger rightLowerNeighbor;// right neighbor

  /**
   * this is the constructor of the badger class that takes in a size 
   * and set leftLowerNeighbor and rightLowerBeighbor to 0
   * 
   * @param size an int that represents the size of the badger
   */
  public Badger(int size) {
    this.size = size;
    this.leftLowerNeighbor = null;
    this.rightLowerNeighbor = null;
  }

  /**
   * This method returns a badgers lower left neighbor.
   * 
   * @return leftLowerNeighbor a Badger object which is the left child of the Badger
   *         object.
   */
  public Badger getLeftLowerNeighbor() {
    return this.leftLowerNeighbor;
  }

  /**
   * This method sets a badgers lower left neighbor.
   * 
   * @param badger which represents the Badger objects left child.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }

  /**
   * This method returns a badgers lower right neighbor.
   * 
   * @return rightLowerNeighbor a Badger object which is the right child of the Badger
   *         object.
   */
  public Badger getRightLowerNeighbor() {
    return this.rightLowerNeighbor;
  }

  /**
   * This method sets a badgers right left neighbor.
   * 
   * @param badger which represents the Badger objects right child.
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }

  /**
   * Returns the size of the badger.
   * 
   * @return an int that represents the size of a Badger object.
   */
  public int getSize() {
    return this.size;
  }


}
