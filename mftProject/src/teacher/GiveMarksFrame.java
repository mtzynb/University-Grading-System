package teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Raha on 10/5/2017.
 */
public class GiveMarksFrame {



    public static JFrame giveMarksInfoFrame;
    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable giveMarksTable = new JTable(model);

    public GiveMarksFrame() {


        giveMarksInfoFrame = new JFrame("Give Marks Frame");
        giveMarksInfoFrame.setBounds(0, 0, 1400, 500);

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(giveMarksTable);
        scrollPane.setPreferredSize(new Dimension(1300, 100));

        model.addColumn("Student ID");
        model.addColumn("Course ID");
        model.addColumn("Course Name ");
        model.addColumn("Student Name ");
        model.addColumn("Student FamilyName");
        model.addColumn("Score");

        JButton submit = new JButton("Submit");
        JButton cancel = new JButton("Cancel");

        submit.setActionCommand("submit");
        cancel.setActionCommand("cancelForGiveMarksFrame");

        submit.addActionListener(new TeacherControllers());
        cancel.addActionListener(new TeacherControllers());


        jPanel.add(scrollPane);
        jPanel.add(submit);
        jPanel.add(cancel);

        giveMarksInfoFrame.add(jPanel);
        // jPanel.setLayout(null);
        giveMarksInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        giveMarksInfoFrame.setVisible(true);

    }





}
