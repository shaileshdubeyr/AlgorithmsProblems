package com.algorithm;

import java.util.Scanner;

public class Queue {
    LinkedList<T> queue = new LinkedList<T>();
    int index = 0;
    public int bankBalance = 500000;
    Scanner scanner = new Scanner(System.in);
    int counter = 1;

    public int size() {
        return index;
    }

    public void enQueue(int data) {
        queue.add(data);
        index++;
    }

    public void enQueueAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            enQueue(list.get(i));
        }
    }

    // method for dequeue the element

    public void deQueue() {
        index--;
        queue.deleteAt(index);
    }

    public void show() {
        queue.show();
    }
    public String showQueueWithoutSpace() {
        return queue.showListWithoutSpaces();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T get() {
        return queue.get(index);
    }

    public T get(int ind) {
        return queue.get(ind);
    }

    public void service() {

        System.out.println("Token number is : " + counter);

        int choice;
        int amount = 0;
        System.out.println("press 1: for withdraw\npress 2: for deposit");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter amount to withdraw");
                amount = scanner.nextInt();
                bankBalance = bankBalance - amount;
                System.out.println("Thank you for using service");
                amount = 0;
                break;
            case 2:
                System.out.println("Enter amount to deposit");
                amount = scanner.nextInt();
                bankBalance = bankBalance + amount;
                System.out.println("Thank you for using service");
                amount = 0;
                break;
            default:
                System.out.println("Enter valid option");
        }
        counter++;
    }

}
