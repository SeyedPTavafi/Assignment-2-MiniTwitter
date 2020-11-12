package view;

import javax.swing.*;

import Message.Message;

public class ShowMessagesList {
    JFrame frame;

    public ShowMessagesList(String text, Message[] messages) {
        frame = new JFrame();

        JLabel title = new JLabel(text);

        title.setBounds(40, 10, 180, 25);
        frame.add(title);

        for (int i = 0; i < messages.length; i++) {
            JLabel label = new JLabel(messages[i].getUser().getId() + " : " + messages[i].getMessage());

            int h = 25;
            int y = (h * (i + 1)) + (10 * (i + 1)) + 10;
            label.setBounds(40, y, 200, h);
            frame.add(label);
        }

        frame.setLocationRelativeTo(null);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
