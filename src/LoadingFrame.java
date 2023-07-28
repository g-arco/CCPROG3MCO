import javax.swing.*;
import java.awt.*;

public class LoadingFrame extends JFrame {

        public LoadingFrame(){

            JFrame load = new JFrame("Processing...");

            load.setSize(480, 480);
            load.setLayout(null);
            load.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon gifHaloHalo = new ImageIcon(getClass().getResource("/resources/halohalo_load.gif"));
            JLabel loadHaloHalo = new JLabel(gifHaloHalo);
            loadHaloHalo.setBounds(0, 0, 480, 480);

            String str = "Dispensing...";
            JLabel strOutput = new JLabel(str);//get string from model
            strOutput.setBounds(190, 50, 100, 60);
            strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
            strOutput.setForeground(Color.red);

            loadHaloHalo.add(strOutput);
            load.add(loadHaloHalo);


            load.setVisible(true);

        }

        public static void main(String args[])
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LoadingFrame().setVisible(true);
                }
            });

        }
    }

