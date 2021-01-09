package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class G_SetEmployee extends JPanel {
    public  G_SetEmployee() {
        super(new GridLayout(3, 2));

        JLabel job = new JLabel("Εργαζόμενοι");
        JComboBox<Employee> employee1 = new JComboBox<Employee>(Main.employees.toArray(new Employee[0]));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> dep = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JButton save = new JButton("Ενημέρωση");
        employee1.setVisible(true);
        this.add(job);
        this.add(employee1);
        this.add(department);
        this.add(dep);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Employee emp = (Employee) employee1.getSelectedItem();
                Department depart = (Department) dep.getSelectedItem();
                depart.setEmployees(emp);

            }});
    }
}
