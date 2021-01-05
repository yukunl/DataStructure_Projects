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
 * This class extends class Animal
 * and represents a Deer in the JunglePark application
 *
 */
public class Deer extends Animal {

  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  // Constructor that creates a new Deer object positioned at a random position of the display
  // window
  public Deer(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);
    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current deer
    nextID++;
  }

  // Checks if there is a threat (a Tiger for instance) at the neighborhood
  // scanRange is an integer that represents the range of the area to be scanned around the animal
  public boolean scanForThreat(int scanRange) {
    boolean hasThreat = false;
    // loop through the tigers of their position, if found tiger, return true, else return false
    // loop through the arraylist
    for (int i = 0; i < processing.listGUI.size(); i++) {
      // get tiger position
      if (processing.listGUI.get(i) instanceof Tiger) {
        // if tiger is within the scanRange
       // if (distance((Animal) processing.listGUI.get(i)) <= scanRange) {
        if(isClose((Animal) processing.listGUI.get(i),scanRange) == true) {
          //System.out.println("checkpoint");
          hasThreat = true;
        }
      }
    }
    return hasThreat;
  }

  // Defines the behavior of a Deer object in the Jungle park
  @Override
  public void action() {
    if (scanForThreat(SCAN_RANGE) == true) {
      this.processing.fill(0); // specify font color: black
      // display warning
      this.processing.text("THREAT!", this.getPositionX(),
          this.getPositionY() - this.image.height / 2 - 4);
    }
  }
}
