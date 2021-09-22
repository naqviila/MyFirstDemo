/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaviewhotels;


public class MeetingRoom{
    String roomType;
    int ratePerHour;
    String description;
    
    MeetingRoom(){
        this.roomType="";
        this.ratePerHour=0;
        this.description="";
    }
    
    MeetingRoom(String type, int rate, String desc){
        this.ratePerHour=rate;
        this.roomType=type;
        this.description=desc;
    }
    
}
