package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Job {
    private String jobName;
    private String description;
    private double income; //mixed incomings
    private double outcome; //devices we own (pagia)
    private double funcOut; //Operational Outcomes
    private HashMap<Employee, Date[]> jobEmp; // Hashmap to store employees' start and end date of a job

    public Job(String jobName, String description, double income, double outcome, double funcOut, HashMap<Employee, Date[]> jobEmp) {
        this.jobName = jobName;
        this.description = description;
        this.income = income;
        this.outcome = outcome;
        this.funcOut = funcOut;
        this.jobEmp = jobEmp;
    }

    //To check if the Employees passed on the HashMap are employed or not
    public boolean isEmployed(Employee employee){
        for( Employee e: jobEmp.keySet()){
            if(employee==e)
                return true;
        }
           return false;
    }

    public HashMap<Employee, Date[]> getJobEmp() {
        return jobEmp;
    }//returns the Hashmap

    //in order to take only the month
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

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", description='" + description + '\'' +
                ", income=" + income +
                ", outcome=" + outcome +
                ", funcOut=" + funcOut +
                ", jobEmp=" + jobEmp +
                '}';
    }
}
