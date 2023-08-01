package model;

import view.MaintenanceFrame;

import java.util.ArrayList;
import java.util.Scanner;

public class Maintenance
{
    ArrayList<ItemSlot> itemList;
    ArrayList<MoneySlot> moneyList;
    public Maintenance(ArrayList<ItemSlot> itemList, ArrayList<MoneySlot> moneyList){
        this.itemList = itemList;
        this.moneyList = moneyList;
    }
    public void setNewPrice(Item i, int newPHP)
    {
        int newPrice;

        newPrice = newPHP;

        i.setPrice(newPrice);
    }

    public void restockItem(ItemSlot i, int Amt)
    {
        int dAmount;
        boolean result;


        dAmount = Amt;

        result = i.addItem(dAmount);

        if(result)
            System.out.println("Success!");
        else
            System.out.println("Item slot is full!");

    }

    public void collectMoney(int mIndex) // update parameters if needed.
    {
        this.moneyList.get(mIndex).clearSlots();
    }

    public void replenishMoney(int mIndex, int Amt) // update parameters if needed
    {
        int dAmount;

        dAmount = Amt;

        this.moneyList.get(mIndex).getReplenished(dAmount);


    }

    public ArrayList<ItemSlot> getItemList() {
        return itemList;
    }

    public ArrayList<MoneySlot> getMoneyList() {
        return moneyList;
    }
}