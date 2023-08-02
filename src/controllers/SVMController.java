package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
import model.Record;
import model.SVM;
import view.*;

import javax.swing.*;
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
    int withPrep;

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

    public void clearSVM(){
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();
        this.specialVMFrame = new SpecialVMFrame(itemsCurr,moneyCurr,this);
    }

    public void purchaseItems(ArrayList<ItemSlot> cart, int totalAmt)
    {
        this.specialVMFrame.getFrame().dispose();
        this.specialVMFrame.dispose();

        this.totalDue = totalAmt;

        mainC.toMoneyFrame(totalAmt, 2);
    }

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

    public boolean isAvailable(int index){

        if (this.itemsCurr.get(index).getQuantity() >= 1)
            return true;
        else
            return false;

    }

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
