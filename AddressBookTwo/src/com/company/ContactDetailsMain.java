package com.company;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;

public class ContactDetailsMain {
     static Hashtable<Integer, ArrayList<AddContact>> hashTable = new Hashtable<Integer, ArrayList<AddContact>>();

    private static char inputCharater() {
        Scanner scanCharater = new Scanner(System.in);
        char charaterInput = scanCharater.next().charAt(0);
        return charaterInput;
    }

    private static int inputInteger() {
        Scanner scanCharater = new Scanner(System.in);
        int integerInput = scanCharater.nextInt();
        return integerInput;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AddContact addPersonDetails;
        final int ONE = 1;
        System.out.println("enter the address book limit");
        int addressBookLimit = inputInteger();
        for (int i = ONE; i <= addressBookLimit; i++) {
            ArrayList<AddContact> addDetailsToArryList = new <AddContact>ArrayList();
            while (true) {
                addPersonDetails = new AddContact();
                System.out.printf("Input the Charater A to add Details " +
                                  "E to Edit details D to delete details\n" +
                                  "Any charater to end the details Entry :- ");
                char charater = inputCharater();
                if (charater == 'A' || charater == 'E' || charater == 'D' || charater == 'a' || charater == 'e'
                        || charater == 'd') {
                    switch (charater) {
                        case 'A':
                            addPersonDetails.addContactDetails();
                            boolean isDubliCateEntry = addPersonDetails.checkForDuplicateEntry(addDetailsToArryList, addPersonDetails);
                            if(isDubliCateEntry == false){
                                addDetailsToArryList.add(addPersonDetails);
                            }
                            else
                                System.out.println("dublicate entry found skipped Entry");
                            break;
                        case 'E':
                            System.out.println("Enter the name to edit");
                            addPersonDetails.editDetails(addDetailsToArryList);
                            break;
                        case 'D':
                            addPersonDetails.deleteDetails(addDetailsToArryList);
                            break;
                        case 'S':
                            System.out.println("enter the state or city name to search ");

                        default:
                            System.out.println("you have not perform any operation ");
                            break;
                    }

                } else {
                    System.out.println("Details are uptodate");
                    break;
                }

            }
            hashTable.put(i, addDetailsToArryList);
            addPersonDetails.writeIntoFile(hashTable);
            if(hashTable.size() == addressBookLimit ){
                System.out.println("Do you wnat to search the persons who belong to this state or city y :- yes N :- no " );
                char searchAcrossAddressbook = inputCharater();
                   if(searchAcrossAddressbook == 'y' || searchAcrossAddressbook == 'Y')
                        addPersonDetails.searchAccrossAddressBook(hashTable);
                   else
                       System.out.println("you doesnot want to serch name of person across address book who belong to particular city ");
            }
            addPersonDetails.sortPersonDetails(hashTable);
            addPersonDetails.sortWithCityAndState(hashTable);
            System.out.println("Reading from file");
            addPersonDetails.readFromFile();
        }
        for(int i = ONE; i <= hashTable.size(); i++) {
            System.out.println("Address book "+i);
            System.out.println(hashTable.get(i));
        }

    }
}
