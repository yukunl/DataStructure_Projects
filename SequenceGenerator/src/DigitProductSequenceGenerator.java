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


import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a generator for an DigitProduct progression
 * 
 * @author Yukun
 *
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * Generates an arithmetic progression
   * 
   * @param init initial value
   * @param size number of elements in the sequence
   */

  public DigitProductSequenceGenerator(int init, int size) {
    // check for the precondition: size > 0, throws an
    // IllegalArgumentException if this precondition is not satisfied
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    // check for the validity of init (>=0) throw an IllegalArgumentException
    // if these two parameters are not valid
    if (init <= 0) {
      throw new IllegalArgumentException("WARNING: The starting element for digit"
          + " product sequence cannot be less than or equal to zero.");
    }
    // set the instance fields
    INIT = init;
    SIZE = size;
    // initialize sequence to an empty array
    ArrayList<Integer> array = new ArrayList<Integer>();
    sequence = array;
    // generate sequence
    this.generateSequence();
  }

  /*
   * This method modifies sequence arrayList to become DigitProduct Sequence
   * 
   */

  public void generateSequence() {

    int current = INIT; // set the current value to initial value
    for (int j = 0; j < SIZE; j++) {// for this many numbers we want to generate
      sequence.add(current); // add current value to the sequence arrayList
      int product = 1; // reset product for every number generates
      int tempval = current; // tempval holds current's value

      while (tempval > 0) {// when current value is bigger than 0
        int currentProduct = tempval % 10;// take the first digit of this number
        if (currentProduct > 0) {// if this digit is not 0, multiplies it
          product *= currentProduct;
        }
        tempval = tempval / 10;// update current
      }
      current += product; // update current
    }
  }

  /**
   * iterate through the sequence arrayList
   * 
   * @return digitProduct sequence
   */
  public Iterator<Integer> getIterator() {
    // TODO return an Iterator to iterate over the ArrayList sequence field
    return sequence.iterator();
  }


}
