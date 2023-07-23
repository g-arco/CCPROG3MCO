/**
 * This is the ItemSlot class. It represents a slot in a typical vending machine. It holds items and it has a counter as to how many it is currently holding.
 */
public class ItemSlot
{
    /**
     *  item = the Item class that the ItemSlot will hold
     *  numItems = the total number of items ItemSlot is currently holding
     *  capacity = the total number of items ItemSlot can hold
     */
    private Item item;
    private int numItems;
    private int capacity;

    /**
     * Constructor method for class Item
     *
     * @param item is the item to be passed to the ItemSlot (It is necessary as ItemSlot needs Items)
     * @param numItems the initial number of items that the ItemSlot will hold
     */
    public ItemSlot(Item item, int numItems)
    {
        this.item = item;
        this.numItems = numItems;
        this.capacity = 10;
    }

    /**
     * A bit different setter for numItems of class ItemSlot
     *
     * @param i is the number to be added to the total of numItems
     */
    public void getRestocked(int i)
    {
        numItems += i;
    }

    /**
     * A getter for the ItemName of the its Item attribute
     *
     * @return String value of the name of the Item
     */
    public String returnItemName()
    {
        return item.getName();
    }

    /**
     * A getter for the value of capacity of ItemSlot class
     *
     * @return value of the capacity attribute of the ItemSlot
     */
    public int getCapacity()
    {
        return capacity;
    }
    /**
     * A getter to return the number of items it is currently holding
     *
     * @return the int value of the attribute numItems
     */
    public int getNumItems()
    {
        return numItems;
    }

    /**
     * A setter that simply subtracts numItems by 1
     *
     */
    public void setBoughtNumItems()
    {
        //System.out.println(this.numItems);
        this.numItems-= 1;
        //System.out.println(this.numItems);
    }
    /**
     * A getter that returns the Item attribute of the class ItemSlot
     *
     * @return the Item attribute
     */
    public Item getItem()
    {
        return item;
    }
}