package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class G_NewEmployee extends JPanel {
    public G_NewEmployee() {
        super(new GridLayout(8, 2));
        JLabel label1 = new JLabel("Ονοματεπώνυμο: ");
        JLabel label2 = new JLabel("Ημερομηνία γέννησης: (yyyy-mm-dd)");
        JLabel label3 = new JLabel("Οικογενείακή κατάσταση : ");
        JLabel label4 = new JLabel("Αριθμός τέκνων : ");
        JLabel label5 = new JLabel("Χρονολογία πρόσληψης : ");
        JLabel label6 = new JLabel("Ειδικότητα : ");
        JLabel label7 = new JLabel("Σπουδές : ");

        JTextField fullname = new JTextField();
        JTextField birthDate = new JTextField();
        JCheckBox isMarried = new JCheckBox("Έγγαμος");
        JTextField childnum = new JTextField();
        JTextField yearHired =  new JTextField();
        JTextField specialized = new JTextField();
        String[] choices = { "δευτεροβάθμια εκπαίδευση", "πανεπιστημιακή εκπαίδευση", "μεταπτυχιακό δίπλωμα", "διδακτορικό δίπλωμα"};
        JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        JButton save = new JButton("Αποθήκευση");


        this.add(label1);
        this.add(fullname);
        this.add(label2);
        this.add(birthDate);
        this.add(label3);
        this.add(isMarried);
        this.add(label4);
        this.add(childnum);
        this.add(label5);
        this.add(yearHired);
        this.add(label6);
        this.add(specialized);
        this.add(label7);
        this.add(cb);
        this.add(save);


    }
}
