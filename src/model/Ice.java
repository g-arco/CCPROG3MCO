package model;

import model.Item;

public class Ice extends Item
{
    public Ice(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public String ItemPreparation()
    {
        System.out.println(name+" is being crushed...");
        return name+" is being crushed...";
    }
}