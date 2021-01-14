package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Similarly coding method with G_ViewEmpNDeps and G_ViewJobNEmps
 * */
public class G_ViewJobsNDeps extends JPanel {
    public G_ViewJobsNDeps() {
        super(new GridLayout(5,2));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> depa = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JLabel job = new JLabel("Εργα");
        JTextArea textJob =new JTextArea();
        textJob.setEditable(false);

        JButton view = new JButton("Εμφάνιση");
        job.setVisible(true);
        this.add(department);
        this.add(depa);
        this.add(job);
        this.add(textJob);
        this.add(view);


        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Department d = (Department) depa.getSelectedItem();
                textJob.setText("");
                //For each job of the department (Arraylist<Job> getJob())
                for (Job j : d.getJob()){
                    //Pass the result at the end of the file as String
                    textJob.append(j.toString());
                    textJob.append("\n");
                }
            }});
    }

}
