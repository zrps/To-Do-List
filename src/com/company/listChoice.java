package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * Created by zachary on 5/30/16.
 */
public class listChoice extends JFrame{
    private JButton toDoButton;
    private JButton inProgressButton;
    private JButton completedButton;
    private JButton quitButton;
    private JPanel choicePanel;

    public JButton getToDoButton() {
        return toDoButton;
    }

    public void setToDoButton(JButton toDoButton) {
        this.toDoButton = toDoButton;
    }

    public JButton getInProgressButton() {
        return inProgressButton;
    }

    public void setInProgressButton(JButton inProgressButton) {
        this.inProgressButton = inProgressButton;
    }

    public JButton getCompletedButton() {
        return completedButton;
    }

    public void setCompletedButton(JButton completedButton) {
        this.completedButton = completedButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JPanel getChoicePanel() {
        return choicePanel;
    }

    public void setChoicePanel(JPanel choicePanel) {
        this.choicePanel = choicePanel;
    }

    public listChoice(Tree root) {

        super("Login Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(getChoicePanel());
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        quitButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }

        });
        toDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new toDoDisplay(root);
                setVisible(false);
            }
        });
        inProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new inProgDisplay(root);
                setVisible(false);
            }
        });
        completedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new completeDisplay(root);
                setVisible(false);
            }
        });
    }
}
