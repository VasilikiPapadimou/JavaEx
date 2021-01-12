package com.company;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Every Department HAS Employees and Master Employees, and HAS Jobs
 * Every Employee that is Master is assigned ONLY in 1 Department
 * Every Department can have more than 1 Jobs
 *
 * Constructor Department --> includes ALL types of Employees (Master) and Job
 * Arraylist<Employee> getEmployees --> returns the employees from the Arraylist
 * PaymentExpences() --> counts the amount of money payed FOR EACH Employee employee that is in the ArrayList
 *                       and adds the exact amount accounted for the Masters
 * MaxPureIncome --> counts the job that gives the Max incoming money to the company
 * setMaster --> Sets a master from Master class as the Department master
 * toString --> to visualise the outcome of this class
 **/
public class Department implements Serializable {

    private Master master;
    private ArrayList<Employee> employees;
    private ArrayList<Job> job; // anathesi ypaliloy poy anhkei se tmhma ths etereias se sygekrimeno ergo
    private String depName;
    private String description;

    public Department(Master master, String depName, String description) {
        this.master = master;
        this.employees = employees;
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

    public int PaymentExpences() {
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

    public void setEmployees(Employee e){
        employees.add(e);
    } // add-> used for lists

    public void SetJob(Job j)
    {
        this.job.add(j);
    }


    public Master getMaster() {
        return master;
    }

    public ArrayList<Employee> getEmployees() { return employees; }

    public ArrayList<Job> getJob() {
        return job;
    }

    public String getDepName() {
        return depName;
    }

    public String getDescription() {
        return description;
    }

    //To move an Employee to another Department
    public void ChangeDepartment(Department destinationdepart, Employee employee)  { }

    @Override
    public String toString() {
        return depName;
    }
}
