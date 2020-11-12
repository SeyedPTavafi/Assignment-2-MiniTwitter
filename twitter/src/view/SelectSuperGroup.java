package view;

import Group.Group;
import Pool.Pool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSuperGroup {
    JFrame frame;
    public SelectSuperGroup(Pool pool, String groupId, JFrame beforeFrame) {
        frame = new JFrame();

        JLabel label1 = new JLabel("enter super group id");
        JLabel label2 = new JLabel("if you like this group has a super group else click next");
        JTextField textField = new JTextField();
        JButton button = new JButton("next");

        label1.setBounds(140, 10, 400, 25);
        label2.setBounds(10, 35, 400, 25);
        textField.setBounds(30, 75, 150, 25);
        button.setBounds(220, 75, 150, 25);
        frame.add(label1);
        frame.add(label2);
        frame.add(textField);
        frame.add(button);

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Group group=null;
                        Group superGroup=null;
                        if (textField.getText().equals("")) {
                            group = new Group(groupId);
                            pool.addGroup(group);
                            frame.dispose();
                            beforeFrame.dispose();
                            new ControlPanel(pool);
                        }
                        else if(Pool.searchGroup(textField.getText(),pool.getGroups())==null){
                            new TextInfo("super group not found");
                        }
                        else{
                            group = new Group(groupId);
                            pool.addGroup(group);
                            superGroup=Pool.searchGroup(textField.getText(),pool.getGroups());
                            superGroup.setSubgroups(group);
                            group.setSuperGroup(superGroup);
                            frame.dispose();
                            beforeFrame.dispose();
                            new ControlPanel(pool);
                        }
                    }
                }
        );
    }
}
