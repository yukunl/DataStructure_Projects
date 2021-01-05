
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
 * This class represents a generator for an Fibonacci progression This class implements the
 * Iterator<Integer> interface
 * 
 * @author Yukun
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  /**
   * Generates an Fibonacci progression
   * 
   * @param size number of elements in the sequence
   */
  public FibonacciSequenceGenerator(int size) {
    // check for the precondition: size > 0, throws an
    // IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    // set the instance fields
    this.SIZE = size;
    this.prev = 0;
    this.next = 1;
    generatedCount = 0;
  }


  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element in this sequence, false
   *         otherwise
   */
  // time complexity: O(1)
  @Override
  public boolean hasNext() {

    // true when generated number doesn't exceed size
    return generatedCount < SIZE;

  }

  /**
   * Returns the next element in this Fibonacci sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  // time complexity: O(1)
  @Override
  public Integer next() {

    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    // the first two number does not involve calculation
    if (generatedCount <= 2) {
      Integer tempval = new Integer(this.prev);
      this.prev = this.next;
      generatedCount++;
      return tempval;
    }
    // calculation of numbers after first 2 numbers
    int current = this.next; // set the current element to next
    this.next = current + this.prev;// set next number to the 2 previous number
    this.prev = current; // move "the previous" number to the current number
    this.generatedCount++; // increment the number of generated elements so far
    return this.next; // return the next number as the generated one
  }

  // You CAN add public accessor and mutator methods as needed here in order to implement your test
  // methods

}
