package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Job job1 =new Job();
        Job job2 =new Job();
        Job job3= new Job();
        Employee emp1 =new Employee("LAKIS", format.parse("11/5/1997"),false, 1, 2019, "Software Engineering", "master" );
        Employee emp2 =new Employee("VICKY", format.parse("10/15/1996"),false, 0, 2018, "Telecoms Engineering", "master" );
        Employee emp3 =new Employee("Maria", format.parse("09/5/1981"),true, 3, 2020, "Software Engineering", "employee" );
        Master emp4 =new Master("Sotiris", format.parse("07/30/1986"),true, 2, 2010, "Telecoms Engineering", "employee" ,format.parse("07/30/2006"));
        Master emp5 =new Master("Xara", format.parse("05/19/1997"),false, 1, 2019, "Software Engineering", "employee",format.parse("07/30/2019") );
        Master emp6 =new Master("Mitsos", format.parse("05/19/1997"),false, 1, 2019, "Software Engineering", "employee",format.parse("07/30/2019") );

        ArrayList<Employee> arr1= new ArrayList();
        ArrayList<Employee> arr2= new ArrayList();
        ArrayList<Employee> arr3= new ArrayList();

        arr1.add(emp1);
        arr2.add(emp2);
        arr3.add(emp3);

        ArrayList<Job> jobarr1= new ArrayList();
        ArrayList<Job> jobarr2= new ArrayList();
        ArrayList<Job> jobarr3= new ArrayList();

        jobarr1.add(job1);
        jobarr2.add(job2);
        jobarr3.add(job3);

        Department dep1 =new Department(emp4,arr1,jobarr1,"Telecomms","Telecomms Department");
        Department dep2 =new Department(emp5,arr2,jobarr2,"Software","Software Department");
        Department dep3 =new Department(emp6,arr3,jobarr3,"Marketing","Marketing Department");

    }
}
