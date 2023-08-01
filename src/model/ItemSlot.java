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
    private int toSell;

    public ItemSlot(Item i)
    {
        this.items = new ArrayList<Item>();
        this.quantity = 5;
        name = i.getName();
        canSell = i.getSoldAlone();
        this.item = i;

        for(int counter = 0; counter < 5; counter++)
        {
            this.items.add(i);
        }


    }

    public ItemSlot(Item i, int quantity)
    {
        this.items = new ArrayList<Item>();
        this.quantity = quantity;
        name = i.getName();
        canSell = i.getSoldAlone();
        this.item = i;

        for(int counter = 0; counter < quantity; counter++)
        {
            this.items.add(i);
        }

    }


    // use polymorphism.
    public boolean addItem(int amount)
    {
        if(amount <= 0)
            return false;

        else if (quantity + amount <= 10)
        {
            do
            {
                items.add(item);
                quantity++;
                amount--;
            } while(amount != 0);

            this.toSell = 0;
            System.out.println(quantity);
            return true;
        }

        else
            return false;
    }

    public boolean dispenseItem()
    {
        if (items.isEmpty() == false)
        {
            items.remove(quantity-1);
            quantity--;
            setToSell(this.toSell-1);
            return true;
        }

        else
            return false;
    }

    public void setToSell(int i)
    {
        this.toSell = i;
    }

    public void cancelOrder()
    {
        this.toSell = 0;
        this.quantity = items.size();
    }

    public int getToSell()
    {
        return this.toSell;
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