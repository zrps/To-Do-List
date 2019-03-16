package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zachary on 5/31/16.
 */
public class ListAdd {
    private JTextField itemAdd;
    private JPanel panel1;
    private JButton addButton;

    public ListAdd() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textToAdd = itemAdd.getText();
            }
        });
        itemAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
