package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;

import User.User;
import Pool.Pool;
import Group.Group;

public class ControlPanel implements ActionListener {
    JFrame frame;
    JTextField userId;
    JTextField groupId;
    JTree jt;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode users;
    DefaultMutableTreeNode groups;


    public ControlPanel(Pool pool) {


        frame = new JFrame();

        this.tree(pool);

        JLabel userIdLable = new JLabel("user id :");
        JLabel groupIdLable = new JLabel("group id :");

        userId = new JTextField();
        groupId = new JTextField();

        JButton addUser = new JButton("add user");
        JButton addGroup = new JButton("add group");
        JButton showAllUsers = new JButton("show all users");
        JButton showAllGroups = new JButton("show all groups");
        JButton usersTotal = new JButton("users total");
        JButton groupsTotal = new JButton("groups total");
        JButton messagesTotal = new JButton("messages total");
        JButton positivePercentage = new JButton("positive percentage");
        JButton refreshPage = new JButton("refresh");

        userIdLable.setBounds(350, 10, 120, 40);
        groupIdLable.setBounds(350, 60, 120, 40);
        userId.setBounds(475, 17, 120, 25);
        groupId.setBounds(475, 67, 120, 25);
        userId.setMargin(new Insets(0, 5, 0, 0));
        groupId.setMargin(new Insets(0, 5, 0, 0));
        addUser.setBounds(650, 17, 120, 25);
        addGroup.setBounds(650, 67, 120, 25);
        showAllUsers.setBounds(350, 110, 200, 40);
        showAllGroups.setBounds(570, 110, 200, 40);
        usersTotal.setBounds(350, 160, 200, 40);
        groupsTotal.setBounds(570, 160, 200, 40);
        messagesTotal.setBounds(350, 210, 200, 40);
        positivePercentage.setBounds(570, 210, 200, 40);
        refreshPage.setBounds(10, 220, 150, 25);

        frame.add(userIdLable);
        frame.add(groupIdLable);
        frame.add(userId);
        frame.add(groupId);
        frame.add(addUser);
        frame.add(addGroup);
        frame.add(showAllUsers);
        frame.add(showAllGroups);
        frame.add(usersTotal);
        frame.add(groupsTotal);
        frame.add(messagesTotal);
        frame.add(positivePercentage);
        frame.add(refreshPage);
        frame.setSize(800, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        addUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (null == pool.searchUser(userId.getText(), pool.getUsers()) && (!userId.getText().equals(""))) {
                    User user = new User(userId.getText());
                    pool.addUser(user);
                    frame.getContentPane().remove(jt);
                    frame.invalidate();
                    tree(pool);
                    frame.validate();
                    new TextInfo("user add successfully");
                    frame.dispose();
                    new ControlPanel(pool);
                } else {
                    new TextInfo("choose other id");
                }
            }
        });

        addGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (null == pool.searchGroup(groupId.getText(), pool.getGroups()) && (!groupId.getText().equals(""))) {
                    new SelectSuperGroup(pool, groupId.getText(), frame);
                } else {
                    new TextInfo("choose other id");
                }
            }
        });
        showAllUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AllUsers(pool);
            }
        });
        showAllGroups.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AllGroups(pool);
            }
        });
        usersTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = "users total : " + pool.getUsers().toArray().length + "";
                new TextInfo(text);
            }
        });
        groupsTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = "groups total : " + pool.getGroups().toArray().length + "";
                new TextInfo(text);
            }
        });
        messagesTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = "messages total : " + pool.getMessages().toArray().length + "";
                new TextInfo(text);
            }
        });
        positivePercentage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PercentageWord(pool);
            }
        });
        refreshPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ControlPanel(pool);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
    /**
     * This method is used to refresh tree
     *
     * @param pool This is the first paramter
     */
    private void tree(Pool pool) {
        root = new DefaultMutableTreeNode("root");
        users = new DefaultMutableTreeNode("users");
        groups = new DefaultMutableTreeNode("groups");
        for (int i = 0; i < pool.getUsers().toArray().length; i++) {
            User user = (User) pool.getUsers().get(i);
            users.add(new DefaultMutableTreeNode(user.getId()));
        }

        for (int i = 0; i < pool.getGroups().toArray().length; i++) {
            Group group = (Group) pool.getGroups().get(i);
            if (group.getSuperGroup() == null) {
                groups.add(this.createTree(group));
            }
        }

        root.add(users);
        root.add(groups);
        jt = new JTree(root);
        jt.setBounds(10, 10, 330, 190);
        frame.add(jt);
    }

    /**
     * This method is used to create group tree
     *
     * @param group This is the first paramter
     * @return groupTree This returns groupTree.
     */
    private DefaultMutableTreeNode createTree(Group group) {
        DefaultMutableTreeNode groupTree = new DefaultMutableTreeNode(group.getId());

        if (group.getUsers().length != 0) {
            for (int j = 0; j < group.getUsers().length; j++) {
                DefaultMutableTreeNode user = new DefaultMutableTreeNode(group.getUsers()[j].getId());
                groupTree.add(user);
            }
        }
        if (group.getSubgroups().length != 0) {
            for (int i = 0; i < group.getSubgroups().length; i++) {
                groupTree.add(createTree(group.getSubgroups()[i]));
            }
        }

        return groupTree;
    }
}