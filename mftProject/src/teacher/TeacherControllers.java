package teacher;

import db.DataBaseConnection;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by Raha on 10/5/2017.
 */
public class TeacherControllers implements ActionListener {
    DataBaseConnection dbForGiveMarks;
    DataBaseConnection dbForUpdateScores;

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("giveMarks")) {

            try {
                new GiveMarksFrame();
                dbForGiveMarks = new DataBaseConnection();
                ResultSet r = dbForGiveMarks.SelectForGiveMarks();
                while (r.next()) {
                    GiveMarksFrame.model.addRow(new Object[]{
                            r.getString("St_id"), r.getString("Course_id"),
                            r.getString("Course_name"), r.getString("Name"),
                            r.getString("FamilyName"), r.getString("Score")
                    });

                }


            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }


        }
        if (e.getActionCommand().equals("cancelTeacherProfileFrame")) {
            ProfileForTeacher.teacherProfileFrame.dispose();
        }

        if (e.getActionCommand().equals("submit")) {

            GiveMarksFrame.giveMarksTable.getCellEditor().stopCellEditing();

            dbForUpdateScores = new DataBaseConnection();

            int row = GiveMarksFrame.giveMarksTable.getSelectedRow();
            int column = GiveMarksFrame.giveMarksTable.getSelectedColumn(); // result will be 5


            String score = (String) GiveMarksFrame.giveMarksTable.getValueAt(row, 5);
            String studentId = (String) GiveMarksFrame.giveMarksTable.getValueAt(row, 0);
            String courseId = (String) GiveMarksFrame.giveMarksTable.getValueAt(row, 1);

            System.out.println(studentId);
            System.out.println(courseId);
            System.out.println(score);

            dbForUpdateScores.updateScores(score, studentId, courseId);


            JOptionPane.showMessageDialog(null, "Done", "done", JOptionPane.INFORMATION_MESSAGE);


        }

        if (e.getActionCommand().equals("cancelForGiveMarksFrame")) {
            GiveMarksFrame.giveMarksInfoFrame.dispose();

        }

//        dbForGiveMarks.close();
//        dbForUpdateScores.close();
    }
}
