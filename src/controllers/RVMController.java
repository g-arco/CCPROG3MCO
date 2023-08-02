package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
import model.Record;
import model.SVM;
import view.LoadingFrame;
import view.MoneyFrame;
import view.RVMFrame;

import java.util.ArrayList;

public class RVMController {

    RVMFrame rvmFrame;
    MoneyFrame moneyFrame;
    LoadingFrame loadingFrame;
    ArrayList<MoneySlot> moneyCurr;
    ArrayList<MoneySlot> channgeList;
    ArrayList<ItemSlot> itemsCurr;
    MainController mainC;
    SVM svm;

    ArrayList<ItemSlot> itemToBuy;
    ArrayList<String> itemPrep;
    int totalPaid;
    Record allRecord;

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

    public void initializeChangeList(){
        for (int i =0; i <this.channgeList.size(); i++)
        {
            this.channgeList.get(i).clearSlots();
            //System.out.println(this.channgeList.get(i).getQuantity());
            //System.out.println(this.moneyCurr.get(i).getQuantity());
        }

    }

    public void backFromOthers(){
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void pushedMaintenanceBtn(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.pushedMaintenanceBtn();
    }

    public void pushedSwitchBtn(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.pushedSVMBtn();
    }

    public void pushedGet(int totalAmt, ItemSlot itemSlot){
        itemToBuy = new ArrayList<ItemSlot>();
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        this.itemToBuy.add(itemSlot);
        this.itemToBuy.get(0).setToSell(1);
        mainC.toMoneyFrame(totalAmt, 1);

    }

    public void pushedBack(MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void pushedExit(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.terminateProgram();
    }


    public void showMoneyHold(ArrayList<Money> moneyHold,MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.loadingFrame = new LoadingFrame(moneyHold, mainC, 1);
    }
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
            initializeChangeList();
        }

    }

    public boolean isAvailable(ItemSlot itemSlot){
        if (itemSlot.getQuantity() >= 1)
            return true;
        else
            return false;

    }

    public void successPay(int totalPaid,MoneyFrame moneyFrame){
        this.moneyFrame = moneyFrame;
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();

        this.totalPaid = totalPaid;
        this.itemPrep = new ArrayList<String>();
        this.itemPrep = this.svm.proceedTransaction(this.itemToBuy);
        System.out.println(itemPrep.get(0));
        this.loadingFrame = new LoadingFrame(itemPrep, mainC, 1, 0, 0);
        this.itemsCurr = svm.getItemSlotArrayList();
        this.moneyCurr = svm.getMoneySlotArrayList();
    }

    public ArrayList<MoneySlot> getMoneyCurr() {
        return moneyCurr;
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
}
