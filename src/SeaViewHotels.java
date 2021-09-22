/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaviewhotels;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author admin
 */
public class SeaViewHotels {
    private static ArrayList<Organization> organizationList=new ArrayList<>();
    public static void main(String[] args) throws IOException, ParseException {
    
    int choice=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("\n============================================");
    System.out.println("       WELCOME TO SEA VIEW HOTELS");
    System.out.println("============================================");
    do{
        System.out.println("\nWhat do you want to do:");
        System.out.println("1. Create a new Organisational Client");
        System.out.println("2. Create a new Meeting Booking for a Hotel Guest."); 
        System.out.println("0. Exit.");
        System.out.println("Enter selection: ");
     choice=sc.nextInt();
     if ((choice > -1) && (choice <= 2))
                {
                    if (choice == 0)
                    {
                        ExitProgram();
                        
                    }
                    else{
                        Proceed(choice);
                    }
                    
                }
     else
                {
                    System.out.println("Incorrect option. Please try again.");
                }
     }
     while(choice!=0);
    }
    public static void ExitProgram(){
       System.out.println("Exiting the program");
                         
    }
    
     public static void Proceed(int choice) throws IOException, ParseException{
     switch(choice){
                case 1:
                    CreateOrganizationalClient();
                    break;
                case 2:
                    CreateMeetingBooking();
                    break;
              }
    }
     
     public static void CreateOrganizationalClient(){
        String orgName, contactPerson, contactNumber;
        boolean proceed=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the name of the organization: ");
        orgName=sc.nextLine();
        System.out.println("Please enter the name of the contact person");
        contactPerson=sc.nextLine();
        do{
        System.out.println("Please enter the contact number of "+orgName+": ");
        contactNumber=sc.nextLine();
        proceed=validateContact(contactNumber);
        if(!proceed){
            System.out.println("Invalid phone number. Please try again.");
        }
        }while(proceed==false);
        
        Organization org=new Organization(orgName, contactPerson, contactNumber);
        organizationList.add(org);
        System.out.println("Client "+orgName+" added successfully");
     }
     
     public static void CreateMeetingBooking(){
         
     }
     
     public static boolean validateContact(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
         // Returning bollean value
        return (m.matches());
    }
}
