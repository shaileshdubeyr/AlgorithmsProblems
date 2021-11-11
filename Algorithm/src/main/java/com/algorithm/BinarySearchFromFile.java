package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BinarySearchFromFile {

    public static void main(String[] args) throws Exception {
        List<String> ArrayForFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("wordlist.txt"));
        String saveLine;
        while ((saveLine = bufferedReader.readLine()) != null) {
            ArrayForFile.add(saveLine);
        }
        bufferedReader.close();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Key: ");
        String searchForString = scanner.nextLine();
        // checking for word.
        BinarySearchFromFile binarySerchFromFile = new BinarySearchFromFile();
        Arrays.sort(ArrayForFile.toArray());
        System.out.println(ArrayForFile);
        int index = binarySerchFromFile.binarySearchString(ArrayForFile, searchForString);
        if (index == -1) {
            System.out.println(" word Not found in file:" + searchForString);
        } else {
            System.out.println(" word found in file:" + searchForString);
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
