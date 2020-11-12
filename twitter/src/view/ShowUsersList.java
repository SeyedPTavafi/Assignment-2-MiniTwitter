package view;

import javax.swing.*;

import User.User;

public class ShowUsersList {
    JFrame frame;

    public ShowUsersList(String text, User[] users) {
        frame = new JFrame();

        JLabel title = new JLabel(text);

        title.setBounds(40, 10, 120, 25);
        frame.add(title);

        for (int i = 0; i < users.length; i++) {
            JLabel label = new JLabel(users[i].getId());

            int h = 25;
            int y = (h * (i + 1)) + (10 * (i + 1)) + 10;
            label.setBounds(40, y, 120, h);
            frame.add(label);
        }

        frame.setLocationRelativeTo(null);
        frame.setSize(200, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
