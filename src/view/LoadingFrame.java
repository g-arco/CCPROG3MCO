package view;

import controllers.RVMController;
import model.Money;

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
        int index;
        int buffer;
        RVMController controller;

        public LoadingFrame(ArrayList<Money> moneyHold, RVMController controller)
        {
            init();

            String str = "Processing...";
            JLabel strOutput = new JLabel(str);//get string from model
            strOutput.setBounds(0, 50, 480, 60);
            strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
            strOutput.setHorizontalAlignment(JLabel.CENTER);
            strOutput.setForeground(Color.red);

            Timer timer = new Timer(800, null);
            index = moneyHold.size()-1;
            buffer=1;
            ActionListener listner = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (index==-1){
                        strOutput.setText("Finished...");
                        timer.stop();
                        controller.closeWindow();
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

    public LoadingFrame(ArrayList<String> string, ArrayList<Money> money, RVMController controller)
    {
        init();

        String str = "Processing...";
        JLabel strOutput = new JLabel(str);//get string from model
        strOutput.setBounds(0, 50, 480, 60);
        strOutput.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        strOutput.setHorizontalAlignment(JLabel.CENTER);
        strOutput.setForeground(Color.red);

        Timer timer = new Timer(800, null);
        index = string.size()-1;
        buffer=1;
        ActionListener listner = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (index==-1){
                    strOutput.setText("Finished...");
                    timer.stop();
                    controller.closeWindow();
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

