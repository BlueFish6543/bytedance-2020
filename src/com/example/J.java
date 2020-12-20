package com.example;

import java.util.*;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numGlasses = Integer.parseInt(scanner.nextLine());
        List<Integer> capacities = new ArrayList<>();
        List<Integer> water = new ArrayList<>();
        for (int i = 0; i < numGlasses; i++) {
            String[] strings = scanner.nextLine().split(" ");
            capacities.add(Integer.parseInt(strings[0]));
            water.add(Integer.parseInt(strings[1]));
        }
        List<Integer> copy = new ArrayList<>(water);
        copy.sort(Collections.reverseOrder());
        capacities.sort(Comparator.comparing(copy::indexOf));
        water.sort(Comparator.comparing(copy::indexOf));
        // gave up
    }
}
