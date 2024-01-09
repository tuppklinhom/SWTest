package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SquareCalculator {
    static int x;
    static int y;

    public SquareCalculator() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Enter X: ");
            x = userInput.nextInt();
            if (x >= 4 && x <= 10) {
                break;
            }
            System.out.println("X is not in range!");
        }
        while (true) {
            System.out.println("Enter Y: ");
            y = userInput.nextInt();
            if (y >= 8 && y <= 12) {
                break;
            }
            System.out.println("Y is not in range!");
        }

    }

    public int cal() {
        int squareCal = x * y;
        return squareCal;
    }

    public void writeTestCase() {
        String testCase, filename, isPass;
        Scanner userInput = new Scanner(System.in);
        int expectedResult;

        System.out.println("Enter Filename: ");
        filename = userInput.nextLine();

        System.out.println("Enter Expected Result: ");
        expectedResult = userInput.nextInt();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter date_time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date_timeString = myDateObj.format(date_time);

        /*** Actual Test part.  **/
        if (cal() == expectedResult){
            isPass = "Passed !";
        }
        else {
            isPass = "Not Passed!";
        }
        /*************************/

        testCase = "Expected result: " + expectedResult + " ,Input x: " + String.valueOf(getX()) + ", Input y: " + String.valueOf(getY()) + ", Date Time" + date_timeString +" " + isPass + "\n";
        try {
            System.out.println(filename + ".txt"); /* change pathing */
            FileWriter fw = new FileWriter( filename + ".txt", true);
            for (int i = 0; i < testCase.length(); i++)
                fw.write(testCase.charAt(i));

            System.out.println("Successfully written");

            // close the file
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static int getX() {
        return x;
    }

    private static int getY() {
        return y;
    }

}
