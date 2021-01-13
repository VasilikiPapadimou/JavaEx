package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * This is the main class for the whole graphics environment
 * Generally I want the Main Panel to have some tabs (JTabbedPane) and there
 * I will put the graphics needed with the actions need to be performed mentioned
 *
 * AddNew --> to create the graphics in "Προσθήκη" tabbedPane
 * EditData --> to create the graphics in "Επεξεργασία Δεδομέων" tabbedPane
 * ViewItems --> to create the graphics in "Εμφάνιση στοιχείων" tabbedPane
 * FinancialData  --> to create the graphics in "Οικονομικά στοιχεία" tabbedPane
 *
 * Then I created all the methods that are used from ActionListeners (buttons) to perform an Action
 *
 * */
public class Graphics extends JPanel {

    public Graphics(){
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent panel1 = AddNew();
        tabbedPane.addTab("Προσθήκη", null, panel1, "Adds Info");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = EditData();
        tabbedPane.addTab("Επεξεργασία Δεδομέων", null, panel2, "Edits info");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 =ViewItems();
        tabbedPane.addTab("Εμφάνιση στοιχείων", null, panel3, "Shows Info");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = FinancialData();
        tabbedPane.addTab("Οικονομικά στοιχεία", null, panel4, "Shows financial info");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //Add the tabbed pane to this panel.
        add(tabbedPane);
    }

    protected JComponent AddNew() {
        JPanel panel = new JPanel(new GridLayout(4,1));
        JLabel label = new JLabel("Επιλέξτε την λειτουργεία που θέλετε να εκτελέσετε:");
        JButton employeeButton = new JButton("Προσθήκη Υπαλλήλου");
        JButton departmentButton = new JButton("Προσθήκη Τμήματος");
        JButton jobButton = new JButton("Προσθήκη Έργου");

        /**------------ActionListeners for the Buttons in "Προσθήκη" tabbedPane-------------**/
        employeeButton.addActionListener(new ActionListener() { //adds a new employee
            public void actionPerformed(ActionEvent e) { employeeButtonPress(); }
        } );
        departmentButton.addActionListener(new ActionListener() {//adds a new department
            public void actionPerformed(ActionEvent e) { departmentButtonPress(); }
        } );
        jobButton.addActionListener(new ActionListener() {//adds a new job
            public void actionPerformed(ActionEvent e) { jobButtonPress(); }
        } );

        panel.add(label);
        panel.add(employeeButton);
        panel.add(departmentButton);
        panel.add(jobButton);
        return panel;
    }

    protected JComponent EditData(){
        JPanel panel = new JPanel(new GridLayout(5,1));
        JLabel label = new JLabel("Επεξεργασία:");
        JButton setMaster = new JButton("Ανάθεση Διευθυντή σε τμήμα");
        JButton setJob = new JButton("Ανάθεση έργου σε τμήμα");
        JButton setEmployee = new JButton("Ανάθεση εργαζομένου σε τμήματα");
        JButton setEmployeetoJob = new JButton ("Ανάθεση εργαζομένου σε έργο");

        /**------------ActionListeners for the Buttons in "Επεξεργασία Δεδομένων" tabbedPane-------------**/
        setMaster.addActionListener(new ActionListener() {//Sets a new Master
            public void actionPerformed(ActionEvent e) { SetMasterViewPage(); }
        } );
        setJob.addActionListener(new ActionListener() {//Sets a new job
            public void actionPerformed(ActionEvent e) { SetJobViewPage(); }
        } );
        setEmployee.addActionListener(new ActionListener() { //sets Employees to departments
            @Override
            public void actionPerformed(ActionEvent e) { setEmployeeViewPage(); }
        });
        setEmployeetoJob.addActionListener(new ActionListener() { //sets Employees to jobs
            @Override
            public void actionPerformed(ActionEvent e) { setEmployeetoJobViewPage(); }
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

        /**------------ActionListeners for the Buttons in "Επεξεργασία Δεδομένων" tabbedPane-------------**/
        employeeView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { employeeViewPress(); }
        } );
        departmentView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { departmentViewPress(); }
        } );
        jobView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { jobViewPress(); }
        } );
        empNdepView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { empNdepViewPress(); }
        } );
        jobNdepView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { jobNdepViewPress(); }
        } );
        jobWorkersView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { jobWorkersViewPress(); }
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

    protected JComponent FinancialData(){
        JPanel panel = new JPanel(new GridLayout(7,1));
        JLabel label = new JLabel("Επιλέξτε τα στοιχεία που θέλετε να εμφανίσετε:");
        JButton paymentInfo= new JButton("Στοιχεία Μισθοδοσίας");
        JButton companyIncome = new JButton("Έσοδα Ετερείας");

        /**------------ActionListeners for the Buttons in " Οικονομικά στοιχεία" tabbedPane-------------**/
        paymentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { paymentInfoView(); }
        } );
        companyIncome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { companyIncomeView(); }
        } );

        panel.add(label);
        panel.add(paymentInfo);
        panel.add(companyIncome);

        return panel;
    }


    /**------------ Code for Actions Performed in the "Προσθήκη" panel------------**/

    public void employeeButtonPress(){
        JFrame employeeFrame = new JFrame("Νέος Εργαζόμενος");
        employeeFrame.setPreferredSize(new Dimension(400, 200));

        //Add content to the window.
        employeeFrame.add(new G_NewEmployee(), BorderLayout.CENTER);

        //Display the window.
        employeeFrame.pack();
        employeeFrame.setVisible(true);
    }
    public void departmentButtonPress(){
        JFrame departmentFrame = new JFrame("Νεο Τμήμα");
        departmentFrame.setPreferredSize(new Dimension(300, 200));

        departmentFrame.add(new G_NewDepartment(), BorderLayout.CENTER);
        departmentFrame.pack();
        departmentFrame.setVisible(true);
    }
    public void jobButtonPress(){
        JFrame jobFrame = new JFrame("Νέο έργο");
        jobFrame.setPreferredSize(new Dimension(400, 200));

        jobFrame.add(new G_NewJob(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);
    }

    /**------------Code for Actions Performed in the "Επεξεργασία στοιχείων" panel------------**/

    private void SetMasterViewPage() {
        JFrame masterFrame = new JFrame("Ανάθεση διευθυντή σε τμήμα");
        masterFrame.setPreferredSize(new Dimension(300, 200));

        masterFrame.add(new G_SetMaster(), BorderLayout.CENTER);
        masterFrame.pack();
        masterFrame.setVisible(true);
    }
    private void SetJobViewPage() {
        JFrame jobFrame = new JFrame("Ανάθεση έργου σε τμήμα");
        jobFrame.setPreferredSize(new Dimension(300, 200));

        jobFrame.add(new G_SetJob(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);
    }
    public void setEmployeeViewPage(){
        JFrame employeeFrame = new JFrame("Ανάθεση εργαζομένου σε τμήμα");
        employeeFrame.setPreferredSize(new Dimension(300,200));
        employeeFrame.add(new G_SetEmployee(), BorderLayout.CENTER);
        employeeFrame.pack();
        employeeFrame.setVisible(true);
    }
    private void setEmployeetoJobViewPage() {
        JFrame employeeJobFrame = new JFrame("Ανάθεση εργαζομένου σε έργο");
        employeeJobFrame.setPreferredSize(new Dimension(300, 200));

        employeeJobFrame.add(new G_SetEmpToJob(), BorderLayout.CENTER);
        employeeJobFrame.pack();
        employeeJobFrame.setVisible(true);
    }


    /**------------Code for Actions Performed in the "Εμφάνιση Δεδομέων" panel------------**/

    public void employeeViewPress(){
        JFrame  employeeFrame= new JFrame("Επεξεργασία στοιχείων εργαζομένων");
        employeeFrame.setSize(700,200);

        employeeFrame.add(new G_ViewEmployees(), BorderLayout.CENTER);
        employeeFrame.pack();
        employeeFrame.setVisible(true);
    }
    public void departmentViewPress(){
        JFrame  departmentFrame= new JFrame("Επεξεργασία στοιχείων τμήματος");
        departmentFrame.setPreferredSize(new Dimension(500,200));
        departmentFrame.add(new G_ViewDepartment(), BorderLayout.CENTER);
        departmentFrame.pack();
        departmentFrame.setVisible(true);
    }
    public void jobViewPress(){
        JFrame  jobFrame= new JFrame("Επεξεργασία στοιχείων έργων");
        jobFrame.setPreferredSize(new Dimension(500,200));
        jobFrame.add(new G_ViewJobs(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);

    }
    public void empNdepViewPress(){
        JFrame  jobFrame= new JFrame("Επεξεργασία στοιχείων εργαζομένων και τμημάτων");
        jobFrame.setPreferredSize(new Dimension(450,300));
        jobFrame.add(new G_ViewEmpNDeps(), BorderLayout.CENTER);
        jobFrame.pack();
        jobFrame.setVisible(true);
    }
    public void jobNdepViewPress(){
        JFrame  jobNdepFrame= new JFrame("Επεξεργασία στοιχείων έργων και τμημάτων");
        jobNdepFrame.setPreferredSize(new Dimension(450,300));
        jobNdepFrame.add(new G_ViewJobsNDeps(), BorderLayout.CENTER);
        jobNdepFrame.pack();
        jobNdepFrame.setVisible(true);
    }
    private void jobWorkersViewPress() {
        JFrame  jobNdepFrame= new JFrame("Εμφάνιση στοιχείων έργων και εργαζομένων");
        jobNdepFrame.setPreferredSize(new Dimension(450,300));
        jobNdepFrame.add(new G_jobWorkersView(), BorderLayout.CENTER);
        jobNdepFrame.pack();
        jobNdepFrame.setVisible(true);
    }


    /**------------Code for Actions Performed in the "Οικονομικά Δεδομένα" panel------------**/

    private void paymentInfoView() {
        JFrame  paymentInfoFrame= new JFrame("Επεξεργασία στοιχείων εργαζομένων");
        paymentInfoFrame.setSize(700,200);

        paymentInfoFrame.add(new G_ViewPaymentInfo(), BorderLayout.CENTER);
        paymentInfoFrame.pack();
        paymentInfoFrame.setVisible(true);
    }
    private void companyIncomeView() {
        JFrame  companyIncomeFrame= new JFrame("Επεξεργασία στοιχείων εργαζομένων");
        companyIncomeFrame.setSize(700,200);

        companyIncomeFrame.add(new G_ViewCompIncome(), BorderLayout.CENTER);
        companyIncomeFrame.pack();
        companyIncomeFrame.setVisible(true);
    }

}
