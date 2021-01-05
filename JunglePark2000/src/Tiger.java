//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: JunglePark.java, ParkGUI.java, Animal.java, Tiger.java,
// JungleParkTests.java,Deer.java,Account.java, Button.java,
// AddAnimalButton.java
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
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class extends class Animal and represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; 
  // range dimension for scanning the neighborhood for food
                                             
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger

  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far

  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    deerEatenCount = 0;
  }

  public int getdeerEatenCount() {
    return deerEatenCount;
  }

  /**
   * Defines the Tiger's behavior in the Jungle Park Tiger's 
   * behavior in the Jungle Park Scans for
   * food at the neighborhood of the current tiger. 
   * If the Tiger founds any deer at its proximity,
   * it hops on it, and eats it
   */

  @Override
  public void action() {
    // search through objects to find deers
    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Deer) {
        // perform hop method on deer
        hop((Deer) processing.listGUI.get(i));
      }
    }
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }


  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }


  /**
   * when a tiger is close enough to a deer, it will take the position of the deer and remove deer
   * from the park
   * 
   * @param food Deer that are close to a tiger
   */
  public void hop(Deer food) {

    // for (int i = 0; i < processing.listGUI.size(); i++) {
    // if (processing.listGUI.get(i) instanceof Tiger) {
    if (isClose(food, SCAN_RANGE)) { // check if food is close
      // move to the position of food
      setPositionX(food.getPositionX());
      setPositionY(food.getPositionY());
      // eat it: remove deer from park
      processing.listGUI.remove(food);
      // increment deerEatenCount
      deerEatenCount++;
    }
  }
  // }
  // }

}
