package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * I use an array String to store the degrees and then I parse them as String degree
 * The first Constructor is general ,
 * The second Constructor creates an Employee employee that also is a Master
 *
 * MonthIncomeEmp --> Calculates the monthly amount of money an employee takes
 *                    according to the degrees, number of children, the years he/she worked in
 *                    the company and if he/she is Master or not
 * I created the set accessors that were asked
 * toString --> to visualise the fullName property of this class
 **/
public class Employee implements Serializable {
    private String[] degrees = new String[]{"defterobathmia","panepistimiaki","metaptixiako","didaktoriko"};
    private String fullName;
    private Date birthDate;
    private Boolean isMarried;
    private int noChild;
    private int yearHire;
    private String domain; //eidikotita
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
        return price;
    }

    public String[] getDegrees() {
        return degrees;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public int getNoChild() {
        return noChild;
    }

    public int getYearHire() {
        return yearHire;
    }

    public String getDomain() {
        return domain;
    }

    public String getDegree() {
        return degree;
    }

    public void setMarried(Boolean married) { isMarried = married; }

    public void setNoChild(int noChild) { this.noChild = noChild; }

    public void setDomain(String domain) { this.domain = domain; }

    public void setDegree(String degree) { this.degree = degree; }

    @Override
    public String toString() {
        return  fullName ;
    }
}
