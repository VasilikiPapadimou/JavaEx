package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class G_SetMaster extends JPanel {

    public  G_SetMaster(){
        super( new GridLayout(3,2));


        JLabel employee = new JLabel("Εργαζόμενοι");
        JComboBox<Employee> cb = new JComboBox<Employee>(Main.employees.toArray(new Employee[0]));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> cb2 = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JButton save = new JButton("Ενημέρωση");
        cb.setVisible(true);
        this.add(employee);
        this.add(cb);
        this.add(department);
        this.add(cb2);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Employee emp = (Employee) cb.getSelectedItem();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                Master m = new Master(emp,date);
                Department dep = (Department) cb2.getSelectedItem();
                dep.setMaster(m);

            }});


    }
}