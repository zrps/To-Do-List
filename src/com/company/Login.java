package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by zachary on 4/28/16.
 */
public class Login extends JFrame {
    private JPanel LoginPanel;
    private JPasswordField passwordField1;
    private JTextField userField;
    private JButton loginButton;
    private JButton quitButton;
    private JButton createAccountButton;
    private JPasswordField passwordField;


    public Login(Users user) throws IOException {
        super("Login Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(getLoginPanel());
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        try {
            user.load();
        }catch(IOException ex){
            System.out.println("Failed to load");
        }

       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //createAccountButton = new JButton();
        //createAccountButton.addActionListener(this);
       /* createAccountButton.setActionCommand("Open");
        add(createAccountButton);
        pack();*/

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // setVisible(false);
                new CreateAccount(user);
                setVisible(false);
               // JFrame log = new JFrame();
                /*JFrame CA = new JFrame();// CreateAccount().setVisible(true);
                CA.setVisible(true);
                CA.setContentPane(new CreateAccount().getCreatePanel());
                CA.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
                CA.pack();
                System.out.println("Visible");
                Login.this.setVisible(false);
                dispose();
                //Login.this.disposeLogin(log);
                System.out.println("Invisible");
                //log.dispose();*/
            }
        });
        setTitle("Login");
       // getContentPane().add(createAccountButton, BorderLayout.CENTER);
     //   getContentPane().add(quitButton);
       // getContentPane(new Login.this.getLoginPanel());

        userField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usrNm = userField.getText();

            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // JPasswordField passwordField1 = new JPasswordField();

                String usrNm = userField.getText();
                char[] pssWd = passwordField.getPassword();
                //Users user = new Users();
                Tree UserTemp = user.check(usrNm,pssWd);
                if(UserTemp != null){
                   /*new toDoDisplay(rootTemp);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //setContentPane(getTodolistPanel());
                    setLocationRelativeTo(null);
                    pack();*/
                    //new toDoDisplay(rootTemp);
                    new listChoice(UserTemp);
                    setVisible(false);
                }
                if(UserTemp == null){
                    System.out.println("No username and password match found");
                }
            }
        });

    }
   /* public void disposeLogin(JFrame frame){
        frame.setVisible(false);
        frame.dispose();
    }*/

    public boolean logPressed(){
        if(loginButton.getModel().isPressed()){
            return true;
        }
        return false;
    }
    public boolean createPressed(){
        if(createAccountButton.getModel().isPressed()){
            return true;
        }
        return false;
    }
    public boolean quitPressed(){
        if(quitButton.getModel().isPressed()){
            return true;
        }
        return false;
    }

    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(JButton createAccountButton) {
        this.createAccountButton = createAccountButton;
    }

    public JPanel getLoginPanel() {
        return LoginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.LoginPanel = loginPanel;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public JTextField getUserField() {
        return userField;
    }

    public void setUserField(JTextField userField) {
        this.userField = userField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public static void main(String[] args) throws IOException{
        Users user = new Users();

        new Login(user);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                // Do what you want when the application is stopping
                user.exit();
            }
        }));
        //JFrame frame = new JFrame();
       // frame.setContentPane(new Login().LoginPanel);

       /* JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
       // Login l = new Login();
       // l.setVisible(false);
       /* JFrame frame = new JFrame("Login:");
        frame.setContentPane(new Login().getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
        //frame.setVisible(false);
    }
}
