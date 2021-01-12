package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {


    public void WriteEmployees(ArrayList<Employee> emp) throws IOException {
        for(Employee employee : emp)
        {
            File employeefile = new File("Employees.txt");
            employeefile.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(employeefile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(employee);
            objectOut.close();
        }
    }

    public void WriteJobs(ArrayList<Job> jobs) throws IOException {
        for(Job job : jobs)
        {
            File jobfile = new File("Jobs.txt");
            jobfile.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(jobfile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(job);
            objectOut.close();
        }

    }

    public void WriteDepartements(ArrayList<Department> deps) throws IOException {
        for(Department dep : deps)
        {
            File depfile = new File("Departments.txt");
            depfile.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(depfile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(dep);
            objectOut.close();
        }
    }

    public ArrayList<Department> ReadDepartements() throws IOException {
        File depfile = new File("Departments.txt");
        FileInputStream fis=new FileInputStream(depfile);
        ArrayList<Department> deps= new ArrayList<Department>();
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(cont){
                Department dep=null;

                    dep = (Department) ois.readObject();

                if(dep != null)
                    deps.add(dep);
                else
                    cont = false;
            }
        } catch (FileNotFoundException e) {}
        finally {return deps;}


    }

    public ArrayList<Employee> ReadEmployees() throws IOException {
        File empfile = new File("Employees.txt");
        FileInputStream fisemp=new FileInputStream(empfile);
        ArrayList<Employee> employees= new ArrayList<Employee>();
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fisemp);
            while(cont){
                Employee emp=null;
                emp = (Employee) ois.readObject();

                if(emp != null)
                    employees.add(emp);
                else
                    cont = false;
            }
        } catch (FileNotFoundException e) {} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
          return employees;
        }

    }

    public ArrayList<Job> ReadJobs() throws IOException {
        File jobfile = new File("Jobs.txt");
        FileInputStream fisjob=new FileInputStream(jobfile);
        ArrayList<Job> jobs= new ArrayList<Job>();
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fisjob);
            while(cont){
                Job job=null;
                job = (Job) ois.readObject();

                if(job != null)
                    jobs.add(job);
                else
                    cont = false;
            }
        } catch (FileNotFoundException e) {} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return jobs;
        }

    }



}
