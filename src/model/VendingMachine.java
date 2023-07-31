package model;

import model.ItemSlot;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine
{
    private ArrayList<ItemSlot> itemSlotArrayList;
    private ArrayList<MoneySlot> moneySlotArrayList;

    public VendingMachine(ArrayList<ItemSlot> itemSlotArrayList)
    {
        this.itemSlotArrayList = itemSlotArrayList;
    }

    // YOU MAY WANT TO ADAPT THIS FOR GUI BUT FOR NOW, CLI IS JUST FOR TESTING
    public void sellItem()
    {
        Scanner s = new Scanner(System.in);
        int dChoice;
        ArrayList<ItemSlot> sellableItemList = new ArrayList<ItemSlot> ();

        System.out.println("ITEMS FOR SALE: ");
        for(int i = 0; i < itemSlotArrayList.size(); i++)
        {
            if(itemSlotArrayList.get(i).getCanSell() == true)
            {
                sellableItemList.add(itemSlotArrayList.get(i));
            }
        }

        for(int i = 0; i < sellableItemList.size(); i++)
        {
            System.out.println("["+i+"] - "+sellableItemList.get(i).getName());
        }

        System.out.println("What do you want to buy?");
        dChoice = s.nextInt();
    }


}