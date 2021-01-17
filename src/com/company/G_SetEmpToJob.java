package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class G_SetEmpToJob extends JPanel {
    JFrame frame;
    JComboBox <Job> jobs=null;
    JComboBox <Employee> emp=null;
    public  G_SetEmpToJob() {
        super(new GridLayout(8, 2));
        JLabel department = new JLabel("Τμήματα");
        JComboBox<Department> dep = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JButton search = new JButton("Αναζήτηση έργων");
        JButton save = new JButton("Αποθήκευση");

        this.add(department);
        this.add(dep);
        this.add(search);

        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Department depart = (Department) dep.getSelectedItem();
                JLabel joblabel = new JLabel("Έργα");
                JLabel emplabel = new JLabel("Εργαζόμενοι");

                try{
                    jobs = new JComboBox<Job>(depart.getJob().toArray(new Job[0]));
                    emp = new JComboBox<Employee>(depart.getEmployees().toArray(new Employee[0]));
                }catch(Exception ex){
                    jobs= new JComboBox<Job>();
                    emp= new JComboBox<Employee>();
                }
                G_SetEmpToJob.this.removeAll();
                G_SetEmpToJob.this.add(department);
                G_SetEmpToJob.this.add(dep);
                G_SetEmpToJob.this.add(search);

                G_SetEmpToJob.this.add(joblabel);
                G_SetEmpToJob.this.add(jobs);
                G_SetEmpToJob.this.add(emplabel);
                G_SetEmpToJob.this.add(emp);
                G_SetEmpToJob.this.add(save);

                G_SetEmpToJob.this.revalidate();
                G_SetEmpToJob.this.repaint();

            }});

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(
                        frame,
                        "Συμπληρώστε ημερομηνία έναρξης και λήξης ανάθεσης με μορφή yyyy/MM/dd yyyy/MM/dd",
                        "");
                Employee emp2 = (Employee) emp.getSelectedItem();
                String[] strDates = s.split(" ");
                Date[] dates = new Date[2];
                try {
                    dates[0] = new SimpleDateFormat("yyyy/MM/dd").parse(strDates[0]);
                    dates[1] = new SimpleDateFormat("yyyy/MM/dd").parse(strDates[1]);
                    Job j =(Job) jobs.getSelectedItem();
                    j.NewWorker(emp2,dates);

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }


            }});
    }
}
