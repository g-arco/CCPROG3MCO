package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
import model.Record;
import model.SVM;
import view.*;

import java.util.ArrayList;

public class SVMController {
    SpecialVMFrame specialVMFrame;
    MoneyFrame moneyFrame;
    LoadingFrame loadingFrame;
    ArrayList<MoneySlot> moneyCurr;
    ArrayList<MoneySlot> channgeList;
    ArrayList<ItemSlot> itemsCurr;
    MainController mainC;
    SVM svm;

    ArrayList<ItemSlot> itemToBuy;
    ArrayList<String> itemPrep;
    int totalPaid, totalDue;
    Record allRecord;

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

    public void initializeChangeList(){
        for (int i =0; i <this.channgeList.size(); i++)
        {
            this.channgeList.get(i).clearSlots();
            //System.out.println(this.channgeList.get(i).getQuantity());
            //System.out.println(this.moneyCurr.get(i).getQuantity());
        }

    }

    public void pushedMaintenanceBtn(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        mainC.pushedMaintenanceBtn();
    }

    public void backFromMaintenance(){
        this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void backFromRVM(){
        this.specialVMFrame = new SpecialVMFrame(itemsCurr,moneyCurr,this);
    }

    public boolean pushedtoRVM(){
        this.specialVMFrame.getFrame().dispose();
        specialVMFrame.dispose();
        mainC.pushedBacktoRVMfromS();
        return true;
    }

    public void pushedSwitchBtn(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        mainC.pushedBacktoRVMfromS();
    }

    public void purchaseItems(ArrayList<ItemSlot> cart, int totalAmt)
    {
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();

        this.totalDue = totalAmt;

        mainC.toMoneyFrame(totalAmt, 2);
    }

    public void successPayS(int totalPaid,MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();

        this.totalPaid = totalPaid;

        this.itemPrep = new ArrayList<String>();
        this.itemPrep = this.svm.proceedTransaction(this.itemsCurr);

        for (int i = 0; i < this.itemPrep.size(); i++)
        {
            //this.itemToBuy.add(cart.get(i));
            System.out.println(itemPrep.get(i));
        }

        this.loadingFrame = new LoadingFrame(itemPrep, mainC, 2, 0, 0);
        this.itemsCurr = svm.getItemSlotArrayList();
        this.moneyCurr = svm.getMoneySlotArrayList();
    }

    public void pushedBackS(MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void showMoneyHoldS(ArrayList<Money> moneyHold, MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.loadingFrame = new LoadingFrame(moneyHold, mainC,2);
    }

    public void closeWindowS(int isDone){
        if(isDone ==0)
        {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();

            this.channgeList = this.svm.produceChange(this.totalPaid, this.totalDue, this.channgeList);
            this.moneyCurr = this.svm.getMoneySlotArrayList();
            this.loadingFrame = new LoadingFrame(this.channgeList, mainC, 2,0);

        }
        else {
            this.loadingFrame.getFrame().dispose();
            this.loadingFrame.dispose();
            this.specialVMFrame = new SpecialVMFrame(this.itemsCurr, this.moneyCurr, this);
            initializeChangeList();
        }

    }

    public MoneyFrame getMoneyFrame() {
        return moneyFrame;
    }

    public void setItemsCurr(ArrayList<ItemSlot> itemsCurr) {
        this.itemsCurr = itemsCurr;
    }

    public void setMoneyCurr(ArrayList<MoneySlot> moneyCurr) {
        this.moneyCurr = moneyCurr;
    }

    public ArrayList<ItemSlot> getItemsCurr() {
        return itemsCurr;
    }

    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
    }
}
