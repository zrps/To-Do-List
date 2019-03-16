package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by zachary on 5/31/16.
 */
public class inProgDisplay extends JPanel{
    private JPanel inProgPanel;
    private JPanel todolistPanel;
    private JButton addItemButton;
    private JButton moveCompButton;
    private JList IPList;
    private JButton backButton;
    private JFormattedTextField toAddField;

    public JPanel getInProgPanel() {
        return inProgPanel;
    }

    public JPanel getTodolistPanel() {
        return todolistPanel;
    }

    public JButton getAddItemButton() {
        return addItemButton;
    }

    public JButton getMoveCompButton() {
        return moveCompButton;
    }

    public JList getIPList() {
        return IPList;
    }

    public JFormattedTextField getToAddField() {
        return toAddField;
    }

    public inProgDisplay(Tree root) {

        setLayout(new BorderLayout());
        DefaultListModel <String>model = new DefaultListModel<>();
        JFrame frame = new JFrame("In Progress List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getInProgPanel());
        frame.pack();
        frame.setVisible(true);

        for(Node i : root.getInProg().getProg()) {
            model.addElement(i.getData());
        }

        IPList.setModel(model);//refreshes JList AFTER model adds an element so that list items can be created
        IPList.repaint();


/*        toAddField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
        moveCompButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = IPList.getSelectedIndex();
                model.remove(removeIndex);
                Node temp = root.getInProg().get(removeIndex);
                root.getComp().insert(temp);
                root.getInProg().remove(removeIndex);
            }
        });
       /* addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toAdd = toAddField.getText();
                model.addElement(toAdd);
                if(root.getInProg() == null) {
                    System.out.println("getInProg is null");
                    root.setInProg( new progress());
                }
                root.getInProg().insert(toAdd);
            }
        });
        IPList.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

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
