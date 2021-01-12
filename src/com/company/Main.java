package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static FileHandler fh = new FileHandler();
    public static ArrayList<Employee> employees ;
    public static ArrayList<Department> departments;
    public static ArrayList<Job> jobs ;


    public static void main(String[] args)   {

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
        LoadData();
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add content to the window.
        frame.add(new Graphics(), BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try{
                    fh.WriteDepartements(departments);
                    fh.WriteEmployees(employees);
                    fh.WriteJobs(jobs);
                }catch(Exception ex){ }

            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static void LoadData() {
        try {
            employees = fh.ReadEmployees();
            departments = fh.ReadDepartements();
            jobs = fh.ReadJobs();}
        catch(FileNotFoundException e){
                employees= new ArrayList<Employee>();
                departments= new ArrayList<Department>();
                jobs= new ArrayList<Job>();
            }
        catch (Exception e){}

    }


}
