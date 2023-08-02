package model;

import model.Item;
/**
 * This is rice krispie item
 */
public class RiceKrispie extends Item
{
    public RiceKrispie(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being chopped...");
        return name+" is being chopped...";
    }
}