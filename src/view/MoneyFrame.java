package view;

import controllers.RVMController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MoneyFrame extends JFrame{

    JLabel AmttoPaylb;
    JLabel AmtUserPaidlb;
    JLabel AmttoPayInt;
    JTextField AmtUserPaidInt;
    RVMController controller;
    ArrayList<Money> moneyHold;

    int totalPaidMoney;
    int totalAmt;

    JFrame moneyFrame;

    public MoneyFrame(int totalAmt, RVMController controller){

        this.controller = controller;
        totalPaidMoney = 0;
        moneyHold = new ArrayList<Money>();
        this.totalAmt = totalAmt;

        moneyFrame = new JFrame("Purchase Items");
        AmttoPaylb = new JLabel("Total Amount to be Paid: ");
        AmtUserPaidlb = new JLabel("You have Paid: "+"             PHP");
        AmttoPayInt = new JLabel(totalAmt+" PHP");
        AmtUserPaidInt = new JTextField();
        JButton btnQuit = new JButton("Cancel Payment");
        JLabel userDesc = new JLabel("Click on the coin/bill you want to input!");
        Font lbFont = new Font("Comic Sans MS", Font.PLAIN, 15);
        Font pesoFont = new Font("Comic Sans MS",Font.PLAIN,10);

        moneyFrame.setSize(612, 612);
        moneyFrame.setLayout(null);
        moneyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        AmttoPaylb.setBounds(5,30, 190, 100);
        AmttoPaylb.setForeground(Color.black);
        AmttoPaylb.setFont(lbFont);

        AmttoPayInt.setBounds(190,30, 210, 100);
        AmttoPayInt.setForeground(Color.black);
        AmttoPayInt.setFont(lbFont);

        AmtUserPaidlb.setBounds(5,70, 200, 100);
        AmtUserPaidlb.setForeground(Color.black);
        AmtUserPaidlb.setFont(lbFont);

        AmtUserPaidInt.setBounds(110,111, 55, 20);
        AmtUserPaidInt.setBackground(Color.white);
        AmtUserPaidlb.setForeground(Color.black);
        AmtUserPaidInt.setText("0");
        AmtUserPaidlb.setFont(lbFont);
        AmtUserPaidlb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(moneyFrame, "DO NOT EDIT! Input will not be considered","Input through icons below!",JOptionPane.WARNING_MESSAGE);
            }
        });

        userDesc.setBounds(180,100, 400, 100);
        userDesc.setForeground(Color.black);
        userDesc.setFont(new Font("Comic Sans MS",Font.PLAIN,12));

        btnQuit.setBounds(240, 420,120,20);
        btnQuit.setMargin(new Insets(0,0,0,0));
        btnQuit.setFont(lbFont);
        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(totalPaidMoney == 0)
                    controller.pushedBack();
                else
                    controller.showMoneyHold(moneyHold);
            }
        });


        //========================

        ImageIcon imgPeso1000 = new ImageIcon(getClass().getResource("/resources/pixel_1000.png"));
        JLabel pixel1000 = new JLabel(imgPeso1000);
        pixel1000.setBounds(100, 170, 120, 70);
        pixel1000.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(1000);
            }
        });

        JLabel p1000lb = new JLabel("1000 PHP");
        p1000lb.setBounds(140, 222, 70, 27); //+52 down from  icon
        p1000lb.setFont(pesoFont);
        p1000lb.setForeground(Color.black);

        //=============================================
        ImageIcon imgPeso500 = new ImageIcon(getClass().getResource("/resources/pixel_500.png"));
        JLabel pixel500 = new JLabel(imgPeso500);
        pixel500.setBounds(230, 170, 120, 70); //+130 to the right
        pixel500.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(500);
            }
        });

        JLabel p500lb = new JLabel("500 PHP");
        p500lb.setBounds(270, 222, 70, 27); //+52 down from  icon, +130 to the right
        p500lb.setFont(pesoFont);
        p500lb.setForeground(Color.black);

        //================================================

        ImageIcon imgPeso200 = new ImageIcon(getClass().getResource("/resources/pixel_200.png"));
        JLabel pixel200 = new JLabel(imgPeso200);
        pixel200.setBounds(360, 170, 120, 70); //+130 to the right
        pixel200.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(200);
            }
        });

        JLabel p200lb = new JLabel("200 PHP");
        p200lb.setBounds(400, 222, 70, 27); //+52 down from  icon, +130 to the right
        p200lb.setFont(pesoFont);
        p200lb.setForeground(Color.black);

        //===============================================


        ImageIcon imgPeso100 = new ImageIcon(getClass().getResource("/resources/pixel_100.png"));
        JLabel pixel100 = new JLabel(imgPeso100);
        pixel100.setBounds(100, 242, 120, 70); //+72 down
        pixel100.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(100);
            }
        });

        JLabel p100lb = new JLabel("100 PHP");
        p100lb.setBounds(140, 294, 70, 27); //+52 down from  icon
        p100lb.setFont(pesoFont);
        p1000lb.setForeground(Color.black);

        //=============================================
        ImageIcon imgPeso50 = new ImageIcon(getClass().getResource("/resources/pixel_50.png"));
        JLabel pixel50 = new JLabel(imgPeso50);
        pixel50.setBounds(230, 242, 120, 70); //+130 to the right, +72 down
        pixel50.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(50);
            }
        });

        JLabel p50lb = new JLabel("50 PHP");
        p50lb.setBounds(273, 294, 70, 27); //+52 down from  icon, +130 to the right
        p50lb.setFont(pesoFont);
        p50lb.setForeground(Color.black);

        //================================================

        ImageIcon imgPeso20 = new ImageIcon(getClass().getResource("/resources/pixel_20.png"));
        JLabel pixel20 = new JLabel(imgPeso20);
        pixel20.setBounds(360, 242, 120, 70); //+130 to the right, +72 down
        pixel20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(20);
            }
        });

        JLabel p20lb = new JLabel("20 PHP");
        p20lb.setBounds(403, 294, 70, 27); //+52 down from  icon, +130 to the right
        p20lb.setFont(pesoFont);
        p20lb.setForeground(Color.black);

        //============================================

        ImageIcon imgPeso10 = new ImageIcon(getClass().getResource("/resources/pixel_10.png"));
        JLabel pixel10 = new JLabel(imgPeso10);
        pixel10.setBounds(100, 314, 120, 70); //+72 down
        pixel10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(10);
            }
        });

        JLabel p10lb = new JLabel("10 PHP");
        p10lb.setBounds(143, 366, 70, 27); //+52 down from  icon
        p10lb.setFont(pesoFont);
        p100lb.setForeground(Color.black);

        //=============================================
        ImageIcon imgPeso5 = new ImageIcon(getClass().getResource("/resources/pixel_5.png"));
        JLabel pixel5 = new JLabel(imgPeso5);
        pixel5.setBounds(230, 314, 120, 70); //+130 to the right, +72 down
        pixel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(5);
            }
        });

        JLabel p5lb = new JLabel("5 PHP");
        p5lb.setBounds(275, 366, 70, 27); //+52 down from  icon, +130 to the right
        p5lb.setFont(pesoFont);
        p5lb.setForeground(Color.black);

        //================================================

        ImageIcon imgPeso1 = new ImageIcon(getClass().getResource("/resources/pixel_1.png"));
        JLabel pixel1 = new JLabel(imgPeso1);
        pixel1.setBounds(360, 314, 120, 70); //+130 to the right, +72 down
        pixel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseDetected(1);

            }
        });

        JLabel p1lb = new JLabel("1 PHP");
        p1lb.setBounds(405, 366, 70, 27); //+52 down from  icon, +130 to the right
        p1lb.setFont(pesoFont);
        p1lb.setForeground(Color.black);

        //============================================


        moneyFrame.add(pixel1000);
        moneyFrame.add(p1000lb);

        moneyFrame.add(pixel500);
        moneyFrame.add(p500lb);

        moneyFrame.add(pixel200);
        moneyFrame.add(p200lb);

        moneyFrame.add(pixel100);
        moneyFrame.add(p100lb);

        moneyFrame.add(pixel50);
        moneyFrame.add(p50lb);

        moneyFrame.add(pixel20);
        moneyFrame.add(p20lb);

        moneyFrame.add(pixel10);
        moneyFrame.add(p10lb);

        moneyFrame.add(pixel5);
        moneyFrame.add(p5lb);

        moneyFrame.add(pixel1);
        moneyFrame.add(p1lb);

        moneyFrame.add(AmttoPaylb);
        moneyFrame.add(AmttoPayInt);
        moneyFrame.add(AmtUserPaidlb);
        moneyFrame.add(AmtUserPaidInt);
        moneyFrame.add(userDesc);
        moneyFrame.add(btnQuit);

        moneyFrame.setVisible(true);

    }

    public void mouseDetected(int amtToAdd){
        moneyHold.add(new Money(amtToAdd));
        totalPaidMoney += amtToAdd;
        AmtUserPaidInt.setText(totalPaidMoney+"");

        if (totalPaidMoney >= this.totalAmt)
            controller.successPay();
    }

    public JFrame getFrame() {
        return moneyFrame;
    }
}
