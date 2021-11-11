package com.algorithm;

import java.util.*;

public class PrimeNumber {
    public static final int ONE = 1,TWO = 2, ZERO = 0;
    public PrimeNumber(int number) {
        int checkOne;
        int checkTwo;


        List<String> primeList = new ArrayList<>(), anagramList = new ArrayList<>();

        for (checkOne = TWO; checkOne < number; checkOne++) {
            for (checkTwo = TWO; checkTwo < checkOne; checkTwo++)
            {
                if (checkOne % checkTwo == ZERO)
                    break;
            }
            if (checkTwo == checkOne)
            {
                System.out.println(checkOne);

                primeList.add(Integer.toString(checkOne));
            }
        }
        System.out.println();
        System.out.println("Prime Numbers List: " + primeList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Range: ");
        int number = scanner.nextInt();
        PrimeNumber primeNumber = new PrimeNumber(number);

    }
}
