package view;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import Group.Group;
import Message.Message;
import Pool.Pool;

import java.awt.event.*;
import java.util.List;

import User.User;

public class UserView implements ActionListener {
    JFrame frame;

    public UserView(Pool pool, User user) {
        frame = new JFrame();

        JLabel userIdlable = new JLabel("user id : ");
        JLabel userId = new JLabel(user.getId());

        JButton showUserGroups = new JButton("groups");
        JButton showFollowing = new JButton("following");
        JButton showFollower = new JButton("followers");

        JLabel followUserLable = new JLabel("follow by user id : ");
        JTextField followUserTextField = new JTextField();
        JButton followUserBtn = new JButton("follow user");

        DefaultMutableTreeNode userTree = new DefaultMutableTreeNode("users");
        for (int i = 0; i < pool.getUsers().toArray().length; i++) {
            User u = (User) pool.getUsers().get(i);
            userTree.add(new DefaultMutableTreeNode(u.getId()));
        }
        JTree jt = new JTree(userTree);

        JLabel joinGroupLable = new JLabel("join to group : ");
        JTextField joinGroupTextField = new JTextField();
        JButton joinGroupBtn = new JButton("join");

        DefaultMutableTreeNode groupTree = new DefaultMutableTreeNode("groups");
        for (int i = 0; i < pool.getGroups().toArray().length; i++) {
            Group group = (Group) pool.getGroups().get(i);
            if (group.getSuperGroup() == null) {
                groupTree.add(this.createTree(group));
            }
        }
        JTree groupJT = new JTree(groupTree);

        JTextField messageTextField = new JTextField();
        JButton sendMessageBtn = new JButton("send Message");
        JButton sentMessagesBtn = new JButton("sent Messages");
        JButton recivedMessagesBtn = new JButton("recived Messages");

        userIdlable.setBounds(10, 10, 65, 25);
        userId.setBounds(75, 10, 150, 25);
        showUserGroups.setBounds(10, 55, 120, 25);
        showFollowing.setBounds(140, 55, 120, 25);
        showFollower.setBounds(270, 55, 120, 25);
        followUserLable.setBounds(10, 100, 150, 25);
        followUserTextField.setBounds(140, 100, 120, 25);
        followUserBtn.setBounds(270, 100, 120, 25);
        jt.setBounds(10, 135, 380, 200);
        joinGroupLable.setBounds(10, 345, 150, 25);
        joinGroupTextField.setBounds(140, 345, 120, 25);
        joinGroupBtn.setBounds(270, 345, 120, 25);
        groupJT.setBounds(10, 380, 380, 200);
        messageTextField.setBounds(10, 600, 180, 25);
        sendMessageBtn.setBounds(210, 600, 180, 25);
        sentMessagesBtn.setBounds(10, 635, 180, 25);
        recivedMessagesBtn.setBounds(210, 635, 180, 25);

        frame.add(userIdlable);
        frame.add(userId);
        frame.add(showUserGroups);
        frame.add(showFollowing);
        frame.add(showFollower);
        frame.add(followUserLable);
        frame.add(followUserTextField);
        frame.add(followUserBtn);
        frame.add(jt);
        frame.add(joinGroupLable);
        frame.add(joinGroupTextField);
        frame.add(joinGroupBtn);
        frame.add(groupJT);
        frame.add(messageTextField);
        frame.add(sendMessageBtn);
        frame.add(sentMessagesBtn);
        frame.add(recivedMessagesBtn);

        frame.setSize(400, 705);
        frame.setLayout(null);
        frame.setVisible(true);

        followUserBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User following = Pool.searchUser(followUserTextField.getText(), pool.getUsers());
                if (following == null || following.getId().equals(user.getId())) {
                    new TextInfo("user not found");
                } else {
                    following.setFollowers(user);
                    user.setFollowing(following);
                    new TextInfo("you follow " + followUserTextField.getText());
                }
            }
        });

        showFollowing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShowUsersList("Following :", user.getFollowings());
            }
        });
        showFollower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShowUsersList("Followers :", user.getFollowers());
            }
        });
        showUserGroups.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (user.getGroup() == null) {
                    new TextInfo(user.getId() + " has not group");
                } else {
                    new TextInfo(user.getId() + " group is " + user.getGroup().getId());
                }
            }
        });
        joinGroupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Group group = Pool.searchGroup(joinGroupTextField.getText(), pool.getGroups());
                Group beforeGroup = user.getGroup();
                if (group == null) {
                    new TextInfo("group not found");
                } else {
                    user.setGroup(group);
                    group.setUsers(user);
                    new TextInfo("you join to " + joinGroupTextField.getText());
                    if (beforeGroup != null)
                        beforeGroup.deleteUser(user);
                }

            }
        });
        sendMessageBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (messageTextField.getText().equals("")) {
                    new TextInfo("please write message");
                } else {
                    Message message = new Message(messageTextField.getText());
                    pool.addMessage(message);
                    user.setSentMessages(message);
                    message.setUser(user);
                    for (int i = 0; i < user.getFollowers().length; i++) {
                        user.getFollowers()[i].setRecivedMessages(message);

                        System.out.println("follower ; " + user.getFollowers()[i]);

                        for (int j = 0; j < user.getFollowers()[i].getRecivedMessages().length; j++)
                            System.out.println(user.getFollowers()[i].getRecivedMessages()[j]);

                    }
                    new TextInfo("message send to your followers");
                }
            }
        });
        sentMessagesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShowMessagesList("sent messages", user.getSentMessages());
            }
        });
        recivedMessagesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShowMessagesList("recived messages", user.getRecivedMessages());
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
    }

    /**
     * This method is used to create group tree
     *
     * @param group This is the first paramter
     * @return groupTree This returns groupTree.
     */
    private DefaultMutableTreeNode createTree(Group group) {
        DefaultMutableTreeNode groupTree = new DefaultMutableTreeNode(group.getId());
        if (group.getSubgroups().length != 0) {
            for (int i = 0; i < group.getSubgroups().length; i++) {
                groupTree.add(createTree(group.getSubgroups()[i]));
                for (int j = 0; j < group.getUsers().length; j++) {
                    DefaultMutableTreeNode user = new DefaultMutableTreeNode(group.getUsers()[i].getId());
                    groupTree.add(user);
                }
            }
        }
        return groupTree;
    }
}