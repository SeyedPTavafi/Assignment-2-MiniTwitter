package view;

import Group.Group;
import Pool.Pool;
import User.User;

import javax.swing.*;
import java.util.List;

public class AllGroups {
    JFrame frame;

    public AllGroups(Pool pool) {
        frame = new JFrame();

        for (int i = 0; i < pool.getGroups().toArray().length; i++) {
            Group group = (Group) pool.getGroups().get(i);
            JButton btn = new JButton(group.getId());
            int h = 25;
            int y = (h * i) + (10 * i) + 10;
            btn.setBounds(40, y, 120, h);
            frame.add(btn);

        }

        frame.setSize(200, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
