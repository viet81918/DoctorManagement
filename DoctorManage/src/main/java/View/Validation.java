/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

/**
 *
 * @author conch
 */
public class Validation {
    public static Scanner in= new Scanner(System.in);
      public static int checkInputInt() {

        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Please input a valid integer.");
                System.out.print("Enter again: ");
            }
        }
    }
}
