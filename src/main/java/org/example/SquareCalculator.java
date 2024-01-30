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

    }

    public int cal() {
        Scanner userInput = new Scanner(System.in);
        boolean xpass = false, ypass = false;

        System.out.println("Enter X: ");
        x = userInput.nextInt();
        if (x >= 4 && x <= 10) {
            xpass = true;
        }

        System.out.println("Enter Y: ");
        y = userInput.nextInt();
        if (y >= 8 && y <= 12) {
            ypass = true;
        }


        if (xpass == false || ypass == false){
            return 0;
        }


        int squareCal = x * y;
        return squareCal;
    }

    public int cal(int x, int y) {
        this.x = x;
        this.y = y;
        if (x < 4 || x > 10) {
            System.out.println("X is not in range!");
            return -1;
        }
        if (y < 8 || y > 12) {
            System.out.println("Y is not in range!");
            return -1;
        }

        int squareCal = x * y;
        return squareCal;
    }


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

}
