package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestCase {
    private String filename, testerName;
    private int passCount = 0;
    private int notPassCount = 0;
    private int count = 0;

    public TestCase(){
        Scanner userInput = new Scanner(System.in);


        System.out.println("Enter Filename: ");
        filename = userInput.nextLine();
        System.out.println("Enter Tester Name: ");
        testerName = userInput.nextLine();

        /** Test part **/
        TestCal(4 , 8 ,32);
        TestCal(7, 10 ,70);
        TestCal(6, 8, 48);
        TestCal(9, 12, 108);
        TestCal(10, 10, 100);
        TestCal(10, 12, 120);
        TestCal(11, 10, -1);
        TestCal(8, 13, -1);
        TestCal(3, 10, -1);
        TestCal(5, 7, -1);

        try {
            FileWriter fw = new FileWriter(filename + ".txt", true);
            String testCount =
                    "\nTotal Pass: " + String.valueOf(passCount) +
                            "\nTotal Not Pass: " + String.valueOf(notPassCount) +
                            "\n===============================";

            fw.write(testCount);
            fw.close();
        }catch(Exception e) {
            e.getStackTrace();
            }

        /***************/
    }

    private void TestCal(int x, int y, int expectedResult){
        String passStatus = "";

        long start = System.currentTimeMillis();
        count++;
        SquareCalculator squareCalculator = new SquareCalculator();
        int ans = squareCalculator.cal(x, y);

        if (ans == expectedResult) {
            passStatus = "Pass";
            passCount++;
        }
        else {
            passStatus = "Not Pass";
            notPassCount++;
        }

        String testCase;

        testCase ="[Test case " + count + " ]" +
                "\nTest By: " + testerName +
                "\nInput: x=" + String.valueOf(squareCalculator.getX()) + ", y=" + String.valueOf(squareCalculator.getY()) +
                "\nExpected result: " + expectedResult +
                "\nActual Result: " + ans +
                "\nStatus: " + passStatus;
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
