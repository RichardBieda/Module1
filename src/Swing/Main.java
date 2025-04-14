package Swing;

import javax.swing.*;
import java.awt.*;

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
    }
}
