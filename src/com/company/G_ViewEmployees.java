package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * Similarly coding method with G_ViewEmployees and G_ViewPaymentInfo
 * There is a need to fill a table with rows and columns with info
 **/
public class G_ViewEmployees extends JPanel {
    public G_ViewEmployees() {
        super();
        String [] columnnames ={"Ονομ/Επων","Ημ/Γέννησης","Οικογενιακή Κατ.","Αρ.Τεκνων","Έτος Προσληψης","Ειδικότητα","Πτυχίο"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[7];
        //Info from Employee class
        for(Employee e : Main.employees){
            rowData[0]= e.getFullName();
            rowData[1]= e.getBirthDate();
            rowData[2]= e.getMarried();
            rowData[3]= e.getNoChild();
            rowData[4]= e.getYearHire();
            rowData[5]= e.getDomain();
            rowData[6]= e.getDegree();
            model.addRow(rowData);
            }
        JTable table = new JTable(model);
        table.setBounds(120,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);
    }

}

