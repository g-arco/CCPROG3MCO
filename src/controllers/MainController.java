package controllers;

import model.*;
import view.MaintenanceFrame;

import java.util.ArrayList;

public class MainController {

    ArrayList<ItemSlot> itemCurr;
    ArrayList<MoneySlot> moneyCurr;
    RVMController rvmController;
    MaintenanceController maintenanceController;

    public MainController(){

        Item ice = new Ice(5, 0, "Ice", false);
        Item evapMilk = new EvapMilk(25, 80, "Evaporated Milk", false);
        Item vanIceCream = new IceCream(25, 111, "Vanilla Ice Cream", true, "Vanilla");
        Item riKi = new RiceKrispie(10, 10, "Rice Krispie", false);
        Item banana = new Banana(10, 8, "Banana", true);
        Item coco = new Coconut(15, 17, "Coconut", true);
        Item mung = new MungBeans(15, 12, "Mung Beans", true);
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
        ArrayList<MoneySlot> changeList = new ArrayList<MoneySlot>();

        moneyList.add(money1000);
        moneyList.add(money500);
        moneyList.add(money200);
        moneyList.add(money100);
        moneyList.add(money50);
        moneyList.add(money20);
        moneyList.add(money10);
        moneyList.add(money5);
        moneyList.add(money1);

        changeList.add(money1000);
        changeList.add(money500);
        changeList.add(money200);
        changeList.add(money100);
        changeList.add(money50);
        changeList.add(money20);
        changeList.add(money10);
        changeList.add(money5);
        changeList.add(money1);

        this.moneyCurr = moneyList;
        this.itemCurr = initializeList;
        VendingMachine vm = new VendingMachine(this.itemCurr);

       rvmController = new RVMController(this.moneyCurr, this.itemCurr, changeList, this);
    }

    public void pushedMaintenanceBtn(){
        this.itemCurr = rvmController.getItemsCurr();
        this.moneyCurr = rvmController.getMoneyCurr();
        if (maintenanceController == null)
            maintenanceController = new MaintenanceController(this.moneyCurr, this.itemCurr, this);
        else
        {
            maintenanceController.setItemsCurr(this.itemCurr);
            maintenanceController.setMoneyCurr(this.moneyCurr);
            maintenanceController.backFromRVM();
        }

    }

    public void pushedBacktoRVM(){
        this.itemCurr = rvmController.getItemsCurr();
        this.moneyCurr = rvmController.getMoneyCurr();

        rvmController.setItemsCurr(this.itemCurr);
        rvmController.setMoneyCurr(this.moneyCurr);
        rvmController.backFromMaintenance();

    }

    public void terminateProgram(){

    }
}
