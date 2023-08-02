package view;

import controllers.MainController;
import controllers.RVMController;
import model.Money;
import model.MoneySlot;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.*;

public class LoadingFrame extends JFrame {

        JFrame load;
        JLabel loadHaloHalo;
        JLabel strOutput;
        int index, index2;
        int buffer;
        MainController controller;

        public LoadingFrame(ArrayList<Money> moneyHold, MainController controller, int source)
        {
            init();

            String str = "Processing...";
            JLabel strOutput = new JLabel(str);//get string from model
            strOutput.setBounds(0, 50, 480, 60);
            strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
            strOutput.setHorizontalAlignment(JLabel.CENTER);
            strOutput.setForeground(Color.red);

            Timer timer = new Timer(900, null);
            index = moneyHold.size()-1;
            buffer=1;
            ActionListener listner = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (index==-1){
                        strOutput.setText("Finished...");
                        timer.stop();
                        controller.closeWindow(1, source);
                    }
                    else if (buffer==1)
                    {
                        strOutput.setText(moneyHold.get(index).getValue()+" PHP has been dispensed...");
                        System.out.println(moneyHold.get(index).getValue()+" PHP has been dispensed...");
                        index--;
                        buffer=2;
                    }
                    else
                    {
                        strOutput.setText("....");
                        buffer=1;
                    }


                }
            };
            timer.addActionListener(listner);
            timer.start();



            loadHaloHalo.add(strOutput);


        }

    public LoadingFrame(ArrayList<MoneySlot> money, MainController controller, int source, int a)
    {
        init();

        String str = "Processing...";
        JLabel strOutput = new JLabel(str);//get string from model
        strOutput.setBounds(0, 50, 480, 60);
        strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        strOutput.setHorizontalAlignment(JLabel.CENTER);
        strOutput.setForeground(Color.red);

        Timer timer = new Timer(900, null);
        index2 = money.size()-1;
        buffer=1;
        ActionListener listner = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (index2==-1){
                    strOutput.setText("Finished...");
                    timer.stop();
                    controller.closeWindow(1, source);
                }
                else if (buffer==1)
                {
                    if(money.get(index2).getQuantity() > 0)
                    {
                        strOutput.setText(money.get(index2).getQuantity()+" "+money.get(index2).getValue()+" PHP has been dispensed...");
                        System.out.println(money.get(index2).getQuantity()+" "+money.get(index2).getValue()+" PHP has been dispensed...");
                    }

                    index2--;
                    buffer=2;
                }
                else
                {
                    strOutput.setText("....");
                    buffer=1;
                }


            }
        };
        timer.addActionListener(listner);
        timer.start();



        loadHaloHalo.add(strOutput);


    }

    public LoadingFrame(ArrayList<String> string, MainController controller, int source, int isDone, int b)
    {
        init();

        String str = "Processing...";
        JLabel strOutput = new JLabel(str);//get string from model
        strOutput.setBounds(0, 50, 480, 60);
        strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        strOutput.setHorizontalAlignment(JLabel.CENTER);
        strOutput.setForeground(Color.red);

        Timer timer = new Timer(1000, null);
        index = string.size()-1;
        buffer=1;
        ActionListener listner = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (index==-1){
                    strOutput.setText("Finished...");
                    timer.stop();
                    controller.closeWindow(isDone, source);
                }
                else if (buffer==1)
                {
                    strOutput.setText(string.get(index));
                    index--;
                    buffer=2;
                }
                else
                {
                    strOutput.setText("....");
                    buffer=1;
                }


            }
        };
        timer.addActionListener(listner);
        timer.start();



        loadHaloHalo.add(strOutput);


    }

        public void init()
        {
            load = new JFrame("Processing...");

            load.setSize(480, 480);
            load.setLayout(null);
            load.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon gifHaloHalo = new ImageIcon(getClass().getResource("/resources/halohalo_load.gif"));
            loadHaloHalo = new JLabel(gifHaloHalo);
            loadHaloHalo.setBounds(0, 0, 480, 480);

            load.add(loadHaloHalo);

            load.setVisible(true);
        }

    public JFrame getFrame() {
        return load;
    }
}

