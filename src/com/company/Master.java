package com.company;

import java.util.Date;

public class Master extends Employee {
   private Date  startTime;

   public Master(String fullName, Date birthDate, boolean isMarried, int noChild, int yearHire, String domain, String degree, Date startTime) {
      super(fullName, birthDate, isMarried, noChild, yearHire, domain, degree);
      this.startTime=startTime;
   }
   public Master(Employee employee,Date startTime){
      super(employee);
      this.startTime=startTime;
   }

}
