package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/** Creation of the main frame and the FileHandler manage "tools"*/
public class Main {

    public static FileHandler fh = new FileHandler();
    /*
    * Use of Arraylists to be able to copy info to the Files latter.
    * I take the info from Department class and pass it to an Arraylist departments etc
    * Don't forget --> Department class has ArrayList<Employee> employees; and ArrayList<Job> job;
    *                  Job class has HashMap<Employee, Date[]> jobEmp; to have access to Employees class
    * */
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
        JFrame frame = new JFrame("Java Exercise");
        LoadData(); // start the "FileHandler"
        frame.setPreferredSize(new Dimension(500, 400));
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

        frame.pack();
        frame.setVisible(true);
    }

    //Method to load data to FileHandler.java
    private static void LoadData() {
        try {
            employees = fh.ReadEmployees();
            departments = fh.ReadDepartements();
            jobs = fh.ReadJobs();}
        catch(FileNotFoundException e){     // if the file is empty
                employees= new ArrayList<Employee>();
                departments= new ArrayList<Department>();
                jobs= new ArrayList<Job>();
            }
        catch (Exception e){}

    }
}
