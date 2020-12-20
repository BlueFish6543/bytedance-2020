// package com.example;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            scanner.nextLine();
            String red = scanner.nextLine();
            String blue = scanner.nextLine();
            int redCounter = 0;
            int blueCounter = 0;
            for (int j = 0; j < red.length(); j++) {
                if (red.charAt(j) > blue.charAt(j)) {
                    redCounter += 1;
                } else if (red.charAt(j) < blue.charAt(j)) {
                    blueCounter += 1;
                }
            }
            if (redCounter > blueCounter) {
                System.out.println("RED");
            } else if (redCounter < blueCounter) {
                System.out.println("BLUE");
            } else {
                System.out.println("EQUAL");
            }
        }
    }
}
