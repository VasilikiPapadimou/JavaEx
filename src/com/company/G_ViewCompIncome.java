package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * Θα θέλω μια καρτέλα για να δείχνω τα έργα μια για το σε πιό Τμήμα ανήκουν και τα έσοδα τους
 * Θα μπορούσαν να εμφανίζονται σε μορφή πίνακα ή σε μορφή Συνόλου Κατευθείαν
 * πχ να δείχνει τα έργα όλα και να κάνει και την πρόσθεση των εσόδων και να εμφανίζει και το τόταλ
 *
 *
 * Emfanizei lathos ta stoixeia
 * */
public class G_ViewCompIncome extends JPanel {
    public G_ViewCompIncome() {
        super();
        String [] columnnames ={"Όνομα Έργων","Όνομα Τμήματος", "Έσοδα"};
        DefaultTableModel model = new DefaultTableModel (columnnames,0);
        Object rowData[] = new Object[3]; //creation of 3 columns
        for(Job j : Main.jobs){
            rowData[0] = j.getJobName();
            rowData[1] = j.PureIncome(); // *********** Ta emfanizei anapoda sthn kartela  onoma ta exoda kai to anapodo
            for(Department d : Main.departments)
              try{
                  rowData[2]= d.getDepName();
                  //Department department = new Department(d.getDepName(),Main.jobs.toString());
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
