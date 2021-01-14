package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        for (Employee em : Main.employees){  //**********************ginete mhpws me kalytero tropo?
            rowData[0]= em.getFullName();
            //Info from Department class
            for(Department d : Main.departments ){
                try{
                    //rowData[0]= d.getEmployees(); ***********************
                    rowData[1]= d.getDepName();
                    rowData[2]= d.PaymentExpenses();
                }catch(Exception e){
                    rowData[2]="";
                }
        }
            model.addRow(rowData);
        }
        JTable table = new JTable(model);
        table.setBounds(100,60,200,300);
        JScrollPane sp=new JScrollPane(table);

        this.add(sp);


    }
}
