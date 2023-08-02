package model;

import model.Item;
/**
 * This is evaporated milk item
 */
public class EvapMilk extends Item
{
    public EvapMilk(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being poured...");
        return name+" is being poured...";
    }
}