package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class G_ViewJobs extends JPanel {
    public G_ViewJobs(){
        super();
        String [] columnnames ={"Όνομα Έργου","Περιγραφή Έργου", "Τμήμα που το φιλοξενεί"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[2];
        for(Job j : Main.jobs){
                rowData[0]= j.getJobName();
                rowData[1]= j.getDescription();
            model.addRow(rowData);
        }
        JTable table = new JTable(model);
        table.setBounds(100,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);
    }
}