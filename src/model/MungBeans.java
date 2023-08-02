package model;

import model.Item;
/**
 * This is mung beans item
 */
public class MungBeans extends Item
{
    public MungBeans(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being placed...");
        return name+" is being placed...";
    }
}