package com.algorithm;

import java.util.*;

public class Generic {
    public static final int ONE = 1, TWO = 2, ZERO = 0;

    private static <T extends Comparable<T>> void insertionSort(T[] array, int length) {
        for (int i = ONE; i < array.length; i++) {
            T key = array[i];
            int j = i - ONE;
            while (j >= 0 && (array[j].compareTo(key) > ZERO)) {
                array[j + ONE] = array[j];
                j = j - ONE;
            }
            array[j + ONE] = key;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int low, int high, T key) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid].equals(key))
                return mid;
            if (array[mid].compareTo(key) > ZERO) {
                return binarySearch(array, low, mid - ONE, key);
            } else {
                return binarySearch(array, mid + ONE, high, key);
            }
        }
        return -ONE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How Many Elements do u want to insert: ");
        int length = scanner.nextInt();
        String[] array = new String[length];
        System.out.println("Enter Array Elements: ");

        for (int i = ZERO; i < array.length; i++) {
            array[i] = scanner.next();
        }

        System.out.println("1. Binary Search using Generics.\n2. Insertion Sort Using Generics."
                + "\n3. Bubble Sort Using Generics.\nEnter Your Choice: \n");
        switch (scanner.nextInt()) {
            case 1:

                System.out.println("Sorted Array is: ");
                Arrays.sort(array);
                for (String str : array)
                    System.out.print(str + " ");
                System.out.println("\nEneter VALUE to search: ");
                String key = scanner.next();
                int value = binarySearch(array, ZERO, array.length - ONE, key);
                if (value == -ONE) {
                    System.out.println("Element Not Present");
                } else
                    System.out.println("Element Found at index " + value);

            case 2:
                insertionSort(array, array.length);
                for (int arryData = 0; arryData < array.length; arryData++) {
                    System.out.print(array[arryData] + " ");
                }

        }
    }

}
