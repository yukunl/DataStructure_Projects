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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the main driver method and allows the user to interact with the 
 * canvas.
 * @author Will and Yukun
 *
 */
public class AsciiArt {

  /**
   * This method is the main driver method for this application
   * @param args
   */
  public static void main(String[] args) {
    Scanner userIn = new Scanner(System.in);
    // prompt the user for an imput
    System.out.println("======== MENU ========");
    System.out.println("[1] Create a new canvas");
    System.out.println("[2] Draw a character");
    System.out.println("[3] Undo drawing");
    System.out.println("[4] Redo drawing");
    System.out.println("[5] Show current canvas");
    System.out.println("[6] Show drawing history");
    System.out.println("[7] Exit");
    // suggest the user to put in 1
    int userInt = 0;
    while (userInt != 1) {
      System.out.println("Please Enter create a canvas by entering 1.");
      userInt = userIn.nextInt();
    }
    // once the user put in 1, ask for width and height
    if (userInt == 1) {
      System.out.println("Width of canvas: ");
      int width = userIn.nextInt();
      System.out.println("Height of canvas: ");
      int height = userIn.nextInt();
      // create the canvas of given width and height
      Canvas ArtCanvas = new Canvas(width, height);
      // a boolean to keep track if the loop is still running
      boolean run = true;
      // once a canvas is created, we can draw on the canvas
      while (run == true) {
        // print out the menu again
        System.out.println("======== MENU ========");
        System.out.println("[1] Create a new canvas");
        System.out.println("[2] Draw a character");
        System.out.println("[3] Undo drawing");
        System.out.println("[4] Redo drawing");
        System.out.println("[5] Show current canvas");
        System.out.println("[6] Show drawing history");
        System.out.println("[7] Exit");

        try {
          // check if it is a number that is put in

          
          userInt = userIn.nextInt();

        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
          
          userInt = userIn.nextInt();
        }
        // ask for a new command, should not work if the number is not 2-7
        if (userInt > 7 || userInt < 0) {
          System.out.println("Please Enter an integer between 1 and 7.");
        }
        System.out.println(">" + userInt);

        // Draw a character with command 2
        if (userInt == 2) {
          // prompt and take in for the row and column and character
          System.out.println("On which Row would you like to draw?");
          int row = userIn.nextInt();
          System.out.println("On which Column would you like to draw?");
          int col = userIn.nextInt();
          System.out.println("what character would you like to draw?");
          char Charc = userIn.next().charAt(0);
          try {
            // check if any of the value is illegal
            ArtCanvas.draw(row, col, Charc);
          } catch (IllegalArgumentException e) {
            System.out.println("please enter a row or col that is smaller than width and height");

          }
        }
        // undo drawing with command 3
        if (userInt == 3) {
          try {
            // check if undo can be performed
            if (!ArtCanvas.undo()) {
              throw new NullPointerException();
            }
            ArtCanvas.undo();
          } catch (NullPointerException e) {
            System.out.println("Sorry! Unable to undo!");
          }
        }
        // redo drawing with command 4
        if (userInt == 4) {
          try {
            // check if redo can be performed
            if (!ArtCanvas.redo()) {
              throw new NullPointerException();
            }
            ArtCanvas.redo();
          } catch (NullPointerException e) {
            System.out.println("Sorry! Unable to undo!");
          }
        }
        // show current canvas with command 5
        if (userInt == 5) {
          // Show current canvas
          ArtCanvas.toString();
        }
        // Show drawing history with command 6
        if (userInt == 6) {
          // iterate through artCanvas
          //System.out.println(ArtCanvas.getUndoStack().iterator());
        }
        // exit with command 7
        if (userInt == 7) {
          run = false;
          System.out.println("Bye");
          break;
        }
      }
    }
    // close Scanner, clear buffer
    userIn.close();
  }
}


