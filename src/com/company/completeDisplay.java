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
public class completeDisplay extends JPanel{
    private JPanel inProgPanel;
    private JPanel todolistPanel;
    private JButton moveCompButtonremoveButton;
    private JList CList;
    private JPanel compPanel;
    private JButton backButton;

    public JPanel getCompPanel() {
        return compPanel;
    }

    public completeDisplay(Tree root) {
        setLayout(new BorderLayout());
        DefaultListModel <String>model = new DefaultListModel<>();
        JFrame frame = new JFrame("In Progress List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getCompPanel());
        frame.pack();
        frame.setVisible(true);

        for(Node i : root.getComp().getComp()) {
            model.addElement(i.getData());
        }

        CList.setModel(model);//refreshes JList AFTER model adds an element so that list items can be created
        CList.repaint();





       /* CList.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               // super.componentResized(e);
                int removeIndex = CList.getSelectedIndex();
                model.remove(removeIndex);
                if(root.getComp() == null) {
                    System.out.println("getComp is null");
                    root.setComp( new complete());
                }
                root.getToDo().remove(removeIndex);

            }
        });*/
        moveCompButtonremoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = CList.getSelectedIndex();
                model.remove(removeIndex);
                root.getComp().remove(removeIndex);
            }
        });
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
