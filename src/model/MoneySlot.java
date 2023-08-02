package model;

import java.util.ArrayList;
/**
 * This is the MoneySlot, the container for the Money class.
 */
public class MoneySlot
{
    /**
     * value = the integer value of the moneyS it holds
     * money = the MoneyS object that the MoneySlotS is currently "simulating"
     * slot = the array for each instance of MoneyS
     * quantity = the number of elements currently inside slot
     */
    private int value;
    private Money money;
    private ArrayList<Money> slot;
    private int quantity;

    /**
     * Constructor method for MoneySlotS
     * @param m = the money that the slot will contain
     */
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
        } while (i < 0);// 15 is just an arbitrary number lol
        quantity = 0;
    }

    /**
     * This method replenishes the slot amount times
     * @param amount
     */
    public void getReplenished(int amount)
    {
        int i = 0;
        System.out.println(i+" "+amount);

        while (i < amount)
        {
            slot.add(money);
            i++;
            System.out.println(i);
        }
        System.out.println(slot.size());
        this.quantity = slot.size();

        System.out.println("Successfully replenished! Quantity is now "+this.quantity+": "+this.money.getValue());
    }

    /**
     * This method clears all the money for this certain money slots
     */
    public void clearSlots()
    {
        slot.clear();

        quantity = slot.size();

        System.out.println("Successfully cleared! Quantity is now "+quantity+": "+this.money.getValue());
    }


    /**
     * dispense 1 instance of moneyS by removing one instance of moneyS
     * @return true if successful and false if not
     */
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


    /**
     * getter for the value
     * @return = value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * getter for the slot
     * @return = slot
     */
    public ArrayList<Money> getSlot()
    {
        return slot;
    }

    /**
     * getter for the money
     * @return money
     */
    public Money getMoney()
    {
        return money;
    }

    /**
     * getter for the quantity
     * @return quantity
     */
    public int getQuantity()
    {
        return this.quantity;
    }

}