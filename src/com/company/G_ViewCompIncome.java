package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class G_ViewCompIncome extends JPanel {
    public G_ViewCompIncome() {
        super();
        String [] columnnames ={"Όνομα Έργων","Όνομα Τμήματος", "Έσοδα"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[3]; //creation of 3 columns
        for(Department d : Main.departments)
        {
            rowData[1] = d.getDepName();
            for(Job j : d.getJob()){
                rowData[0] = j.getJobName();
                rowData[2] = j.PureIncome();
                model.addRow(rowData);
            }
        }
        JTable table = new JTable(model);
        table.setBounds(100,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);

    }
}
