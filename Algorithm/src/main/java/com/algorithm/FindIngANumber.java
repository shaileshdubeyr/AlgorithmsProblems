package com.algorithm;

import java.util.Scanner;

public class FindIngANumber {
    public static final int ONE = 1, ZERO = 0, TWO = 2;
    public static <FindingANumber> void main(String[] args) {
        FindingANumber findthenumber = new FindingANumber();
        int n = Integer.parseInt("10");
        int range = (int) Math.pow(TWO, n);
        System.out.println("Range is 0 to " + range);
        yourNumber(range);
    }

    public static  void yourNumber(int range) {
        Scanner scanner = new Scanner(System.in);
        int li = ZERO;
        int by = range - ONE;
        int si = (li + by) / TWO;

        System.out.println();
        System.out.println("Think of a number in your mind between 0 to " + (range - ONE));

        while (li < by) {
            System.out.println("if your number is between " + li + " to " + si + " Press 1 ");
            System.out.println("if your number is between " + (si + ONE) + " to " + by + " Press 2");

            int uservalue = scanner.nextInt();
            if (uservalue == ONE) {
                by = si;
                si = (li + by) / TWO;
            } else if (uservalue == TWO) {
                li = si + ONE;
                si = (li + by) / TWO;
            } else {
                System.out.println("Wrong input ");
            }
        }
        System.out.println("Your number is :" + si);
        scanner.close();
    }
}
