package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static ArrayList<Department> departments = new ArrayList<Department>();
    public static ArrayList<Job> jobs = new ArrayList<Job>();


    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Java Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add content to the window.
        frame.add(new Graphics(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
