package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
/**
 * HashMap<Employee, Date[]> --> (Key) employee's start and end (Value) date of a job
 *
 * JobExpenses --> calculates the budget that's available from the company to pay for a job
 *                 To calculate it we need the MonthIncomeEmp from Employee class and the months
 *                 the employee works on it
 * NewWorker --> to update/add info to HashMap jobEmp
 * toString --> to visualize the jobName property of this class
 **/
public class Job implements Serializable {
    private String jobName;
    private String description;
    private double income; //mixed incomings
    private double outcome; //devices we own (pagia)
    private double funcOut; //Operational Outcomes
    private HashMap<Employee, Date[]> jobEmp;

    public Job(String jobName, String description, double income, double outcome, double funcOut, HashMap<Employee, Date[]> jobEmp) {
        this.jobName = jobName;
        this.description = description;
        this.income = income;
        this.outcome = outcome;
        this.funcOut = funcOut;
        this.jobEmp = jobEmp;
    }

    public Job(String jobName, String description,double income,double outcome,double funcOut) {
        this.jobName = jobName;
        this.description = description;
        this.income=income;
        this.outcome=outcome;
        this.funcOut=funcOut;
        jobEmp= new HashMap<Employee,Date[]>();
    }

    // to check for every Employee e if it matches the keySet of jobEmp object
    public boolean isEmployed(Employee employee){
        for( Employee e: jobEmp.keySet()){
            if(employee==e)
                return true;
        }
           return false;
    }

    //to take only the month
    public SimpleDateFormat getFormatter() {
        return formatter;
    }
    SimpleDateFormat formatter = new SimpleDateFormat("MM");

    public int JobExpenses() {
        int budget=0;
        for( Employee e: jobEmp.keySet()){
            Date [] temp = jobEmp.get(e);
            int date1 = Integer.parseInt(formatter.format(temp[0]));
            int date2 = Integer.parseInt(formatter.format(temp[1]));
            int monthsBetween = date2-date1;
            budget+=e.MonthIncomeEmp()+monthsBetween*100;
        }
        return budget;
    }

    //Calculation of Pure income
    public double PureIncome(){ return  income-outcome-funcOut-JobExpenses(); }

    public void NewWorker(Employee emp ,Date[] dates){
        jobEmp.put(emp,dates);
    }

    public String getJobName() { return jobName; }
    public String getDescription() { return description; }
    public HashMap<Employee, Date[]> getJobEmp() { return jobEmp; }

    @Override
    public String toString() {
        return jobName;
    }
}
