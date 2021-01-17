package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Every Department HAS Employees and Master Employees, and HAS Jobs
 * Every Employee that is Master is assigned ONLY in 1 Department
 * Every Department can have more than 1 Jobs
 *
 * ArrayList<Employee> ReturnAllEmployees()--> Returns all employees Arraylist typed
 * PaymentExpences() --> counts the amount of money payed FOR EACH Employee employee that is in the ArrayList
 *                       and adds the exact amount accounted for the Masters
 * toString --> to visualize the outcome of this class
 **/
public class Department implements Serializable {
    private Master master;
    private ArrayList<Employee> employees;
    private ArrayList<Job> job;
    private String depName;
    private String description;

    public Department(Master master, String depName, String description) {
        this.master = master;
        this.depName = depName;
        this.description = description;
        job = new ArrayList<Job>();
        employees = new ArrayList<Employee>();
    }

    public Department(String depName, String description) {
        this.depName = depName;
        this.description = description;
        this.job = new ArrayList<Job>();
        employees = new ArrayList<Employee>();
    }

    //Returns all employees Arraylist typed
    public ArrayList<Employee> ReturnAllEmployees(){
        ArrayList<Employee> allEmployee = this.employees;
        if(master!=null){
            allEmployee.add(master);
        }
        return allEmployee;
    }

    public int PaymentExpenses() {
        int sum=0;
        for(Employee employee : employees){
            sum+=employee.MonthIncomeEmp();
        }
        sum+= master.MonthIncomeEmp();
        return sum;
    }

    public Job MaxPureInc(){
        double max=0;
        int found=0;
        for(int i=0; i<job.size(); i++)
            if(job.get(i).PureIncome()>max){
            max=job.get(i).PureIncome();
            found=i;
        }
       return job.get(found);
    }

    public void setMaster(Master master){this.master=master;}
    public void setEmployees(Employee e){ employees.add(e); } // add-> used for lists
    public void SetJob(Job j) { this.job.add(j); }
    public Master getMaster() { return master; }

    //To pass all employees to the end of an Arraylist (done via a HashSet)
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> temp =this.employees;
        HashSet hs = new HashSet();
        hs.addAll(temp);
        temp.clear();
        temp.addAll(hs);
        return temp;
    }

    public ArrayList<Job> getJob() { return job; }
    public String getDepName() {
        return depName;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return depName;
    }
}
