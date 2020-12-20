// package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int numPlayers = Integer.parseInt(strings[0]);
        int numShots = Integer.parseInt(strings[1]);
        int[] freeThrows = new int[numPlayers];
        int[] twoPointers = new int[numPlayers];
        int[] threePointers = new int[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            strings = scanner.nextLine().split(" ");
            freeThrows[i] = Integer.parseInt(strings[2]);
            twoPointers[i] = Integer.parseInt(strings[1]);
            threePointers[i] = Integer.parseInt(strings[0]);
        }
        int totalScore = 0;
        List<Integer> reductions = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            reductions.add(0);
        }
        for (int i = 0; i < numShots; i++) {
            strings = scanner.nextLine().split(" ");
            int player = Integer.parseInt(strings[0]) - 1;
            if (strings[1].equals("2")) {
                totalScore += 2 * twoPointers[player];
                int reduction = 2 * (twoPointers[player] - freeThrows[player]);
                if (reduction > 0) {
                    reduce(reductions, reduction);
                }
            } else {
                totalScore += 3 * threePointers[player];
                int reduction = 3 * (threePointers[player] - freeThrows[player]);
                if (reduction > 0) {
                    reduce(reductions, reduction);
                }
            }
        }
        double totalReduction = reductions.stream().mapToInt(Integer::intValue).sum();
        System.out.println((totalScore - totalReduction) / 100);
    }

    private static void reduce(List<Integer> reductions, int reduction) {
        int j = 0;
        while (j < 6 && reduction >= reductions.get(j)) {
            j += 1;
        }
        if (j > 0) {
            reductions.add(j, reduction);
            reductions.remove(0);
        }
    }
}
