package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
import model.Record;
import model.SVM;
import view.LoadingFrame;
import view.MoneyFrame;
import view.RVMFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class handles all rvm operations
 */
public class RVMController {

    /**
     * rvmFrame = main rvm frame
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
     *  allRecord = basis of system records
     */
    private RVMFrame rvmFrame;
    private MoneyFrame moneyFrame;
    private LoadingFrame loadingFrame;
    private ArrayList<MoneySlot> moneyCurr;
    private ArrayList<MoneySlot> channgeList;
    private ArrayList<ItemSlot> itemsCurr;
    private MainController mainC;
    private SVM svm;

    private ArrayList<ItemSlot> itemToBuy;
    private ArrayList<String> itemPrep;
    private int totalPaid;
    private Record allRecord;

    /**
     * Constructor method for RVM Controller
     * @param moneyCurr =  current money in the system
     * @param itemsCurr = current items in the system
     * @param changeList = moneyslot arraylist for change
     * @param mainC = main controller
     * @param allRecord = records from main controller
     */
    public RVMController(ArrayList<MoneySlot> moneyCurr, ArrayList<ItemSlot> itemsCurr, ArrayList<MoneySlot> changeList,MainController mainC, Record allRecord){

        this.mainC = mainC;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;
        this.allRecord = allRecord;
        this.svm = new SVM(this.itemsCurr, this.moneyCurr, this.allRecord);
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
        this.channgeList = changeList;
        initializeChangeList();
    }

    /**
     * This method initializes change moneyslot array list
     */
    public void initializeChangeList(){
        for (int i =0; i <this.channgeList.size(); i++)
        {
            this.channgeList.get(i).clearSlots();
            //System.out.println(this.channgeList.get(i).getQuantity());
            //System.out.println(this.moneyCurr.get(i).getQuantity());
        }

    }

    /**
     * This method calls on a new rvm frame when it returns from other frames
     */
    public void backFromOthers(){
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    /**
     * This method redirects user to Maintenance frame
     */
    public void pushedMaintenanceBtn(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.pushedMaintenanceBtn();
    }

    /**
     * This method is used to switch from rvm frame to svm frame
     */
    public void pushedSwitchBtn(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.pushedSVMBtn();
    }

    /**
     * This method is used when a user chooses their desired item
     * @param totalAmt = total amount that needs to be paid
     * @param itemSlot = the itemslot of desired item
     */
    public void pushedGet(int totalAmt, ItemSlot itemSlot){
        itemToBuy = new ArrayList<ItemSlot>();
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        this.itemToBuy.add(itemSlot);
        this.itemToBuy.get(0).setToSell(1);
        mainC.toMoneyFrame(totalAmt, 1);

    }

    /**
     * This method redirects user back to rvm when payment is cancelled and no money was inputted
     * @param moneyFrame = the money frame that was displayed
     */
    public void pushedBack(MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    /**
     * This method will terminate program after exit button was pushed
     */
    public void pushedExit(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.terminateProgram();
    }
    /**
     * This dispenses the user's money when payment is cancelled
     * @param moneyHold = money inputted by the user
     * @param moneyFrame = money frame in display
     */
    public void showMoneyHold(ArrayList<Money> moneyHold,MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.loadingFrame = new LoadingFrame(moneyHold, mainC, 1);
    }

    /**
     * This method checks if there is sufficient change
     * @param totalPaid = total money paid by the user
     * @return boolean = true, if there is available change; false, if otherwise
     */
    public boolean checkChange(int totalPaid) {
        this.totalPaid = totalPaid;
        if (this.svm.produceChange(this.totalPaid, this.itemToBuy.get(0).getItem().getPrice(), this.channgeList).size() == 9) {
            System.out.println(this.channgeList.size());
            return true;
        }
        else {
            initializeChangeList();
            return false;
        }
    }


    /**
     * This method is called when payment is successful and initiates the closing of loading frame/s
     * @param isDone = 0 value indicates if there is more processing frames; 1, if no more processing after
     */
    public void closeWindow(int isDone){
        if(isDone ==0)
        {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();

            this.moneyCurr = this.svm.getMoneySlotArrayList();
            this.loadingFrame = new LoadingFrame(this.channgeList, mainC, 1,0);

        }
        else {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();

            this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
            JOptionPane.showMessageDialog(null, "Order Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            initializeChangeList();
        }

    }

    /**
     * This method is called when payment is cancelled the user inputted money is dispensed and closes the loading frame
     * @param isDone = indicates if there is more processing frames after
     */
    public void closeWindowMH(int isDone){
        if(isDone ==1)
        {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();

            this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
            JOptionPane.showMessageDialog(null, "Money Dispense Completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            initializeChangeList();
        }

    }

    /**
     * This method determines if the user's desired item still has stock
     * @param itemSlot = the item slot of desired item
     * @return bool = true, if item is available for purchase; false, if otherwise
     */
    public boolean isAvailable(ItemSlot itemSlot){
        if (itemSlot.getQuantity() >= 1)
            return true;
        else
            return false;

    }

    /**
     * This method is called when the item can be successfully dispensed
     * @param totalPaid = total amount of money paid
     * @param moneyFrame = the moneyFrame that is displayed
     */
    public void successPay(int totalPaid,MoneyFrame moneyFrame){
        int isDone=0;

        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();

        this.totalPaid = totalPaid;
        this.itemPrep = new ArrayList<String>();
        this.itemPrep = this.svm.proceedTransaction(this.itemToBuy,0);
        System.out.println(itemPrep.get(0));

        if (this.totalPaid == this.itemToBuy.get(0).getItem().getPrice()){
            isDone = 1;
        }
        this.loadingFrame = new LoadingFrame(itemPrep, mainC, 1, isDone, 0);
        this.itemsCurr = svm.getItemSlotArrayList();
        this.moneyCurr = svm.getMoneySlotArrayList();
    }

    /**
     * Getter for current MoneySlot arraylist
     * @return moneyCurr
     */
    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
    }

    /**
     * Getter for current ItemSlot arraylist
     * @return itemsCurr
     */
    public ArrayList<ItemSlot> getItemsCurr() {
        return itemsCurr;
    }

    /**
     * Setter for current MoneySlot arraylist
     * @param  moneyCurr
     */
    public void setMoneyCurr(ArrayList<MoneySlot> moneyCurr) {
        this.moneyCurr = moneyCurr;
    }

    /**
     * Getter for current ItemSlot arraylist
     * @param itemsCurr
     */
    public void setItemsCurr(ArrayList<ItemSlot> itemsCurr) {
        this.itemsCurr = itemsCurr;
    }
}
