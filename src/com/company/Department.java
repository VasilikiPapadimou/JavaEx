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
    public void MaxPureInc(){
        double max=0;
        int found=0;
        for(int i=0; i<job.size(); i++)
            if(job.get(i).PureIncome()>max){
            max=job.get(i).PureIncome();
            found=i;
        }
        System.out.println(job.get(found).toString());
    }

    public void ChangeDepartment(Department destinationdepart,Employee employee)  { }

    public void setMaster(Master master){this.master=master;}

}
