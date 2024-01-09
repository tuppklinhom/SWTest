package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SquareCalculator myObj = new SquareCalculator();
        myObj.writeTestCase();
        System.out.println("Area of square: " + myObj.cal());
    }
}