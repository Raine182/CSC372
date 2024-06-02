package account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

public class MenuOrange {
    private static JTextArea textArea;
    private static Color initialColor;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem menuItem1 = new JMenuItem("Print Date and Time");
        JMenuItem menuItem2 = new JMenuItem("Write to File");
        JMenuItem menuItem3 = new JMenuItem("Change Background Color");
        JMenuItem menuItem4 = new JMenuItem("Exit");

        textArea = new JTextArea();
        initialColor = getRandomOrange();

        // Action listener for "Print Date and Time"
        menuItem1.addActionListener(e -> {
            String dateTime = LocalDateTime.now().toString();
            textArea.append(dateTime + "\n");
        });

        // Action listener for "Write to File"
        menuItem2.addActionListener(e -> {
            String content = textArea.getText();
            String fileName = getUserInput("Enter a filename (e.g., log.txt):");
            String savedFileName = writeToFile(fileName, content);
            textArea.append("File saved as: " + savedFileName + "\n");
        });

        // Action listener for "Change Background Color"
        menuItem3.addActionListener(e -> {
            textArea.setBackground(initialColor); // Set background color of the JTextArea
        });

        // Action listener for "Exit"
        menuItem4.addActionListener(e -> System.exit(0));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);

        // Create a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to the frame

        frame.setJMenuBar(menuBar);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static String writeToFile(String fileName, String text) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(text);
            return fileName; // Return the saved filename
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null; // Return null if an error occurs
        }
    }

    private static Color getRandomOrange() {
        Random random = new Random();
        float hue = random.nextFloat() * 30.0f; // Adjusted orange hue range
        float saturation = 0.9f; // full saturation
        float brightness = 1.0f; // bright color
        return Color.getHSBColor(hue, saturation, brightness);
    }

    private static String getUserInput(String prompt) {
        return JOptionPane.showInputDialog(null, prompt);
    }
}