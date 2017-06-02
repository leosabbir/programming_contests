/* File:    TheGrid.java
 * Created: 2017-06-01
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * https://power-outage.zappos.biz/game/attempt/24
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class TheGrid {
  static String input[][] = {
          {"1R", "1D", "2L", "2R", "1D", "1D", "2D", "1R", "1L"},
          {"2R", "1D", "1D", "2D", "3D", "4D", "1L", "1L", "2L"},
          {"1D", "1R", "1D", "1L", "2L", "2D", "1D", "1U", "4L"},
          {"2R", "2L", "1R", "1L", "1U", "1R", "1L", "2L", "1D"},
          {"6R", "1U", "2R", "1R", "--", "1R", "1D", "3L", "3D"},
          {"3R", "1U", "1D", "1L", "2L", "1L", "1D", "4L", "2L"},
          {"1U", "1U", "2U", "1U", "1R", "2L", "2L", "2U", "1D"},
          {"1D", "1R", "2L", "3L", "1U", "1U", "1R", "1L", "3L"},
          {"2R", "1R", "1U", "1L", "1L", "3U", "1R", "1U", "1U"}
                  };

  public static void main(String[] args) {
    /*String[][] input = {
            {"1D", "1L", "2L", "2D", "1D"},
            {"1R", "1L", "1U", "1R", "1L"},
            {"2R", "1R", "--", "1R", "1D"},
            {"1D", "1L", "2L", "1L", "1D"},
            {"2U", "1U", "1R", "2U", "2L"}

    };*/
    int count = 0;
    for (int row = 0; row < input.length; row++) {
      for (int col = 0; col < input[0].length; col++) {
        int r = row;
        int c = col;
        String command = input[r][c];
        if (command.equalsIgnoreCase("--")) continue;

        int[][] visited = new int[input.length][input[0].length];

        while (true) {
          command = input[r][c];
          char dir = command.charAt(command.length() - 1);
          int steps = Integer.parseInt(command.substring(0, command.length() - 1));
          visited[r][c] = 1;

          if(dir == 'D') r += steps;
          if(dir == 'U') r -= steps;
          if (dir == 'L') c -= steps;
          if (dir == 'R') c += steps;

          if (r < 0 || c < 0 || r >= input.length || c >= input[0].length) {
            break;
          }

          if (input[r][c] == "--") {
            count++;
            break;
          }
          if(visited[r][c] == 1) {
            break;
          }
        }
      }
    }
    System.out.println(count);
  }
} // TheGrid
