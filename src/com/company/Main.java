package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");


        Employee emp1 =new Employee("LAKIS", format.parse("11/5/1997"),false, 1, 2019, "Software Engineering", "didaktoriko" );
        Employee emp2 =new Employee("VICKY", format.parse("10/15/1996"),false, 0, 2018, "Telecoms Engineering", "didaktoriko" );
        Employee emp3 =new Employee("Maria", format.parse("09/5/1981"),true, 3, 2020, "Software Engineering", "panepistimiaki" );
        Master emp4 =new Master("Sotiris", format.parse("07/30/1986"),true, 2, 2010, "Telecoms Engineering", "defterobathmia" ,format.parse("07/30/2006"));
        Master emp5 =new Master("Xara", format.parse("05/19/1997"),false, 1, 2019, "Software Engineering", "metaptixiako",format.parse("07/30/2019") );
        Master emp6 =new Master("Mitsos", format.parse("05/19/1997"),false, 1, 2019, "Software Engineering", "metaptixiako",format.parse("07/30/2019") );


        ArrayList<Employee> arr1= new ArrayList();
        ArrayList<Employee> arr2= new ArrayList();
        ArrayList<Employee> arr3= new ArrayList();

        arr1.add(emp1);
        arr2.add(emp2);
        arr3.add(emp3);

        ArrayList<Job> jobarr1= new ArrayList();
        ArrayList<Job> jobarr2= new ArrayList();
        ArrayList<Job> jobarr3= new ArrayList();



        Department dep1 =new Department(emp4,arr1,jobarr1,"Telecomms","Telecomms Department");
        Department dep2 =new Department(emp5,arr2,jobarr2,"Software","Software Department");
        Department dep3 =new Department(emp6,arr3,jobarr3,"Marketing","Marketing Department");



//String jobName, String description, double income, double outcome, double funcOut, HashMap<Employee, Date[]> jobEmp
        ArrayList<Employee> temp1 = dep1.getEmployees();
        HashMap<Employee, Date[]> h1 = new HashMap();
        h1.put(emp1,new Date[]{format.parse("4/10/2020"),format.parse("11/10/2021")});

        ArrayList<Employee> temp2 = dep2.getEmployees();
        HashMap<Employee, Date[]> h2 = new HashMap();
        h2.put(emp1,new Date[]{format.parse("22/07/2020"),format.parse("22/09/2020")});

        ArrayList<Employee> temp3 = dep3.getEmployees();
        HashMap<Employee, Date[]> h3 = new HashMap();
        h3.put(emp1,new Date[]{format.parse("22/05/2020"),format.parse("22/07/2020")});

        Job job1 =new Job("Job1","Job Tel", 10000,400,200,h1);
        Job job2 =new Job("Job2","Job Tel", 10000,400,200,h2);
        Job job3 =new Job("Job3","Job Tel", 10000,400,200,h3);

        //Phase1 Ready


        jobarr1.add(job1);
        jobarr2.add(job2);
        jobarr3.add(job3);

        System.out.println("*****Καταστήματα********");
        System.out.println(dep1.toString());
        System.out.println(dep2.toString());
        System.out.println(dep3.toString());

        System.out.println("******Εργαζόμενοι*******");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        System.out.println(emp4.toString());
        System.out.println(emp5.toString());
        System.out.println(emp6.toString());



        System.out.println("*****Επαγγέλματα******");
        System.out.println(job1.toString());
        System.out.println(job2.toString());
        System.out.println(job3.toString());


        System.out.println("******Μισθοί Υπαλλήλων****");
        System.out.println(emp1.MonthIncomeEmp());
        System.out.println(emp2.MonthIncomeEmp());
        System.out.println(emp3.MonthIncomeEmp());
        System.out.println(emp4.MonthIncomeEmp());
        System.out.println(emp5.MonthIncomeEmp());
        System.out.println(emp6.MonthIncomeEmp());


        System.out.println("******Department*******");
        System.out.println(dep1.PaymentExpences());
        System.out.println(dep1.MaxPureInc());

        System.out.println("*****Job*******");
        System.out.println(job1.JobExpenses());
        System.out.println(job1.PureIncome());



    }
}
