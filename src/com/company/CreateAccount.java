package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * Created by zachary on 5/10/16.
 */
public class CreateAccount extends JFrame{
    private JTextField userField;
    private JPasswordField PasswordField;
    private JButton createButton;
    private JPanel CreatePanel;

    public CreateAccount(Users user) {
        super("Account Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(getCreatePanel());
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // try {
                   // File file = new File("src/com/company/users.txt");
                    //Scanner read = new Scanner(file);
                    //FileWriter writer = new FileWriter(file, true);
                    String userNmTxt = userField.getText();
                    char[] pssWdTxt = PasswordField.getPassword();
                    String PWtemp = Arrays.toString(pssWdTxt);
                    //System.out.println(PWtemp);
                    if(!userNmTxt.isEmpty() && !PWtemp.equals("[]")) {
                        Tree temp = new Tree(userNmTxt, pssWdTxt);
                        temp.setToDo(new toDoList());
                        // temp.getToDo().insert();
                        temp.setInProg(new progress());
                        temp.setComp(new complete());


                        // Users make = new Users();
                        user.insert(temp);

                        // String usrNm = userField.getText();
                        //  char[] pssWd = passwordField.getPassword();
                        //Users user = new Users();
                        Tree rootTemp = user.check(userNmTxt, pssWdTxt);
                        if (rootTemp != null) {
                   /*new toDoDisplay(rootTemp);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //setContentPane(getTodolistPanel());
                    setLocationRelativeTo(null);
                    pack();*/
                            //new toDoDisplay(rootTemp);
                            new listChoice(rootTemp);
                            setVisible(false);
                        }
                        if (rootTemp == null) {
                            System.out.println("No username and password match found");
                        }
                    }

                   // Login
              //  }catch (IOException ex) {
               //     ex.printStackTrace();
               // }
            }
        });
        userField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        PasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getCreatePanel() {
        return CreatePanel;
    }

 /*   public static void main(String[] args) throws IOException{
        new CreateAccount(user);

    }*/

}
