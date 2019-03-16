package com.company;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

/**
 * Created by zachary on 5/23/16.
 */
public class toDoDisplay extends JPanel {
    private JList TDList;
    private JButton addItemButton;
    private JButton moveProgButton;
    private JPanel todolistPanel;
    private JFormattedTextField toAddField;
    private JButton backButton;
    private JButton saveButton;
    // DefaultListModel model;

    public JPanel getTodolistPanel() {
        return todolistPanel;
    }


    public JButton getAddItemButton() {
        return addItemButton;
    }

    public JButton getMoveProgButton() {
        return moveProgButton;
    }

    public JFormattedTextField getToAddField() {
        return toAddField;
    }

    public JList getTDList() {
        return TDList;
    }

    public toDoDisplay(Tree root) {
        //super("To Do List");
       // TDList =  new JList();
        setLayout(new BorderLayout());
        DefaultListModel <String>model = new DefaultListModel<>();
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getTodolistPanel());
        frame.pack();
        frame.setVisible(true);

       // setVisible(true);
        //TDList = new JList(model);
       // JScrollPane pane = new JScrollPane(TDList);
        //Tree rootTemp = root;
       // while(root.getToDo().find() != null) {

            //model.addElement(root.getToDo().find());
        if(root.getToDoListHead() != null) {
            for (Node i : root.getToDoListHead()) {
                model.addElement(i.getData());
            }
        }

       // }
        TDList.setModel(model);//refreshes JList AFTER model adds an element so that list items can be created
        TDList.repaint();


        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toAdd = toAddField.getText();
                model.addElement(toAdd);
                System.out.println(toAdd);
                if(root.getToDo() == null) {
                    System.out.println("getToDo is null");
                    root.setToDo( new toDoList());
                }
                root.getToDo().insert(toAdd);

            }
        });
        moveProgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = TDList.getSelectedIndex();
                model.remove(removeIndex);
                Node temp = root.getToDo().get(removeIndex);//fix. prints null when removing first node in jlist
                if(root.getInProg() == null) {
                    System.out.println("getInProg is null");
                    root.setInProg( new progress());
                }
                root.getInProg().insert(temp);
                root.getToDo().remove(removeIndex);
            }
        });

        toAddField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        moveProgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
       /* saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder USER = new StringBuilder();
                StringBuilder TODO = new StringBuilder();
                StringBuilder PROG = new StringBuilder();
                StringBuilder COMP = new StringBuilder();
                String PWCONVERT = new String(root.getPassword());
                for(Node i: root.getToDo().getTodo()){
                    TODO.append(i.getData()).append(";");
                }
                for(Node i: root.getInProg().getInProgHead()){
                    PROG.append(i.getData()).append(";");
                }
                for(Node i: root.getComp().getComp()){
                    COMP.append(i.getData()).append(";");
                }
                USER.append(root.getUsername()).append("&").append(PWCONVERT).append("&").append(TODO).append("&").append(PROG).append("&").append(COMP);
               // System.out.println("USER: "+ USER + "\nTODO: " + TODO + "\nPROG: "+ PROG + "\nCOMP: " + COMP + "PW")
                try {
                   BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/company/users.txt"));
                   bw.write(USER.toString());
                   bw.close();
               }catch(IOException ex){
                    System.out.println("Failed To save");
                }
            }
        });*/
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listChoice LC = new listChoice(root);
                LC.setVisible(true);
                frame.setVisible(false);

            }
        });
    }
}
