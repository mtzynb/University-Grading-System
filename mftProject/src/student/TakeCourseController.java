package student;

import db.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raha on 10/3/2017.
 */
public class TakeCourseController implements ActionListener {

    public static DataBaseConnection dbForChooseCourse;

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("cancelForTakeCourse")) {
            dbForChooseCourse.close();
            TakeCourse.takeCourseFrame.dispose();
        }


        if (e.getActionCommand().equals("choose")) {
            dbForChooseCourse = new DataBaseConnection();
            int row = TakeCourse.courseTable.getSelectedRow();

            String st_id = (String) TakeCourse.courseTable.getValueAt(row, 0);
            String course_id = (String) TakeCourse.courseTable.getValueAt(row, 1);
            String course_name = (String) TakeCourse.courseTable.getValueAt(row, 2);
            String classNo = (String) TakeCourse.courseTable.getValueAt(row, 3);
            String teacherName = (String) TakeCourse.courseTable.getValueAt(row, 4);
            String teacherFamilyName = (String) TakeCourse.courseTable.getValueAt(row, 5);
            String classTime = (String) TakeCourse.courseTable.getValueAt(row, 6);
            String examTime = (String) TakeCourse.courseTable.getValueAt(row, 7);
            String teacher_id = (String) TakeCourse.courseTable.getValueAt(row, 8);

            dbForChooseCourse.insertCourse(st_id, course_id, course_name, classNo, teacherName, teacherFamilyName, classTime, examTime,  teacher_id);
            JOptionPane.showMessageDialog(null, "Course Added", "Done", JOptionPane.INFORMATION_MESSAGE);

        }

        dbForChooseCourse.close();
    }
}
