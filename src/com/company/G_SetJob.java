package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class G_SetJob extends JPanel {
    public  G_SetJob() {
        super(new GridLayout(3, 2));

        JLabel job = new JLabel("Έργα");
        JComboBox<Job> job1 = new JComboBox<Job>(Main.jobs.toArray(new Job[0]));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> dep = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JButton save = new JButton("Ενημέρωση");
        job1.setVisible(true);
        this.add(job);
        this.add(job1);
        this.add(department);
        this.add(dep);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Job j = (Job) job1.getSelectedItem();
                Department depart = (Department) dep.getSelectedItem();
                depart.SetJob(j);

            }});
    }
}
