package org.example;

import java.util.Scanner;

public class SquareCalculator {
    int x, y;

    public SquareCalculator() {
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Enter X: ");
            x = userInput.nextInt();
            if (x >= 4 && x <= 10){
                break;
            }
            System.out.println("X is not in range!");
        }
        while(true) {
            System.out.println("Enter Y: ");
            y = userInput.nextInt();
            if (y >= 8 && y <= 12){
                break;
            }
            System.out.println("Y is not in range!");
        }
    }

    public int cal(){
        int squareCal = x*y;
        return squareCal;
    }
}
