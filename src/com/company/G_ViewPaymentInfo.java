package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Similarly coding method with G_ViewJobs, G_ViewEmployees and G_ViewJobs
 *
 * For the Payment Info I'll get info from Employees class and Department class (Name , department name )
 * I will also need the Department method -> PaymentExpenses.
 * */
public class G_ViewPaymentInfo extends JPanel {
    public G_ViewPaymentInfo() {
        super();
        String [] columnnames ={"Όνομα Εργαζομένου","Όνομα Τμήματος", "Μισθοδοσία"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[3]; //creation of 3 columns
        //Info from Employees class
        for (Department dep : Main.departments){
            ArrayList<Employee> temp =dep.ReturnAllEmployees();
            HashSet hs = new HashSet();
            hs.addAll(temp);
            temp.clear();
            temp.addAll(hs);
            for(Employee em:temp){
                rowData[0]= em.getFullName();
                rowData[1]= dep.getDepName();
                rowData[2] = em.MonthIncomeEmp();
                model.addRow(rowData);
            }



        }
        JTable table = new JTable(model);
        table.setBounds(100,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);


    }
}
