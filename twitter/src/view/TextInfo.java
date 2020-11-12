package view;

import javax.swing.*;

public class TextInfo {
    JFrame textInfo;

    public TextInfo(String text) {
        textInfo = new JFrame();

        JLabel Text = new JLabel(text);

        Text.setBounds(140, 60, 400, 20);
        textInfo.add(Text);

        textInfo.setSize(400, 200);
        textInfo.setLocationRelativeTo(null);
        textInfo.setLayout(null);
        textInfo.setVisible(true);
    }
}
