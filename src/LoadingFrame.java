import javax.swing.*;

public class LoadingFrame extends JFrame {

    public LoadingFrame(){

        JFrame load = new JFrame("Processing...");

        load.setSize(300, 200);
        load.setLayout(null);
        load.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon gifHaloHalo = new ImageIcon();
        JLabel loadHaloHalo = new JLabel(gifHaloHalo);



        load.setVisible(true);

    }
}
