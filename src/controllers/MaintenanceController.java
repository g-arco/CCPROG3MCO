package controllers;
import model.*;
import model.Record;
import view.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class controls all related operations in maintenance
 */

public class MaintenanceController {

    /**
     * modelMaintenance = maintenance model
     * maintenanceFrame = main menu for maintenance
     * restockItemFrame = restock items frame
     * setPriceFrame= set price frame
     * moneyMaintenanceFrame = money restock frame
     * summaryFrame = print summary of records frame
     * moneyCurr = current money in the system
     * itemsCurr = current items in the system
     * mainC = main controller
     * svm = vending machine model
     *  allRecord = basis of system records
     */
    private Maintenance modelMaintenance;
    private MaintenanceFrame maintenanceFrame;
    private RestockItemFrame restockItemFrame;
    private SetPriceFrame setPriceFrame;
    private MoneyMaintenanceFrame moneyMaintenanceFrame;
    private SummaryFrame summaryFrame;
    private ArrayList<MoneySlot> moneyCurr;
    private ArrayList<ItemSlot> itemsCurr;

    private MainController mainC;
    private Record allRecord;


    /**
     * This is the constructor method of the Maintenance Controller
     * @param moneyCurr =  current money in the system
     * @param itemsCurr = current items in the system
     * @param mainC = main controller
     * @param allRecord = records from main controller
     */
    public MaintenanceController(ArrayList<MoneySlot> moneyCurr, ArrayList<ItemSlot> itemsCurr, MainController mainC, Record allRecord){

        this.mainC = mainC;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;
        this.allRecord = allRecord;
        this.modelMaintenance = new Maintenance(itemsCurr,moneyCurr);
        this.maintenanceFrame = new MaintenanceFrame(itemsCurr,moneyCurr,this);
    }

    /**
     * This method is called if RVM wants to access maintenance mode
     */
    public void backFromRVM(){
        this.maintenanceFrame = new MaintenanceFrame(itemsCurr,moneyCurr,this);
    }

    /**
     * Redirects user to the restock items frame
     */
    public void pushedStockItemBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.restockItemFrame = new RestockItemFrame(maintenanceFrame,this, this.itemsCurr);
    }

    /**
     * Redirects user to set price frame
     */
    public void pushedPriceBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.setPriceFrame = new SetPriceFrame(maintenanceFrame,this);
    }

    /**
     * Redirects user to stock money frame
     */
    public void pushedMoneyStockBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        this.moneyMaintenanceFrame = new MoneyMaintenanceFrame(maintenanceFrame,this);
    }

    /**
     * Redirects user to show summary frame
     */
    public void pushedSummaryBtn(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        ArrayList<String> summary = allRecord.printRecord();
        this.summaryFrame = new SummaryFrame(maintenanceFrame,this, summary);
    }

    /**
     * RThis method redirects user back to the maintenace frame
     * @param frame = source frame
     * @param frameName = mname of source frame
     */
    public void pushedDone(JFrame frame, String frameName){
        frame.dispose();
        if (frameName.equals("setPriceFrame"))
            setPriceFrame.getFrame().dispose();
        if (frameName.equals("moneyMaintenanceFrame"))
            moneyMaintenanceFrame.getFrame().dispose();
        if (frameName.equals("restockItemFrame"))
        {
            this.allRecord.initializeRecord(this.itemsCurr);
            restockItemFrame.getFrame().dispose();
        }
        if (frameName.equals("summaryFrame"))
            summaryFrame.getFrame().dispose();
        this.maintenanceFrame = new MaintenanceFrame(this.itemsCurr, this.moneyCurr, this);

    }

    /**
     * This method redirects user back to rvm
     * @return
     */
    public void pushedtoRVM(){
        this.maintenanceFrame.getFrame().dispose();
        maintenanceFrame.dispose();
        mainC.pushedBacktoRVMfromM();
    }

    /**
     * This method restocks item given the amount
     * @param Amt = amount to be added
     * @param itemIndex = item for restock
     */
    public void restockItems(int Amt, int itemIndex)
    {
       modelMaintenance.restockItem(this.itemsCurr.get(itemIndex),Amt);
       this.itemsCurr = modelMaintenance.getItemList();

    }

    /**
     * This method sets the new price for an item given the amound
     * @param itemIndex = item whose price will be changed
     * @param newPHP = the new price
     */
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

    /**
     * This method collects the money or sets the current moneylist to 0
     */
    public void collectMoney()
    {
        for (int i =0; i <this.moneyCurr.size(); i++)
            modelMaintenance.collectMoney(i);
        this.moneyCurr = modelMaintenance.getMoneyList();


        for (int i =0; i <this.moneyCurr.size(); i++)
            System.out.println(this.moneyCurr.get(i).getQuantity());

    }

    /**
     * This method restocks current money with the desired amount
     * @param Amt = amount to be added
     * @param moneyIndex = certain money that wants to be restocked
     * @return
     */
    public int stockMoney(int Amt, int moneyIndex)
    {
        modelMaintenance.replenishMoney(moneyIndex, Amt);
        this.moneyCurr = modelMaintenance.getMoneyList();

        return modelMaintenance.getMoneyList().get(moneyIndex).getQuantity();

        /*
        for (int i =0; i <moneyCurr.size(); i++)
            System.out.println(modelMaintenance.getMoneyList().get(i).getQuantity());*/

    }

    /**
     * This method checks if the restock value is valid
     * @param amt = amount that wants to be added
     * @param index = itemslot of desired item to restock
     * @return
     */
    public boolean isPassed(int amt, int index){
        int checkCurrQuantity = this.itemsCurr.get(index).getQuantity();

        if (checkCurrQuantity + amt > 0 && checkCurrQuantity + amt <= 10)
            return true;
        else
            return false;
    }

    /**
     * Getter for current items
     * @return itemsCurr
     */
    public ArrayList<ItemSlot> getItemsCurr() {
        return itemsCurr;
    }

    /**
     * Getter for current money list
     * @param moneyCurr
     */
    public void setMoneyCurr(ArrayList<MoneySlot> moneyCurr) {
        this.moneyCurr = moneyCurr;
    }

    /**
     * Setter for current items
     * @param itemsCurr
     */
    public void setItemsCurr(ArrayList<ItemSlot> itemsCurr) {
        this.itemsCurr = itemsCurr;
    }

    /**
     * Getter for current money list
     * @return moneyCurr
     */
    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
    }
}
