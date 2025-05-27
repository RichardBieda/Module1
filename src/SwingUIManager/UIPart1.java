package SwingUIManager;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UIPart1 {

    public static void main(String[] args) {

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
             System.out.println(info.getName() + " - " + info.getClassName());
        }
        System.out.println("------------------------------------");
        try {
             UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
         } catch (Exception e) {
             throw new RuntimeException(e);
         }

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = env.getAvailableFontFamilyNames();
        for (String fontName : fonts) {
            System.out.println(fontName);
        }

//        String uiLaF = "";
//
//        try (Scanner scan = new Scanner(System.in)){
//            uiLaF = scan.nextLine();
//             UIManager.setLookAndFeel(uiLaF);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }

        UIManager.put("Label.background", Color.ORANGE);

        SwingUtilities.invokeLater(() -> {
             JFrame frame = new JFrame("Test");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLayout(new GridLayout(0,2));
             frame.add(new JButton("Button"));
             JLabel label = new JLabel();
             label.setOpaque(true);
             frame.add(label);

             frame.setSize(300,200);
             frame.setVisible(true);
         });
    }
}
