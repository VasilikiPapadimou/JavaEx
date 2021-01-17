package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Similarly coding method with G_ViewJobsNDeps and G_ViewJobNEmps
 * */
public class G_ViewEmpNDeps extends JPanel {
    public G_ViewEmpNDeps() {
        super(new GridLayout(5,2));
        JLabel department = new JLabel("Τμήμα");
        JComboBox<Department> depa = new JComboBox<Department>(Main.departments.toArray(new Department[0]));
        JLabel job = new JLabel("Εργαζόμενοι");
        JTextArea textJob =new JTextArea();
        textJob.setEditable(false);

        JButton view = new JButton("Εμφάνιση");
        job.setVisible(true);
        this.add(department);
        this.add(depa);
        this.add(job);
        this.add(textJob);
        this.add(view);

        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Department d = (Department) depa.getSelectedItem();
                textJob.setText("");
                //For each employee of the department (Arraylist<Employee> getEmployees())
                for (Employee em : d.getEmployees()){
                    //Passes the result at the end of the document as String
                    textJob.append(em.toString());
                    textJob.append("\n");
                }
            }});
    }
}
