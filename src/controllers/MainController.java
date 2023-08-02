package controllers;

import model.*;
import model.Record;
import view.*;

import java.util.ArrayList;

public class MainController {

    ArrayList<ItemSlot> itemCurr;
    ArrayList<MoneySlot> moneyCurr;
    ArrayList<MoneySlot> changeList;
    RVMController rvmController;
    MaintenanceController maintenanceController;
    SVMController svmController;
    MoneyFrame moneyFrame;
    Record allRecord;

    public MainController(){

        Item ice = new Ice(5, 0, "Ice", false);
        Item evapMilk = new EvapMilk(25, 80, "Evaporated Milk", false);
        Item vanIceCream = new IceCream(25, 111, "Vanilla Ice Cream", true, "Vanilla");
        Item riKi = new RiceKrispie(10, 10, "Rice Krispie", false);
        Item banana = new Banana(10, 8, "Banana", true);
        Item coco = new Coconut(15, 17, "Coconut", true);
        Item mung = new MungBeans(15, 12, "Mung Beans", false);
        Item yam = new Yam(15, 15, "Yam", false);


        ItemSlot iceSlot = new ItemSlot(ice);
        ItemSlot emSlot = new ItemSlot(evapMilk);
        ItemSlot vanICSlot = new ItemSlot(vanIceCream);
        ItemSlot rkSlot = new ItemSlot(riKi);
        ItemSlot bananaSlot = new ItemSlot(banana);
        ItemSlot coconutSlot = new ItemSlot(coco);
        ItemSlot mungSlot = new ItemSlot(mung);
        ItemSlot yamSlot = new ItemSlot(yam);

        ArrayList<ItemSlot> initializeList = new ArrayList<ItemSlot>();

        initializeList.add(iceSlot);
        initializeList.add(emSlot);
        initializeList.add(vanICSlot);
        initializeList.add(rkSlot);
        initializeList.add(bananaSlot);
        initializeList.add(coconutSlot);
        initializeList.add(mungSlot);
        initializeList.add(yamSlot);

        MoneySlot money1000 = new MoneySlot(new Money(1000));
        MoneySlot money500 = new MoneySlot(new Money(500));
        MoneySlot money200 = new MoneySlot(new Money(200));
        MoneySlot money100 = new MoneySlot(new Money(100));
        MoneySlot money50 = new MoneySlot(new Money(50));
        MoneySlot money20 = new MoneySlot(new Money(20));
        MoneySlot money10 = new MoneySlot(new Money(10));
        MoneySlot money5 = new MoneySlot(new Money(5));
        MoneySlot money1 = new MoneySlot(new Money(1));

        ArrayList<MoneySlot> moneyList = new ArrayList<MoneySlot>();
        ArrayList<MoneySlot> forChange = new ArrayList<MoneySlot>();

        moneyList.add(money1000);
        moneyList.add(money500);
        moneyList.add(money200);
        moneyList.add(money100);
        moneyList.add(money50);
        moneyList.add(money20);
        moneyList.add(money10);
        moneyList.add(money5);
        moneyList.add(money1);

        MoneySlot money1000C = new MoneySlot(new Money(1000));
        MoneySlot money500C = new MoneySlot(new Money(500));
        MoneySlot money200C = new MoneySlot(new Money(200));
        MoneySlot money100C = new MoneySlot(new Money(100));
        MoneySlot money50C = new MoneySlot(new Money(50));
        MoneySlot money20C = new MoneySlot(new Money(20));
        MoneySlot money10C = new MoneySlot(new Money(10));
        MoneySlot money5C = new MoneySlot(new Money(5));
        MoneySlot money1C = new MoneySlot(new Money(1));

        forChange.add(money1000C);
        forChange.add(money500C);
        forChange.add(money200C);
        forChange.add(money100C);
        forChange.add(money50C);
        forChange.add(money20C);
        forChange.add(money10C);
        forChange.add(money5C);
        forChange.add(money1C);


        this.moneyCurr = moneyList;
        this.itemCurr = initializeList;
        this.changeList = forChange;

        this.allRecord = new Record(this.itemCurr);

       rvmController = new RVMController(this.moneyCurr, this.itemCurr, changeList, this, this.allRecord);
    }

    public void pushedSVMBtn(){
        this.itemCurr = rvmController.getItemsCurr();
        this.moneyCurr = rvmController.getMoneyCurr();
        if (svmController == null)
            svmController = new SVMController(this.moneyCurr, this.itemCurr, changeList,this, allRecord);
        else
        {
            svmController.setItemsCurr(this.itemCurr);
            svmController.setMoneyCurr(this.moneyCurr);
            svmController.backFromRVM();
        }

    }

    public void pushedMaintenanceBtn(){
        this.itemCurr = rvmController.getItemsCurr();
        this.moneyCurr = rvmController.getMoneyCurr();
        if (maintenanceController == null)
            maintenanceController = new MaintenanceController(this.moneyCurr, this.itemCurr, this, allRecord);
        else
        {
            maintenanceController.setItemsCurr(this.itemCurr);
            maintenanceController.setMoneyCurr(this.moneyCurr);
            maintenanceController.backFromRVM();
        }

    }

    public void pushedBacktoRVMfromM(){
        this.itemCurr = maintenanceController.getItemsCurr();
        this.moneyCurr = maintenanceController.getMoneyCurr();

        rvmController.setItemsCurr(this.itemCurr);
        rvmController.setMoneyCurr(this.moneyCurr);
        rvmController.backFromOthers();

    }

    public void pushedBacktoRVMfromS(){
        this.itemCurr = svmController.getItemsCurr();
        this.moneyCurr = svmController.getMoneyCurr();

        rvmController.setItemsCurr(this.itemCurr);
        rvmController.setMoneyCurr(this.moneyCurr);
        rvmController.backFromOthers();

    }

    public void toMoneyFrame(int totalAmt, int source){
        this.moneyFrame = new MoneyFrame(totalAmt, this, source);
    }

    public boolean checkChange(int source, int totalPaid){
        if(source==1)
        {
            return rvmController.checkChange(totalPaid);
        }
        else
        {
            boolean i = svmController.checkChange(totalPaid);
            System.out.println(i+"!!!!");
            return i;
        }

    }

    public void pushedBack(){
        rvmController.pushedBack(this.moneyFrame);
    }

    public void showMoneyHold(ArrayList<Money> moneyHold){
        rvmController.showMoneyHold(moneyHold, this.moneyFrame);
    }

    public void pushedBackS(){
        svmController.pushedBackS(this.moneyFrame);
    }

    public void showMoneyHoldS(ArrayList<Money> moneyHold){
        svmController.showMoneyHoldS(moneyHold, this.moneyFrame);
    }

    public void successPay(int totalMoney){
        rvmController.successPay(totalMoney, this.moneyFrame);
    }

    public void successPayS(int totalMoney){
        svmController.successPayS(totalMoney, this.moneyFrame);
    }

    public void closeWindow(int isDone, int source){
        if(source==1)
            rvmController.closeWindow(isDone);
        if(source==2)
            svmController.closeWindowS(isDone);

    }

    public void setMoneyCurr(ArrayList<Money> moneyHold){
        for(int i=0; i < moneyHold.size(); i++)
        {
            for (int j=0; j < this.moneyCurr.size(); j++)
            {
                if(this.moneyCurr.get(j).getMoney() == moneyHold.get(i))
                    this.moneyCurr.get(j).getReplenished(1);
            }
        }
    }

    public MoneyFrame getMoneyFrame() {
        return moneyFrame;
    }

    public void terminateProgram(){
        System.exit(0);
    }
}
