package view;

import javax.swing.*;
import java.awt.*;

public class SummaryFrame extends JFrame{

    public SummaryFrame(){
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

        summaryPrint.setBounds(16,100, 564, 420);

        printFrame.add(btnDone);
        printFrame.add(userDesc);
        printFrame.add(showTitle);
        printFrame.add(summaryPrint);

        printFrame.setVisible(true);

    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SummaryFrame().setVisible(true);
            }
        });

    }


}
