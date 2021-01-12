package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class G_ViewJobsNDeps extends JPanel {
    public G_ViewJobsNDeps() {
        super(new GridLayout(5,2));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> depa = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JLabel job = new JLabel("Εργα");
        JTextArea textJob =new JTextArea();
        textJob.setEditable(false);

        JButton save = new JButton("Εμφάνιση");
        job.setVisible(true);
        this.add(department);
        this.add(depa);
        this.add(job);
        this.add(textJob);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Department d = (Department) depa.getSelectedItem();
                textJob.setText("");
                for (Job j : d.getJob()){
                    textJob.append(j.toString());
                    textJob.append("\n");
                }
            }});
    }

}