package model;

import model.Item;
/**
 * This is coconut item
 */
public class Coconut extends Item
{
    public Coconut(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being placed...");
        return name+" is being sliced...";
    }
}