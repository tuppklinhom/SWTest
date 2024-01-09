package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestCase {
    private String filename;

    public TestCase(){
        Scanner userInput = new Scanner(System.in);


        System.out.println("Enter Filename: ");
        filename = userInput.nextLine();

        /** Test part **/
        TestCal(4 , 8 ,32);
        TestCal(7, 10 ,70);
        TestCal(10, 12, 120);

        /***************/
    }

    private void TestCal(int x, int y, int expectedResult){
        String isPass;
        SquareCalculator squareCalculator = new SquareCalculator();

        if(squareCalculator.cal(x, y) == expectedResult){
            isPass = "Passed !";
        }else{
            isPass = "Not Passed !";
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter date_time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date_timeString = myDateObj.format(date_time);



        String testCase;

        testCase = "Expected result: " + expectedResult + " ,Input x: " + String.valueOf(squareCalculator.getX()) + ", Input y: " + String.valueOf(squareCalculator.getY()) + ", Actual Result: " + squareCalculator.cal(x, y) + ", Date Time" + date_timeString + " " + isPass + "\n";
        try {
            System.out.println(filename + ".txt"); /* change pathing */
            FileWriter fw = new FileWriter(filename + ".txt", true);
            for (int i = 0; i < testCase.length(); i++)
                fw.write(testCase.charAt(i));

            System.out.println("Successfully written");

                // close the file
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


    }
}
