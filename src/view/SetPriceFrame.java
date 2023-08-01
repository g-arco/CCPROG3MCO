package view;

import controllers.MaintenanceController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SetPriceFrame extends JFrame{

        JLabel imgBg;
        ImageIcon RVMbg;
        MaintenanceController controller;
        MaintenanceFrame sourceFrame;
        int icePrice, evamilkPrice, vanillaICPrice, rkPrice, bananaPrice,coconutPrice,monggoPrice,ubePrice;
        JLabel icePricelb, evamilkPricelb, vanillaICPricelb, rkPricelb, bananaPricelb, coconutPricelb, monggoPricelb, ubePricelb;


        public SetPriceFrame(MaintenanceFrame sourceFrame, MaintenanceController controller){

            this.controller = controller;
            this.sourceFrame = sourceFrame;

            //https://youtu.be/QXVyg7lY9r8
            JFrame setPrice = new JFrame("Set Item Price");
            JLabel showWelcome = new JLabel("Set Item Price");

            setPrice.setSize(612, 612);
            setPrice.setLayout(null);
            setPrice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            showWelcome.setBounds(0,0,612,30);
            showWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            showWelcome.setHorizontalAlignment(JLabel.CENTER);
            showWelcome.setForeground(Color.red);

            JLabel showDesc = new JLabel("<html> <center> Click on items to see item details and/or change item's price. <center> </html>", SwingConstants.CENTER);
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
            icePrice = controller.getItemsCurr().get(0).getItem().getPrice();
            pixelIce.setBounds(203, 95, 40, 27); //paint coordinates; 208 (-28), 120(-18)
            pixelIce.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object iceNewPrice;
                    iceNewPrice=  JOptionPane.showInputDialog(setPrice, "<html>Shaved Ice (PHP "+icePrice+" || 0 Calories)<br/>Enter new price: </html>", "Shaved Ice", JOptionPane.PLAIN_MESSAGE, iceImg, null, icePrice);
                    if(iceNewPrice!=null)
                    {
                        if(Integer.parseInt(iceNewPrice.toString())!=icePrice) {
                            controller.newPrice(0,Integer.parseInt(iceNewPrice.toString()));
                            icePrice = controller.getItemsCurr().get(0).getItem().getPrice();
                        }
                    }
                }
            });


            icePricelb = new JLabel("Price: PHP "+icePrice+"");
            icePricelb.setBounds(205, 120, 50, 27); //paint coordinates; 208 (-23), 120(-18)
            icePricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            icePricelb.setForeground(Color.white);

            //====================================================================================
            ImageIcon evamilkImg = new ImageIcon(getClass().getResource("/resources/pixel_Milk.png"));
            JLabel pixelEvaMilk = new JLabel(evamilkImg);
            evamilkPrice = controller.getItemsCurr().get(1).getItem().getPrice();
            pixelEvaMilk.setBounds(303, 85, 40, 40); //paint coordinates; 208 (-23), 120(-18)
            pixelEvaMilk.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object evamilkNewPrice;
                    evamilkNewPrice= JOptionPane.showInputDialog(setPrice, "<html>Evaporated Milk (PHP "+evamilkPrice+" || 80 Calories)<br/>Enter new price: </html>", "Evaporated Milk", JOptionPane.PLAIN_MESSAGE, evamilkImg, null, evamilkPrice);
                    if(evamilkNewPrice!=null)
                    {
                        if(Integer.parseInt(evamilkNewPrice.toString())!=evamilkPrice) {
                            controller.newPrice(1,Integer.parseInt(evamilkNewPrice.toString()));
                            evamilkPrice = controller.getItemsCurr().get(1).getItem().getPrice();
                        }
                    }
                }
            });

            evamilkPricelb = new JLabel("Price: PHP "+evamilkPrice+"");
            evamilkPricelb.setBounds(304, 120, 50, 27); //+102 to the right
            evamilkPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            evamilkPricelb.setForeground(Color.white);


            //===============================================================================

            ImageIcon vanillaICImg = new ImageIcon(getClass().getResource("/resources/pixel_vanillaIC.png"));
            JLabel pixelVanillaIC = new JLabel(vanillaICImg);
            vanillaICPrice = controller.getItemsCurr().get(2).getItem().getPrice();
            pixelVanillaIC.setBounds(203, 157, 40, 40); //+72 down
            pixelVanillaIC.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object vanillaICNewPrice;
                    vanillaICNewPrice=JOptionPane.showInputDialog(setPrice, "<html>Vanilla Ice Cream (PHP "+vanillaICPrice+" || 111 Calories))<br/>Enter new price: </html>", "Vanilla Ice Cream", JOptionPane.PLAIN_MESSAGE, vanillaICImg, null, vanillaICPrice);
                    if(vanillaICNewPrice!=null)
                    {
                        if(Integer.parseInt(vanillaICNewPrice.toString())!=vanillaICPrice) {
                            controller.newPrice(2, Integer.parseInt(vanillaICNewPrice.toString()));
                            vanillaICPrice = controller.getItemsCurr().get(2).getItem().getPrice();
                        }
                    }
                }
            });

            vanillaICPricelb = new JLabel("Price: PHP "+vanillaICPrice+"");
            vanillaICPricelb.setBounds(205, 192, 50, 27); //paint coordinates; 208 (-23), 120(-18)
            vanillaICPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            vanillaICPricelb.setForeground(Color.white);

//=====================================================================================================
            ImageIcon rkImg = new ImageIcon(getClass().getResource("/resources/pixel_RiceKrispies.png"));
            JLabel pixelRK = new JLabel(rkImg);
            rkPrice = controller.getItemsCurr().get(3).getItem().getPrice();
            pixelRK.setBounds(303, 157, 50, 40); //+72 down
            pixelRK.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object rkNewPrice;
                    rkNewPrice=JOptionPane.showInputDialog(setPrice, "<html>Rice Krispie (PHP "+rkPrice+" || 10 Calories)<br/>Enter new price: </html>", "Rice Krispie", JOptionPane.PLAIN_MESSAGE, rkImg, null, rkPrice);
                    if(rkNewPrice!=null)
                    {
                        if(Integer.parseInt(rkNewPrice.toString())!=rkPrice) {
                            controller.newPrice(3, Integer.parseInt(rkNewPrice.toString()));
                            rkPrice = controller.getItemsCurr().get(3).getItem().getPrice();
                        }
                    }
                }
            });

            rkPricelb = new JLabel("Price: PHP "+rkPrice+"");
            rkPricelb.setBounds(304, 192, 50, 27); //+102 to the right
            rkPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            rkPricelb.setForeground(Color.white);

            //===============================================================================================

            ImageIcon bananaImg = new ImageIcon(getClass().getResource("/resources/pixel_banana.png"));
            JLabel pixelBanana = new JLabel(bananaImg);
            bananaPrice = controller.getItemsCurr().get(4).getItem().getPrice();
            pixelBanana.setBounds(203, 232, 40, 40); //+75 down
            pixelBanana.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object bananaNewPrice;
                    bananaNewPrice= JOptionPane.showInputDialog(setPrice, "<html>Banana (PHP "+bananaPrice+" || 8 Calories)<br/>Enter new price: </html>", "Banana", JOptionPane.PLAIN_MESSAGE, bananaImg, null, bananaPrice);
                    if(bananaNewPrice!=null)
                    {
                        if(Integer.parseInt(bananaNewPrice.toString())!=bananaPrice) {
                            controller.newPrice(4,Integer.parseInt(bananaNewPrice.toString()));
                            bananaPrice = controller.getItemsCurr().get(4).getItem().getPrice();
                        }
                    }
                }
            });

            bananaPricelb = new JLabel("Price: PHP "+bananaPrice+"");
            bananaPricelb.setBounds(205, 267, 50, 27); //paint coordinates; 208 (-23), 120(-18)
            bananaPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            bananaPricelb.setForeground(Color.white);

//=====================================================================================================

            ImageIcon coconutImg = new ImageIcon(getClass().getResource("/resources/pixel_coconut.png"));
            JLabel pixelCoconut = new JLabel(coconutImg);
            coconutPrice = controller.getItemsCurr().get(5).getItem().getPrice();
            pixelCoconut.setBounds(303, 232, 40, 40); //+75 down
            pixelCoconut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object coconutNewPrice;
                    coconutNewPrice= JOptionPane.showInputDialog(setPrice, "<html>Coconut (PHP "+coconutPrice+" || 17 Calories)<br/>Enter new price: </html>", "Coconut", JOptionPane.PLAIN_MESSAGE, coconutImg, null, coconutPrice);
                    if(coconutNewPrice!=null)
                    {
                        if(Integer.parseInt(coconutNewPrice.toString())!=coconutPrice) {
                            controller.newPrice(5,Integer.parseInt(coconutNewPrice.toString()));
                            coconutPrice = controller.getItemsCurr().get(5).getItem().getPrice();
                        }
                    }
                }
            });

            coconutPricelb = new JLabel("Price: PHP "+coconutPrice+"");
            coconutPricelb.setBounds(304, 267, 50, 27); //+102 to the right
            coconutPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            coconutPricelb.setForeground(Color.white);

            //=====================================================================================================================

            ImageIcon monggoImg = new ImageIcon(getClass().getResource("/resources/pixel_mungbeans.png"));
            JLabel pixelMonggo = new JLabel(monggoImg);
            monggoPrice = controller.getItemsCurr().get(6).getItem().getPrice();;
            pixelMonggo.setBounds(203, 311, 40, 40); //+79 down
            pixelMonggo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object monggoNewPrice;
                    monggoNewPrice= JOptionPane.showInputDialog(setPrice, "<html>Mung Beans (PHP "+monggoPrice+" || 12 Calories)<br/>Enter new price: </html>", "Mung Beans", JOptionPane.PLAIN_MESSAGE, monggoImg, null, monggoPrice);
                    if(monggoNewPrice!=null)
                    {
                        if(Integer.parseInt(monggoNewPrice.toString())!=monggoPrice) {
                            controller.newPrice(6,Integer.parseInt(monggoNewPrice.toString()));
                            monggoPrice = controller.getItemsCurr().get(6).getItem().getPrice();
                        }
                    }
                }
            });

            monggoPricelb = new JLabel("Price: PHP "+monggoPrice+"");
            monggoPricelb.setBounds(205, 346, 50, 27); //+102 to the right
            monggoPricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            monggoPricelb.setForeground(Color.white);

            //=======================================================================================================================

            ImageIcon ubeImg = new ImageIcon(getClass().getResource("/resources/pixel_ube.png"));
            JLabel pixelUbe = new JLabel(ubeImg);
            ubePrice = controller.getItemsCurr().get(7).getItem().getPrice();
            pixelUbe.setBounds(303, 311, 40, 40); //+79 down
            pixelUbe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object ubeNewPrice;
                    ubeNewPrice= JOptionPane.showInputDialog(setPrice, "<html>Purple Yam (PHP "+ubePrice+" || 15 Calories)<br/>Enter new price: </html>", "Purple Yam", JOptionPane.PLAIN_MESSAGE, ubeImg, null, ubePrice);
                    if(ubeNewPrice!=null)
                    {
                        if(Integer.parseInt(ubeNewPrice.toString())!=ubePrice) {
                            controller.newPrice(7,Integer.parseInt(ubeNewPrice.toString()));
                            ubePrice = controller.getItemsCurr().get(7).getItem().getPrice();
                        }
                    }
                }
            });

            ubePricelb = new JLabel("Price: PHP "+ubePrice+"");
            ubePricelb.setBounds(304, 346, 50, 27); //+102 to the right
            ubePricelb.setFont(new Font("Comic Sans MS",Font.PLAIN,7));
            ubePricelb.setForeground(Color.white);

            //=======================================================================================================================

            JButton btnDone = new JButton("Done Editing");
            btnDone.setBounds(250, 550,120,20);
            btnDone.setMargin(new Insets(0,0,0,0));
            btnDone.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            btnDone.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    controller.pushedDone(setPrice, "setPriceFrame");
                }
            });



            imgBg.add(pixelIce);
            imgBg.add(icePricelb);

            imgBg.add(pixelEvaMilk);
            imgBg.add(evamilkPricelb);

            imgBg.add(pixelVanillaIC);
            imgBg.add(vanillaICPricelb);

            imgBg.add(pixelRK);
            imgBg.add(rkPricelb);

            imgBg.add(pixelBanana);
            imgBg.add(bananaPricelb);

            imgBg.add(pixelCoconut);
            imgBg.add(coconutPricelb);


            imgBg.add(pixelMonggo);
            imgBg.add(monggoPricelb);

            imgBg.add(pixelUbe);
            imgBg.add(ubePricelb);


            imgBg.add(btnDone);
            imgBg.add(showWelcome);
            imgBg.add(showDesc);
            imgBg.setBounds(0,0,600,600);
            setPrice.add(imgBg);

            setPrice.setVisible(true);


        }

    public void setFrame(boolean bool)
    {
        this.setVisible(bool);
    }

    public JFrame getFrame(){
        return this;
    }

    public JLabel getIcePricelb() {
        return icePricelb;
    }

    public JLabel getEvamilkPricelb() {
        return evamilkPricelb;
    }

    public JLabel getVanillaICPricelb() {
        return vanillaICPricelb;
    }

    public JLabel getRkPricelb() {
        return rkPricelb;
    }

    public JLabel getBananaPricelb() {
        return bananaPricelb;
    }

    public JLabel getCoconutPricelb() {
        return coconutPricelb;
    }

    public JLabel getMonggoPricelb() {
        return monggoPricelb;
    }

    public JLabel getUbePricelb() {
        return ubePricelb;
    }

}
