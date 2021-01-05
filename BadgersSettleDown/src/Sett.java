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


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The class represents a sett where Badger objects are stored in a binary tree.
 * @author Will and Yukun
 *
 */
public class Sett {
  private Badger topBadger;

  /**
   * sett constructor that sets the first badger in sett null
   */
  public Sett() {
    this.topBadger = null;
  }

  /**
   * This method returns the top badger.
   * 
   * @return topBadger is a Badger object which represents the root of the binary tree.
   */
  public Badger getTopBadger() {
    return this.topBadger;
  }


  /**
   * this method checks if the sett is empty
   * 
   * @return true if sett is empty
   */
  public boolean isEmpty() {

    boolean settIsEmpty = false;

    if (this.topBadger == null) {
      settIsEmpty = true;
    }

    return settIsEmpty;

  }

  /**
   * this method checks if the size already exits and settles badger according to their 
   * size with the help of settleHelper
   * 
   * @param size an int that represents the size of the Badger added to the binary tree
   */
  public void settleBadger(int size) {
    boolean foundBadger = false;
    Badger newBadger = new Badger(size);
    Badger current = this.getTopBadger();
    // check if sett is empty
    if (this.isEmpty()) {
      this.topBadger = newBadger;
    } else {
      try {
        this.findBadger(size); // check if there is a badger of same size
        foundBadger = true;
      } catch (NoSuchElementException e) {
        settleHelper(current, newBadger); // if no, settle the badger
      }

      // if same size badger exists, gives a warning
      if (foundBadger) {
        throw new IllegalArgumentException("WARNING: failed to settle the badger with size " + size
            + ", as there is already a badger with the same size in this sett");
      }
    }
  }

  /**
   * This method is a helper method for settleBadger and put badger to smaller badger to the left
   * bigger badger to the right
   * 
   * @param current the current node
   * @param newBadger the new badger that is going to be added
   */
  private void settleHelper(Badger current, Badger newBadger) {
    if (current.getSize() > newBadger.getSize()) { 
      if(current.getLeftLowerNeighbor() == null) {
      current.setLeftLowerNeighbor(newBadger);
      return;}
      else {
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
      }
    } 
    if (current.getSize() < newBadger.getSize()) {
      if(current.getRightLowerNeighbor() == null) {
      current.setRightLowerNeighbor(newBadger); // same reason settle it as right neighbor
      return;
    }
      else{
        settleHelper(current.getRightLowerNeighbor(), newBadger);
        }
      }
    
//    if (current.getSize() > newBadger.getSize()) { // if 
//      settleHelper(current.getLeftLowerNeighbor(), newBadger);
//    } else if (current.getSize() < newBadger.getSize()){
//      settleHelper(current.getRightLowerNeighbor(), newBadger);
//    }

  }


  /**
   * this method finds the badger with a given size with the help of findHelper method
   * 
   * @param size is that size of the Badger that is searched for.
   * @return Badger that has the inquired size
   */
  public Badger findBadger(int size) {
    Badger curr = this.getTopBadger();
    return findHelper(curr, size);

  }

  /**
   * this method is the helper method for findBadger
   * it finds a badger of a inquired size starting from a inquired badger
   * @param current the badger we want to start finding 
   * @param size the size of the badger we want to find
   * @return the Badger object that has the size searched for.
   */
  private Badger findHelper(Badger current, int size) {
    while (current != null) {
      if (size == current.getSize()) { // if current badger is than inquired size
        return current;
      } else if (size < current.getSize()) { // if current badger is bigger 
        current = current.getLeftLowerNeighbor();
      } else { // if the current badger is smaller
        current = current.getRightLowerNeighbor();
      }
    }// if given size doesnt exist
    throw new NoSuchElementException(
        "WARNING: failed to find a badger with size " + size + " in the sett");
  }

  /**
   * Counts how many badgers are in the sett with the help of countHelper
   * 
   * @return the number of badgers in the sett as an int.
   */
  public int countBadger() {
    Badger current = this.getTopBadger();
    int badgerCount = countHelper(current);
    return badgerCount;

  }

  /**
   * Recursive helper to count badgers in the sett.
   * 
   * @param current is the current Badger object you are counting.
   * @return an int that represents the number of badgers in the sett.
   */
  private int countHelper(Badger current) {
    if (current == null) {
      return 0;
    } else {
      return countHelper(current.getLeftLowerNeighbor())
          + countHelper(current.getRightLowerNeighbor()) + 1;
    }
  }

  /**
   * THis method turns binary tree into list in inorder with the help of getAllHelper
   * @return the list of badgers
   */
  public java.util.List<Badger> getAllBadgers() {
    List<Badger> allBadgers = new ArrayList<>();
    Badger current = this.getTopBadger();
    this.getAllHelper(current, allBadgers);
    return allBadgers;

  }

  /**
   * this method helps getAll Badgers starting from a given badger 
   * @param current is the current Badger object being examined
   * @param allBadgers is a list of Badger objects.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {

    if (current == null) {
      return;
    }

    getAllHelper(current.getLeftLowerNeighbor(), allBadgers); // get left badger
    allBadgers.add(current); // get middle badger
    getAllHelper(current.getRightLowerNeighbor(), allBadgers); // get right badger
  }

  /**
   * this method gets the height of the tree with the help of getHeightHelper
   * @return the height of the bst
   */
  public int getHeight() {
    Badger current = this.getTopBadger();
    int height = getHeightHelper(current);
    return height;
  }

  /**
   * this is the helper method for getHeight(), it starts to count height from a given badger
   * @param current starting from the current badger
   * @return the height of the tree
   */
  private int getHeightHelper(Badger current) {
    int height = 0;
    if (current == null) {
      return height;
    }// takes the taller part of the tree
    return 1 + Math.max(getHeightHelper(current.getLeftLowerNeighbor()),
        getHeightHelper(current.getRightLowerNeighbor()));
  }

  /**
   * this method gets the largest badger in the sett
   * @return the largest badger
   */
  public Badger getLargestBadger() {
    List<Badger> badgerList = this.getAllBadgers();
    return badgerList.get(badgerList.size() - 1); // takes the last badger in the list form
  }

  /**
   * this method clears the sett, and sett the first badger to null
   */
  public void clear() {
    this.topBadger = null;
  }


}
