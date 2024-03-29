package com.company;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Employee {
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
    //Creates Master Employee because every Master Is-AN Employee
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
            if(degree.equals(degrees[i])) //To check if they match and give the amount of money needed
                price+=80*i;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date date = new Date();
        //to convert Date date to Integer we use wrappers
        int threeyears= Integer.parseInt(formatter.format(date))/yearHire;
        price+=threeyears*40;
        //if employee is type of Master
        if(this instanceof Master){ price+=400; }
        return price;
    }

    public void setMarried(Boolean married) { isMarried = married; }

    public void setNoChild(int noChild) { this.noChild = noChild; }

    public void setDomain(String domain) { this.domain = domain; }

    public void setDegree(String degree) { this.degree = degree; }

    @Override
    public String toString() {
        return "Employee{" +
                "degrees=" + Arrays.toString(degrees) +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", isMarried=" + isMarried +
                ", noChild=" + noChild +
                ", yearHire=" + yearHire +
                ", domain='" + domain + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
