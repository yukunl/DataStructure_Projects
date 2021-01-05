
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: Seuqencek.java, FibonacciSequence.java, DigitProductSequence.java,
// SeuqenceGenerateTests.java, ArithmeticSequenceGenerator.java,
// GeometricSequenceGenerator.java
//
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
// Online Sources: https://stackoverflow.com/questions
/// 14743165/simple-number-to-array-with-individual-digits
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * This class represents a generator for an Geometric progression This class implements the
 * Iterator<Integer> interface
 * 
 * @author Yukun
 *
 */
public class GeometricSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // The number of elements in this sequence
  private final int INIT; // The first term in this sequence
  private final int RATIO; // The common ratio for this sequence
  private int next; // The next term in the sequence

  private int generatedCount; // The number of terms generated so far in this sequence
  // It refers also to the order of the next number to be generated by next() method

  /**
   * Generates an arithmetic progression
   * 
   * @param init initial value
   * @param ratio common ratio difference
   * @param size number of elements in the sequence
   */
  public GeometricSequenceGenerator(int init, int ratio, int size) {

    // check for the precondition: size > 0, throws an IllegalArgumentException
    // if this precondition is not satisfied
    if (size < 0) {
      throw new IllegalArgumentException(
          "WARNING:" + " CANNOT create a sequence with size <= zero.");
    }
    // check for the validity of init (>0) and ratio (>0),
    // throw an IllegalArgumentException if these two parameters are not valid
    if (ratio <= 0 || init <= 0) {
      throw new IllegalArgumentException(
          "WARNING: " + "The starting element and the common ratio for"
              + " a geometric progression should be STRICTLY POSITIVE.");
    }

    // set the instances of the fields
    this.INIT = init;
    this.SIZE = size;
    this.RATIO = ratio;
    // initializes next to the first element in this Geometric progression
    next = init;
    generatedCount = 0;

  }


  /** 
   * Checks if the iteration has a next element in this sequence
   * @return true if the current element in the
   * iteration has a next element in this sequence,
   * false otherwise 
   */
  // time complexity: O(1)
  @Override
  public boolean hasNext() {
    return generatedCount < SIZE;
  }

  /** 
   * Returns the next element in this geometric sequence iteration with respect to the numbers
   * generated so far
   * @return the next element in this iteration
   */
  // time complexity: O(1)
  @Override
  public Integer next() {
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int current = next; // set the current element to next
    generatedCount++; // increment the number of generated elements so far
    next = next * RATIO; // set the next element (multiplies the common ratio to the current number)
    return current; // return the current number as the generated one

  }

  // You can add local variable to your hasNext() or next() method to implement their correct
  // behavior if needed
  // You can add public getters and setters methods as needed to implement your test methods here
  // You CANNOT define mutators for any final field


}