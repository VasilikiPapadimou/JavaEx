package com.company;

import java.util.ArrayList;

public class Department {

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

    public Master getMaster() {
        return master;
    }

    public ArrayList<Job> getJob() {
        return job;
    }

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
    public void SetJob(Job j)
    {
        this.job.add(j);
    }

    public void ChangeDepartment(Department destinationdepart, Employee employee)  { }

    public void setMaster(Master master){this.master=master;}

    public void setEmployees(Employee e){
        employees.add(e);
    }

    public ArrayList<Employee> getEmployees() { return employees; }
}
