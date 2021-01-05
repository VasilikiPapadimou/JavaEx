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

        JComponent panel2 = new JPanel();
        tabbedPane.addTab("Επεξεργασία Δεδομέων", null, panel2, "Does nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 =new JPanel();
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
