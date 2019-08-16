package student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raha on 10/3/2017.
 */
public class MyCourses {

    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable mycourseTable = new JTable(model);

    public MyCourses() {

        JFrame myCoursesFrame = new JFrame("Your coursesss ");
        myCoursesFrame.setBounds(0, 0, 1400, 500);

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(mycourseTable);
        scrollPane.setPreferredSize(new Dimension(1300, 300));
        //model.addColumn("Student ID");
        model.addColumn("Course ID");
        model.addColumn("Course name");
        model.addColumn("ClassNo");
        model.addColumn("Teacher name ");
        model.addColumn("Teacher FamilyName");
        model.addColumn("Class time");
        model.addColumn("Exam time");
        model.addColumn("Score");

        JButton cancel = new JButton("cancel");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCoursesFrame.dispose();

            }
        });

        jPanel.add(scrollPane);
        jPanel.add(cancel);
        myCoursesFrame.add(jPanel);
        myCoursesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myCoursesFrame.setVisible(true);


    }
}
