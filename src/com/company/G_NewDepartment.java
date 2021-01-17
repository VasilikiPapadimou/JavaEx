package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  To add a department I only need the name (deptName) and a description--> (2nd Department.class Constructor)
 *  So I create the panel with the boxes and labels.
 *
 *  Button "save" --> info is added to Main.Arraylist<Department> departments.
 *  This way it's easier for as to pass the info to a file later.
 **/
public class G_NewDepartment extends JPanel {
    public G_NewDepartment() {
        super(new GridLayout(3, 2));
        JLabel label1 = new JLabel("Όνομα Τμήματος: ");
        JLabel label2 = new JLabel("Περιγραφή: ");
        JButton save = new JButton("Αποθήκευση");

        JTextField deptName = new JTextField();
        JTextField deptDescription = new JTextField();

        this.add(label1);
        this.add(deptName);
        this.add(label2);
        this.add(deptDescription);
        this.add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Department department = null;
                    department = new Department(deptName.getText(),deptDescription.getText());
                Main.departments.add(department);
            }});


    }
}
