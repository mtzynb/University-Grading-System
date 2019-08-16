package student;


import db.DataBaseConnection;
import teacher.ProfileForTeacher;
import teacher.ValidTeacherLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raha on 9/26/2017.
 */

public class WelcomAndLoginController implements ActionListener {

    Login loginObject = new Login();
    ValidTeacherLogin validTeacherLoginObject = new ValidTeacherLogin();
    Registration registrationObject = new Registration();
    DataBaseConnection dataBaseConnection = new DataBaseConnection();


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("signIn")) {

            loginObject.setLoginFrame();

        }
        if (e.getActionCommand().equals("signUp")) {
            registrationObject.setRegisteringFrame();
        }

        if (e.getActionCommand().equals("cancelForWelcomFrame")) {
            Welcom.welcomFrame.dispose();
        }

        if (e.getActionCommand().equals("login")) {
            //alert
            try {
                if (Login.studentOrTeacherComboBox.getItemAt(Login.studentOrTeacherComboBox.getSelectedIndex()).equals("Student"))
                    loginObject.validLogin(Login.usernameTextFiled.getText());

                else validTeacherLoginObject.validLoginForTeacher(Login.usernameTextFiled.getText());


            } catch (Exception exp) {
                exp.getStackTrace();
            }


        }
        if (e.getActionCommand().equals("cancelForLoginFrame")) {
            Login.loginFrame.dispose();
        }


    }


}

