package model;

import model.Item;
/**
 * This is yam item
 */
public class Yam extends Item
{
    public Yam(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being placed...");
        return name+" is being placed...";
    }
}