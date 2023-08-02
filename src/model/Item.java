package model;

/**
 * This is the Item class and it provides the value, calories, and price of the given item to be stored in ItemSlots and sold by RVM.
 *
 *
 */
public class Item
{
    /**
     * price = the item price
     * calories = the item calories
     * name = item name
     * soldAlone = if it can be sold alone (true) or it should be bought with ice and evaporated milk in svm (false)
     */
    protected int price;
    protected int calories;
    protected String name;
    protected boolean soldAlone;

    /**
     * Constructor method for Item
     * @param price = the item price
     * @param calories = the item calories
     * @param name = item name
     * @param soldAlone = if it can be sold alone (true) or it should be bought with ice and evaporated milk in svm (false)
     */
    public Item (int price, int calories, String name, boolean soldAlone)
    {
        this.price = price;
        this.calories = calories;
        this.name = name;
        this.soldAlone = soldAlone;
    }

    /**
     * The method called if we want to out the item preparation string
     * @return String
     */
    public String ItemPreparation()
    {
        System.out.println(name+" is being prepared...");
        return name+" is being prepared...";
    }

    /**
     * Setter to change price attribute of model.Item class
     *
     * @param price the new price of the model.Item
     */
    public void setPrice(int price)
    {
        this.price = price;
    }

    /**
     * Getter to return the value of calories of model.Item class
     *
     * @return the value of price of model.Item class
     */
    public int getCalories()
    {
        return this.calories;
    }
    /**
     * Getter to return the value of price of model.Item class
     *
     * @return the value of price of model.Item class
     */

    public int getPrice()
    {
        return this.price;
    }
    /**
     * Getter to return the name of the object of model.Item class
     *
     * @return the name of the object of model.Item class
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Getter for if sold alone or not
     * @return soldAlone
     */
    public boolean getSoldAlone()
    {
        return this.soldAlone;
    }
}