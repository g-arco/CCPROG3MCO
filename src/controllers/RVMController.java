package controllers;

import model.ItemSlot;
import model.Money;
import model.MoneySlot;
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
    ArrayList<ItemSlot> itemsCurr;
    MainController mainC;
    SVM svm;

    ArrayList<ItemSlot> itemToBuy;

    public RVMController(ArrayList<MoneySlot> moneyCurr, ArrayList<ItemSlot> itemsCurr, ArrayList<MoneySlot> changeList,MainController mainC){

        this.mainC = mainC;
        this.moneyCurr = moneyCurr;
        this.itemsCurr = itemsCurr;
        this.svm = new SVM(this.itemsCurr, this.moneyCurr);
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void backFromMaintenance(){
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void pushedMaintenanceBtn(){
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        mainC.pushedMaintenanceBtn();
    }

    public void pushedGet(int totalAmt, ItemSlot itemSlot){
        itemToBuy = new ArrayList<ItemSlot>();
        this.rvmFrame.getFrame().dispose();
        this.rvmFrame.dispose();
        this.itemToBuy.add(itemSlot);
        this.itemToBuy.get(0).setToSell(1);
        this.moneyFrame = new MoneyFrame(totalAmt, this);

    }

    public void pushedBack(){
        this.moneyFrame.getFrame().dispose();
        this.moneyFrame.dispose();
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void showMoneyHold(ArrayList<Money> moneyHold){
        this.moneyFrame.dispose();
        this.loadingFrame = new LoadingFrame(moneyHold, this);
    }

    public void closeWindow(){
        this.loadingFrame.getFrame().dispose();
        this.loadingFrame.dispose();
        this.rvmFrame = new RVMFrame(this.itemsCurr, this.moneyCurr, this);
    }

    public void successPay(){
        this.moneyFrame.dispose();
        ArrayList<Money> change = new ArrayList<>();
        change.add(new Money(1));
        ArrayList<String> itemPrep = new ArrayList<String>();
        itemPrep = this.svm.proceedTransaction(this.itemToBuy);
        this.loadingFrame = new LoadingFrame(itemPrep, change, this);
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
