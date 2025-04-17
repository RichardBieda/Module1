package Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Main {

    public static void main(String[] args) {


        JFrame frame = new JFrame(); //new Frame
        frame.setTitle("Main Frame"); //sets the window title
        frame.setVisible(true); // makes it visible
        frame.setSize(1200, 800); //set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits the application
        frame.setResizable(true); //makes the window resizable

        ImageIcon image = new ImageIcon("src\\Swing\\paper-plane.png"); //creates a new icon file
        frame.setIconImage(image.getImage()); //sets the new icon

        //Changing colors
        //frame.getContentPane().setBackground(Color.lightGray);
        //hexadecimal colors
        //frame.setBackground(new Color(0xFFFFFF));
        //colors  from 0 to 255 red green blue
        frame.getContentPane().setBackground(new Color(230, 230, 230));

        ImageIcon rundesding = new ImageIcon("src\\Swing\\rundesding.png");
        Border border = BorderFactory.createLineBorder(Color.magenta, 3);
        JLabel label = new JLabel();
        label.setText("Hello");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIcon(rundesding);
        label.setForeground(new Color(10, 100, 255));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(0);
        label.setBackground(new Color(0,255,0));
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.setLayout(null);
        label.setBounds(0,0,600, 400);
//        frame.pack(); sets a combined layout
        frame.add(label);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(600,400,600,400);
        frame.add(redPanel);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(0,400,600,400);
        frame.add(bluePanel);

        JLabel label1 = new JLabel();
        label1.setText("New label");
        label1.setFont(new Font("MV Boli", Font.LAYOUT_RIGHT_TO_LEFT, 80));
        bluePanel.add(label1);
    }
}
