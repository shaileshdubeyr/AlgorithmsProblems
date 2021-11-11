package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramDetection {
    public static void main(String[] args) {
        String string1, string2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the string 1");
        string1 = scanner.next();
        System.out.println("enter the string 2");
        string2 = scanner.next();
        AnagramDetection anagramDetection = new AnagramDetection();
        boolean isAnagram = anagramDetection.isAnagram(string1, string2);
        if (isAnagram) {
            System.out.println("Two String are anagram");
        } else {
            System.out.println("Two String are not anagram");
        }
    }

    public boolean isAnagram(String string1, String string2) {
        char[] arry1 = string1.toCharArray();
        char[] arry2 = string2.toCharArray();
        if (string1.length() != string2.length()) {
            return false;
        } else {
            Arrays.sort(arry1);
            Arrays.sort(arry2);
            if (Arrays.equals(arry1, arry2)) {
                return true;
            }
        }
        return false;
    }
}
