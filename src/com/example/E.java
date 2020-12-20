// package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    private static long gcd(long small, long large) {
        if (small == 0) {
            return large;
        } else {
            return gcd(large % small, small);
        }
    }

    private static long gcd2(long n1, long n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }
            if (n1 > n2) {
                long temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 -= n1;
        } while (n2 != 0);

        return n1 << n;
    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] a = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long[] b = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (long j : b) {
            if (a.length == 1) {
                sb.append(a[0] + j).append(" ");
                continue;
            }
            long result = gcd(Math.min(a[0] + j, a[1] + j), Math.max(a[0] + j, a[1] + j));
//            long result = gcd2(a[0] + j, a[1] + j);
            for (int i = 2; i < a.length; i++) {
                result = gcd(Math.min(result, a[i] + j), Math.max(result, a[i] + j));
//                result = gcd2(result, a[i] + j);
            }
            sb.append(result).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
