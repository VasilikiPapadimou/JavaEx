package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

public class Job {
    private String jobName;
    private String description;
    private double income; //mikta esoda
    private double outcome; //pagia
    private double funcOut; //leitoyrgika exoda
    private HashMap<Employee, Date[]> jobEmp; // gia hme/nia enarxis, lixis ergou

    public Job(String jobName, String description, double income, double outcome, double funcOut, HashMap<Employee, Date[]> jobEmp) {
        this.jobName = jobName;
        this.description = description;
        this.income = income;
        this.outcome = outcome;
        this.funcOut = funcOut;
        this.jobEmp = jobEmp;
    }

    public boolean isEmployed(Employee employee){
        for( Employee e: jobEmp.keySet()){
            if(employee==e)
                return true;
        }
           return false;
    }

    public Job(String jobName, String description) {
        this.jobName = jobName;
        this.description = description;
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

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public HashMap<Employee, Date[]> getJobEmp() {
        return jobEmp;
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

    @Override
    public String toString() {
        return jobName;
    }
}
