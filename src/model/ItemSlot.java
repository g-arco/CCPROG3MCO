package model;

import model.Item;

import java.util.ArrayList;
/**
 * This class stores all available instance of a certain item
 */
public class ItemSlot
{
    /**
     * items = array of Item that will be stored/dispensed by this class
     * quantity = number of elements inside items
     * name = name of the Item that the class holds
     * canSell = boolean value if the Item it contains can be sold or not
     * item = ItemS that the ItemSlot is currently holding
     * toSell = the amount that the user wants to buy for their halo halo
     */
    private ArrayList<Item> items;
    private int quantity;
    private String name;
    private boolean canSell;
    private Item item;
    private int toSell;

    /**
     * Constructor 1 method to instantiate ItemSlot
     *
     * @param i = the Item that the ItemSlotS will hold or store
     */
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

    /**
     * Constructor 2 method to instantiate ItemSlot
     * @param i = the Item that the ItemSlotS will hold or store
     * @param quantity = indicated how much you want to initialize this instance
     */
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

    /**
     * adds an ItemS amount times to the items arraylist.
     * @param amount = the number of times to add an item to items arraylist
     * @return true if it successfully stores and false if not
     */
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

    /**
     * Dispenses (or removes) an ItemS from items
     * @return true if it is successful and false if not
     */
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

    /**
     * This method is used in conjuction with SVM
     * @param i
     */
    public void setToSell(int i)
    {
        this.toSell = i;
    }

    /**
     * This method cancels the order by setting the amount to sell to zero and resets the quantity to the current size of the items arraylist
     */
    public void cancelOrder()
    {
        this.toSell = 0;
        this.quantity = items.size();
    }

    /**
     * This method returns toSell
     * @return toSell = integer value of the number of items to sell
     */
    public int getToSell()
    {
        return this.toSell;
    }

    /**
     * This method returns the quantity
     * @return quantity = the number of items in the arraylist (temporary value)
     */
    public int getQuantity()
    {
        return this.quantity;
    }

    /**
     * This method returns the name of the item the itemslot is currently holding
     * @return name = the name of the item
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * This method returns the boolean value which indicates if the item the itemslot holds can be sold or not
     * @return canSell = boolean value which indicates if the item the itemslot holds can be sold or not
     */
    public boolean getCanSell()
    {
        return this.canSell;
    }

    /**
     * This method returns the arraylist that contains the item that the itemslot is currently holding
     * @return items = the arraylist that contains the item that the itemslot is currently holding
     */
    public ArrayList<Item> getArrayList()
    {
        return this.items;
    }
    /**
     * This method returns the item that the itemslot is currently holding
     * @return item = the item that the itemslot is currently holding
     */
    public Item getItem()
    {
        return this.item;
    }

}