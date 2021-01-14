package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class G_SetEmployee extends JPanel {
    public  G_SetEmployee() {
        super(new GridLayout(3, 2));

        JLabel employee = new JLabel("Έργαζόμενοι");
        JComboBox<Employee> emp = new JComboBox<Employee>(Main.employees.toArray(new Employee[0]));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> dep = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JButton save = new JButton("Ενημέρωση");
        emp.setVisible(true);
        this.add(employee);
        this.add(emp);
        this.add(department);
        this.add(dep);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Employee empl = (Employee) emp.getSelectedItem();
                Department depart = (Department) dep.getSelectedItem();
                depart.setEmployees(empl);


            }});
    }
}
