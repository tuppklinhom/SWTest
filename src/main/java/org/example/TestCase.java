package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestCase {
    private String filename;
    private int count = 0;

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
        long start = System.currentTimeMillis();
        count++;
        SquareCalculator squareCalculator = new SquareCalculator();
        int ans = squareCalculator.cal(x, y);

        String testCase;

        testCase ="[Test case " + count + " ]" +
                 "\nInput: x=" + String.valueOf(squareCalculator.getX()) + ", y=" + String.valueOf(squareCalculator.getY()) +
                "\nExpected result: " + expectedResult +
                "\nActual Result: " + ans;
        long finished = System.currentTimeMillis();
        testCase = testCase + "\nExecution Time: " + (finished - start) + " ms\n";
        try {
            System.out.println(filename + ".txt"); /* change pathing */
            FileWriter fw = new FileWriter(filename + ".txt", true);
            for (int i = 0; i < testCase.length(); i++)
                fw.write(testCase.charAt(i));

            String testStart = "start = " + start + "\n";
            fw.write(testStart);
            String testFinish = "finish = " + finished + "\n";
            fw.write(testFinish);
            fw.write("===============================\n");
            System.out.println("Successfully written");

                // close the file
            fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


    }
}
