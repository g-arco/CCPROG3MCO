import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MaintenanceFrame extends JFrame{

    JLabel imgBg;
    ImageIcon RVMbg;


    public MaintenanceFrame(){
        int iceAmt;

        //https://youtu.be/QXVyg7lY9r8
        JFrame maintenance = new JFrame("Maintenance Menu");
        JLabel showWelcome = new JLabel("Maintenance Mode");

        maintenance.setSize(612, 612);
        maintenance.setLayout(null);
        maintenance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showWelcome.setBounds(0,0,612,30);
        showWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        showWelcome.setHorizontalAlignment(JLabel.CENTER);
        showWelcome.setForeground(Color.red);

        JLabel showDesc = new JLabel("<html> <center> Choose a maintenance action. <br/> Hover on items to see item details. <center> </html>", SwingConstants.CENTER);
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
                JOptionPane.showMessageDialog(maintenance, "Shaved Ice (PHP 5 || 0 Calories)", "Shaved Ice", JOptionPane.INFORMATION_MESSAGE, iceImg);
            }
        });


        JLabel iceStocklb = new JLabel("In-Stock: ");
        iceStocklb.setBounds(205, 120, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        iceStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        iceStocklb.setForeground(Color.white);
        JLabel availIcelb = new JLabel("0");
        availIcelb.setForeground(Color.white);
        availIcelb.setBounds(243, 120, 40, 27);
        availIcelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //====================================================================================
        ImageIcon evamilkImg = new ImageIcon(getClass().getResource("/resources/pixel_Milk.png"));
        JLabel pixelEvaMilk = new JLabel(evamilkImg);
        pixelEvaMilk.setBounds(303, 85, 40, 40); //paint coordinates; 208 (-23), 120(-18)
        pixelEvaMilk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Evaporated Milk (PHP 25 || 80 Calories)", "Evaporated Milk", JOptionPane.INFORMATION_MESSAGE, evamilkImg);
            }
        });

        JLabel evamilkStocklb = new JLabel("In-Stock: ");
        evamilkStocklb.setBounds(304, 120, 40, 27); //+102 to the right
        evamilkStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        evamilkStocklb.setForeground(Color.white);
        JLabel availEvaMilklb = new JLabel("0");
        availEvaMilklb.setForeground(Color.white);
        availEvaMilklb.setBounds(342, 120, 40, 27);
        availEvaMilklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //===============================================================================

        ImageIcon vanillaICImg = new ImageIcon(getClass().getResource("/resources/pixel_vanillaIC.png"));
        JLabel pixelVanillaIC = new JLabel(vanillaICImg);
        pixelVanillaIC.setBounds(203, 157, 40, 40); //+72 down
        pixelVanillaIC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Vanilla Ice Cream (PHP 25 || 111 Calories)", "Vanilla Ice Cream", JOptionPane.INFORMATION_MESSAGE, vanillaICImg);
            }
        });

        JLabel vanillaICStocklb = new JLabel("In-Stock: ");
        vanillaICStocklb.setBounds(205, 192, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        vanillaICStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        vanillaICStocklb.setForeground(Color.white);
        JLabel availVanillaIClb = new JLabel("0");
        availVanillaIClb.setForeground(Color.white);
        availVanillaIClb.setBounds(243, 192, 40, 27);
        availVanillaIClb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

//=====================================================================================================
        ImageIcon rcImg = new ImageIcon(getClass().getResource("/resources/pixel_RiceKrispies.png"));
        JLabel pixelRC = new JLabel(rcImg);
        pixelRC.setBounds(303, 157, 50, 40); //+72 down
        pixelRC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Rice Krispie (PHP 10 || 10 Calories)", "Rice Krispie", JOptionPane.INFORMATION_MESSAGE, rcImg);
            }
        });

        JLabel rcStocklb = new JLabel("In-Stock: ");
        rcStocklb.setBounds(304, 192, 40, 27); //+102 to the right
        rcStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        rcStocklb.setForeground(Color.white);
        JLabel availRClb = new JLabel("0");
        availRClb.setForeground(Color.white);
        availRClb.setBounds(342, 192, 40, 27);
        availRClb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //===============================================================================================

        ImageIcon bananaImg = new ImageIcon(getClass().getResource("/resources/pixel_banana.png"));
        JLabel pixelBanana = new JLabel(bananaImg);
        pixelBanana.setBounds(203, 232, 40, 40); //+75 down
        pixelBanana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Banana (PHP 10 || 8 Calories)", "Banana", JOptionPane.INFORMATION_MESSAGE, bananaImg);
            }
        });

        JLabel bananaStocklb = new JLabel("In-Stock: ");
        bananaStocklb.setBounds(205, 267, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        bananaStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        bananaStocklb.setForeground(Color.white);
        JLabel availBananalb = new JLabel("0");
        availBananalb.setForeground(Color.white);
        availBananalb.setBounds(243, 267, 40, 27);
        availBananalb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

//=====================================================================================================

        ImageIcon coconutImg = new ImageIcon(getClass().getResource("/resources/pixel_coconut.png"));
        JLabel pixelCoconut = new JLabel(coconutImg);
        pixelCoconut.setBounds(303, 232, 40, 40); //+75 down
        pixelCoconut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Coconut (PHP 15 || 17 Calories)", "Coconut", JOptionPane.INFORMATION_MESSAGE, coconutImg);
            }
        });

        JLabel coconutStocklb = new JLabel("In-Stock: ");
        coconutStocklb.setBounds(304, 267, 40, 27); //+102 to the right
        coconutStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        coconutStocklb.setForeground(Color.white);
        JLabel availCoconutlb = new JLabel("0");
        availCoconutlb.setForeground(Color.white);
        availCoconutlb.setBounds(342, 267, 40, 27);
        availCoconutlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //=====================================================================================================================

        ImageIcon monggoImg = new ImageIcon(getClass().getResource("/resources/pixel_mungbeans.png"));
        JLabel pixelMonggo = new JLabel(monggoImg);
        pixelMonggo.setBounds(203, 311, 40, 40); //+79 down
        pixelMonggo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Mung Beans (PHP 15 || 12 Calories)", "Mung Beans", JOptionPane.INFORMATION_MESSAGE, monggoImg);
            }
        });

        JLabel monggoStocklb = new JLabel("In-Stock: ");
        monggoStocklb.setBounds(205, 346, 40, 27); //+102 to the right
        monggoStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        monggoStocklb.setForeground(Color.white);
        JLabel availMonggolb = new JLabel("0");
        availMonggolb.setForeground(Color.white);
        availMonggolb.setBounds(243, 346, 40, 27);
        availMonggolb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //=======================================================================================================================

        ImageIcon ubeImg = new ImageIcon(getClass().getResource("/resources/pixel_ube.png"));
        JLabel pixelUbe = new JLabel(ubeImg);
        pixelUbe.setBounds(303, 311, 40, 40); //+79 down
        pixelUbe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(maintenance, "Purple Yam (PHP 15 || 15 Calories)", "Purple Yam", JOptionPane.INFORMATION_MESSAGE, ubeImg);
            }
        });

        JLabel ubeStocklb = new JLabel("In-Stock: ");
        ubeStocklb.setBounds(304, 346, 40, 27); //+102 to the right
        ubeStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        ubeStocklb.setForeground(Color.white);
        JLabel availUbelb = new JLabel("0");
        availUbelb.setForeground(Color.white);
        availUbelb.setBounds(342, 346, 40, 27);
        availUbelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //=======================================================================================================================

        JButton btnRestock = new JButton();
        btnRestock.setBounds(488, 100,74,80);
        btnRestock.setMargin(new Insets(0,0,0,0));
        btnRestock.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnRestock.setText("<html><center> Restock <br/> an Item</center></html>");

        JButton btnSetPHP = new JButton("Set Price of an Item");
        btnSetPHP.setBounds(488, 200,74,80);//+100 down
        btnSetPHP.setMargin(new Insets(0,0,0,0));
        btnSetPHP.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnSetPHP.setText("<html><center>Set <br/> Price <br/> of an Item</center> </html>");

        JButton btnCollectPHP = new JButton("Collect ALL Money");
        btnCollectPHP.setBounds(488, 300,74,80);
        btnCollectPHP.setMargin(new Insets(0,0,0,0));
        btnCollectPHP.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnCollectPHP.setText("<html><center>Collect <br/> ALL Money </center> </html>");

        JButton btnPrint = new JButton("Print Summary of Transactions");
        btnPrint.setBounds(488, 400,74,80);
        btnPrint.setMargin(new Insets(0,0,0,0));
        btnPrint.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnPrint.setText("<html><center>Print <br/> Summary of <br/> Transactions </center> </html>");



        JButton btnMain = new JButton(" Back to RVM Mode");
        btnMain.setBounds(250, 550,120,20);
        btnMain.setMargin(new Insets(0,0,0,0));
        btnMain.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));



        imgBg.add(pixelIce);
        imgBg.add(iceStocklb);
        imgBg.add(availIcelb);

        imgBg.add(pixelEvaMilk);
        imgBg.add(evamilkStocklb);
        imgBg.add(availEvaMilklb);

        imgBg.add(pixelVanillaIC);
        imgBg.add(vanillaICStocklb);
        imgBg.add(availVanillaIClb);

        imgBg.add(pixelRC);
        imgBg.add(rcStocklb);
        imgBg.add(availRClb);

        imgBg.add(pixelBanana);
        imgBg.add(bananaStocklb);
        imgBg.add(availBananalb);

        imgBg.add(pixelCoconut);
        imgBg.add(coconutStocklb);
        imgBg.add(availCoconutlb);


        imgBg.add(pixelMonggo);
        imgBg.add(monggoStocklb);
        imgBg.add(availMonggolb);

        imgBg.add(pixelUbe);
        imgBg.add(ubeStocklb);
        imgBg.add(availUbelb);

        imgBg.add(btnCLick);
        imgBg.add(btnRestock);
        imgBg.add(btnSetPHP);
        imgBg.add(btnCollectPHP);
        imgBg.add(btnPrint);

        imgBg.add(btnMain);
        imgBg.add(showWelcome);
        imgBg.add(showDesc);
        imgBg.setBounds(0,0,600,600);
        maintenance.add(imgBg);

        maintenance.setVisible(true);


    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MaintenanceFrame().setVisible(true);
            }
        });

    }
    
}
