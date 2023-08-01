package model;

/**
 * This is the model.Item class and it provides the value, calories, and price of the given item to be stored in ItemSlots and sold by RVM.
 *
 *
 */
public class Item
{
    protected int price;
    protected int calories;
    protected String name;
    protected boolean soldAlone;

    public Item (int price, int calories, String name, boolean soldAlone)
    {
        this.price = price;
        this.calories = calories;
        this.name = name;
        this.soldAlone = soldAlone;
    }

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

    public boolean getSoldAlone()
    {
        return this.soldAlone;
    }
}