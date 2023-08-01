package view;

import controllers.MaintenanceController;
import model.ItemSlot;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class RestockItemFrame extends JFrame{

        JLabel imgBg;
        ImageIcon RVMbg;
        MaintenanceController controller;
        MaintenanceFrame sourceFrame;

        ArrayList<ItemSlot> itemsCurr;
        JFrame restockItem;
        int iceStock, evamilkStock,vanillaICStock,rkStock,bananaStock, coconutStock,monggoStock,ubeStock;

        public RestockItemFrame(MaintenanceFrame sourceFrame, MaintenanceController controller, ArrayList<ItemSlot> itemsCurr){
            int iceAmt;
            this.controller = controller;
            this.sourceFrame = sourceFrame;
            this.itemsCurr = itemsCurr;


            //https://youtu.be/QXVyg7lY9r8
            restockItem = new JFrame("Restock Items");
            JLabel showWelcome = new JLabel("Restock Items");
            //JButton bthClick = new JButton();

            restockItem.setSize(612, 612);
            restockItem.setLayout(null);
            restockItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            showWelcome.setBounds(0,0,612,30);
            showWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            showWelcome.setHorizontalAlignment(JLabel.CENTER);
            showWelcome.setForeground(Color.red);

            JLabel showDesc = new JLabel("<html> <center> Input the AMOUNT OF STOCK YOU WAN TO ADD! <br/> Hover on items to see item details. </center> </html>", SwingConstants.CENTER);
            showDesc.setFont(new Font("Comic Sans MS",Font.PLAIN,8));
            showDesc.setVerticalAlignment(JLabel.TOP);
            showDesc.setHorizontalAlignment(JLabel.CENTER);
            showDesc.setForeground(Color.black);
            showDesc.setBounds(0,26,612,50);


            RVMbg = new ImageIcon(getClass().getResource("/resources/RVM_bg.jpg"));
            Image img = RVMbg.getImage();
            Image temp_img = img.getScaledInstance(612,612,Image.SCALE_SMOOTH);
            RVMbg = new ImageIcon(temp_img);
            imgBg = new JLabel("",RVMbg,JLabel.CENTER);

            ImageIcon iceImg = new ImageIcon(getClass().getResource("/resources/pixel_Ice.png"));
            JLabel pixelIce = new JLabel(iceImg);
            iceStock =this.itemsCurr.get(0).getQuantity();
            int icePrice = this.itemsCurr.get(0).getItem().getPrice();
            pixelIce.setBounds(203, 95, 40, 27); //paint coordinates; 208 (-28), 120(-18)
            pixelIce.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Shaved Ice (PHP "+icePrice+" || 0 Calories || In Stock: "+iceStock+")", "Shaved Ice", JOptionPane.INFORMATION_MESSAGE, iceImg);
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
            getIceAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String iceAmtStr = getIceAmt.getText();
                    int iceAmtInt=0;
                    mouseEntered(iceAmtStr,iceAmtInt,0);
                    iceStock=controller.getItemsCurr().get(0).getQuantity();

                }
            });

            //====================================================================================
            ImageIcon evamilkImg = new ImageIcon(getClass().getResource("/resources/pixel_Milk.png"));
            JLabel pixelEvaMilk = new JLabel(evamilkImg);
            evamilkStock = this.itemsCurr.get(1).getQuantity();
            int evamilkPrice = this.itemsCurr.get(1).getItem().getPrice();
            pixelEvaMilk.setBounds(303, 85, 40, 40); //paint coordinates; 208 (-23), 120(-18)
            pixelEvaMilk.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Evaporated Milk (PHP "+evamilkPrice+" || 80 Calories || In Stock: "+evamilkStock+")", "Evaporated Milk", JOptionPane.INFORMATION_MESSAGE, evamilkImg);
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
            getEvaMilkAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String evamilkAmtStr = getEvaMilkAmt.getText();
                    int evamilkAmtInt = 0;
                    mouseEntered(evamilkAmtStr,evamilkAmtInt,1);
                    evamilkStock=controller.getItemsCurr().get(1).getQuantity();

                }
            });

            //===============================================================================

            ImageIcon vanillaICImg = new ImageIcon(getClass().getResource("/resources/pixel_vanillaIC.png"));
            JLabel pixelVanillaIC = new JLabel(vanillaICImg);
            vanillaICStock = this.itemsCurr.get(2).getQuantity();
            int vanillaICPrice = this.itemsCurr.get(2).getItem().getPrice();
            pixelVanillaIC.setBounds(203, 157, 40, 40); //+72 down
            pixelVanillaIC.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Vanilla Ice Cream (PHP "+vanillaICPrice+" || 111 Calories || In Stock: "+vanillaICStock+")", "Vanilla Ice Cream", JOptionPane.INFORMATION_MESSAGE, vanillaICImg);
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
            getVanillaICAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String vanillaICAmtStr = getVanillaICAmt.getText();
                    int vanillaICAmtInt = 0;
                    mouseEntered(vanillaICAmtStr,vanillaICAmtInt,2);
                    vanillaICStock = controller.getItemsCurr().get(2).getQuantity();

                }
            });

//=====================================================================================================
            ImageIcon rkImg = new ImageIcon(getClass().getResource("/resources/pixel_RiceKrispies.png"));
            JLabel pixelRK = new JLabel(rkImg);
            rkStock =this.itemsCurr.get(3).getQuantity();
            int rkPrice = this.itemsCurr.get(3).getItem().getPrice();
            pixelRK.setBounds(303, 157, 50, 40); //+72 down
            pixelRK.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Rice Krispie (PHP "+rkPrice+" || 10 Calories || In Stock: "+rkStock+")", "Rice Krispie", JOptionPane.INFORMATION_MESSAGE, rkImg);
                }
            });

            JLabel rkAmtlb = new JLabel("Amount: ");
            rkAmtlb.setBounds(290, 192, 40, 27); //to the right +100
            rkAmtlb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            rkAmtlb.setForeground(Color.white);
            JTextField getRKAmt = new JTextField("0",1);
            getRKAmt.setBackground(Color.white);
            getRKAmt.setForeground(Color.black);
            getRKAmt.setBounds(318, 197, 40, 13);
            getRKAmt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
            getRKAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String rkAmtStr = getRKAmt.getText();
                    int rkAmtInt = 0;
                    mouseEntered(rkAmtStr,rkAmtInt,3);
                    rkStock = controller.getItemsCurr().get(3).getQuantity();

                }
            });

            //===============================================================================================

            ImageIcon bananaImg = new ImageIcon(getClass().getResource("/resources/pixel_banana.png"));
            JLabel pixelBanana = new JLabel(bananaImg);
            bananaStock = this.itemsCurr.get(4).getQuantity();
            int bananaPrice = this.itemsCurr.get(4).getItem().getPrice();
            pixelBanana.setBounds(203, 232, 40, 40); //+75 down
            pixelBanana.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Banana (PHP "+bananaPrice+" || 8 Calories || In Stock: "+bananaStock+")", "Banana", JOptionPane.INFORMATION_MESSAGE, bananaImg);
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
            getBananaAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String bananaAmtStr = getBananaAmt.getText();
                    int bananaAmtInt = 0;
                    mouseEntered(bananaAmtStr,bananaAmtInt,4);
                    bananaStock = controller.getItemsCurr().get(4).getQuantity();

                }
            });


//=====================================================================================================

            ImageIcon coconutImg = new ImageIcon(getClass().getResource("/resources/pixel_coconut.png"));
            JLabel pixelCoconut = new JLabel(coconutImg);
            coconutStock = this.itemsCurr.get(5).getQuantity();
            int coconutPrice = this.itemsCurr.get(5).getItem().getPrice();
            pixelCoconut.setBounds(303, 232, 40, 40); //+75 down
            pixelCoconut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Coconut (PHP "+coconutPrice+" || 17 Calories || In Stock: "+coconutStock+")", "Coconut", JOptionPane.INFORMATION_MESSAGE, coconutImg);
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
            getCoconutAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String coconutAmtStr = getCoconutAmt.getText();
                    int coconutAmtInt = 0;
                    mouseEntered(coconutAmtStr,coconutAmtInt,5);
                    coconutStock = controller.getItemsCurr().get(5).getQuantity();

                }
            });

            //=====================================================================================================================

            ImageIcon monggoImg = new ImageIcon(getClass().getResource("/resources/pixel_mungbeans.png"));
            JLabel pixelMonggo = new JLabel(monggoImg);
            monggoStock = this.itemsCurr.get(6).getQuantity();
            int monggoPrice = this.itemsCurr.get(6).getItem().getPrice();
            pixelMonggo.setBounds(203, 310, 40, 40); //+78 down
            pixelMonggo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Mung Beans (PHP "+monggoPrice+" || 12 Calories || In Stock: "+monggoStock+")", "Mung Beans", JOptionPane.INFORMATION_MESSAGE, monggoImg);
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
            getMonggoAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String monggoAmtStr = getMonggoAmt.getText();
                    int monggoAmtInt = 0;
                    mouseEntered(monggoAmtStr,monggoAmtInt,6);
                    monggoStock = controller.getItemsCurr().get(6).getQuantity();

                }
            });

            //=======================================================================================================================

            ImageIcon ubeImg = new ImageIcon(getClass().getResource("/resources/pixel_ube.png"));
            JLabel pixelUbe = new JLabel(ubeImg);
            ubeStock = this.itemsCurr.get(7).getQuantity();
            int ubePrice = this.itemsCurr.get(7).getItem().getPrice();
            pixelUbe.setBounds(303, 310, 40, 40); //+72 down
            pixelUbe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(restockItem, "Purple Yam (PHP "+ubePrice+" || 15 Calories || In Stock: "+ubeStock+")", "Purple Yam", JOptionPane.INFORMATION_MESSAGE, ubeImg);
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
            getUbeAmt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ubeAmtStr = getUbeAmt.getText();
                    int ubeAmtInt = 0;
                    mouseEntered(ubeAmtStr,ubeAmtInt,7);
                    monggoStock = controller.getItemsCurr().get(7).getQuantity();

                }
            });

            //=======================================================================================================================

            JButton btnDone = new JButton("Done Stocking");
            btnDone.setBounds(250, 550,120,20);
            btnDone.setMargin(new Insets(0,0,0,0));
            btnDone.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            btnDone.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    controller.pushedDone(restockItem, "restockItemFrame");
                }
            });



            imgBg.add(pixelIce);
            imgBg.add(iceAmtlb);
            imgBg.add(getIceAmt);

            imgBg.add(pixelEvaMilk);
            imgBg.add(evamilkAmtlb);
            imgBg.add(getEvaMilkAmt);

            imgBg.add(pixelVanillaIC);
            imgBg.add(vanillaICAmtlb);
            imgBg.add(getVanillaICAmt);

            imgBg.add(pixelRK);
            imgBg.add(rkAmtlb);
            imgBg.add(getRKAmt);

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

            imgBg.add(btnDone);
            imgBg.add(showWelcome);
            imgBg.add(showDesc);
            imgBg.setBounds(0,0,600,600);
            restockItem.add(imgBg);

            restockItem.setVisible(true);


        }

        public void mouseEntered(String str, int stringToInt, int index){
            int tryAgain=0;

            if(str.matches(".*\\d.*")) //if string has an integer
            {
                stringToInt = Integer.parseInt(str);
                if(controller.isPassed(stringToInt,index)==true)
                {
                    controller.restockItems(stringToInt, index);
                    JOptionPane.showMessageDialog(restockItem, this.itemsCurr.get(index).getItem().getName()+" has +"+stringToInt+" restock","Restock Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(restockItem, "Stock Overflowing! Enter a value that will make total stock less than or equal to 10","Invalid Value", JOptionPane.ERROR_MESSAGE);
                }
            }

            else
                JOptionPane.showMessageDialog(restockItem, "ERROR! Should be an integer input.","Integer Input Needed", JOptionPane.ERROR_MESSAGE);

        }

        public void setFrame(boolean bool)
    {
        this.setVisible(bool);
    }

        public JFrame getFrame(){
            return this;}

        public ArrayList<ItemSlot> getItemsCurr() {
            return itemsCurr;
        }
}


