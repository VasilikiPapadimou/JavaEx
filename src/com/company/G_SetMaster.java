package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * I use this class to describe the behaviour of the panel "Ανάθεση Διευθυντή σε Έργο"
 * I don't forget that I have 3 Arraylists in Main class. Here I'll need only employees and department.
 * This way I will have
 * all the employees converted to an array. Finally I can pass them to an Object
 * of JPanel -> JComboBox
 * I use a 'save' button to save all the info of
 * */
public class G_SetMaster extends JPanel {

    public  G_SetMaster(){
        super( new GridLayout(3,2));

        JLabel employee = new JLabel("Διευθυντής");
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
