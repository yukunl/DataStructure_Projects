//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Math Game
// Files: GameApplication.java, GameList.java, GameNode.java, GameTests.java
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
// Online Sources: https://www.tutorialspoint.com/java/java_string_charat.htm
//                 Above link was used to determine how to implement Atchar() 
//                 method.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;
import java.util.Scanner;
/**
 * This class is used as the main driver, allowing the user to enter commands and see the 
 * game board. 
 * @author Yukun Li
 *
 */
public class GameApplication { 
  
private int NumberMoves; // Number of moves the player has made
private int target; // Number that the user must achieve to win

/**
 * Getter for the target field
 * @return int target that is the goal the player is trying to reach.
 */
private int getTarget() {
  return this.target;
}

/**
 * Updates the NumberMoves field by 1 each time it's called.
 */
private void updateMoves() {
  this.NumberMoves++;
}

/**
 * Getter for number of moves a player has made during a game.
 * @return an int that is the number of moves the player has made.
 */
private int getNumberMoves() {
  return this.NumberMoves;
}

/**
 * Creates a GameApplication object with a target set to a random integer between 10 and 99
 * and number of moves set to 0.
 * @param rng a Random object used to create a random integer for the target.
 */
public GameApplication(Random rng) {
  this.target = rng.nextInt(89) + 10;
  this.NumberMoves = 0;
}

/**
 * This is the main driver that allows the user to play the game. Displays and updates the
 * game list according to user input.
 * @param args allows for command line arguments.
 */
public static void main(String[] args) {
  Random rng = new Random();
  
  GameList list = new GameList();
  
  GameApplication game = new GameApplication(rng);
  
  for (int i=0; i < 7; i++) { // create a GameList with 7 random GameNodes
    GameNode newNode = new GameNode(rng);
    list.addNode(newNode);
  }
  
  Scanner userIn = new Scanner(System.in);

  boolean run = true;
  
  while(run == true) { // Continue to run until the user has won or quit.
      System.out.println("Goal: " + game.getTarget() + " Moves Taken: " + 
          game.getNumberMoves());
      System.out.println("Puzzle: " + list.toString());
      System.out.print("Number and Operation " + GameOperator.ALL_OPERATORS.toString() +
          " to Apply: ");
      String command = userIn.nextLine();

      command = command.trim().toLowerCase();
      
      if (command.equals("quit")) { // Check to see if the user wants to quit.
        run = false;
        System.out.println("Goodbye!");
        break;
      }
      
      // Process the command and split it into an operator char and integer.
      char operator = command.charAt(command.length() - 1);
      String num_string = command.substring(0, command.length() - 1);
      Integer number = Integer.parseInt(num_string);
      
      // If the user input is valid, update the board accordingly
      if (list.contains(number) && GameOperator.getFromChar(operator) != null) {
        game.updateMoves();
        GameNode nodeAdded = new GameNode(rng);
        list.addNode(nodeAdded);
        list.applyOperatorToNumber(number, GameOperator.getFromChar(operator));
        if (list.contains(game.getTarget())) { // when target is present
          System.out.println("Congratulations! You've won the math game!");
          break;
        }
      }else { // If the user input is not valid, give the user a warning.
        System.out.println("WARNING: Please enter a valid input.");
      }
    
  }

}
  

}
