package model;

import model.ItemSlot;

import java.util.ArrayList;

public class VendingMachine
{
    private ArrayList<ItemSlot> itemSlots;

    public VendingMachine()
    {
        this.itemSlots = new ArrayList<ItemSlot>();

    }

    public void testDisplayItems()
    {
        System.out.println("Hello world!");
    }

}