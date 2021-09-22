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
    
    protected static ArrayList<Organization> organizationList=new ArrayList<>();
    protected static ArrayList<Booking> bookingList=new ArrayList<>();
    protected static ArrayList<MeetingRoom> roomList=new ArrayList<>();
    public static void main(String[] args) throws IOException, ParseException {
    InitializeMeetingRooms();
    int choice=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("\n============================================");
    System.out.println("       WELCOME TO SEA VIEW HOTELS");
    System.out.println("============================================");
    do{
        System.out.println("\nWhat do you want to do:");
        System.out.println("1. Create a new Organisational Client");
        System.out.println("2. Create a new Meeting Booking for a Hotel Guest."); 
        System.out.println("3. Display bookings for specific day of month.");
        System.out.println("4. Display all bookings.");
        System.out.println("0. Exit.");
        System.out.println("Enter selection: ");
     choice=sc.nextInt();
     if ((choice > -1) && (choice <= 4))
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
                case 3:
                    DisplayBooking();
                    break;
                case 4:
                    DisplayAllBookings();
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
         if(organizationList.isEmpty()){
             System.out.println("No clients added. Please add a client first.");
         }
         else{
         BookMeeting book=new BookMeeting();
         book.MeetingBooking();
         }
     }
     
     public static void DisplayBooking(){
         if(bookingList.isEmpty()){
             System.out.println("No booking till now.");
         }
         else{
         int bookingDate=0;
         Scanner sc=new Scanner(System.in);
         do{
             System.out.println("Display the bookings for which day of the month (1‐30): ");
           bookingDate=sc.nextInt();
            if(bookingDate<1||bookingDate>30){
                bookingDate=0;
                System.out.println("Invalid date. Try again.");
            }
         }while(bookingDate==0);
         
         System.out.println("The following bookings are currently recorded: ");
         for(int i=0;i<bookingList.size();i++){
             if(bookingList.get(i).getDay()==bookingDate){
                System.out.println(bookingList.get(i).toString());
             }
         }
                 }
     }
     
     public static void DisplayAllBookings(){
         if(bookingList.isEmpty()){
             System.out.println("No booking till now.");
         }
         else{
         System.out.println("The following bookings are currently recorded: ");
         for(int i=0;i<bookingList.size();i++){
             System.out.println(bookingList.get(i).toString());
         }
        }
     }
     
     public static boolean validateContact(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
         // Returning bollean value
        return (m.matches());
    }
     
     public static void InitializeMeetingRooms(){
         
         MeetingRoom room;
         room=new MeetingRoom("Small Discussion Room", 80, "one big table with 12 chairs max");
         roomList.add(room);
         room=new MeetingRoom("Standard Meeting Room ", 250, "can fit up to 80 people");
         roomList.add(room);
         room=new MeetingRoom("Large Meeting Room", 370, "(can fit up to 200 people");
         roomList.add(room);
         
         
     }
}
