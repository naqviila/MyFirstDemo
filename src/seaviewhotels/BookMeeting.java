/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaviewhotels;

import java.util.Scanner;
import static seaviewhotels.SeaViewHotels.organizationList;

/**
 *
 * @author admin
 */
public class BookMeeting extends SeaViewHotels {
   
    int bookingChoice=0, orgChoice=-1, bookingDate=0, bookingHour=0, duration=0, room=0;
    int snackChoice=0, people=0;
    char mealBooking='x';
    String type;
    Scanner sc;
    
    public void MeetingBooking(){
        
        sc=new Scanner(System.in);
         System.out.println("You have selected to create a new Booking for an Organisation.");
         do{
            System.out.println("Please select the type of booking:\n1. Meeting\n2. Dining Only");
            bookingChoice=sc.nextInt();
            if(bookingChoice==1||bookingChoice==2){}
            else{
                bookingChoice=0;
                System.out.println("Invalid choice. Try again.");
            }
         }while(bookingChoice==0);
         
         if(bookingChoice==1)
         { 
             type="Meeting";
         do{
             System.out.println("\nPlease select the organisation which is making this booking:");
            for(int i=0;i<organizationList.size();i++){
                System.out.println((i+1)+". "+organizationList.get(i).getOrgName());
            }
            orgChoice=sc.nextInt();
            if(orgChoice<1||orgChoice>organizationList.size()){
                orgChoice=-1;
                System.out.println("Invalid choice. Try again.");
            }
            else{
                orgChoice--;
            }
         }while(orgChoice==-1);
         
         do{
             System.out.println(" What date will "+ organizationList.get(orgChoice).getOrgName()+" book for its meeting (1‐30): ");
           bookingDate=sc.nextInt();
            if(bookingDate<1||bookingDate>30){
                bookingDate=0;
                System.out.println("Invalid date. Try again.");
            }
            
         }while(bookingDate==0);
         
         do{
             System.out.println("What hour of the day will "+ organizationList.get(orgChoice).getOrgName()+" begin its meeting (7‐20): ");
           bookingHour=sc.nextInt();
            if(bookingHour<7||bookingHour>20){
                bookingHour=0;
                System.out.println("Invalid time. Try again.");
            }
            
         }while(bookingHour==0);
         
         do{
             System.out.println("How many hours will the meeting last: ");
           duration=sc.nextInt();
            if(bookingHour+duration>22){
                duration=0;
                System.out.println("Sorry! Meetings can go no later than 10pm. Specify duration again.");
            }
            
         }while(duration==0);
         
         do{
             System.out.println("What type of room is required: ");
           
            for(int i=0;i<roomList.size();i++){
                System.out.println((i+1)+". "+roomList.get(i).getRoomType()+" ($"+roomList.get(i).getRates()+" per hour)");
            }
            room=sc.nextInt();
            if(room<1||room>roomList.size()){
                room=-1;
                System.out.println("Invalid choice. Try again.");
            }
            else{
                room--;
            }
            
         }while(room==-1);
         
         do{
            System.out.println("How many sessions of serving coffee/tea & cakes/fruit are required (0‐2): ");
            snackChoice=sc.nextInt();
            if(snackChoice<0||snackChoice>2){
                snackChoice=-1;
                System.out.println("Invalid choice. Try again.");
            }
         }while(snackChoice==-1);
         
         do{
            System.out.println("Is a meal booking required (y/n): ");
            mealBooking=sc.next().charAt(0);
            if(mealBooking=='y'||mealBooking=='Y'||mealBooking=='n'||mealBooking=='N'){}
            else{
                mealBooking='x';
                System.out.println("Invalid answer. Try again.");
            }
         }while(mealBooking=='x');
         
         do{
            System.out.println("How many people will need to be catered for: ");
            people=sc.nextInt();
            if(people<0){
                people=0;
                System.out.println("Invalid choice. Try again.");
            }
         }while(people==0);
         System.out.println("Thank you");
         DisplayBookingCost();
         }
         else{//PERSON 1 TASK
             System.out.println("PERSON 1 TASK");
         }
    }
    
    public void DisplayBookingCost(){
        int time, roomCost, snackCost=0, mealCost=0, totalCost;
        String am_pm;
        if(bookingHour>12){
            am_pm=":00 pm";
            time=bookingHour-12;
        }
        else{
            am_pm=":00 am";
            time=bookingHour;
        }
        roomCost=roomList.get(room).getRates()*duration;
        String str1, str2;
        System.out.println("A booking has been made for"+ organizationList.get(orgChoice).getOrgName()+" on day "+bookingDate+" of the month: ");
        str1="\tfor "+roomList.get(room).getRoomType()+" for "+duration+" hours from "+time+am_pm;
        str2="$"+roomCost;
        System.out.printf("%-15s %25s %n",str1,str2);
        if(snackChoice>0){
            snackCost=(people*12)*snackChoice;
            str1="\tWith "+snackChoice+" serving sessions of coffee/tea & cakes/fruit ("+people+" pax)";
            str2="$"+snackCost;
            System.out.printf("%-15s %15s %n",str1,str2);
        }
        if(mealBooking=='y'||mealBooking=='Y'){
            mealCost=people*23;
            str1="\tWith 1 meal ("+people+" pax)";
            str2="$"+mealCost;
            System.out.printf("%-15s %55s %n",str1,str2);
        }
        totalCost=roomCost+snackCost+mealCost;
        str1="\tTotal Cost:";
        str2="$"+totalCost;
        System.out.printf("%-15s %60s %n",str1,str2);
        String tt=time+am_pm;
        Booking booking=new Booking(organizationList.get(orgChoice).getOrgName(),type,bookingDate,tt,duration,roomList.get(room),snackChoice,mealBooking,people,totalCost);
        bookingList.add(booking);
    }
}
