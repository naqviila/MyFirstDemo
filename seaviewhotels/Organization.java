/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaviewhotels;

public class Organization {
  private String OrgName;
  private String contactPerson;
  private String contactNumber;
  
  Organization(){
      this.OrgName="";
      this.contactNumber="";
      this.contactPerson="";
  }
  
  Organization(String orgName, String contactPerson, String contactNumber){
      this.OrgName=orgName;
      this.contactNumber=contactNumber;
      this.contactPerson=contactPerson;
  }
  
}
