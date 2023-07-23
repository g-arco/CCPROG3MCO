import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver
{


    public static void main (String args[])
    {
        Item Ice = new Item(0, 30, "Ice");
        Item Milk = new Item(80, 25, "Evaporated milk");
        Item VanillaIC = new Item(111, 25, "Vanilla ice cream");
        Item RiceKrispie = new Item(7, 10, "Rice krispie");
        Item Banana = new Item(8, 10, "Banana");
        Item Coconut = new Item(17, 15, "Coconut");
        Item MungBeans = new Item(12, 15, "Mung beans");
        Item Yam = new Item(15, 15, "Yam");
        //https://www.nutritionix.com/i/nutritionix/halo-halo-1-cup/56ba1309ef6b82185c64dd98

        ItemSlot IceSlots = new ItemSlot(Ice, 5);
        ItemSlot MilkSlots = new ItemSlot(Milk, 5);
        ItemSlot VanillaICSlots = new ItemSlot(VanillaIC, 5);
        ItemSlot RiceKrispieSlots = new ItemSlot(RiceKrispie, 5);
        ItemSlot BananaSlots = new ItemSlot(Banana, 5);
        ItemSlot CoconutSlots = new ItemSlot(Coconut, 5);
        ItemSlot MungBeansSlots = new ItemSlot(MungBeans, 5);
        ItemSlot YamSlots = new ItemSlot(Yam, 5);

        boolean flag;

        Money money1000 = new Money(1000, 0);
        Money money500 = new Money(500, 0);
        Money money200 = new Money(200, 0);
        Money money100 = new Money(100, 0);
        Money money50 = new Money(50, 0);
        Money money20 = new Money(20, 0);
        Money money10 = new Money(10, 0);
        Money money5 = new Money(5, 0);
        Money money1 = new Money(1, 0);

        ArrayList<ItemSlot> slots = new ArrayList<>();
        slots.add(IceSlots);
        slots.add(MilkSlots);
        slots.add(VanillaICSlots);
        slots.add(RiceKrispieSlots);
        slots.add(BananaSlots);
        slots.add(CoconutSlots);
        slots.add(MungBeansSlots);
        slots.add(YamSlots);
        Money money[] = {money1000, money500, money200, money100, money50, money20, money10, money5, money1};
        RVM r = new RVM(slots, money);
        Maintenance m = new Maintenance(slots, money);

        Menu menu = new Menu(r, m);

        //GUIMain main = new GUIMain();
        //MoneyFrame moneyF = new MoneyFrame();
        //MaintenanceFrame maitenanceF = new MaintenanceFrame();

        /*
        do
        {
            System.out.print("\033[H\033[2J"); 
            flag = menu.MainMenu();
        } while (flag == true);*/

    }
}