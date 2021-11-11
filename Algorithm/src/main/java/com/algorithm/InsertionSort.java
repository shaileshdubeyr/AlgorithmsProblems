package com.algorithm;

import java.util.Scanner;

public class InsertionSort {
    public static final int ZERO = 0, ONE = 1;

    void sort(int arr[]) {
        int n = arr.length;
        for (int i = ONE; i < n; ++i) {
            int key = arr[i];
            int assign = i - ONE;

			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
            while (assign >= ZERO && arr[assign] > key) {
                arr[assign + ONE] = arr[assign];
                assign = assign - ONE;
            }
            arr[assign + ONE] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = ZERO; i < n; ++i)
            //System.out.print(arr[i] + " ");
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How Many Numbers of Elements Do u Wnat to Insert? : ");
        int elements = userInput.nextInt();
        System.out.println("TOtal SIze = " + elements);
        String str[] = new String[elements]; // Total number of words/elements to be taken as input in the string array
        System.out.println("Entre Numbers To Sort: ");
        int arry[] = new int[elements];
        for (int element = ZERO; element < elements; element++) {
            str[element] = userInput.next();
            arry[element] = Integer.parseInt(str[element]);
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arry); //Instantiation of InsertionFInal class to use the reference to
                                  // call the sort Method
        printArray(arry);
    }
}
