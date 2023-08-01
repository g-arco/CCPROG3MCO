package model;

import model.Item;

public class Banana extends Item
{
    public Banana(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being sliced...");
        return name+" is being sliced...";
    }
}