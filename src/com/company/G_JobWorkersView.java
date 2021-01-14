package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class G_JobWorkersView extends JPanel {
    public G_JobWorkersView() {
        super(new GridLayout(5,2));
        JLabel joblabel = new JLabel("Έργο");
        JComboBox<Job> job = new JComboBox<Job>(Main.jobs.toArray(new Job[0]));
        JTextArea textJob =new JTextArea();
        textJob.setEditable(false);

        JButton display = new JButton("Εμφάνιση");
        job.setVisible(true);
        this.add(joblabel);
        this.add(job);
        this.add(textJob);
        this.add(display);

        display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { // orismos master kai department se employees
                Job j = (Job) job.getSelectedItem();
                textJob.setText("");
                for (Employee emp: j.getJobEmp().keySet()){
                    textJob.append(emp.toString() +"\tΗμ.Έναρξης: " +j.getJobEmp().get(emp)[0]
                                                        +"\tΗμ.Λήξης: " +j.getJobEmp().get(emp)[1]);

                }
            }});
   }
}
