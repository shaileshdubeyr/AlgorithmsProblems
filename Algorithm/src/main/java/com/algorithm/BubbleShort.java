package com.algorithm;

import java.util.Scanner;

public class BubbleShort {
    public static final int ZERO = 0, ONE = 1;
    public static <BubbleSort> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Total Nos. of Array Elements You Want To sort: ");
        int totalElements = scanner.nextInt();
        int arr[] = new int[totalElements];

        System.out.println("Enter " + totalElements + " Array Elements: ");
        for (int i = ZERO; i < totalElements; i++)
            arr[i] = scanner.nextInt();
        sort(arr, totalElements);
    }

    private static  void sort(int[] arry, int arrLength) {
        System.out.println("Before Sorting");
        // prints the array before sorting
        for (int i = ZERO; i < arrLength; i++)
            System.out.print(arry[i] + " ");

        System.out.println("\nAfter Sorting\n");
        for (int outerLoop = ZERO; outerLoop < arrLength - ONE; outerLoop++) {
            for (int innerLoop = ZERO; innerLoop < arrLength - outerLoop - ONE; innerLoop++) {
                int temp;
                // swap arr[j+1] and arr[i]
                if (arry[innerLoop] > arry[innerLoop + ONE]) {
                    temp = arry[innerLoop];
                    arry[innerLoop] = arry[innerLoop + ONE];
                    arry[innerLoop + ONE] = temp;
                }
            }

        }
        // printing the array
        for (int printArry = ZERO; printArry < arrLength; printArry++) {
            System.out.print(arry[printArry] + " ");
        }
    }
}
