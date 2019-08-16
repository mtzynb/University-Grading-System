package student;

import javax.swing.*;

/**
 * Created by Raha on 9/26/2017.
 **/
//
public class Welcom {

    public static JFrame welcomFrame;
    public JButton signIn;
    public JButton signUp;
    public JButton cancel;
///............ constructor............
    public Welcom() {
        welcomFrame = new JFrame("Hello");
        welcomFrame.setBounds(500, 200, 500, 250);

        JPanel jPanel = new JPanel();

        JLabel label = new JLabel("Welcome to Tehran Technical Complex Registration system");
        label.setBounds(80, 20, 800, 20);

        signIn = new JButton("Sign in");
        signUp = new JButton("Sign up");
        cancel = new JButton("Cancel");

        signIn.setActionCommand("signIn");
        signUp.setActionCommand("signUp");
        cancel.setActionCommand("cancelForWelcomFrame");

        signIn.addActionListener(new WelcomAndLoginController());
        signUp.addActionListener(new WelcomAndLoginController());
        cancel.addActionListener(new WelcomAndLoginController());


        signIn.setBounds(80, 65, 90, 30);
        signUp.setBounds(300, 65, 90, 30);
        cancel.setBounds(200, 150, 90, 25);

        jPanel.add(label);
        jPanel.add(signIn);
        jPanel.add(signUp);
        jPanel.add(cancel);

        welcomFrame.add(jPanel);
        jPanel.setLayout(null);
        //        jFrame.setLayout(null);
        welcomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomFrame.setVisible(true);
    }











    public static void main(String[] args) throws Exception{
        Welcom login = new Welcom();

    }


}