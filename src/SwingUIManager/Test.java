package SwingUIManager;

import javax.swing.*;

class Test {

     public static void main(String[] args) {

//         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//             System.out.println(info.getName() + " - " + info.getClassName());
//         }
//
//         try {
//             UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Test");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.add(new JButton("Button"));
//             frame.setSize(300,200);
//             frame.setVisible(true);
//         });

         UIDefaults defaults = UIManager.getLookAndFeelDefaults();
         for (Object key : defaults.keySet()) {
             System.out.println(key + " = " + defaults.get(key));
         }
     }
}
