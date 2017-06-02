/* File:    BookCode.java
 * Created: 2017-06-01
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class BookCode {

  public static void main(String[] args) throws IOException {
    int[] codes = {4, 1, 2, 6, 2, 3, 51, 126, 141, 257, 3, 22, 2, 247, 5, 141, 3, 1, 126, 20, 3, 9, 126, 6, 20, 11, 3, 1097, 132, 2, 20, 11, 993, 3, 1, 11, 11, 131, 993, 345442, 345442, 126, 26, 126, 199, 247, 132, 6, 26, 136, 8, 199, 345442, 39, 775, 132, 131, 257, 775, 776, 26, 862, 131, 247};

    URL website = new URL("https://d1451350osk5x1.cloudfront.net/war_of_the_worlds_zappos.txt");
    URLConnection connection = website.openConnection();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(
                    connection.getInputStream()));

    StringBuilder response = new StringBuilder();
    String inputLine;

    while ((inputLine = in.readLine()) != null)
      response.append(inputLine).append("\n");

    in.close();

    String res = response.toString();

    for (int idx : codes) {
      System.out.print(res.charAt(idx));
    }
  }
} // BookCode
