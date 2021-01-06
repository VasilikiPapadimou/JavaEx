package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class G_ViewDepartment extends JPanel {
    public G_ViewDepartment() {
        super();
        String [] columnnames ={"Όνομα τμήματος","Περιγραφή Τμήματος", "Ονομα Διευθυντή"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[3];
        for(Department d : Main.departments){
            try{
                rowData[0]= d.getDepName();
                rowData[1]= d.getDescription();
                rowData[2]= d.getMaster().getFullName();

            }catch(Exception e){
                rowData[2]="";
            }
            model.addRow(rowData);
        }
        JTable table = new JTable(model);
        table.setBounds(100,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);


    }
}
