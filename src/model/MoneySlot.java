package model;

import java.util.ArrayList;

public class MoneySlot
{
    private int value;
    private Money money;
    private ArrayList<Money> slot;
    private int quantity;

    public MoneySlot(Money m)
    {
        this.money = m;
        slot = new ArrayList<Money>();
        value = m.getValue();
        int i = 0;

        do
        {
            slot.add(m);
            i++;
        } while (i < 15); // 15 is just an arbitrary number lol
        quantity = 15;
    }

    public void getReplenished(int amount)
    {
        int i = 0;

        do
        {
            slot.add(money);
            i++;
        } while (i < amount);

        this.quantity = slot.size();

        System.out.println("Successfully replenished! Quantity is now "+this.quantity+": "+this.money.getValue());
    }

    public void clearSlots()
    {
        slot.clear();

        quantity = slot.size();

        System.out.println("Successfully cleared! Quantity is now "+quantity+": "+this.money.getValue());
    }

    public boolean dispense()
    {
        if(!slot.isEmpty())
        {
            slot.remove(quantity-1);
            quantity--;
            return true;
        }

        else
            return false;
    }


    public int getValue()
    {
        return value;
    }

    public ArrayList<Money> getSlot()
    {
        return slot;
    }

    public Money getMoney()
    {
        return money;
    }

    public int getQuantity()
    {
        return this.quantity;
    }
}