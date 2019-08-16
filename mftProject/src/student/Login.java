package student;

import db.DataBaseConnection;

import javax.swing.*;
import java.sql.ResultSet;

/**
 * Created by Raha on 9/26/2017.
 */
public class Login {

    public static JFrame loginFrame;
    public static JTextField usernameTextFiled;
    public static JPasswordField passwordTextField;
    public static JComboBox studentOrTeacherComboBox ;
    private DataBaseConnection dbForLogin;
    private   DataBaseConnection dbForShowInfo ;

    //............ Draww login frame ..............
    public void setLoginFrame() {

        loginFrame = new JFrame("log in ");
        loginFrame.setBounds(500, 250, 400, 250);

        JPanel jPanel = new JPanel();

        JLabel username = new JLabel("User name :");
        username.setBounds(80, 20, 80, 20);

        JLabel password = new JLabel("Password :");
        password.setBounds(80, 60, 100, 20);

        usernameTextFiled = new JTextField();
        usernameTextFiled.setBounds(160, 20, 100, 20);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(160, 60, 100, 20);

        JButton login = new JButton("log in");
        login.setBounds(55, 110, 80, 25);
        login.setActionCommand("login");
        login.addActionListener(new WelcomAndLoginController());

        JButton cancel = new JButton("cancel");
        cancel.setBounds(240, 110, 80, 25);
        cancel.setActionCommand("cancelForLoginFrame");
        cancel.addActionListener(new WelcomAndLoginController());

        String[] str ={"Student" , "Teacher"} ;
        studentOrTeacherComboBox = new JComboBox(str);
        studentOrTeacherComboBox.setBounds(150,150,100,20);


        jPanel.add(username);
        jPanel.add(password);
        jPanel.add(usernameTextFiled);
        jPanel.add(passwordTextField);
        jPanel.add(login);
        jPanel.add(cancel);
        jPanel.add(studentOrTeacherComboBox);

        loginFrame.add(jPanel);
        jPanel.setLayout(null);
        //jFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
    }


    /////....... checking valid user nameees and passwword="admin" ..........!!!
    public void validLogin(String username) throws Exception {

        boolean validUsername = false;

        dbForLogin = new DataBaseConnection();
        ResultSet r = dbForLogin.selectForLogin();

        while (r.next()) {
            if (r.getString("userName").equals(username)) {
                validUsername = true;
                break;
            }
        }
//...................... username is validddd .......
        if (validUsername == true) {
            /////////........ username and password both are validd ....
            if (passwordTextField.getText().equals("admin")) {


                try {
                    new Profile();
                    dbForShowInfo = new DataBaseConnection() ;

                    ResultSet resultSet = dbForShowInfo.selectUserInfoAndShowInProfilePage();

                    while (resultSet.next()) {

                        Profile.model.addRow(new Object[]{resultSet.getString("NationalCode"),
                                resultSet.getString("Name"), resultSet.getString("FamilyName"), resultSet.getString("Birthday"), resultSet.getString("EntranceYear"),
                                resultSet.getString("userName"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"),
                                resultSet.getString("Gender"), resultSet.getString("Department"), resultSet.getString("Degree")});

                    }


                } catch (Exception exp) {
                    exp.getStackTrace();
                }




                JOptionPane.showMessageDialog(null, "Welcom \" " + usernameTextFiled.getText() + " \"", "welcom", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.dispose();
                Welcom.welcomFrame.dispose();
            }

            ////,,,,,,,username is valid but password is invalid
            else {
                JOptionPane.showMessageDialog(null, "Invalid Password!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "There is no such \"" + usernameTextFiled.getText() + "\" username.",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
        dbForLogin.close();
        dbForShowInfo.close();
    }


}
