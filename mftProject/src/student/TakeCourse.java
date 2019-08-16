package student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Raha on 10/2/2017.
 */
public class TakeCourse {

    public static  JFrame takeCourseFrame ;
    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable courseTable = new JTable(model);
    public static JButton choose;


    public TakeCourse() {

        takeCourseFrame = new JFrame("CourseS");
        takeCourseFrame.setBounds(0, 0, 1400, 500);

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setPreferredSize(new Dimension(1300, 300));
        model.addColumn("Student ID");
        model.addColumn("Course ID");
        model.addColumn("Course name");
        model.addColumn("ClassNo");
        model.addColumn("Teacher name ");
        model.addColumn("TeacherFamilyName");
        model.addColumn("Class time");
        model.addColumn("Exam time");
        model.addColumn("Teacher ID");

        choose = new JButton("Choose");
        choose.setActionCommand("choose");
        choose.addActionListener(new TakeCourseController());

        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("cancelForTakeCourse");
        cancel.addActionListener(new TakeCourseController());


        jPanel.add(scrollPane);
        jPanel.add(choose);
        jPanel.add(cancel);
        takeCourseFrame.add(jPanel);
        takeCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        takeCourseFrame.setVisible(true);


    }

}
