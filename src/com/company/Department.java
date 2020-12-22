package com.company;

import java.util.ArrayList;

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

    public void ChangeDepartment(Department destinationdepart, Employee employee)  { }

    public void setMaster(Master master){this.master=master;}

    public ArrayList<Employee> getEmployees() { return employees; }
}
