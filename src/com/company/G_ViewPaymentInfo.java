package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * For the Payment Info I'll need to get info from Employees.class and Department.class (Name , department name )
 * I will also need the Department method -> PaymentExpenses.
 *
 * The appearance will be similar to the one in : "Εμφάνιση Στοιχείων" -> "Τμήματα"
 * */
public class G_ViewPaymentInfo extends JPanel {
    public G_ViewPaymentInfo() {
        super();
        String [] columnnames ={"Όνομα Εργαζομένου","Όνομα Τμήματος", "Μισθοδοσία"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[3]; //creation of 3 columns
        for (Employee em : Main.employees){  //**********************ginete mhpws me kalytero tropo?
            rowData[0]= em.getFullName();
            for(Department d : Main.departments ){
                try{
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
