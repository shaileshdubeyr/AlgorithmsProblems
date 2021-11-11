package com.algorithm;

import java.util.Scanner;

public class MergeSort {
    public static final int ONE = 1, TWO = 2, ZERO = 0;

    public static void main(String[] args) {
        String[] stringArray = {"one", "two", "four", "five", "six", "seven", "eight", "nine"};
        mergeSort(stringArray);
        for (String copyOfArry : stringArray) {
            System.out.println(copyOfArry);
        }
    }

    public static void mergeSort(String[] string) {
        if (string.length > ONE) {
            String[] leftString = new String[string.length / TWO];
            String[] rightString = new String[string.length - string.length / TWO];
            for (int i = ZERO; i < leftString.length; i++) {
                leftString[i] = string[i];
            }
            for (int arryElement = ZERO; arryElement < rightString.length; arryElement++) {
                rightString[arryElement] = string[arryElement + string.length / TWO];
            }
            mergeSort(leftString);
            mergeSort(rightString);
            merge(string, leftString, rightString);
        }
    }

    public static void merge(String[] stringArray, String[] leftString, String[] rightString) {
        int a = 0;
        int b = 0;
        for (int i = ZERO; i < stringArray.length; i++) {
            if (b >= rightString.length
                    || (a < leftString.length && leftString[a].compareToIgnoreCase(rightString[b]) < ZERO)) {
                stringArray[i] = leftString[a];
                a++;
            } else {
                stringArray[i] = rightString[b];
                b++;
            }
        }
    }
}
