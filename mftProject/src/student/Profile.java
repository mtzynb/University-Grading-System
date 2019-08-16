package student;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Raha on 9/29/2017.
 */
public class Profile {

    public static  JFrame profileFrame ;
    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable infoTable = new JTable(model);
    public static JTextField textField = new JTextField();


    public Profile() {

        profileFrame = new JFrame("Student Profile Frame");
        profileFrame.setBounds(0, 0, 1400, 500);

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(infoTable);
        scrollPane.setPreferredSize(new Dimension(1300, 100));

        model.addColumn("National Code");
        model.addColumn("Name");
        model.addColumn("Family Name");
        model.addColumn("Date of birth");
        model.addColumn("Entrance year");
        model.addColumn("Username ");
        model.addColumn("Email");
        model.addColumn("Phone number");
        model.addColumn("Gender");
        model.addColumn("Department");
        model.addColumn("Degree");

        JButton takeCourse = new JButton("Take Course");
        JButton myCourses = new JButton("My Courses");
       // JButton myScores = new JButton("My Scores");
        JButton cancel = new JButton("Cancel");

        takeCourse.setActionCommand("takeCourse");
        myCourses.setActionCommand("myCourses");
        //myScores.setActionCommand("myScores");
        cancel.setActionCommand("cancelForProfileFrame");

        takeCourse.addActionListener(new ProfileController());
        myCourses.addActionListener(new ProfileController());
        //myScores.addActionListener(new ProfileController());
        cancel.addActionListener(new ProfileController());


        jPanel.add(scrollPane);
        jPanel.add(takeCourse);
        jPanel.add(myCourses);
       // jPanel.add(myScores);
        jPanel.add(cancel);

        profileFrame.add(jPanel);
        // jPanel.setLayout(null);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(true);

    }



}







