package com.company;

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

    public boolean isEmployed(Employee employee){
        for( Employee e: jobEmp.keySet()){
            if(employee==e)
                return true;
        }
           return false;
    }
    public int JobExpenses() {
        int budget=0;
        for( Employee e: jobEmp.keySet()){
            Date [] temp = jobEmp.get(e);
            long monthsBetween = ChronoUnit.MONTHS.between(
                    LocalDate.parse((CharSequence) temp[0]).withDayOfMonth(1),
                    LocalDate.parse((CharSequence) temp[1]).withDayOfMonth(1));
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
