package student;

import db.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raha on 9/27/2017.
 */
public class RegistrationController implements ActionListener {

    Registration registrationObject = new Registration();
    public static DataBaseConnection dataBaseObject ;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cancelForRegistration")) {
            Registration.registeringFrame.dispose();
        }

        if (e.getActionCommand().equals("submit")) {
            dataBaseObject = new DataBaseConnection();
            if(registrationObject.setErrorFields()){

                JOptionPane.showMessageDialog(null , "Thank you for joining us! :)" , "Registration is done." , JOptionPane.INFORMATION_MESSAGE);
                dataBaseObject.insertRegistrationDataInDataBase();
                dataBaseObject.close();
                Registration.registeringFrame.dispose();


            }

        }
    }
}
