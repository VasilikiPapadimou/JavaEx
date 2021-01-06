package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class G_NewJob extends JPanel {
    public G_NewJob() {
        super(new GridLayout(3, 2));
        JLabel label1 = new JLabel("Όνομα Έργου: ");
        JLabel label2 = new JLabel("Περιγραφή Έργου: ");
        JTextField jobName = new JTextField();
        JTextField jobDescription = new JTextField();

        JButton save = new JButton("Αποθήκευση");

        this.add(label1);
        this.add(jobName);
        this.add(label2);
        this.add(jobDescription);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Job job = new Job(jobName.getText(),jobDescription.getText());
                Main.jobs.add(job);
            }});

    }

}
