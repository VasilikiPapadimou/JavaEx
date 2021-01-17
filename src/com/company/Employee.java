package com.company;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
/**
 * MonthIncomeEmp --> Calculates the monthly amount of money an employee takes
 *                    according to the degrees, number of children, the years he/she worked in
 *                    the company and if he/she is Master or not
 * toString --> to visualize the fullName property of this class
 **/

public class Employee implements Serializable {
    private String[] degrees = new String[]{"defterobathmia","panepistimiaki","metaptixiako","didaktoriko"};
    private String fullName;
    private Date birthDate;
    private Boolean isMarried;
    private int noChild;
    private int yearHire;
    private String domain; //specialty
    private String degree;


    public Employee(String fullName, Date birthDate, boolean isMarried,int noChild, int yearHire, String domain, String degree){
        this.fullName= fullName;
        this.birthDate= birthDate;
        this.isMarried= isMarried;
        this.noChild= noChild;
        this.yearHire= yearHire;
        this.domain= domain;
        this.degree= degree;
    }

    public Employee(Employee employee){
        fullName=employee.fullName;
        birthDate=employee.birthDate;
        isMarried=employee.isMarried;
        noChild=employee.noChild;
        yearHire=employee.yearHire;
        domain=employee.domain;
        degree=employee.degree;
    }

    //Calculates the monthly amount of money an employee takes
    public int MonthIncomeEmp(){
        int price=750;
        if(noChild<=3)
            price+=60*noChild;
        for(int i =0; i<degrees.length; i++)
            if(degree.equals(degrees[i]))
                price+=80*i;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int threeyears= Integer.parseInt(formatter.format(date))/yearHire;
        price+=threeyears*40;
        if(this instanceof Master){ price+=400; }
        for(Job j :  Main.jobs){                // for each Job j that exists also in Main class Arraylist <Job>
            for(Employee emp : j.getJobEmp().keySet()){     //for every emp in HashMap getJobEmp()
                if(emp.equals(this)){           //the class employee equals emp from the HashMap
                    price+=100;
                }
            }
        }
        return price;
    }

    public String[] getDegrees() { return degrees;}
    public String getFullName() { return fullName;}
    public Date getBirthDate() { return birthDate;}
    public Boolean getMarried() {return isMarried;}
    public int getNoChild() { return noChild;}
    public int getYearHire() { return yearHire;}
    public String getDomain() { return domain;}
    public String getDegree() { return degree;}

    @Override
    public String toString() {return  fullName ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return noChild == employee.noChild && yearHire == employee.yearHire && Arrays.equals(degrees, employee.degrees) && Objects.equals(fullName, employee.fullName) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(isMarried, employee.isMarried) && Objects.equals(domain, employee.domain) && Objects.equals(degree, employee.degree);
    }

}



