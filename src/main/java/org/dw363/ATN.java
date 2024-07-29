package org.dw363;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATN extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JButton calculateButton;
    private JPanel panel;

    public ATN() {
        setTitle("ATN");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.ORANGE);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(50, 100, 100, 30);
        panel.add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(250, 100, 100, 30);
        panel.add(textField2);

        calculateButton = new JButton("Посчитать");
        calculateButton.setBounds(150, 150, 100, 30);
        panel.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());
                    int sum = num1 + num2;
                    JOptionPane.showMessageDialog(null, "Сумма: " + sum);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа.");
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ATN calculator = new ATN();
                calculator.setVisible(true);
            }
        });
    }
}