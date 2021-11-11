package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BinarySearchFromFile {

    public static void main(String[] args) throws Exception {
        List<String> fileArray = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/User/eclipse-workspace/wordlist.txt"));
        String saveLine;
        while ((saveLine = bufferedReader.readLine()) != null) {
            fileArray.add(saveLine);
        }
        bufferedReader.close();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Key: ");
        String inputString = scanner.nextLine();
        // Check if your word exists or not.
        BinarySearchFromFile binarySerchFromFile = new BinarySearchFromFile();
        Arrays.sort(fileArray.toArray());
        System.out.println(fileArray);
        int index = binarySerchFromFile.binarySearchString(fileArray, inputString);
        if (index == -1) {
            System.out.println(" word Not found in file:" + inputString);
        } else {
            System.out.println(" word found in file:" + inputString);
        }
    }

    public int binarySearchString(List<String> array, String key) {
        int start = 0;
        int end = array.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (key.compareTo((String) array.toArray()[mid]) < 0) {
                end = mid;
            } else if (key.compareTo((String) array.toArray()[mid]) > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
