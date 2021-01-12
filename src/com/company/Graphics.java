package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Graphics extends JPanel {

    public Graphics(){
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();


        JComponent panel1 = AddNew();
        tabbedPane.addTab("Προσθήκη", null, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = EditData();
        tabbedPane.addTab("Επεξεργασία Δεδομέων", null, panel2, "Does nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 =ViewItems();
        tabbedPane.addTab("Εμφάνιση στοιχείων", null, panel3, "Does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = new JPanel();
        tabbedPane.addTab("Οικονομικά στοιχεία", null, panel4, "Does nothing");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    }


    protected JComponent EditData(){
        JPanel panel = new JPanel(new GridLayout(5,1));
        JLabel label = new JLabel("Επεξεργασία:");
        JButton setMaster = new JButton("Ανάθεση Διευθυντή σε τμήμα");
        JButton setJob = new JButton("Ανάθεση έργου σε τμήμα");
        JButton setEmployee = new JButton("Ανάθεση εργασζομένου σε τμήματα");
        JButton setEmployeetoJob = new JButton ("Ανάθεση εργαζομένου σε έργο");

        setMaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetMasterViewPage();
            }

        } );

        setJob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetJobViewPage();
            }

        } );

        setEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEmployeeViewPage();
            }
        });

        setEmployeetoJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEmployeetoJobViewPage();
            }
        });

        panel.add(label);
        panel.add(setMaster);
        panel.add(setJob);
        panel.add(setEmployee);
        panel.add(setEmployeetoJob);
        return panel;
    }




    protected JComponent ViewItems(){
        JPanel panel = new JPanel(new GridLayout(7,1));
        JLabel label = new JLabel("Επιλέξτε τα στοιχεία που θέλετε να εμφανίσετε:");
        JButton employeeView = new JButton("Υπαλλήλοι");
        JButton departmentView = new JButton("Τμήματα");
        JButton jobView = new JButton("Έργα");
        JButton empNdepView = new JButton("Εργαζόμενοι και τμήματα");
        JButton jobNdepView = new JButton("Έργα και τμήματα");
        JButton jobWorkersView = new JButton("Έργα και εργαζόμενοι");


        employeeView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeViewPress();
            }

        } );
        departmentView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departmentViewPress();
            }
        } );
        jobView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jobViewPress();
            }
        } );
        empNdepView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empNdepViewPress();
            }
        } );
        jobNdepView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jobNdepViewPress();
            }
        } );
        jobWorkersView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jobWorkersViewPress();
            }
        } );

        panel.add(label);
        panel.add(employeeView);
        panel.add(departmentView);
        panel.add(jobView);
        panel.add(empNdepView);
        panel.add(jobNdepView);
        panel.add(jobWorkersView);
        return panel;


    }



    protected JComponent AddNew() {
        JPanel panel = new JPanel(new GridLayout(4,1));
        JLabel label = new JLabel("Επιλέξτε την λειτουργεία που θέλετε να εκτελέσετε:");
        JButton employeeButton = new JButton("Προσθήκη Υπαλλήλου");
        JButton departmentButton = new JButton("Προσθήκη Τμήματος");
        JButton jobButton = new JButton("Προσθήκη Έργου");

        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeButtonPress();
            }
        } );
        departmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departmentButtonPress();
            }
        } );
        jobButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jobButtonPress();
            }
        } );

        panel.add(label);
        panel.add(employeeButton);
        panel.add(departmentButton);
        panel.add(jobButton);
        return panel;
    }

    public void employeeViewPress(){
        JFrame  employeeFrame= new JFrame("Στοιχεία εργασζομένων");
        employeeFrame.setSize(500,200);

        employeeFrame.add(new G_ViewEmployees(), BorderLayout.CENTER);
        employeeFrame.pack();
        employeeFrame.setVisible(true);
    }
    public void departmentViewPress(){
        JFrame  departmentFrame= new JFrame("Στοιχεία τμήματος");
        departmentFrame.setPreferredSize(new Dimension(400,200));
        departmentFrame.add(new G_ViewDepartment(), BorderLayout.CENTER);
        departmentFrame.pack();
        departmentFrame.setVisible(true);
    }
    public void jobViewPress(){
        JFrame  jobFrame= new JFrame("Στοιχεία εργασζομένων");
        jobFrame.setPreferredSize(new Dimension(400,200));
        jobFrame.add(new G_ViewJobs(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);
    }
    public void empNdepViewPress(){
        JFrame  jobFrame= new JFrame("Εργαζόμενοι και τμήματα");
        jobFrame.setPreferredSize(new Dimension(400,200));
        jobFrame.add(new G_ViewEmpNDeps(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);
    }
    public void jobNdepViewPress(){
        JFrame  jobNdepFrame= new JFrame("Στοιχεία Έργων και τμημάτων");
        jobNdepFrame.setPreferredSize(new Dimension(400,200));
        jobNdepFrame.add(new G_ViewJobsNDeps(), BorderLayout.CENTER);
        jobNdepFrame.pack();
        jobNdepFrame.setVisible(true);
    }

    private void jobWorkersViewPress() {
        JFrame  jobNdepFrame= new JFrame("Στοιχεία έργων και εργαζομένων");
        jobNdepFrame.setPreferredSize(new Dimension(400,200));
        jobNdepFrame.add(new G_jobWorkersView(), BorderLayout.CENTER);
        jobNdepFrame.pack();
        jobNdepFrame.setVisible(true);
    }


    public void setEmployeeViewPage(){
        JFrame empolyeeframe = new JFrame("Ανάθεση εργαζομένου σε τμήμα");
        empolyeeframe.setPreferredSize(new Dimension(400,200));
        empolyeeframe.add(new G_SetEmployee(), BorderLayout.CENTER);
        empolyeeframe.pack();
        empolyeeframe.setVisible(true);
    }

    public void employeeButtonPress(){
        JFrame employeeFrame = new JFrame("New Employee");
        employeeFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        employeeFrame.add(new G_NewEmployee(), BorderLayout.CENTER);

        //Display the window.
        employeeFrame.pack();
        employeeFrame.setVisible(true);
    }



    public void departmentButtonPress(){
        JFrame departmentFrame = new JFrame("New Department");
        departmentFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        departmentFrame.add(new G_NewDepartment(), BorderLayout.CENTER);

        //Display the window.
        departmentFrame.pack();
        departmentFrame.setVisible(true);
    }
    private void SetMasterViewPage() {
        JFrame jobFrame = new JFrame("Επιλογή διευθυντή");
        jobFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        jobFrame.add(new G_SetMaster(), BorderLayout.CENTER);

        //Display the window.
        jobFrame.pack();
        jobFrame.setVisible(true);
    }

    private void setEmployeetoJobViewPage() {
        JFrame jobFrame = new JFrame("Ανάθεση εργαζομένου σε έργο");
        jobFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        jobFrame.add(new G_SetEmpToJob(), BorderLayout.CENTER);

        //Display the window.
        jobFrame.pack();
        jobFrame.setVisible(true);
    }

    private void SetJobViewPage() {
        JFrame jobFrame = new JFrame("Επιλογή διευθυντή");
        jobFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        jobFrame.add(new G_SetJob(), BorderLayout.CENTER);

        //Display the window.
        jobFrame.pack();
        jobFrame.setVisible(true);
    }

    public void jobButtonPress(){
        JFrame jobFrame = new JFrame("New Job");
        jobFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        jobFrame.add(new G_NewJob(), BorderLayout.CENTER);

        //Display the window.
        jobFrame.pack();
        jobFrame.setVisible(true);
    }

}
