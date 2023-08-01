package controllers;
import model.*;
import view.*;

import javax.swing.*;
import java.util.ArrayList;

public class MaintenanceController {

    Maintenance modelMaintenance;
    MaintenanceFrame maintenanceFrame;
    RestockItemFrame restockItemFrame;
    SetPriceFrame setPriceFrame;
    MoneyMaintenanceFrame moneyMaintenanceFrame;
    SummaryFrame summaryFrame;
    ArrayList<MoneySlot> moneyCurr;
    ArrayList<ItemSlot> itemsCurr;

    MainController mainC;


    public MaintenanceController(ArrayList<MoneySlot> moneyCurr, ArrayList<ItemSlot> itemsCurr, MainController mainC){

        this.mainC = mainC;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;
        this.modelMaintenance = new Maintenance(itemsCurr,moneyCurr);
        this.maintenanceFrame = new MaintenanceFrame(itemsCurr,moneyCurr,this);
    }

    public boolean backFromRVM(){
        this.maintenanceFrame = new MaintenanceFrame(itemsCurr,moneyCurr,this);
        return true;
    }

    public boolean pushedStockItemBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.restockItemFrame = new RestockItemFrame(maintenanceFrame,this, this.itemsCurr);
        return true;
    }

    public boolean pushedPriceBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.setPriceFrame = new SetPriceFrame(maintenanceFrame,this);

        return true;
    }


    public boolean pushedMoneyStockBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.moneyMaintenanceFrame = new MoneyMaintenanceFrame(maintenanceFrame,this);

        return true;
    }


    public boolean pushedSummaryBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.summaryFrame = new SummaryFrame(maintenanceFrame,this);

        return true;
    }

    public boolean pushedDone(JFrame frame, String frameName){
        frame.dispose();
        if (frameName.equals("setPriceFrame"))
            setPriceFrame.getFrame().dispose();
        if (frameName.equals("moneyMaintenanceFrame"))
            moneyMaintenanceFrame.getFrame().dispose();
        if (frameName.equals("restockItemFrame"))
            restockItemFrame.getFrame().dispose();
        if (frameName.equals("summaryFrame"))
            summaryFrame.getFrame().dispose();
        this.maintenanceFrame = new MaintenanceFrame(itemsCurr, moneyCurr, this);

        return true;
    }

    public boolean pushedtoRVM(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        mainC.pushedBacktoRVMfromM();
        return true;
    }

    public void restockItems(int Amt, int itemIndex)
    {
       modelMaintenance.restockItem(this.itemsCurr.get(itemIndex),Amt);
       this.itemsCurr = modelMaintenance.getItemList();

    }

    public void newPrice(int itemIndex,int newPHP)
    {
        modelMaintenance.setNewPrice(this.itemsCurr.get(itemIndex).getItem(), newPHP);
        this.itemsCurr = modelMaintenance.getItemList();
        if (itemIndex==0)
            this.setPriceFrame.getIcePricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==1)
            this.setPriceFrame.getEvamilkPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==2)
            this.setPriceFrame.getVanillaICPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==3)
            this.setPriceFrame.getRkPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==4)
            this.setPriceFrame.getBananaPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==5)
            this.setPriceFrame.getCoconutPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==6)
            this.setPriceFrame.getMonggoPricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");
        if (itemIndex==7)
            this.setPriceFrame.getUbePricelb().setText("Price: PHP "+this.itemsCurr.get(itemIndex).getItem().getPrice()+"");

    }


    public void collectMoney()
    {
        for (int i =0; i <this.moneyCurr.size(); i++)
            modelMaintenance.collectMoney(i);
        this.moneyCurr = modelMaintenance.getMoneyList();


        for (int i =0; i <this.moneyCurr.size(); i++)
            System.out.println(this.moneyCurr.get(i).getQuantity());

    }

    public void stockMoney(int Amt, int moneyIndex)
    {
        modelMaintenance.replenishMoney(moneyIndex, Amt);
        this.moneyCurr = modelMaintenance.getMoneyList();

        /*
        for (int i =0; i <moneyCurr.size(); i++)
            System.out.println(modelMaintenance.getMoneyList().get(i).getQuantity());*/

    }

    public ArrayList<ItemSlot> getItemsCurr() {
        return itemsCurr;
    }

    public void setMoneyCurr(ArrayList<MoneySlot> moneyCurr) {
        this.moneyCurr = moneyCurr;
    }

    public void setItemsCurr(ArrayList<ItemSlot> itemsCurr) {
        this.itemsCurr = itemsCurr;
    }

    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
    }
}
