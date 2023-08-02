package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
import model.Record;
import model.SVM;
import view.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class handles all svm operations
 */
public class SVMController {
    /**
     * specialVMFrame = main svm frame
     * moneyFrame = money frame to be showed after rvm frame
     * loadingFrame = loading frame for all things that will be dispensed
     * moneyCurr = current money in the system
     * channgeList = moneyslot for change
     * itemsCurr = current items in the system
     * mainC = main controller
     * svm = vending machine model
     * itemToBuy = the item of choice from user
     * itemPrep = string that will be used when dispensing item process will be shown to user
     * totalPaid = total money paid by the user
     * totalDue = amount that needs to be paid by the user
     *  allRecord = basis of system records
     *  withPrep = detemines if the out will have a "item preperation" or simple "dispense" style of dispening an item
     */
    private SpecialVMFrame specialVMFrame;
    private MoneyFrame moneyFrame;
    private LoadingFrame loadingFrame;
    private ArrayList<MoneySlot> moneyCurr;
    private ArrayList<MoneySlot> channgeList;
    private ArrayList<ItemSlot> itemsCurr;
    private MainController mainC;
    private SVM svm;

    private ArrayList<ItemSlot> itemToBuy;
    private ArrayList<String> itemPrep;
    private int totalPaid, totalDue;
    private Record allRecord;
    private int withPrep;

    /**
     * This is the constructor method of the SVM Controller
     * @param moneyCurr =  current money in the system
     * @param itemsCurr = current items in the system
     * @param changeList = moneyslot arraylist for change
     * @param mainC = main controller
     * @param allRecord = records from main controller
     */
    public SVMController(ArrayList<MoneySlot> moneyCurr, ArrayList<ItemSlot> itemsCurr, ArrayList<MoneySlot> changeList, MainController mainC, Record allRecord){

        this.mainC = mainC;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;
        this.allRecord = allRecord;
        this.svm = new SVM(this.itemsCurr, this.moneyCurr, this.allRecord);
        this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
        this.channgeList = changeList;
        initializeChangeList();
    }

    /**
     * This method initializes change moneyslot array list
     */
    public void initializeChangeList(){
        for (int i =0; i < this.channgeList.size(); i++)
        {
            if (i==9)
                this.channgeList.remove(i);
            else
                this.channgeList.get(i).clearSlots();
            //System.out.println(this.channgeList.get(i).getQuantity());
            //System.out.println(this.moneyCurr.get(i).getQuantity());
        }

    }

    /**
     * This method redirects user to Maintenance frame
     */
    public void pushedMaintenanceBtn(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        mainC.pushedMaintenanceBtn();
    }

    /**
     * This method calls on a new rvm frame when it returns from rvm frame
     */
    public void backFromRVM(){
        this.specialVMFrame = new SpecialVMFrame(itemsCurr,moneyCurr,this);
    }

    /**
     * This method is used to redirect user to rvm
     */
    public void pushedSwitchBtn(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        mainC.pushedBacktoRVMfromS();
    }

    /**
     * This method clears all current dat in rvm
     */
    public void clearSVM(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        this.specialVMFrame = new SpecialVMFrame(itemsCurr,moneyCurr,this);
    }

    /**
     * This method is called when the user needs to purchase items
     * @param cart = itemslot array list with a list for items to sell
     * @param totalAmt = the total amount that a user needs to pay
     */
    public void purchaseItems(ArrayList<ItemSlot> cart, int totalAmt)
    {
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        this.itemsCurr = cart;

        this.totalDue = totalAmt;

        mainC.toMoneyFrame(totalAmt, 2);
    }

    /**
     * This method is called when the item can be successfully dispensed
     * @param totalPaid = total amount of money paid
     * @param moneyFrame = the moneyFrame that is displayed
     */
    public void successPayS(int totalPaid,MoneyFrame moneyFrame){
        int isDone=0;

        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();

        this.totalPaid = totalPaid;

        if (this.totalPaid == this.totalDue){
            isDone = 1;
        }

        this.itemPrep = new ArrayList<String>();
        this.itemPrep = this.svm.proceedTransaction(this.itemsCurr, this.withPrep);

        for (int i = 0; i < this.itemPrep.size(); i++)
        {
            //this.itemToBuy.add(cart.get(i));
            System.out.println(itemPrep.get(i));
        }

        this.loadingFrame = new LoadingFrame(itemPrep, mainC, 2, isDone, 0);
        this.itemsCurr = svm.getItemSlotArrayList();
        this.moneyCurr = svm.getMoneySlotArrayList();
    }

    /**
     * This method redirects user back to svm when payment is cancelled and no money was inputted
     * @param moneyFrame = moneyFrame displayed
     */
    public void pushedBackS(MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    /**
     * This dispenses the user's money when payment is cancelled
     * @param moneyHold = money inputted by the user
     * @param moneyFrame = money frame in display
     */
    public void showMoneyHoldS(ArrayList<Money> moneyHold, MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.loadingFrame = new LoadingFrame(moneyHold, mainC,2);
    }

    /**
     * This method checks if there is sufficient change
     * @param totalPaid = total money paid by the user
     * @return boolean = true, if there is available change; false, if otherwise
     */
    public boolean checkChange(int totalPaid){
        this.totalPaid = totalPaid;
        if(this.svm.produceChange(this.totalPaid, this.totalDue, this.channgeList).size() == 9)
        {
            System.out.println(this.channgeList.size());
            return true;
        }
        else
        {
            initializeChangeList();
            return false;
        }
    }


    /**
     * This method is called when payment is successful and initiates the closing of loading frame/s
     * @param isDone = 0 value indicates if there is more processing frames; 1, if no more processing after
     */
    public void closeWindowS(int isDone){
        if(isDone ==0)
        {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();

            //this.channgeList = this.svm.produceChange(this.totalPaid, this.totalDue, this.channgeList);
            this.moneyCurr = this.svm.getMoneySlotArrayList();
            this.loadingFrame = new LoadingFrame(this.channgeList, mainC, 2,0);

        }
        else {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();
            this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
            JOptionPane.showMessageDialog(null, "Order Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            initializeChangeList();
        }

    }

    /**
     * This method is called when payment is cancelled the user inputted money is dispensed and closes the loading frame
     * @param isDone = indicates if there is more processing frames after
     */
    public void closeWindowSMH(int isDone){
        if(isDone ==1)
        {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();
            this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
            JOptionPane.showMessageDialog(null, "Money Dispense Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            initializeChangeList();
        }

    }


    /**
     * This method checks if the item slot chosen has an available stock
     * @param index = index of itemslot in the current item array list
     * @param desiredAmt = desired amount to be purchased
     * @return boolean = true, if there is stock
     */
    public boolean isAvailable(int index, int desiredAmt){

        if (this.itemsCurr.get(index).getQuantity() >= desiredAmt)
            return true;
        else
            return false;

    }

    /**
     * This method checks if items are valid for selling since some items cannot be sold alone
     * @return boolean = true, if list can be sold; false, if not
     */
    public boolean canbeSold(){
        int checkIfWith=0;
        this.withPrep = 0;

        System.out.println(checkIfWith+"> START");

        if(this.itemsCurr.get(0).getToSell() >= 1)
        {
            checkIfWith++;
        }
        if(this.itemsCurr.get(1).getToSell() >= 1)
        {
            checkIfWith++;
        }
        if(this.itemsCurr.get(2).getToSell() >= 1)
            checkIfWith+=2;
        if(this.itemsCurr.get(4).getToSell() >= 1)
            checkIfWith+=2;
        System.out.println(checkIfWith);
        if(this.itemsCurr.get(5).getToSell() >= 1)
            checkIfWith+=2;


        System.out.println(checkIfWith);
        if (checkIfWith%2 != 0)
        {
            if(this.itemsCurr.get(1).getToSell() == 0 && this.itemsCurr.get(0).getToSell() >= 1)
                checkIfWith=0;
            if(this.itemsCurr.get(1).getToSell() >= 1 && this.itemsCurr.get(0).getToSell() == 0)
                checkIfWith=0;
        }

        if(this.itemsCurr.get(1).getToSell() >= 1 && this.itemsCurr.get(0).getToSell() >= 1)
            this.withPrep=2;

        if(checkIfWith >= 2)
            return true;
        else
        {
            this.withPrep = 0;
            return false;
        }


    }

    /**
     * Getter for this money frame
     * @return moneyFrame
     */
    public MoneyFrame getMoneyFrame() {
        return moneyFrame;
    }

    /**
     * Setter for current item list
     * @param itemsCurr
     */
    public void setItemsCurr(ArrayList<ItemSlot> itemsCurr) {
        this.itemsCurr = itemsCurr;
    }

    /**
     * Setter for current Money list
     * @param moneyCurr
     */
    public void setMoneyCurr(ArrayList<MoneySlot> moneyCurr) {
        this.moneyCurr = moneyCurr;
    }

    /**
     * Getter for current item list
     * @return itemsCurr
     */
    public ArrayList<ItemSlot> getItemsCurr() {
        return itemsCurr;
    }

    /**
     * Getter for current Money list
     * @return moneyCurr
     */
    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
    }
}
