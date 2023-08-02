package controllers;

import model.*;
import model.Record;
import view.*;

import java.util.ArrayList;

/**
 * This class handles all operations for connecting sub-operations in maintenance, svm, and rvm
 */
public class MainController {

    /**
     * itemsCurr = basis of current items
     * moneyCurr = basis for current money
     * changeList = basis for change to be dispensed
     * rvmController = sub-controller for regular vending machine
     * maintenanceController = sub-controller for maintenance
     * svmController = sub-controller for special vending machine
     * moneyFrame = centralized money frame
     * allRecord = basis for all records
     */
    private ArrayList<ItemSlot> itemCurr;
    private ArrayList<MoneySlot> moneyCurr;
    private ArrayList<MoneySlot> changeList;
    private RVMController rvmController;
    private MaintenanceController maintenanceController;
    private SVMController svmController;
    private MoneyFrame moneyFrame;
    private Record allRecord;

    /**
     * Constructor method for main controller and where items and money will be initialized
     */
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

    /**
     * This method will switch the frames from rvm to svm
     */
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

    /**
     * This method will switch the frames to the Maintenance frames
     */
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

    /**
     * This method is used when going back to the rvm frame from maintenance frame
     */
    public void pushedBacktoRVMfromM(){
        this.itemCurr = maintenanceController.getItemsCurr();
        this.moneyCurr = maintenanceController.getMoneyCurr();

        rvmController.setItemsCurr(this.itemCurr);
        rvmController.setMoneyCurr(this.moneyCurr);
        rvmController.backFromOthers();

    }

    /**
     * This method is used when going back to the rvm frame from svm frame
     */
    public void pushedBacktoRVMfromS(){
        this.itemCurr = svmController.getItemsCurr();
        this.moneyCurr = svmController.getMoneyCurr();

        rvmController.setItemsCurr(this.itemCurr);
        rvmController.setMoneyCurr(this.moneyCurr);
        rvmController.backFromOthers();

    }

    /**
     * This method is used to generate the money frame
     * @param totalAmt = total amout of money that needs to be paid
     * @param source = source that calls on money frame; 1 for rvm, 2 for svm
     */
    public void toMoneyFrame(int totalAmt, int source){
        this.moneyFrame = new MoneyFrame(totalAmt, this, source);
    }

    /**
     * This method checks if the vending machine has enough change
     * @param source = source that calls on this method; 1 for rvm, 2 for svm
     * @param totalPaid = total amount that the user paid
     * @return boolean = true, if there's enough change; false, if otherwise
     */
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

    /**
     * This automatically redirects user to rvm if no money was inputted and payment was cancelled
     */
    public void pushedBack(){
        rvmController.pushedBack(this.moneyFrame);
    }

    /**
     * This dispenses the user's money when payment is cancelled (from rvm)
     * @param moneyHold = money inputted by the user
     */
    public void showMoneyHold(ArrayList<Money> moneyHold){
        rvmController.showMoneyHold(moneyHold, this.moneyFrame);
    }

    /**
     * This automatically redirects user to svm if no money was inputted and payment was cancelled
     */
    public void pushedBackS(){
        svmController.pushedBackS(this.moneyFrame);
    }

    /**
     * This dispenses the user's money when payment is cancelled (from svm)
     * @param moneyHold = money inputted by the user
     */
    public void showMoneyHoldS(ArrayList<Money> moneyHold){
        svmController.showMoneyHoldS(moneyHold, this.moneyFrame);
    }

    /**
     * This method is used when a user can successfully purchase an item from rvm
     * @param totalMoney = total money paid by user
     */
    public void successPay(int totalMoney){
        rvmController.successPay(totalMoney, this.moneyFrame);
    }

    /**
     * This method is used when a user can successfully purchase an item from svm
     * @param totalMoney
     */
    public void successPayS(int totalMoney){
        svmController.successPayS(totalMoney, this.moneyFrame);
    }

    /**
     * This method is called when payment is successful and initiates the closing of loading frame/s
     * @param isDone = indicates if no more processing frames is needed
     * @param source = indicates if svm or rvm needs this method
     */
    public void closeWindow(int isDone, int source){
        if(source==1)
            rvmController.closeWindow(isDone);
        if(source==2)
            svmController.closeWindowS(isDone);

    }

    /**
     * This method is called when payment is cancelled the user inputted money is dispensed and closes the loading frame
     * @param isDone = indicates if no more processing frames is needed
     * @param source = indicates if svm or rvm needs this method
     */
    public void closeWindowMH(int isDone, int source){
        if(source==1)
            rvmController.closeWindowMH(isDone);
        if(source==2)
            svmController.closeWindowSMH(isDone);

    }

    /**
     * When a transaction is successful, it adds the inputted money into the current money array list
     * @param moneyHold = money inputted by the user
     */
    public void setMoneyCurr(ArrayList<Money> moneyHold){
        for(int i=0; i < moneyHold.size(); i++)
        {
            for (int j=0; j < this.moneyCurr.size(); j++)
            {
                if(this.moneyCurr.get(j).getMoney().getValue() == moneyHold.get(i).getValue())
                    this.moneyCurr.get(j).getReplenished(1);
                //System.out.println(this.moneyCurr.get(j).getQuantity());
            }
            //System.out.println(this.channgeList.get(i).getQuantity());
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
     * This method is called when exit is pressed and it terminates the program
     */
    public void terminateProgram(){
        System.exit(0);
    }
}
