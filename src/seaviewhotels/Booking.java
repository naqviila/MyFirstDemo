/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaviewhotels;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Booking {
    String organization;
    String typeOfBooking;
    int day;
    String time;
    int duration;
    MeetingRoom room;
    int snacksChoice;
    char mealChoice;
    int people;
    int totalCost;
    
    Booking(String organization,
    String typeOfBooking,
    int day,
    String time,
    int duration,
    MeetingRoom room,
    int snacksChoice,
    char mealChoice,
    int people,
    int totalCost){
        this.day=day;
        this.duration=duration;
        this.mealChoice=mealChoice;
        this.organization=organization;
        this.people=people;
        this.room=room;
        this.snacksChoice=snacksChoice;
        this.time=time;
        this.typeOfBooking=typeOfBooking;
        this.totalCost=totalCost;
        
    }
    
    public int getDay(){
        return this.day;
    }
    
    @Override
    public String toString() {
     String s1="",s2="",s3="";
     s1=(organization+" - $"+totalCost+"\nfor a "+typeOfBooking+" event ("+people+"pax) at "+time);
     if(mealChoice=='y'||mealChoice=='Y'){
        s2="\n with 1 meal";
     }
     if(snacksChoice>0){
        s3=" with "+snacksChoice+" serving of coffee/tea & cakes";
     }
    return String.format(s1+s2+s3);
    }
}
