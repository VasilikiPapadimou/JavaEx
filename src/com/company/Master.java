package com.company;

import java.util.Date;
/**
 * Inherits all the Employee properties
 * I created a second Master Constructor to transfer
 * the position of Master to another Employee (2nd Constructor of class Employee)
 **/
public class Master extends Employee {
   private Date  startTime;

   public Master(String fullName, Date birthDate, boolean isMarried, int noChild, int yearHire, String domain, String degree, Date startTime) {
      super(fullName, birthDate, isMarried, noChild, yearHire, domain, degree);
      this.startTime=startTime;
   }
   /*Αυτό είναι το Employee του ArrayList στο Department? */
   public Master(Employee employee,Date startTime){
      super(employee);
      this.startTime=startTime;
   }
}
