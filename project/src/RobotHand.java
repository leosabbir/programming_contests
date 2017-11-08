/* File:    RobotHand.java
 * Created: 2017-11-08
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * Solution to https://www.careercup.com/question?id=5095457003929600
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class RobotHand {

  public static void main(String[] args) {
    process("HI", 26); // R8, T, R1, T
    System.out.println();
    process("HELLO", 13); // R8, T, L3, T, R7, T, T, D1, L10, T
    System.out.println();
    process("SABBIR", 1);
  } // main

  //-------------------------------------------------------------------------------

  /**
   * Print the movement of the robot to print the given input with the keyboard of
   * given width
   * @param input input string to print
   * @param width width of the keyboard
   */
  public static void process(String input, int width) {
    // initial position of the robot hand
    int currentRow = 0;
    int currentCol = -1;

    for (int i = 0; i < input.length(); i++) {
      // next char
      int next = input.charAt(i) - 'A';
      // convert to 2D location (row, col)
      int row = next / width;
      int col = next % width;

      // move the robot hand from current location to new
      if (row < currentRow) {
        System.out.print("U" + (currentRow - row) + ", ");
      } else if (row > currentRow){
        System.out.print("D" + (row - currentRow) + ", ");
      }

      if (col < currentCol) {
        System.out.print("L" + (currentCol - col) + ", ");
      } else if (col > currentCol){
        System.out.print("R" + (col - currentCol) + ", ");
      }

      if (i < input.length() - 1) {
        System.out.print("T, ");
      } else {
        System.out.print('T');
      }

      currentRow = row;
      currentCol = col;
    }
  } // process


} // RobotHand
