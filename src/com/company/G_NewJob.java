package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class G_NewJob extends JPanel {
    public G_NewJob() {
        super(new GridLayout(6, 2));
        JLabel label1 = new JLabel("Όνομα Έργου: ");
        JLabel label2 = new JLabel("Περιγραφή Έργου: ");
        JLabel label3 = new JLabel("Μεικτά Έσοδα: ");
        JLabel label4 = new JLabel("Έξοδα για Υλικοτεχνική Υποδομή: ");
        JLabel label5 = new JLabel("Λοιπά Έξοδα: ");
        JTextField jobName = new JTextField();
        JTextField jobDescription = new JTextField();
        JTextField mixedInc = new JTextField();
        JTextField materialExpense = new JTextField();
        JTextField otherExpenses = new JTextField();

        JButton save = new JButton("Αποθήκευση");

        this.add(label1);
        this.add(jobName);
        this.add(label2);
        this.add(jobDescription);
        this.add(label3);
        this.add(mixedInc);
        this.add(label4);
        this.add(materialExpense);
        this.add(label5);
        this.add(otherExpenses);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Job job = new Job(jobName.getText(),jobDescription.getText(),Double.parseDouble(mixedInc.getText()),
                        Double.parseDouble(materialExpense.getText()),Double.parseDouble(otherExpenses.getText()));
                Main.jobs.add(job);
            }});

    }

}
