package view;

import User.User;

import javax.swing.*;

import Pool.Pool;

import java.awt.event.*;

import java.util.List;

public class AllUsers implements ActionListener {
    JFrame frame;

    public AllUsers(Pool pool) {
        frame = new JFrame();

        for (int i = 0; i < pool.getUsers().toArray().length; i++) {
            User user = (User) pool.getUsers().get(i);
            JButton btn = new JButton(user.getId());

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new UserView(pool,Pool.searchUser(btn.getText(), pool.getUsers()));
                }
            });

            int h = 25;
            int y = (h * i) + (10 * i) + 10;
            btn.setBounds(40, y, 120, h);
            frame.add(btn);
        }

        frame.setSize(200, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }
}
