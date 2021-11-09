package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class AddContact extends PersonDetail {
    Scanner scanData = new Scanner(System.in);
    public void addContactDetails() {
        System.out.println("enter the First Name");
        setFirstName(scanData.nextLine());
        System.out.println("enter the Last Name");
        setLastName(scanData.nextLine());
        System.out.println("enter the Address Name");
        setAddress(scanData.nextLine());
        System.out.println("enter the State Name");
        setState(scanData.nextLine());
        System.out.println("enter the Phone Number");
        setPhoneNumber(scanData.nextLine());
        System.out.println("enter the city name");
        setCity(scanData.nextLine());
        System.out.println("enter the Zip/postal Code");
        setZipCode(scanData.nextLine());
        System.out.println("enter the Email");
        setE_mail(scanData.nextLine());
    }

    public void editDetails(ArrayList<AddContact> contatctDetails) {
        String name = scanData.nextLine();
        System.out.println(contatctDetails.size());
        for (int i = 0; i < contatctDetails.size(); i++) {
            if (contatctDetails.get(i).getFirstName().equals(name)) {
                System.out.printf("enter the number to update contact details" +
                        "1  First Name" +
                        "2  Last Name " +
                        "3  phone number " +
                        "4  pincode " +
                        "5  address " +
                        "6  email " +
                        "7  state " +
                        "8  Search person Across AddressBook by City ans State name" );
                int updateChoice = scanData.nextInt();
                scanData.nextLine();

                switch (updateChoice) {
                    case 1:
                        System.out.println("enter the name to update");
                        String fName = scanData.nextLine();
                        System.out.println("acb");
                        contatctDetails.get(i).setFirstName(fName);
                        break;
                    case 2:
                        System.out.println("enter the Last name to update");
                        String lName = scanData.nextLine();
                        contatctDetails.get(i).setLastName(lName);
                        break;
                    case 3:
                        System.out.println("enter the Phone Number to Update");
                        String phNumber = scanData.nextLine();
                        contatctDetails.get(i).setPhoneNumber(phNumber);
                        break;
                    case 4:
                        System.out.println("enter the Pincode/Postalcode to Update");
                        String pinC = scanData.nextLine();
                        contatctDetails.get(i).setZipCode(pinC);
                        break;
                    case 5:
                        System.out.println("enter the Address to Update");
                        String address = scanData.nextLine();
                        contatctDetails.get(i).setAddress(address);
                        break;
                    case 6:
                        System.out.println("enter the Email to Update");
                        String email = scanData.nextLine();
                        contatctDetails.get(i).setE_mail(email);
                        break;
                    case 7:
                        System.out.println("enter the State sate name to Update");
                        String state = scanData.nextLine();
                        contatctDetails.get(i).setState(state);
                        break;
                    case 8:
                        System.out.println("enter the city name to Update");
                        String city = scanData.nextLine();
                        contatctDetails.get(i).setState(city);
                        break;
                    default:
                        System.out.println("you have not update any details");
                        break;
                }

            } else
                System.out.println("not match any details");
        }
    }

    public void deleteDetails(ArrayList<AddContact> contatctDetails) {
        System.out.println("enter the name");
        String name = scanData.nextLine();
        for(int i = 0; i < contatctDetails.size(); i++ ) {
            if (contatctDetails.get(i).getFirstName().equals(name)) {
                contatctDetails.remove(i);
            } else
                System.out.println("not match any details");
        }
    }

    public boolean checkForDuplicateEntry(ArrayList<AddContact> isDuplicateDetailEntered, AddContact newEntry) {
        System.out.println(isDuplicateDetailEntered);
        boolean duplicateOrNot = false;
        if(isDuplicateDetailEntered.size() > 1) {
            for (AddContact duplicateCopy : isDuplicateDetailEntered) {
                if (duplicateCopy.getFirstName().equalsIgnoreCase(newEntry.getFirstName()))
                    duplicateOrNot = true;
                else
                    duplicateOrNot = false;
            }
        }
        System.out.println(duplicateOrNot);
        return  duplicateOrNot;
    }

    public void searchAccrossAddressBook(Hashtable <Integer, ArrayList<AddContact>> dictionary) {
       int totalCount = 0;
        System.out.println("enter the nane of city or State");
        String stateOrCity = scanData.nextLine();
        for(int i = 1;i<=dictionary.size(); i++)
            System.out.println((dictionary.get(i).stream().filter(filterVariable -> filterVariable.getState()
                    .equalsIgnoreCase(stateOrCity) || filterVariable.getCity()
                    .equals(stateOrCity)).collect(Collectors.toList())));
        for(int i = 1; i<=dictionary.size(); i++){
            int count=0 ;
             count = (int) dictionary.get(i).stream().filter(filterVariable -> filterVariable.getState()
                    .equalsIgnoreCase(stateOrCity) || filterVariable.getCity()
                    .equals(stateOrCity)).count();
            totalCount = totalCount + count;
        }
        System.out.println("the total number of person in city of state is "+totalCount);
    }

    public void sortPersonDetails(Hashtable<Integer, ArrayList<AddContact>> hastableCopy) {
         for(int i = 1; i<=hastableCopy.size(); i++)
             System.out.println(hastableCopy.get(i).stream().sorted(Comparator.comparing(AddContact::getFirstName)).collect(Collectors.toList()));
    }

    public void sortWithCityAndState(Hashtable<Integer, ArrayList<AddContact>> hashtableCopy) {
        for(int i = 1; i<=hashtableCopy.size(); i++)
            System.out.println(hashtableCopy.get(i).stream().sorted(Comparator.comparing(AddContact::getCity).thenComparing(AddContact::getState)).collect(Collectors.toList()));
    }

    public void writeIntoFile(Hashtable<Integer, ArrayList<AddContact>> hashtableCopy) throws IOException, ClassNotFoundException {
            try {
                FileWriter fileWriter = new FileWriter("IOoperation.txt");
                String stream = String.valueOf(hashtableCopy);
                fileWriter.write(stream);
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void readFromFile() {
            try {
                FileReader fileReader = new FileReader("IOoperation.txt");
                int i;
                while ((i = fileReader.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

