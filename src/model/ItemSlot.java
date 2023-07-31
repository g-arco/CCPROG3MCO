package model;

import model.Item;

import java.util.ArrayList;

public class ItemSlot
{
    private ArrayList<Item> items;
    private int quantity;

    public ItemSlot(Item i)
    {
        this.items = new ArrayList<Item>();
        this.items.add(i);
        this.quantity = 10;
    }

    // or alternatively, create a new instance of an item of the same type when this is called.
    public boolean addItem(Item item)
    {
        if (quantity < 10)
        {
            items.add(item);
            quantity++;
            return true;
        }

        else
            return false;
    }

    public boolean dispenseItem()
    {
        if (items.isEmpty() == false)
        {
            // ITEM IS BEING DISPENSED (AKA IT IS BEING "DELETED")
            return true;
        }

        else
            return false;
    }

    public int getQuantity()
    {
        return this.quantity;
    }
}