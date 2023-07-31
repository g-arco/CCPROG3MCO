package model;

import model.Item;

public class MungBeans extends Item
{
    public MungBeans(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public void ItemPreparation()
    {
        System.out.println(name+" is being placed...");
    }
}