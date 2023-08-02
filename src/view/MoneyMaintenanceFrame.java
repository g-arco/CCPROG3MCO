package view;

import controllers.MaintenanceController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoneyMaintenanceFrame extends JFrame{

    MaintenanceController controller;
    MaintenanceFrame sourceFrame;
    JFrame moneyMFrame;


    public MoneyMaintenanceFrame(MaintenanceFrame sourceFrame, MaintenanceController controller) {

        this.controller = controller;
        this.sourceFrame = sourceFrame;

        moneyMFrame = new JFrame("Stock Money");
        JButton btnDone = new JButton("Done Stocking");
        JLabel showTitle = new JLabel("Stock Money");
        JLabel userDesc = new JLabel("<html><center>Input the AMOUNT YOU WANT TO ADD on the text fields<br/>for each bill/coin respectively!<center><html>");
        Font pesoFont = new Font("Comic Sans MS",Font.PLAIN,10);
        Font lbFont = new Font("Comic Sans MS", Font.PLAIN, 15);

        moneyMFrame.setSize(612, 612);
        moneyMFrame.setLayout(null);
        moneyMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showTitle.setBounds(0,65,612,30);
        showTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        showTitle.setHorizontalAlignment(JLabel.CENTER);
        showTitle.setForeground(Color.red);

        userDesc.setBounds(0,80, 612, 100);
        userDesc.setForeground(Color.black);
        userDesc.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
        userDesc.setHorizontalAlignment(JLabel.CENTER);

        btnDone.setBounds(240, 420,120,20);
        btnDone.setMargin(new Insets(0,0,0,0));
        btnDone.setFont(lbFont);
        btnDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.pushedDone(moneyMFrame, "moneyMaintenanceFrame");
            }
        });


        //========================

        ImageIcon imgPeso1000 = new ImageIcon(getClass().getResource("/resources/pixel_1000.png"));
        JLabel pixel1000 = new JLabel(imgPeso1000);
        pixel1000.setBounds(100, 170, 120, 70);

        JLabel p1000lb = new JLabel("1000 PHP Amt:");
        p1000lb.setBounds(105, 224, 70, 27); //+54 down from  icon
        p1000lb.setFont(pesoFont);
        p1000lb.setForeground(Color.black);
        JTextField getP1000Amt = new JTextField("0",1);
        getP1000Amt.setBackground(Color.white);
        getP1000Amt.setForeground(Color.black);
        getP1000Amt.setBounds(175, 231, 40, 13);
        getP1000Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP1000Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1000AmtStr = getP1000Amt.getText();
                int p1000AmtInt = 0;
                clickEnter(p1000AmtStr, p1000AmtInt, 0, "1000 PHP");



            }
        });

        //=============================================
        ImageIcon imgPeso500 = new ImageIcon(getClass().getResource("/resources/pixel_500.png"));
        JLabel pixel500 = new JLabel(imgPeso500);
        pixel500.setBounds(230, 170, 120, 70); //+130 to the right

        JLabel p500lb = new JLabel("500 PHP Amt:");
        p500lb.setBounds(237, 224, 70, 27); //+54 down from  icon, +7 to the right
        p500lb.setFont(pesoFont);
        p500lb.setForeground(Color.black);
        JTextField getP500Amt = new JTextField("0",1);
        getP500Amt.setBackground(Color.white);
        getP500Amt.setForeground(Color.black);
        getP500Amt.setBounds(303, 231, 40, 13);//x = +66, y=+7
        getP500Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP500Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p500AmtStr = getP500Amt.getText();
                int p500AmtInt = 0;
                clickEnter(p500AmtStr, p500AmtInt, 1, "500 PHP");

            }
        });

        //================================================

        ImageIcon imgPeso200 = new ImageIcon(getClass().getResource("/resources/pixel_200.png"));
        JLabel pixel200 = new JLabel(imgPeso200);
        pixel200.setBounds(360, 170, 120, 70); //+130 to the right


        JLabel p200lb = new JLabel("200 PHP Amt:");
        p200lb.setBounds(367, 222, 70, 27); //+52 down from  icon, +7 to the right
        p200lb.setFont(pesoFont);
        p200lb.setForeground(Color.black);
        JTextField getP200Amt = new JTextField("0",1);
        getP200Amt.setBackground(Color.white);
        getP200Amt.setForeground(Color.black);
        getP200Amt.setBounds(433, 231, 40, 13);//x = +66, y=+7
        getP200Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP200Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p200AmtStr = getP200Amt.getText();
                int p200AmtInt =  0;
                clickEnter(p200AmtStr, p200AmtInt, 2, "200 PHP");

            }
        });

        //===============================================


        ImageIcon imgPeso100 = new ImageIcon(getClass().getResource("/resources/pixel_100.png"));
        JLabel pixel100 = new JLabel(imgPeso100);
        pixel100.setBounds(100, 242, 120, 70); //+72 down


        JLabel p100lb = new JLabel("100 PHP Amt:");
        p100lb.setBounds(108, 294, 70, 27); //+52 down from  icon, +8 to the right
        p100lb.setFont(pesoFont);
        p1000lb.setForeground(Color.black);
        JTextField getP100Amt = new JTextField("0",1);
        getP100Amt.setBackground(Color.white);
        getP100Amt.setForeground(Color.black);
        getP100Amt.setBounds(172, 301, 40, 13);//x = +64, y=+7
        getP100Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP100Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p100AmtStr = getP100Amt.getText();
                int p100AmtInt = 0;
                clickEnter(p100AmtStr, p100AmtInt, 3, "100 PHP");

            }
        });

        //=============================================
        ImageIcon imgPeso50 = new ImageIcon(getClass().getResource("/resources/pixel_50.png"));
        JLabel pixel50 = new JLabel(imgPeso50);
        pixel50.setBounds(230, 242, 120, 70); //+130 to the right, +72 down


        JLabel p50lb = new JLabel("50 PHP Amt:");
        p50lb.setBounds(240, 294, 70, 27); //+52 down from  icon, +10 to the right
        p50lb.setFont(pesoFont);
        p50lb.setForeground(Color.black);
        JTextField getP50Amt = new JTextField("0",1);
        getP50Amt.setBackground(Color.white);
        getP50Amt.setForeground(Color.black);
        getP50Amt.setBounds(300, 301, 40, 13);//x = +60, y=+7
        getP50Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP50Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p50AmtStr = getP50Amt.getText();
                int p50AmtInt = 0;
                clickEnter(p50AmtStr, p50AmtInt, 4, "50 PHP");

            }
        });

        //================================================

        ImageIcon imgPeso20 = new ImageIcon(getClass().getResource("/resources/pixel_20.png"));
        JLabel pixel20 = new JLabel(imgPeso20);
        pixel20.setBounds(360, 240, 120, 70); //+130 to the right, +72(-2) down


        JLabel p20lb = new JLabel("20 PHP Amt:");
        p20lb.setBounds(370, 294, 70, 27); //+52 down from  icon, +10 to the right
        p20lb.setFont(pesoFont);
        p20lb.setForeground(Color.black);
        JTextField getP20Amt = new JTextField("0",1);
        getP20Amt.setBackground(Color.white);
        getP20Amt.setForeground(Color.black);
        getP20Amt.setBounds(430, 301, 40, 13);//x = +60, y=+7
        getP20Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        String p20AmtStr = getP20Amt.getText();
        //convert to int
        getP20Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p20AmtStr = getP20Amt.getText();
                int p20AmtInt = 0;
                clickEnter(p20AmtStr, p20AmtInt, 5, "20 PHP");

            }
        });


        //============================================

        ImageIcon imgPeso10 = new ImageIcon(getClass().getResource("/resources/pixel_10.png"));
        JLabel pixel10 = new JLabel(imgPeso10);
        pixel10.setBounds(100, 314, 120, 70); //+72 down


        JLabel p10lb = new JLabel("10 PHP Amt:");
        p10lb.setBounds(111, 366, 70, 27); //+52 down from  icon, +11 to the right
        p10lb.setFont(pesoFont);
        p100lb.setForeground(Color.black);
        JTextField getP10Amt = new JTextField("0",1);
        getP10Amt.setBackground(Color.white);
        getP10Amt.setForeground(Color.black);
        getP10Amt.setBounds(169, 373, 40, 13);//x = +58, y=+7
        getP10Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP10Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p10AmtStr = getP10Amt.getText();
                int p10AmtInt = 0;
                clickEnter(p10AmtStr, p10AmtInt, 6, "10 PHP");

            }
        });


        //=============================================
        ImageIcon imgPeso5 = new ImageIcon(getClass().getResource("/resources/pixel_5.png"));
        JLabel pixel5 = new JLabel(imgPeso5);
        pixel5.setBounds(230, 314, 120, 70); //+130 to the right, +72 down


        JLabel p5lb = new JLabel("5 PHP Amt:");
        p5lb.setBounds(243, 366, 70, 27); //+52 down from  icon, +13 to the right
        p5lb.setFont(pesoFont);
        p5lb.setForeground(Color.black);
        JTextField getP5Amt = new JTextField("0",1);
        getP5Amt.setBackground(Color.white);
        getP5Amt.setForeground(Color.black);
        getP5Amt.setBounds(297, 373, 40, 13);//x = +54, y=+7
        getP5Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP5Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p5AmtStr = getP5Amt.getText();
                int p5AmtInt = 0;
                clickEnter(p5AmtStr, p5AmtInt, 7, "5 PHP");

            }
        });

        //================================================

        ImageIcon imgPeso1 = new ImageIcon(getClass().getResource("/resources/pixel_1.png"));
        JLabel pixel1 = new JLabel(imgPeso1);
        pixel1.setBounds(360, 314, 120, 70); //+130 to the right, +72 down


        JLabel p1lb = new JLabel("1 PHP Amt:");
        p1lb.setBounds(374, 366, 70, 27); //+52 down from  icon, +14 to the right
        p1lb.setFont(pesoFont);
        p1lb.setForeground(Color.black);
        JTextField getP1Amt = new JTextField("0",1);
        getP1Amt.setBackground(Color.white);
        getP1Amt.setForeground(Color.black);
        getP1Amt.setBounds(426, 373, 40, 13);//x = +52, y=+7
        getP1Amt.setFont(new Font("Comic Sans MS",Font.PLAIN,10));
        getP1Amt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1AmtStr = getP1Amt.getText();
                int p1AmtInt =  0;
                clickEnter(p1AmtStr, p1AmtInt, 8, "1 PHP");

            }
        });

        //============================================


        moneyMFrame.add(pixel1000);
        moneyMFrame.add(p1000lb);
        moneyMFrame.add(getP1000Amt);

        moneyMFrame.add(pixel500);
        moneyMFrame.add(p500lb);
        moneyMFrame.add(getP500Amt);

        moneyMFrame.add(pixel200);
        moneyMFrame.add(p200lb);
        moneyMFrame.add(getP200Amt);

        moneyMFrame.add(pixel100);
        moneyMFrame.add(p100lb);
        moneyMFrame.add(getP100Amt);

        moneyMFrame.add(pixel50);
        moneyMFrame.add(p50lb);
        moneyMFrame.add(getP50Amt);

        moneyMFrame.add(pixel20);
        moneyMFrame.add(p20lb);
        moneyMFrame.add(getP20Amt);

        moneyMFrame.add(pixel10);
        moneyMFrame.add(p10lb);
        moneyMFrame.add(getP10Amt);

        moneyMFrame.add(pixel5);
        moneyMFrame.add(p5lb);
        moneyMFrame.add(getP5Amt);

        moneyMFrame.add(pixel1);
        moneyMFrame.add(p1lb);
        moneyMFrame.add(getP1Amt);

        moneyMFrame.add(userDesc);
        moneyMFrame.add(showTitle);
        moneyMFrame.add(btnDone);


        moneyMFrame.setVisible(true);
    }

    public void clickEnter(String str, int strToInt, int index, String name){
        if(str.matches(".*\\d.*")) //if string has an integer
        {
            strToInt = Integer.parseInt(str);
            int i = controller.stockMoney(strToInt, index);
            JOptionPane.showMessageDialog(moneyMFrame, name+" has +"+strToInt+" Stock/ Quantity Now: "+i,"Restock Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(moneyMFrame, "ERROR! Should be an integer input.","Integer Input Needed", JOptionPane.ERROR_MESSAGE);
    }

    public void setFrame(boolean bool)
    {
        this.setVisible(bool);
    }

    public JFrame getFrame(){
        return this.moneyMFrame;
    }



}
