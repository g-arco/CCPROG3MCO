package model;

/**
 * The RecordS class serves as a record of transactions of the SVM class
 */

import java.util.ArrayList;

public class Record
{
    /**
     * totalSale = the total number of sales from the SVM
     * inventory = the current inventory of the SVM
     */
    private int totalSale;
    private ArrayList<ItemSlot> inventory;
    private ArrayList<ItemSlot> prevInventory;
    private ArrayList<Item> soldItems;

    /**
     * This is the constructor method for RecordS which sets the totalSale to zero and instantiates a new arraylist of ItemSlotS
     */
    public Record(ArrayList<ItemSlot> newInventory)
    {
        this.totalSale = 0;
        this.inventory = newInventory;
        this.prevInventory = new ArrayList<ItemSlot>();
        this.soldItems = new ArrayList<Item>();

        int quantity_temp;
        Item item_temp;

        for (int i = 0; i <newInventory.size(); i++)
        {
            quantity_temp = newInventory.get(i).getQuantity();
            item_temp = newInventory.get(i).getItem();
            this.prevInventory.add(new ItemSlot(item_temp,quantity_temp));
        }
    }

    public void initializeRecord(ArrayList<ItemSlot> newInventory)
    {
        this.totalSale = 0;
        this.inventory = newInventory;
        this.prevInventory.clear();
        this.soldItems.clear();

        int quantity_temp;
        Item item_temp;

        for (int i = 0; i <newInventory.size(); i++)
        {
            quantity_temp = newInventory.get(i).getQuantity();
            item_temp = newInventory.get(i).getItem();
            this.prevInventory.add(new ItemSlot(item_temp,quantity_temp));
        }

    }


    /**
     * This is the method that updates the inventory and salesMade once a transaction in SVM has been performed
     * @param inventory = the arraylist of ItemSlotS which will update Record's inventory record
     * @param salesMade = the amount made after a transaction to be added to the totalSale attribute
     */
    public void update(ArrayList<ItemSlot> inventory, int salesMade, Item item)
    {
        this.inventory = inventory;
        this.totalSale += salesMade;
        this.soldItems.add(item);
    }

    /**
     * This method just prints the total sale, the name and the quantity inside each ItemSlotS inside inventory
     */
    public ArrayList<String> printRecord()
    {
        ArrayList<String> printSummary = new ArrayList<String>();

        System.out.println("Total Sales: "+totalSale);
        printSummary.add("Total Sales: "+totalSale+" PHP \r\n");

        printSummary.add("==========SOLD ITEMS==========\r\n");
        if(soldItems.size()==0)
        {
            printSummary.add("NONE \r\n");
        }
        else
        {
            for(int i = 0; i < soldItems.size(); i++)
            {
                printSummary.add(soldItems.get(i).getName()+"+");
            }
            printSummary.add("\r\n");

        }

        printSummary.add("===========PREVIOUS INVENTORY==========\r\n");
        for(int i = 0; i < prevInventory.size(); i++)
        {
            System.out.print(inventory.get(i).getName());
            System.out.println(" Stock: "+inventory.get(i).getQuantity());
            printSummary.add(prevInventory.get(i).getName()+" Stock: "+prevInventory.get(i).getQuantity()+"\r\n");
        }

        printSummary.add("==========CURRENT INVENTORY==========\r\n");
        for(int i = 0; i < inventory.size(); i++)
        {
            System.out.print(inventory.get(i).getName());
            System.out.println(" Stock: "+inventory.get(i).getQuantity());
            printSummary.add(inventory.get(i).getName()+" Stock: "+inventory.get(i).getQuantity()+"\r\n");
        }

        return printSummary;
    }

    /**
     * This method returns the total sales made
     * @return totalSale = total sales made
     */
    public int getTotalSale()
    {
        return this.totalSale;
    }

    /**
     * This method returns the inventory, the arraylist of ItemSlotS
     * @return inventory = arraylist of ItemSlotS
     */
    public ArrayList<ItemSlot> getInventory()
    {
        return this.inventory;
    }
}