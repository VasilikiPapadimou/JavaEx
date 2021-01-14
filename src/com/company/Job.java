package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
/**
 * I need a HashMap to pass the Employees and the Dates to correlate them with Jobs
 * HashMap<Employee, Date[]> --> (Key) employees' start and end (Value) date of a job
 * The 2nd constructor is used to get only the jobName and the description. Every job HAS employees,
 * that's why i need also the HashMap jobEmp in this Constructor
 *
 * isEmployed --> to check for every Employee e if it matches the keySet of jobEmp object ==> Employed
 * JobExpenses --> calculates the budget that's available from the company to pay for a job
 *                 To calculate it we need the MonthIncomeEmp from Employee class and the months
 *                 the employee works on it
 * PureIncome--> Calculation of Pure income according to the instructions
 * NewWorker --> to update/add info to HashMap jobEmp
 * I created the needed accessors set/get
 * toString --> to visualise the outcome of this class
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

    public Job(String jobName, String description) {
        this.jobName = jobName;
        this.description = description;
        jobEmp= new HashMap<Employee,Date[]>();
    }

    public boolean isEmployed(Employee employee){
        for( Employee e: jobEmp.keySet()){
            if(employee==e)
                return true;
        }
           return false;
    }

    //in order to take only the month
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

    public double PureIncome(){ return  income-outcome-funcOut-JobExpenses(); }

    public void NewWorker(Employee emp ,Date[] dates){
        jobEmp.put(emp,dates);
    }


    public String getJobName() {
        return jobName;
    }
    public String getDescription() {
        return description;
    }
    public double getIncome() {
        return income;
    }
    public double getOutcome() {
        return outcome;
    }
    public double getFuncOut() {
        return funcOut;
    }

    public HashMap<Employee, Date[]> getJobEmp() { return jobEmp; }

    @Override
    public String toString() {
        return jobName;
    }
}
