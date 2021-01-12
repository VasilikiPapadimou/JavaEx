package com.company;

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
 * MaxPureIncome --> counts the incoming money came from the job
 * budget and distributes it the the Employees accordingly
 * **/
public class Department {

    private Master master;
    private ArrayList<Employee> employees;
    private ArrayList<Job> job; // anathesi ypaliloy poy anhkei se tmhma ths etereias se sygekrimeno ergo
    private String depName;
    private String description;

    public Department(Master master, ArrayList<Employee> employees, ArrayList<Job> job, String depName, String description) {
        this.master = master;
        this.employees = employees;
        this.job = job;
        this.depName = depName;
        this.description = description;
    }
    public ArrayList<Employee> getEmployees() { return employees; }

    public int PaymentExpences() {
        int sum=0;
        for(Employee employee : employees){
            sum+=employee.MonthIncomeEmp();
        }
        sum+= master.MonthIncomeEmp();
        return sum;
    }   ///gia to trexon etos leei

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
    //To move an Employee to another Department
    public void ChangeDepartment(Department destinationdepart, Employee employee){

    }

    //to set a master for the Department
    public void setMaster(Master master){this.master=master;}

    @Override
    public String toString() {
        return "Department{" +
                "master=" + master +
                ", employees=" + employees +
                ", job=" + job +
                ", depName='" + depName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
