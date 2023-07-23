import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RVMFrame extends JFrame{

    JLabel imgBg;
    ImageIcon RVMbg;


    public RVMFrame(){
        int iceAmt;

        //https://youtu.be/QXVyg7lY9r8
        JFrame main = new JFrame("Main Menu");
        JLabel showWelcome = new JLabel("Welcome to Halo-Halo Zone");
        //JButton bthClick = new JButton();

        main.setSize(612, 612);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showWelcome.setBounds(0,0,612,30);
        showWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        showWelcome.setHorizontalAlignment(JLabel.CENTER);
        showWelcome.setForeground(Color.red);

        JLabel showDesc = new JLabel("<html> <center> You may customize your Halo-Halo by selecting items. <br/> Hover on items to see which are available " +
                "to purchase on their own and their respective name, price, and calorie count.</center> </html>", SwingConstants.CENTER);
        showDesc.setFont(new Font("Comic Sans MS",Font.PLAIN,8));
        showDesc.setVerticalAlignment(JLabel.TOP);
        showDesc.setHorizontalAlignment(JLabel.CENTER);
        showDesc.setForeground(Color.black);
        showDesc.setBounds(0,26,612,50);

        JButton btnCLick = new JButton();
        btnCLick.setBounds(410,218,42,55);
        btnCLick.setMargin(new Insets(0, 0, 0, 0));
        btnCLick.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        btnCLick.setText("Purchase");

        RVMbg = new ImageIcon(getClass().getResource("/resources/RVM_bg.jpg"));
        Image img = RVMbg.getImage();
        Image temp_img = img.getScaledInstance(612,612,Image.SCALE_SMOOTH);
        RVMbg = new ImageIcon(temp_img);
        imgBg = new JLabel("",RVMbg,JLabel.CENTER);

        ImageIcon iceImg = new ImageIcon(getClass().getResource("/resources/pixel_Ice.png"));
        JLabel pixelIce = new JLabel(iceImg);
        pixelIce.setBounds(203, 95, 40, 27); //paint coordinates; 208 (-28), 120(-18)
        pixelIce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Shaved Ice (PHP 5 || 0 Calories)", "Shaved Ice", JOptionPane.INFORMATION_MESSAGE, iceImg);
            }
        });

        JLabel iceAmtlb = new JLabel("Amount: ");
        iceAmtlb.setBounds(190, 120, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        iceAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        iceAmtlb.setForeground(Color.white);
        JTextField getIceAmt = new JTextField("0",1);
        getIceAmt.setBackground(Color.white);
        getIceAmt.setForeground(Color.black);
        getIceAmt.setBounds(218, 125, 40, 13);
        getIceAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String iceAmtStr = getIceAmt.getText();
        //iceAmt = Integer.parseInt(iceAmtStr);

        //====================================================================================
        ImageIcon evamilkImg = new ImageIcon(getClass().getResource("/resources/pixel_Milk.png"));
        JLabel pixelEvaMilk = new JLabel(evamilkImg);
        pixelEvaMilk.setBounds(303, 85, 40, 40); //paint coordinates; 208 (-23), 120(-18)
        pixelEvaMilk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Evaporated Milk (PHP 25 || 80 Calories)", "Evaporated Milk", JOptionPane.INFORMATION_MESSAGE, evamilkImg);
            }
        });

        JLabel evamilkAmtlb = new JLabel("Amount: ");
        evamilkAmtlb.setBounds(290, 120, 40, 27); //to the right +100
        evamilkAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        evamilkAmtlb.setForeground(Color.white);
        JTextField getEvaMilkAmt = new JTextField("0",1);
        getEvaMilkAmt.setBackground(Color.white);
        getEvaMilkAmt.setForeground(Color.black);
        getEvaMilkAmt.setBounds(318, 125, 40, 13);
        getEvaMilkAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String evamilkAmtStr = getEvaMilkAmt.getText();
        //evamilkAmt = Integer.parseInt(iceAmtStr);

        //===============================================================================

        ImageIcon vanillaICImg = new ImageIcon(getClass().getResource("/resources/pixel_vanillaIC.png"));
        JLabel pixelVanillaIC = new JLabel(vanillaICImg);
        pixelVanillaIC.setBounds(203, 157, 40, 40); //+72 down
        pixelVanillaIC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Vanilla Ice Cream (PHP 25 || 111 Calories)", "Vanilla Ice Cream", JOptionPane.INFORMATION_MESSAGE, vanillaICImg);
            }
        });

        JLabel vanillaICAmtlb = new JLabel("Amount: ");
        vanillaICAmtlb.setBounds(190, 192, 40, 27); //to the right +100
        vanillaICAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        vanillaICAmtlb.setForeground(Color.white);
        JTextField getVanillaICAmt = new JTextField("0",1);
        getVanillaICAmt.setBackground(Color.white);
        getVanillaICAmt.setForeground(Color.black);
        getVanillaICAmt.setBounds(218, 197, 40, 13);
        getVanillaICAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String vanillaICAmtStr = getVanillaICAmt.getText();
        //vanillaICAmtStr = Integer.parseInt(iceAmtStr);
//=====================================================================================================
        ImageIcon rcImg = new ImageIcon(getClass().getResource("/resources/pixel_RiceKrispies.png"));
        JLabel pixelRC = new JLabel(rcImg);
        pixelRC.setBounds(303, 157, 50, 40); //+72 down
        pixelRC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Rice Krispie (PHP 10 || 10 Calories)", "Rice Krispie", JOptionPane.INFORMATION_MESSAGE, rcImg);
            }
        });

        JLabel rcAmtlb = new JLabel("Amount: ");
        rcAmtlb.setBounds(290, 192, 40, 27); //to the right +100
        rcAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        rcAmtlb.setForeground(Color.white);
        JTextField getRCAmt = new JTextField("0",1);
        getRCAmt.setBackground(Color.white);
        getRCAmt.setForeground(Color.black);
        getRCAmt.setBounds(318, 197, 40, 13);
        getRCAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String rcAmtStr = getEvaMilkAmt.getText();
        //rcAmtStr = Integer.parseInt(iceAmtStr);

        //===============================================================================================

        ImageIcon bananaImg = new ImageIcon(getClass().getResource("/resources/pixel_banana.png"));
        JLabel pixelBanana = new JLabel(bananaImg);
        pixelBanana.setBounds(203, 232, 40, 40); //+75 down
        pixelBanana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Banana (PHP 10 || 8 Calories)", "Banana", JOptionPane.INFORMATION_MESSAGE, bananaImg);
            }
        });

        JLabel bananaAmtlb = new JLabel("Amount: ");
        bananaAmtlb.setBounds(190, 267, 40, 27); //to the right +100
        bananaAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        bananaAmtlb.setForeground(Color.white);
        JTextField getBananaAmt = new JTextField("0",1);
        getBananaAmt.setBackground(Color.white);
        getBananaAmt.setForeground(Color.black);
        getBananaAmt.setBounds(218, 272, 40, 13);
        getBananaAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String bananaAmtStr = getBananaAmt.getText();
        //bananaAmt = Integer.parseInt(iceAmtStr);


//=====================================================================================================

        ImageIcon coconutImg = new ImageIcon(getClass().getResource("/resources/pixel_coconut.png"));
        JLabel pixelCoconut = new JLabel(coconutImg);
        pixelCoconut.setBounds(303, 232, 40, 40); //+75 down
        pixelCoconut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Coconut (PHP 15 || 17 Calories)", "Coconut", JOptionPane.INFORMATION_MESSAGE, coconutImg);
            }
        });

        JLabel coconutAmtlb = new JLabel("Amount: ");
        coconutAmtlb.setBounds(290, 267, 40, 27); //to the right +100
        coconutAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        coconutAmtlb.setForeground(Color.white);
        JTextField getCoconutAmt = new JTextField("0",1);
        getCoconutAmt.setBackground(Color.white);
        getCoconutAmt.setForeground(Color.black);
        getCoconutAmt.setBounds(318, 272, 40, 13);
        getCoconutAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String coconutAmtStr = getEvaMilkAmt.getText();
        //rcAmtStr = Integer.parseInt(iceAmtStr);

        //=====================================================================================================================

        ImageIcon monggoImg = new ImageIcon(getClass().getResource("/resources/pixel_mungbeans.png"));
        JLabel pixelMonggo = new JLabel(monggoImg);
        pixelMonggo.setBounds(203, 310, 40, 40); //+78 down
        pixelMonggo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Mung Beans (PHP 15 || 12 Calories)", "Mung Beans", JOptionPane.INFORMATION_MESSAGE, monggoImg);
            }
        });

        JLabel monngoAmtlb = new JLabel("Amount: ");
        monngoAmtlb.setBounds(190, 346, 40, 27); //to the right +100
        monngoAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        monngoAmtlb.setForeground(Color.white);
        JTextField getMonggoAmt = new JTextField("0",1);
        getMonggoAmt.setBackground(Color.white);
        getMonggoAmt.setForeground(Color.black);
        getMonggoAmt.setBounds(218, 350, 40, 13);
        getMonggoAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String monggoAmtStr = getMonggoAmt.getText();
        //monggoAmt = Integer.parseInt(iceAmtStr);

        //=======================================================================================================================

        ImageIcon ubeImg = new ImageIcon(getClass().getResource("/resources/pixel_ube.png"));
        JLabel pixelUbe = new JLabel(ubeImg);
        pixelUbe.setBounds(303, 310, 40, 40); //+72 down
        pixelUbe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(main, "Purple Yam (PHP 15 || 15 Calories)", "Purple Yam", JOptionPane.INFORMATION_MESSAGE, ubeImg);
            }
        });

        JLabel ubeAmtlb = new JLabel("Amount: ");
        ubeAmtlb.setBounds(290, 346, 40, 27); //to the right +100
        ubeAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        ubeAmtlb.setForeground(Color.white);
        JTextField getUbeAmt = new JTextField("0",1);
        getUbeAmt.setBackground(Color.white);
        getUbeAmt.setForeground(Color.black);
        getUbeAmt.setBounds(318, 350, 40, 13);
        getUbeAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String ubeAmtStr = getEvaMilkAmt.getText();
        //rcAmtStr = Integer.parseInt(iceAmtStr);

        //=======================================================================================================================

        JButton btnMaintenance = new JButton("Maintenance Mode");
        btnMaintenance.setBounds(250, 550,120,20);
        btnMaintenance.setMargin(new Insets(0,0,0,0));
        btnMaintenance.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));



        imgBg.add(pixelIce);
        imgBg.add(iceAmtlb);
        imgBg.add(getIceAmt);

        imgBg.add(pixelEvaMilk);
        imgBg.add(evamilkAmtlb);
        imgBg.add(getEvaMilkAmt);

        imgBg.add(pixelVanillaIC);
        imgBg.add(vanillaICAmtlb);
        imgBg.add(getVanillaICAmt);

        imgBg.add(pixelRC);
        imgBg.add(rcAmtlb);
        imgBg.add(getRCAmt);

        imgBg.add(pixelBanana);
        imgBg.add(bananaAmtlb);
        imgBg.add(getBananaAmt);

        imgBg.add(pixelCoconut);
        imgBg.add(coconutAmtlb);
        imgBg.add(getCoconutAmt);

        imgBg.add(pixelMonggo);
        imgBg.add(monngoAmtlb);
        imgBg.add(getMonggoAmt);

        imgBg.add(pixelUbe);
        imgBg.add(ubeAmtlb);
        imgBg.add(getUbeAmt);

        imgBg.add(btnCLick);
        imgBg.add(btnMaintenance);
        imgBg.add(showWelcome);
        imgBg.add(showDesc);
        imgBg.setBounds(0,0,600,600);
        main.add(imgBg);

        main.setVisible(true);


    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RVMFrame().setVisible(true);
            }
        });

    }


}
