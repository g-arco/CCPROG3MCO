package view;

import controllers.MaintenanceController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SummaryFrame extends JFrame{

    MaintenanceController controller;
    MaintenanceFrame sourceFrame;
    public SummaryFrame(MaintenanceFrame sourceFrame, MaintenanceController controller, ArrayList<String> summary){

        this.controller = controller;
        this.sourceFrame = sourceFrame;

        JFrame printFrame = new JFrame("Print Summary of Transactions");
        JButton btnDone = new JButton("Done Viewing");
        JLabel showTitle = new JLabel("Print Summary of Transactions");
        JLabel userDesc = new JLabel("<html> <center>Below is the total summary of records!<center><html> ");
        JTextArea summaryPrint = new JTextArea();
        Font pesoFont = new Font("Comic Sans MS",Font.PLAIN,10);
        Font lbFont = new Font("Comic Sans MS", Font.PLAIN, 15);

        printFrame.setSize(612, 612);
        printFrame.setLayout(null);
        printFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showTitle.setBounds(0,35,612,30);
        showTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        showTitle.setHorizontalAlignment(JLabel.CENTER);
        showTitle.setForeground(Color.red);

        userDesc.setBounds(0,35, 612, 80);
        userDesc.setForeground(Color.black);
        userDesc.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
        userDesc.setHorizontalAlignment(JLabel.CENTER);

        btnDone.setBounds(250, 550,120,20);
        btnDone.setMargin(new Insets(0,0,0,0));
        btnDone.setFont(lbFont);
        btnDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.pushedDone(printFrame, "summaryFrame");
            }
        });

        summaryPrint.setBounds(16,100, 564, 420);
        summaryPrint.setText("");
        for (int i=0; i <summary.size();i++)
        {
            summaryPrint.append(summary.get(i));
        }
        summaryPrint.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(summaryPrint);
        scroll.setBounds(16,100, 564, 420);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        printFrame.add(scroll);
        printFrame.add(btnDone);
        printFrame.add(userDesc);
        printFrame.add(showTitle);

        printFrame.setVisible(true);

    }

    public JFrame getFrame(){
        return this;
    }




}
