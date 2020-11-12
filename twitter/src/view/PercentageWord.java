package view;

import Pool.Pool;

import javax.swing.*;

public class PercentageWord {
    JFrame frame;

    public PercentageWord(Pool pool) {
        frame = new JFrame();

        JLabel label1 = new JLabel("The positive percentage for good: "+pool.calculatePercentageWords("good"));
        JLabel label2 = new JLabel("The positive percentage for great: "+pool.calculatePercentageWords("great"));
        JLabel label3 = new JLabel("The positive percentage for excellent: "+pool.calculatePercentageWords("excellent"));
        label1.setBounds(10, 10, 400, 25);
        label2.setBounds(10, 45, 400, 25);
        label3.setBounds(10, 80, 400, 25);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}