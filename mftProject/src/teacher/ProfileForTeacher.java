package teacher;

import student.Login;
import student.ProfileController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Raha on 10/4/2017.
 */
public class ProfileForTeacher {


    public static JFrame teacherProfileFrame;
    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable infoTable = new JTable(model);
    // public static JTextField textField = new JTextField();


    public ProfileForTeacher() {


        teacherProfileFrame = new JFrame("Teacher Profile Frame");
        teacherProfileFrame.setBounds(0, 0, 1400, 500);

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(infoTable);
        scrollPane.setPreferredSize(new Dimension(1300, 100));

        model.addColumn("Name");
        model.addColumn("Family Name");
        model.addColumn("Phone number");
        model.addColumn("Address");
        model.addColumn("Degree");
        model.addColumn("National Code");
        model.addColumn("Date of birth");
        model.addColumn("Username ");
        model.addColumn("Email");
        model.addColumn("Gender");
        model.addColumn("Department");

        JButton giveMarks = new JButton("Give marks");
        JButton cancel = new JButton("Cancel");

        giveMarks.setActionCommand("giveMarks");
        cancel.setActionCommand("cancelTeacherProfileFrame");

        giveMarks.addActionListener(new TeacherControllers());
        cancel.addActionListener(new TeacherControllers());


        jPanel.add(scrollPane);
        jPanel.add(giveMarks);

        jPanel.add(cancel);

        teacherProfileFrame.add(jPanel);
        // jPanel.setLayout(null);
        teacherProfileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teacherProfileFrame.setVisible(true);

    }



}
