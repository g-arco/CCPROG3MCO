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
    }

    public void getReplenished(int amount)
    {
        int i = 0;

        do
        {
            slot.add(money);
            i++;
        } while (i < amount);

        quantity = slot.size();

        System.out.println("Successfully replenished! Quantity is now "+quantity+".");
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
        return quantity;
    }
}