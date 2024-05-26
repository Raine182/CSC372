package account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public class BirthDate {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Birthdate (yyyy-mm-dd)");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(180, 20, 165, 25);
        panel.add(userText);

        JButton calculateButton = new JButton("Calculate Age");
        calculateButton.setBounds(10, 80, 160, 25);
        panel.add(calculateButton);

        JLabel ageLabel = new JLabel("Your Age is: ");
        ageLabel.setBounds(10, 120, 160, 25);
        panel.add(ageLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthdate = userText.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dob = LocalDate.parse(birthdate, formatter);
                LocalDate now = LocalDate.now();
                Period period = Period.between(dob, now);
                ageLabel.setText("Your Age is: " + period.getYears());
            }
        });
    }
}