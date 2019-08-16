package teacher;

import db.DataBaseConnection;
import student.Login;
import student.Profile;
import student.Welcom;

import javax.swing.*;
import java.sql.ResultSet;

/**
 * Created by Raha on 10/4/2017.
 */
public class ValidTeacherLogin {

    private DataBaseConnection dbForLogin;
    private   DataBaseConnection dbForShowInfo ;

    public void validLoginForTeacher(String username) throws Exception {

        boolean validUsername = false;

        dbForLogin = new DataBaseConnection();
        ResultSet r = dbForLogin.seletTeacherUsernameForLogin();

        while (r.next()) {
            if (r.getString("userName").equals(username)) {
                validUsername = true;
                break;
            }
        }
//...................... username is validddd .......
        if (validUsername == true) {
            /////////........ username and password both are validd ....
            if (Login.passwordTextField.getText().equals("admin")) {


                try {
                    new ProfileForTeacher();
                    dbForShowInfo = new DataBaseConnection() ;

                    ResultSet resultSet = dbForShowInfo.selectTeacherInfo();

                    while (resultSet.next()) {

                        ProfileForTeacher.model.addRow(new Object[]{resultSet.getString("Name"),
                                resultSet.getString("FamilyName"), resultSet.getString("PhoneNumber"), resultSet.getString("Address"),
                                resultSet.getString("Degree"), resultSet.getString("NationalCode"),
                                resultSet.getString("Birthday"), resultSet.getString("userName"),
                                resultSet.getString("Email"), resultSet.getString("Gender"), resultSet.getString("Department") ,
                                });

                    }


                } catch (Exception exp) {
                    exp.getStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Welcom \" " + Login.usernameTextFiled.getText() + " \"", "welcom", JOptionPane.INFORMATION_MESSAGE);
                Login.loginFrame.dispose();
               // Welcom.welcomFrame.dispose();
            }

            ////,,,,,,,username is valid but password is invalid
            else {
                JOptionPane.showMessageDialog(null, "Invalid Password!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "There is no such \"" + Login.usernameTextFiled.getText() + "\" username.",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
        dbForLogin.close();
        dbForShowInfo.close();
    }
}

