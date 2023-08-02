package view;

import controllers.MaintenanceController;
import controllers.RVMController;
import model.ItemSlot;
import model.MoneySlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RVMFrame extends JFrame{

    JLabel imgBg;
    ImageIcon RVMbg;

    RVMController controller;
    ArrayList<MoneySlot> moneyCurr;
    ArrayList<ItemSlot> itemsCurr;
    JFrame main;



    public RVMFrame(ArrayList<ItemSlot> itemsCurr, ArrayList<MoneySlot> moneyCurr, RVMController controller){

        this.controller = controller;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;

        //https://youtu.be/QXVyg7lY9r8
        main = new JFrame("Regular Main Menu");
        JLabel showWelcome = new JLabel("Welcome to Halo-Halo Zone");
        JButton bthClick = new JButton();

        main.setSize(612, 612);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showWelcome.setBounds(0,0,612,30);
        showWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        showWelcome.setHorizontalAlignment(JLabel.CENTER);
        showWelcome.setForeground(Color.red);

        JLabel showDesc = new JLabel("<html> <center> You may choose your items by hovering on them. <br/> See " +
                "their respective name, price, and calorie count on the pop-up messages.</center> </html>", SwingConstants.CENTER);
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
        int icePrice = this.itemsCurr.get(0).getItem().getPrice();
        pixelIce.setBounds(203, 95, 40, 27); //paint coordinates; 208 (-28), 120(-18)
        pixelIce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Shaved Ice (PHP "+icePrice+"|| 0 Calories)", "Shaved Ice",  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iceImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(0))==true)
                        controller.pushedGet(icePrice,controller.getItemsCurr().get(0));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        JLabel iceStocklb = new JLabel("In-Stock: ");
        iceStocklb.setBounds(205, 120, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        iceStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        iceStocklb.setForeground(Color.white);
        JLabel availIcelb = new JLabel(this.itemsCurr.get(0).getQuantity()+"");
        availIcelb.setForeground(Color.white);
        availIcelb.setBounds(243, 120, 40, 27);
        availIcelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //====================================================================================
        ImageIcon evamilkImg = new ImageIcon(getClass().getResource("/resources/pixel_Milk.png"));
        JLabel pixelEvaMilk = new JLabel(evamilkImg);
        int evamilkPrice = this.itemsCurr.get(1).getItem().getPrice();
        pixelEvaMilk.setBounds(303, 85, 40, 40); //paint coordinates; 208 (-23), 120(-18)
        pixelEvaMilk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Evaporated Milk (PHP "+evamilkPrice+" || 80 Calories)", "Evaporated Milk", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, evamilkImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(1))==true)
                       controller.pushedGet(evamilkPrice,controller.getItemsCurr().get(1));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel evamilkStocklb = new JLabel("In-Stock: ");
        evamilkStocklb.setBounds(304, 120, 40, 27); //+102 to the right
        evamilkStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        evamilkStocklb.setForeground(Color.white);
        JLabel availEvaMilklb = new JLabel(this.itemsCurr.get(1).getQuantity()+"");
        availEvaMilklb.setForeground(Color.white);
        availEvaMilklb.setBounds(342, 120, 40, 27);
        availEvaMilklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //===============================================================================

        ImageIcon vanillaICImg = new ImageIcon(getClass().getResource("/resources/pixel_vanillaIC.png"));
        JLabel pixelVanillaIC = new JLabel(vanillaICImg);
        int vanillaICPrice = this.itemsCurr.get(2).getItem().getPrice();
        pixelVanillaIC.setBounds(203, 157, 40, 40); //+72 down
        pixelVanillaIC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Vanilla Ice Cream (PHP  "+vanillaICPrice+" || 111 Calories)", "Vanilla Ice Cream", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, vanillaICImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(2))==true)
                        controller.pushedGet(vanillaICPrice,controller.getItemsCurr().get(2));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel vanillaICStocklb = new JLabel("In-Stock: ");
        vanillaICStocklb.setBounds(205, 192, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        vanillaICStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        vanillaICStocklb.setForeground(Color.white);
        JLabel availVanillaIClb = new JLabel(this.itemsCurr.get(2).getQuantity()+"");
        availVanillaIClb.setForeground(Color.white);
        availVanillaIClb.setBounds(243, 192, 40, 27);
        availVanillaIClb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

//=====================================================================================================
        ImageIcon rkImg = new ImageIcon(getClass().getResource("/resources/pixel_RiceKrispies.png"));
        JLabel pixelRK = new JLabel(rkImg);
        int rkPrice = this.itemsCurr.get(3).getItem().getPrice();
        pixelRK.setBounds(303, 157, 50, 40); //+72 down
        pixelRK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Rice Krispie (PHP "+rkPrice+" || 10 Calories)", "Rice Krispie" , JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, rkImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(3))==true)
                        controller.pushedGet(rkPrice,controller.getItemsCurr().get(3));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        JLabel rkStocklb = new JLabel("In-Stock: ");
        rkStocklb.setBounds(304, 192, 40, 27); //+102 to the right
        rkStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        rkStocklb.setForeground(Color.white);
        JLabel availRKlb = new JLabel(this.itemsCurr.get(3).getQuantity()+"");
        availRKlb.setForeground(Color.white);
        availRKlb.setBounds(342, 192, 40, 27);
        availRKlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //===============================================================================================

        ImageIcon bananaImg = new ImageIcon(getClass().getResource("/resources/pixel_banana.png"));
        JLabel pixelBanana = new JLabel(bananaImg);
        int bananaPrice = this.itemsCurr.get(4).getItem().getPrice();
        pixelBanana.setBounds(203, 232, 40, 40); //+75 down
        pixelBanana.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Banana (PHP "+bananaPrice+"  || 8 Calories)", "Banana",  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, bananaImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(4))==true)
                        controller.pushedGet(bananaPrice,controller.getItemsCurr().get(4));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        JLabel bananaStocklb = new JLabel("In-Stock: ");
        bananaStocklb.setBounds(205, 267, 40, 27); //paint coordinates; 208 (-23), 120(-18)
        bananaStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        bananaStocklb.setForeground(Color.white);
        JLabel availBananalb = new JLabel(this.itemsCurr.get(4).getQuantity()+"");
        availBananalb.setForeground(Color.white);
        availBananalb.setBounds(243, 267, 40, 27);
        availBananalb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

//=====================================================================================================

        ImageIcon coconutImg = new ImageIcon(getClass().getResource("/resources/pixel_coconut.png"));
        JLabel pixelCoconut = new JLabel(coconutImg);
        int coconutPrice = this.itemsCurr.get(5).getItem().getPrice();
        pixelCoconut.setBounds(303, 232, 40, 40); //+75 down
        pixelCoconut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Coconut (PHP "+coconutPrice+" || 17 Calories)", "Coconut", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, coconutImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(5))==true)
                        controller.pushedGet(coconutPrice,controller.getItemsCurr().get(5));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel coconutStocklb = new JLabel("In-Stock: ");
        coconutStocklb.setBounds(304, 267, 40, 27); //+102 to the right
        coconutStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        coconutStocklb.setForeground(Color.white);
        JLabel availCoconutlb = new JLabel(this.itemsCurr.get(5).getQuantity()+"");
        availCoconutlb.setForeground(Color.white);
        availCoconutlb.setBounds(342, 267, 40, 27);
        availCoconutlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //=====================================================================================================================

        ImageIcon monggoImg = new ImageIcon(getClass().getResource("/resources/pixel_mungbeans.png"));
        JLabel pixelMonggo = new JLabel(monggoImg);
        int monggoPrice = this.itemsCurr.get(6).getItem().getPrice();
        pixelMonggo.setBounds(203, 311, 40, 40); //+79 down
        pixelMonggo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Mung Beans (PHP "+monggoPrice+" || 12 Calories)", "Mung Beans", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, monggoImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(6))==true)
                        controller.pushedGet(monggoPrice,controller.getItemsCurr().get(6));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel monggoStocklb = new JLabel("In-Stock: ");
        monggoStocklb.setBounds(205, 346, 40, 27); //+102 to the right
        monggoStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        monggoStocklb.setForeground(Color.white);
        JLabel availMonggolb = new JLabel(this.itemsCurr.get(6).getQuantity()+"");
        availMonggolb.setForeground(Color.white);
        availMonggolb.setBounds(243, 346, 40, 27);
        availMonggolb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));

        //=======================================================================================================================

        ImageIcon ubeImg = new ImageIcon(getClass().getResource("/resources/pixel_ube.png"));
        JLabel pixelUbe = new JLabel(ubeImg);
        int ubePrice = this.itemsCurr.get(7).getItem().getPrice();
        pixelUbe.setBounds(303, 311, 40, 40); //+79 down
        pixelUbe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String options[] ={"Get Item", "Go back"};
                int choice = JOptionPane.showOptionDialog(main, "Purple Yam (PHP "+ubePrice+" || 15 Calories)", "Purple Yam", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, ubeImg, options,options[1]);
                if (choice == 0)
                {
                    if(controller.isAvailable(itemsCurr.get(7))==true)
                        controller.pushedGet(ubePrice,controller.getItemsCurr().get(7));
                    else
                        JOptionPane.showMessageDialog(main,"No more stock! Please try another item", "Stock Empty", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel ubeStocklb = new JLabel("In-Stock: ");
        ubeStocklb.setBounds(304, 346, 40, 27); //+102 to the right
        ubeStocklb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
        ubeStocklb.setForeground(Color.white);
        JLabel availUbelb = new JLabel(this.itemsCurr.get(7).getQuantity()+"");
        availUbelb.setForeground(Color.white);
        availUbelb.setBounds(342, 346, 40, 27);
        availUbelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));


        //=======================================================================================================================

        JButton btnMaintenance = new JButton("Maintenance Mode");
        btnMaintenance.setBounds(250, 550,120,20);
        btnMaintenance.setMargin(new Insets(0,0,0,0));
        btnMaintenance.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnMaintenance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.pushedMaintenanceBtn();
            }
        });

        JButton btnSwitch = new JButton("Switch to Special Vending Machine");
        btnSwitch.setBounds(488, 250,74,80);
        btnSwitch.setMargin(new Insets(0,0,0,0));
        btnSwitch.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnSwitch.setText("<html><center>Switch to Special<br/> Vending Machine </center> </html>");
        btnSwitch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.pushedSwitchBtn();
            }
        });


        imgBg.add(pixelIce);
        imgBg.add(iceStocklb);
        imgBg.add(availIcelb);

        imgBg.add(pixelEvaMilk);
        imgBg.add(evamilkStocklb);
        imgBg.add(availEvaMilklb);

        imgBg.add(pixelVanillaIC);
        imgBg.add(vanillaICStocklb);
        imgBg.add(availVanillaIClb);

        imgBg.add(pixelRK);
        imgBg.add(rkStocklb);
        imgBg.add(availRKlb);

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
        imgBg.add(btnSwitch);
        imgBg.add(btnMaintenance);
        imgBg.add(showWelcome);
        imgBg.add(showDesc);
        imgBg.setBounds(0,0,600,600);
        main.add(imgBg);

        main.setVisible(true);


    }

    public JFrame getFrame() {
        return main;
    }
}
