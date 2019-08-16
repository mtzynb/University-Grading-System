package student;

import db.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by Raha on 10/2/2017.
 */
public class ProfileController implements ActionListener {

    public static DataBaseConnection dbForTakeCourse;
    public static DataBaseConnection dbForMyCourse;


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("cancelForProfileFrame")) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to exit? ", "Confirm Exit", JOptionPane.INFORMATION_MESSAGE);
            Profile.profileFrame.dispose();
            dbForTakeCourse.close();

        }

        if (e.getActionCommand().equals("takeCourse")) {

            try {

                new TakeCourse();
                dbForTakeCourse = new DataBaseConnection();

                ResultSet r = dbForTakeCourse.selectForTakeCourse();

                while (r.next()) {
                    TakeCourse.model.addRow(new Object[]{r.getString("St_id"), r.getString("Course_id"),
                            r.getString("Name"), r.getString("CalssNo"), r.getString("tName"), r.getString("tFamilyName"),
                            r.getString("Classtime"), r.getString("ExamTime"),r.getString("Teacher_id")});
                }

            } catch (Exception exp) {
                exp.getStackTrace();
            }

        }
        if (e.getActionCommand().equals("myCourses")) {

            try {
                new MyCourses();
                dbForMyCourse = new DataBaseConnection();
                ResultSet r = dbForMyCourse.selectMyCourses();

                while (r.next()) {
                    MyCourses.model.addRow(new Object[]{
                            r.getString("Course_id"), r.getString("Course_name"), r.getString("ClassNo"),
                            r.getString("TeacherName"), r.getString("TeacherFamilyName"), r.getString("ClassTime"),
                            r.getString("ExamTime"), r.getString("Score")
                    });


                }


            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }


        }


        dbForTakeCourse.close();

    }


}
