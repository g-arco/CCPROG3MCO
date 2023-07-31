package model;

import model.Item;

import java.util.ArrayList;

public class ItemSlot
{
    private ArrayList<Item> items;
    private int quantity;
    private String name;
    private boolean canSell;
    private Item item;

    public ItemSlot(Item i)
    {
        this.items = new ArrayList<Item>();
        this.quantity = 5;
        name = i.getName();
        canSell = i.getSoldAlone();

        for(int counter = 0; counter < 5; counter++)
        {
            this.items.add(i);
        }
    }

    // use polymorphism.
    public boolean addItem(int amount)
    {
        if (quantity + amount <= 10)
        {
            do
            {
                items.add(item);
                quantity++;
                amount--;
            } while(amount != 0);

            return true;
        }

        else
            return false;
    }

    public boolean dispenseItem()
    {
        if (items.isEmpty() == false)
        {
            items.remove(quantity);
            return true;
        }

        else
            return false;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getCanSell()
    {
        return this.canSell;
    }

    public ArrayList<Item> getArrayList()
    {
        return this.items;
    }

    public Item getItem()
    {
        return this.item;
    }
}