/**
 * This is the Maintenance class for special vending machine.
 * It sets the price of an item, restocks an itemSlot, collects and replenishes moneySlotS.
 */

package model;

import view.MaintenanceFrame;

import java.util.ArrayList;
import java.util.Scanner;

public class Maintenance
{
    /**
     * itemList = reference for current itemslot ArrayList in program
     * moneyList = reference for current moneyslot ArrayList in program
     */
    ArrayList<ItemSlot> itemList;
    ArrayList<MoneySlot> moneyList;

    /**
     * This is the constructor method used to initialize the values that will be changed
     * @param itemList = list of all available items
     * @param moneyList = list of current money in the system
     */
    public Maintenance(ArrayList<ItemSlot> itemList, ArrayList<MoneySlot> moneyList){
        this.itemList = itemList;
        this.moneyList = moneyList;
    }

    /**
     * A method to set the price of item
     * @param i = the Item that the price will be changed to
     * @param newPHP = new price for the item
     */
    public void setNewPrice(Item i, int newPHP)
    {
        int newPrice;

        newPrice = newPHP;

        i.setPrice(newPrice);
    }


    /**
     * A method to restock an itemSlotS
     * @param i = the ItemSlot to restock
     * @param Amt = the amount of items that will be put in the current stock
     */
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

    /**
     * A method to clear the arraylist attribute of a MoneySlot
     * @param mIndex = the slot that will be cleared or "collected"
     */
    public void collectMoney(int mIndex) // update parameters if needed.
    {
        this.moneyList.get(mIndex).clearSlots();
    }

    /**
     * A method to add more Money to the arraylist attribute of MoneySlotS
     * @param mIndex = the MoneySlot to replenish
     * @param Amt = the amount that will be added
     */
    public void replenishMoney(int mIndex, int Amt) // update parameters if needed
    {
        int dAmount;

        dAmount = Amt;

        this.moneyList.get(mIndex).getReplenished(dAmount);


    }

    /**
     * Getters fot this current ItemSlot Array list
     * @return itemList
     */
    public ArrayList<ItemSlot> getItemList() {
        return itemList;
    }

    /**
     * Getters fot this current MoneySlot Array list
     * @return moneyList
     */
    public ArrayList<MoneySlot> getMoneyList() {
        return moneyList;
    }
}