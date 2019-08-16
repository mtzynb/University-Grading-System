package student;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by Raha on 9/26/2017.
 */
public class Registration {

    public static JFrame registeringFrame;
    public static JPanel jPanel;


    //......... regestration fieldsss ........
    public static JTextField nameTextfild;
    public static JTextField familyNameTextfild;
    public static JFormattedTextField nationalCodeTextfild;
    public static JFormattedTextField dateOfBirthTextfild;
    public static JComboBox entranceYearTextfild;
    public static JTextField usernameTextfild;
    public static JFormattedTextField phoneNumberTextfild;
    public static JTextField emailTextfild;
    public static JRadioButton maleRadioButton;
    public static JRadioButton femaleRadioButton;
    public static JComboBox degreeComboBox;
    public static JComboBox departmentComboBox;

    //////////....... draw Registration frame .....
    public void setRegisteringFrame() {

        registeringFrame = new JFrame("Sign up ");
        registeringFrame.setBounds(420, 30, 500, 680);


        jPanel = new JPanel();

        JLabel title = new JLabel("Fill in the registration form \"completely\" , Please .");
        title.setBounds(120, 30, 500, 20);
//...............lablesssssssss..........

        JLabel name = new JLabel("Name :");
        name.setBounds(80, 80, 80, 20);

        JLabel familyName = new JLabel("Family name :");
        familyName.setBounds(80, 120, 80, 20);

        JLabel nationalCode = new JLabel("National code :");
        nationalCode.setBounds(80, 160, 120, 20);
        nationalCode.setToolTipText("use 10 digits!!");

        JLabel dateOfBirth = new JLabel("Date of birth :");
        dateOfBirth.setBounds(80, 200, 100, 20);
        dateOfBirth.setToolTipText("mm/dd/yyyy");

        JLabel entranceYear = new JLabel("Entrance Year :");
        entranceYear.setBounds(80, 240, 100, 20);

        JLabel username = new JLabel("Username :");
        username.setBounds(80, 280, 100, 20);

        JLabel phoneNumber = new JLabel("Phone Number:");
        phoneNumber.setBounds(80, 320, 100, 20);

        JLabel email = new JLabel("Email :");
        email.setBounds(80, 360, 100, 20);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(80, 400, 100, 20);

        JLabel degree = new JLabel("Degree :");
        degree.setBounds(80, 440, 100, 20);

        JLabel department = new JLabel("Department :");
        department.setBounds(80, 480, 100, 20);


//.................textfieldssss..........

        nameTextfild = new JTextField();
        nameTextfild.setBounds(180, 80, 100, 20);

        familyNameTextfild = new JTextField();
        familyNameTextfild.setBounds(180, 120, 100, 20);


        try {
            Container content = registeringFrame.getContentPane();
            MaskFormatter mf = new MaskFormatter("##########");
            nationalCodeTextfild = new JFormattedTextField(mf);
            nationalCodeTextfild.setBounds(180, 160, 100, 20);
            content.add(nationalCodeTextfild);
            nationalCodeTextfild.setToolTipText("use 10 digits!!");


        } catch (Exception exp) {
            exp.getStackTrace();
        }


        try {
            Container content = registeringFrame.getContentPane();
            MaskFormatter mf = new MaskFormatter("##/##/####");
            dateOfBirthTextfild = new JFormattedTextField(mf);
            dateOfBirthTextfild.setBounds(180, 200, 100, 20);
            content.add(dateOfBirthTextfild);
            dateOfBirthTextfild.setToolTipText("mm/dd/yyyy");

        } catch (Exception exp) {
            exp.getStackTrace();
        }

        String[] ey = {"----", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"};
        entranceYearTextfild = new JComboBox(ey);
        entranceYearTextfild.setBounds(180, 240, 100, 20);

        usernameTextfild = new JTextField();
        usernameTextfild.setBounds(180, 280, 100, 20);


        try {
            Container content = registeringFrame.getContentPane();
            MaskFormatter mf = new MaskFormatter("(###) ###-####");
            phoneNumberTextfild = new JFormattedTextField(mf);
            phoneNumberTextfild.setBounds(180, 320, 100, 20);
            content.add(phoneNumberTextfild);

        } catch (Exception exp) {
            exp.getStackTrace();
        }


        emailTextfild = new JTextField();
        emailTextfild.setBounds(180, 360, 200, 20);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(180, 400, 60, 20);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(250, 400, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadioButton);
        bg.add(femaleRadioButton);

        String[] deg = {"---", "diploma", "bachelor", "Masters", "Ph.D"};
        degreeComboBox = new JComboBox(deg);
        degreeComboBox.setBounds(180, 440, 100, 20);


        String[] dep = {"---", "ICT", "Art"};
        departmentComboBox = new JComboBox(dep);
        departmentComboBox.setBounds(180, 480, 90, 20);


//************* submit button ***************
        JButton submit = new JButton("Submit");
        submit.setBounds(90, 570, 80, 25);
        submit.setActionCommand("submit");
        submit.addActionListener(new RegistrationController());

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(300, 570, 80, 25);
        cancel.setActionCommand("cancelForRegistration");
        cancel.addActionListener(new RegistrationController());

        //........adding labels to panel.....
        jPanel.add(title);
        jPanel.add(name);
        jPanel.add(familyName);
        jPanel.add(nationalCode);
        jPanel.add(dateOfBirth);
        jPanel.add(entranceYear);
        jPanel.add(username);
        jPanel.add(phoneNumber);
        jPanel.add(email);
        jPanel.add(gender);
        jPanel.add(degree);
        jPanel.add(department);


        //........adding textFields to panel.........
        jPanel.add(nameTextfild);
        jPanel.add(familyNameTextfild);
        jPanel.add(nationalCodeTextfild);
        jPanel.add(dateOfBirthTextfild);
        jPanel.add(entranceYearTextfild);
        jPanel.add(usernameTextfild);
        // jPanel.add(phoneNumberTextfild);
        jPanel.add(emailTextfild);
        jPanel.add(maleRadioButton);
        jPanel.add(femaleRadioButton);
        jPanel.add(degreeComboBox);
        jPanel.add(departmentComboBox);


//******* adding submit button ***********
        jPanel.add(submit);
        jPanel.add(cancel);


        registeringFrame.add(jPanel);
        jPanel.setLayout(null);
        //jFrame.setLayout(null);
        registeringFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registeringFrame.setVisible(true);


    }


    public boolean setErrorFields() {
        boolean validRegistration = true;

        Registration registration = new Registration();
//................... N A M E ...........
        if (nameTextfild.getText().equals("")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 80, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        } else {
            if (!registration.isAlphabet(nameTextfild.getText())) {
                JTextField textField = new JTextField("Invalid chars!");
                textField.setBounds(310, 80, 100, 20);
                textField.setEnabled(false);
                jPanel.add(textField);
                validRegistration = false;

            } else {
                JTextField textField = new JTextField("   ");
                textField.setBounds(310, 80, 100, 20);
                textField.setEnabled(false);
                jPanel.add(textField);
            }
        }

        /// ........ F A M I L Y N A M E ...............
        if (familyNameTextfild.getText().equals("")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 120, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;
        } else {
            if (!registration.isAlphabet(familyNameTextfild.getText())) {
                JTextField textField = new JTextField("Invalid chars!");
                textField.setBounds(310, 120, 100, 20);
                textField.setEnabled(false);
                jPanel.add(textField);
                validRegistration = false;
            } else {
                JTextField textField = new JTextField("   ");
                textField.setBounds(310, 120, 100, 20);
                textField.setEnabled(false);
                jPanel.add(textField);


            }
        }
/////////.......... N A T I O N A L C O D E..........
        if (nationalCodeTextfild.getText().equals("          ")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 160, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        }
        if (!nationalCodeTextfild.getText().equals("          ")) {
            JTextField textField = new JTextField("    ");
            textField.setBounds(310, 160, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }


//////////........  D A T E OF B I R T H // DATE OF BIRTH
        if (dateOfBirthTextfild.getText().equals("  /  /    ")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 200, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        }
        if (!dateOfBirthTextfild.getText().equals("  /  /    ")) {
            JTextField textField = new JTextField("   ");
            textField.setBounds(310, 200, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }


//////////.......... E N T R A N C E Y E A R // ENTRANCE YEAR //
        if (entranceYearTextfild.getItemAt(entranceYearTextfild.getSelectedIndex()).equals("----")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 240, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        }
        if (!(entranceYearTextfild.getItemAt(entranceYearTextfild.getSelectedIndex()).equals("----"))) {
            JTextField textField = new JTextField("   ");
            textField.setBounds(310, 240, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }


/////............  U S E R N A M E ..... /// USER NAME
        if (usernameTextfild.getText().equals("")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 280, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        } else {


            if (usernameTextfild.getText().length() < 5) {
                JTextField textField = new JTextField("USe more chars");
                textField.setBounds(310, 280, 100, 20);
                textField.setEnabled(false);
                jPanel.add(textField);
                validRegistration = false;
            } else {

                try {
                    if (!registration.validUsername(usernameTextfild.getText())) {
                        JTextField textField = new JTextField("Not available!!");
                        textField.setBounds(310, 280, 100, 20);
                        textField.setEnabled(false);
                        jPanel.add(textField);
                        validRegistration = false;
                    } else {
                        JTextField textField = new JTextField("   ");
                        textField.setBounds(310, 280, 100, 20);
                        textField.setEnabled(false);
                        jPanel.add(textField);
                    }
                } catch (Exception exp) {
                    exp.getStackTrace();
                }


            }


        }

/////////// ....... P H O N E N U M B E R ...//PHONE NUMBER //
        if (phoneNumberTextfild.getText().equals("(   )    -    ")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 320, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        }
        if (!phoneNumberTextfild.getText().equals("(   )    -    ")) {
            JTextField textField = new JTextField("    ");
            textField.setBounds(310, 320, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }


/////////....... E M A I L // email
        if (emailTextfild.getText().equals("")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 360, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;

        }
        if (!emailTextfild.getText().equals("")) {
            JTextField textField = new JTextField("   ");
            textField.setBounds(310, 360, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }

///////////////...... R A D I O , B U T T O N S// RADIO BUTTONS//
        if (maleRadioButton.isSelected() == false && femaleRadioButton.isSelected() == false) {
            JTextField textField = new JTextField("Fill the field!!");
            textField.setBounds(310, 400, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;
        }
        if (maleRadioButton.isSelected() || femaleRadioButton.isSelected()) {
            JTextField textField = new JTextField("  ");
            textField.setBounds(310, 400, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
        }


///////////////// ....... D E G R E E // degree//
        if (degreeComboBox.getItemAt(degreeComboBox.getSelectedIndex()).equals("---")) {
            JTextField textField = new JTextField("Fill the field!!");
            textField.setBounds(310, 440, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;
        }
        if (!(degreeComboBox.getItemAt(degreeComboBox.getSelectedIndex()).equals("---"))) {
            JTextField textField = new JTextField("   ");
            textField.setBounds(310, 440, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
        }


///////////////  D E P A R T M E N T ...... //// department//
        if (departmentComboBox.getItemAt(departmentComboBox.getSelectedIndex()).equals("---")) {
            JTextField textField = new JTextField("Fill the field!! ");
            textField.setBounds(310, 480, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);
            validRegistration = false;
        }
        if (!(departmentComboBox.getItemAt(departmentComboBox.getSelectedIndex()).equals("---"))) {
            JTextField textField = new JTextField("   ");
            textField.setBounds(310, 480, 100, 20);
            textField.setEnabled(false);
            jPanel.add(textField);

        }


        return validRegistration;
    }


    /////....... checking valid user nameees  ..........!!!
    public boolean validUsername(String username) throws Exception {

        boolean validUsername = true;

        ResultSet r = RegistrationController.dataBaseObject.selectForLogin();

        while (r.next()) {
            if (r.getString("userName").equals(username)) {
                validUsername = false;
                break;
            }
        }


        return validUsername;
    }


    ///////////// checking name and family name to be only alphabets
    public boolean isAlphabet(String name) {
        boolean validation = true;

        String[] str = name.split("(?!^)");

        for (String s : str) {
            if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") ||
                    s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9")
                    || s.equals("!") || s.equals("@") || s.equals("#") || s.equals("$") || s.equals("%") || s.equals("^") ||
                    s.equals("&") || s.equals("*")
                    || s.equals("(") || s.equals(")") || s.equals("_") || s.equals("-") || s.equals("+")
                    || s.equals(".") || s.equals(",") || s.equals("<") || s.equals(">") || s.equals("/") || s.equals(":") || s.equals("'")
                    || s.equals(";") || s.equals("\"") || s.equals("[") || s.equals("]") || s.equals("{") || s.equals("}")) {

                validation = false;
                break;
            }

        }
        return validation;
    }


    /////  checking phone number and national code  e fit (10 digits not less) // agar kamtar az 10 ta add vared karde bashan
    // yani space darim tue phone number ya kode meli , pas chek mikonim age space dasht , javabe false midim ;
    public boolean haveSpace(String phoneNumber) {
        boolean validation = true;
        String[] str = phoneNumber.split("(?!^)");
        for (String s : str) {
            if (s.equals(" ")) {

                validation = false;
                break;
            }

        }
        return validation;

    }


    ///....... geting text from radiobutton // first i should know which radio button selected after that following method
    // will return the text of item
    public String whichRadioButtonIsSelected() {
        if (maleRadioButton.isSelected()) {
            return "male";

        } else return "female";
    }



    public String  insertIDForDepartmant() {

        String result ="0";

        if  (departmentComboBox.getItemAt(degreeComboBox.getSelectedIndex()).toString().equals("ICT"))
            result = "1" ;

        else if (departmentComboBox.getItemAt(degreeComboBox.getSelectedIndex()).toString().equals("Art"))
            result = "2";

        return result;
    }


}
