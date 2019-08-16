package db;


import student.Login;
import student.Registration;

import java.sql.*;

/**
 * Created by Raha on 9/26/2017.
 */
public class DataBaseConnection {

    private PreparedStatement statement;
    private Connection connection;

    Registration registration = new Registration();

    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "zeynab", "myjava123");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

/////////// Student SQL methods///////////
    public ResultSet selectForLogin() throws Exception {

        statement = connection.prepareStatement("select userName from students");
        ResultSet r = statement.executeQuery();
        return r;
    }

    public void insertRegistrationDataInDataBase() {

        try {
            statement = connection.prepareStatement("INSERT INTO students(NationalCode ,Name ,FamilyName ,Birthday ,EntranceYear ,Dep_id,userName , Email , PhoneNumber , Gender ,Department,Degree ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, Registration.nationalCodeTextfild.getText());
            statement.setString(2, Registration.nameTextfild.getText());
            statement.setString(3, Registration.familyNameTextfild.getText());
            statement.setString(4, Registration.dateOfBirthTextfild.getText());
            statement.setString(5, Registration.entranceYearTextfild.getItemAt(Registration.entranceYearTextfild.getSelectedIndex()).toString());
            statement.setString(6, registration.insertIDForDepartmant());
            statement.setString(7, Registration.usernameTextfild.getText());
            statement.setString(8, Registration.emailTextfild.getText());
            statement.setString(9, Registration.phoneNumberTextfild.getText());
            statement.setString(10, registration.whichRadioButtonIsSelected());
            statement.setString(11, Registration.departmentComboBox.getItemAt(Registration.degreeComboBox.getSelectedIndex()).toString());
            statement.setString(12, Registration.degreeComboBox.getItemAt(Registration.degreeComboBox.getSelectedIndex()).toString());

            statement.executeUpdate();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public ResultSet selectUserInfoAndShowInProfilePage() throws Exception {
        statement = connection.prepareStatement("SELECT NationalCode ,Name ,FamilyName ,Birthday ,EntranceYear ,userName , Email , PhoneNumber , Gender ,Department,Degree FROM students WHERE username =?");
        statement.setString(1, Login.usernameTextFiled.getText());

        ResultSet r = statement.executeQuery();
        return r;
    }


    public ResultSet selectForTakeCourse() throws Exception {
                statement = connection.prepareStatement("SELECT students.St_id, course.Course_id , course.Name , class.CalssNo ," +
                        "  teachers.Name as tName , teachers.FamilyName as tFamilyName " +
                        ", date.Classtime , date.ExamTime, teachers.Teacher_id from course " +
                        "INNER JOIN class ON course.Course_id = class.Course_id" +
                        " INNER JOIN teachers on teachers.Teacher_id = class.Teacher_id " +
                        "INNER JOIN date on date.Course_id = course.Course_id " +
                        "INNER JOIN students on students.Dep_id = course.Dep_id and students.userName=?  ORDER by course_id");

        statement.setString(1, Login.usernameTextFiled.getText());


        ResultSet r = statement.executeQuery();
        return r;

    }

    public void insertCourse(String st_id, String course_id, String courseName, String classNo, String tName, String tFamilyName, String classTime, String examTime, String teacher_id) {

        try {
            statement = connection.prepareStatement("INSERT INTO takecourse (St_id, Course_id, Course_name, ClassNo, " +
                    "TeacherName, TeacherFamilyName, ClassTime,ExamTime , Teacher_id  ) " +
                    " VALUES (?,?,?,?,?,?,?,?,?) ");
            statement.setString(1, st_id);
            statement.setString(2, course_id);
            statement.setString(3, courseName);
            statement.setString(4, classNo);
            statement.setString(5, tName);
            statement.setString(6, tFamilyName);
            statement.setString(7, classTime);
            statement.setString(8, examTime);
            statement.setString(9, teacher_id );



            statement.executeUpdate();

        } catch (Exception e) {
            e.getStackTrace();
        }

    }


    public ResultSet selectMyCourses() throws Exception {
            statement = connection.prepareStatement("SELECT takecourse.Course_id, takecourse.Course_name, takecourse.ClassNo , takecourse.TeacherName, takecourse.TeacherFamilyName, takecourse.ClassTime, takecourse.ExamTime , takecourse.Score FROM takecourse " +
                    " INNER JOIN  students ON students.St_id = takecourse.St_id and students.userName = ? ");

            statement.setString(1, Login.usernameTextFiled.getText());
            ResultSet r= statement.executeQuery();
            return r;



    }


//////////////////////////////////////////////// Teachers Sql methods//////////////////////////


    public ResultSet seletTeacherUsernameForLogin()throws Exception{

        statement = connection.prepareStatement("SELECT userName from teachers");
        ResultSet r = statement.executeQuery();
        return r ;

    }


    public ResultSet selectTeacherInfo() throws Exception{

        statement = connection.prepareStatement("SELECT Name, FamilyName, PhoneNumber, Address, Degree, NationalCode, " +
                "Birthday, userName, Email, Gender, Department FROM teachers WHERE userName=?");

        statement.setString(1,Login.usernameTextFiled.getText());

        ResultSet r = statement.executeQuery();
        return r ;

    }






    public ResultSet SelectForGiveMarks() throws Exception{
        statement = connection.prepareStatement("SELECT takecourse.St_id ,takecourse.Course_id ,takecourse.Course_name ," +
                " students.Name , students.FamilyName ,takecourse.Score FROM takecourse" +
                " INNER JOIN students ON students.St_id = takecourse.St_id " +
                "INNER JOIN teachers ON teachers.Teacher_id = takecourse.Teacher_id WHERE takecourse.Score IS NULL" +
                " AND teachers.userName=? ");
        statement.setString(1, Login.usernameTextFiled.getText());


        ResultSet r = statement.executeQuery();
        return r ;

    }

    public void updateScores(String score , String studentId , String courseId ){
        try {

            statement = connection.prepareStatement("UPDATE takecourse SET score=? where st_id=? AND course_id = ? ");
            statement.setString(1, score);
            statement.setString(2, studentId);
            statement.setString(3, courseId);

            statement.executeUpdate();
        }
        catch (Exception e){
            e.getStackTrace();
        }

    }











}

