/**
 * This is the Item class and it provides the value, calories, and price of the given item to be stored in ItemSlots and sold by RVM.
 *
 *
 */
public class Item
{
    /**
     * calories = int value of the number of calories of an item
     * price = the int value of the price of an item
     * name = the name of the item
     */
    private int calories;
    private int price;
    private String name;

    /**
     * Constructor method for class Item
     *
     * @param calories the amount of calories of an item
     * @param price the price of an item
     * @param name the name of an item
     */
    public Item(int calories, int price, String name)
    {
        this.calories = calories;
        this.price = price;
        this.name = name;
    }

    /**
     * Setter to change price attribute of Item class
     *
     * @param price the new price of the Item
     */
    public void changePrice(int price)
    {
        this.price = price;
    }

    /**
     * Getter to return the value of calories of Item class
     *
     * @return the value of price of Item class
     */
    public int getCalories()
    {
        return calories;
    }
    /**
     * Getter to return the value of price of Item class
     *
     * @return the value of price of Item class
     */

    public int getPrice()
    {
        return price;
    }
    /**
     * Getter to return the name of the object of Item class
     *
     * @return the name of the object of Item class
     */
    public String getName()
    {
        return name;
    }
}