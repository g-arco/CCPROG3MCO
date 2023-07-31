package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Maintenance
{
    public void setNewPrice(Item i)
    {
        int newPrice;
        Scanner s = new Scanner(System.in);

        System.out.println("Insert new price of "+i.getName());
        System.out.println("Current price: "+i.getPrice());
        newPrice = s.nextInt();

        i.setPrice(newPrice);
    }

    public void restockItem(ItemSlot i)
    {
        Scanner s = new Scanner(System.in);
        int dAmount;
        boolean result;

        System.out.println("Insert amount to restock");
        dAmount = s.nextInt();

        result = i.addItem(dAmount);

        if(result)
            System.out.println("Success!");
        else
            System.out.println("Item slot is full!");

    }

    public void collectMoney(MoneySlot m) // update parameters if needed.
    {
        ArrayList<Money> n = m.getSlot();
        n.clear();
    }

    public void replenishMoney(MoneySlot ms) // update parameters if needed
    {
        Scanner s = new Scanner(System.in);
        int dAmount;

        System.out.println("Insert amount to replenish");
        dAmount = s.nextInt();

        ms.getReplenished(dAmount);
    }
}