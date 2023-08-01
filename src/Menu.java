import model.*;
import view.MoneyFrame;
import view.RVMFrame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Menu class is really just a way to implement the program and declutter the Menu.Driver class by only having the method MainMenu loop.
 */
public class Menu
{

    VendingMachine rvm;
    Maintenance m;

    /**
     * Constructor method to initialize Menu
     * @param rvm the vending machine itself
     * @param m maintenance class
     */
    public Menu (VendingMachine rvm, Maintenance m)
    {
        this.rvm = rvm;
        this.m = m;
    }

    /**
     * The main menu where classes start interacting with each other as well as for the user to input and output.
     * @return true if any method other than quit is called. returns false if user decides to quit, terminating the loop in Menu.Driver.
     */

    public void MainMenu() //tbc to boolean
    {
        Scanner s = new Scanner(System.in);
        int i, inputIndex, inputMoney = 0;
        int mIndex;
        boolean mFlag = true;
        int placeholder;
        int ifSure;
        int tempMoney;
        ArrayList<Integer> moneyarr = new ArrayList<Integer>();
        int moneyArrIndex;
        int noException, ifProceed, cancelItem;

        // source: https://intellipaat.com/community/294/java-clear-the-console
        System.out.print("\033[H\033[2J");
        System.out.println("Hello! Welcome to the Halo-Halo Zone!");
        System.out.println("What would you like to buy?");

        /*

        for (i = 0; i < rvm.getCurrentSlots().size(); i++)
        {
            System.out.print("["+i+"] - ");
            System.out.print(rvm.getCurrentSlots().get(i).returnItemName());
            System.out.print(" PHP ");
            System.out.print(rvm.getCurrentSlots().get(i).getItem().getPrice());
            System.out.print(" Calories: ");
            System.out.print(rvm.getCurrentSlots().get(i).getItem().getCalories());
            System.out.print(" Availability: ");
            System.out.println(rvm.getCurrentSlots().get(i).getNumItems());

            if (i == rvm.getCurrentSlots().size()-1)
            {
                System.out.println("[-1] - model.Maintenance Mode");
                System.out.println("[-2] - Quit");
            }
        }

        do
        {

            do {
                inputIndex = -1;
                noException = 0;

                while(noException == 0)
                {
                    try
                    {
                        inputIndex = s.nextInt();
                        noException = 1;
                    }
                    catch (Exception e)
                    {
                        s.nextLine();
                        System.out.println("ERROR: Please input an Integer");
                    }

                }
                if (!(inputIndex>=-2 && inputIndex<=i))
                    System.out.println("ERROR: Please input a valid number within the choices.");
            }while (!(inputIndex>=-2 && inputIndex<=i));

            System.out.println("Are you sure? [1] Yes [2] No");
            do {
                ifSure = -1;
                noException = 0;

                while(noException == 0)
                {
                    try
                    {
                        ifSure = s.nextInt();
                        noException = 1;
                    }
                    catch (Exception e)
                    {
                        s.nextLine();
                        System.out.println("ERROR: Please input an Integer.");
                    }

                }

                if ((ifSure!=1 && ifSure!=2))
                    System.out.println("ERROR: Please input [1] or [2]");
            }while (ifSure!=1 && ifSure!=2);

            if(ifSure!= 1)
                System.out.println("Input again: ");
        } while (ifSure!=1);

        if (inputIndex != -1 && inputIndex != -2)
        {
            if (rvm.pickItem(rvm.getCurrentSlots().get(inputIndex).getItem()) == true)
            {
                do
                {
                    ifProceed = 0;

                    tempMoney = -1;
                    noException = 0;

                    while(noException == 0)
                    {
                        try
                        {
                            System.out.println("Insert the money: ");
                            System.out.println("[Enter 0 to cancel]");
                            tempMoney = s.nextInt();
                            noException = 1;
                        }
                        catch (Exception e)
                        {
                            s.nextLine();
                            System.out.println("ERROR: Please input an Integer.");
                        }

                    }

                    if (!(tempMoney == 1000 || tempMoney == 500 || tempMoney == 200 || tempMoney == 100 ||
                            tempMoney == 50 || tempMoney == 20 || tempMoney == 10 || tempMoney == 5 ||
                            tempMoney == 1))
                    {
                        if (tempMoney ==0)
                        {
                            rvm.cancelItem();
                            ifProceed = 2;
                        }

                        else
                        {
                            System.out.println("Input a valid bill or coin!");
                            System.out.println("Valid bills: [1000] [500] [200] [100] [50] [20]");
                            System.out.println("Valid coins: [10] [5] [1]");

                            do {
                                System.out.println("Do you still want to proceed? [1]Yes [2]No");
                                noException = 0;

                                while(noException == 0)
                                {
                                    try
                                    {
                                        ifProceed = s.nextInt();
                                        noException = 1;
                                    }
                                    catch (Exception e)
                                    {
                                        s.nextLine();
                                        System.out.println("ERROR: Please input an Integer.");
                                    }

                                }

                                if ((ifProceed!=1 && ifProceed!=2))
                                    System.out.println("ERROR: Please input [1] or [2]");
                            }while (ifProceed!=1 && ifProceed!=2);

                        }
                        if (inputMoney!=0 && ifProceed ==2)
                        {
                            while(moneyarr.size()>0)
                            {
                                System.out.println("+"+moneyarr.get(moneyarr.size()-1)+" pesos dispensed");
                                moneyarr.remove(moneyarr.size()-1);
                            }
                            //System.out.println(moneyarr.size());

                        }

                    }
                    else
                    {
                        inputMoney += tempMoney;
                        moneyarr.add(tempMoney);
                    }

                    if (ifProceed==2)
                        return true;
                } while (inputMoney < rvm.getCurrentSlots().get(inputIndex).getItem().getPrice() ||
                        !(tempMoney == 1000 || tempMoney == 500 || tempMoney == 200 || tempMoney == 100 ||
                        tempMoney == 50 || tempMoney == 20 || tempMoney == 10 || tempMoney == 5 ||
                        tempMoney == 1));


                boolean paySuccess = rvm.payRVM(rvm.getCurrentSlots().get(inputIndex).getItem(), inputMoney);


                if (paySuccess == true)
                {
                    System.out.println(rvm.getCurrentSlots().get(inputIndex).getItem().getName()+" has been dispensed!");
                    System.out.println("Enter any number to continue: ");

                    placeholder = 0;
                    noException = 0;

                    while(noException == 0)
                    {
                        try
                        {
                            placeholder = s.nextInt();
                            noException = 1;
                        }
                        catch (Exception e)
                        {
                            s.nextLine();
                            System.out.println("ERROR: Please input an Integer.");
                        }

                    }

                    for (int j = rvm.getMoney().length-1; j >= 0; j--)
                    {
                        System.out.println(rvm.getMoney()[j].getValue()+"  "+rvm.getMoney()[j].getQuantity());

                    }

/*
                    for (moneyArrIndex = 0; moneyArrIndex < moneyarr.size(); moneyArrIndex++)
                    {
                        for(int j=0; j < 9; j++)
                        {
                            if (moneyarr.get(moneyArrIndex) == rvm.getMoney()[j].getValue())
                                rvm.getMoney()[j].setQuantity(rvm.getMoney()[j].getQuantity()+1);
                        }
                    }*/

        /*
                    for (int j = rvm.getMoney().length-1; j >= 0; j--)
                    {
                        System.out.println(rvm.getMoney()[j].getValue()+"  "+rvm.getMoney()[j].getQuantity());

                    }*/
                }
                /*else
                {
                    rvm.cancelItem();
                    while(moneyarr.size()>0)
                    {
                        System.out.println("+"+moneyarr.get(moneyarr.size()-1)+" pesos dispensed");
                        moneyarr.remove(moneyarr.size()-1);
                    }
                }

            }

            return true;
        }

        else if (inputIndex == -1)
        {
            do
            {

                System.out.print("\033[H\033[2J"); 
                System.out.println("What would you like to do?");
                System.out.println("[1] - Restock Items");
                System.out.println("[2] - Set Price of an model.Item");
                System.out.println("[3] - Replenish model.Money");
                System.out.println("[4] - Collect model.Money");
                System.out.println("[5] - Print Summary of Transactions");
                System.out.println("[6] - Quit");


                do
                {
                    mIndex = 0;
                    noException = 0;

                    while(noException == 0)
                    {
                        try
                        {
                            mIndex = s.nextInt();
                            noException = 1;
                        }
                        catch (Exception e)
                        {
                            s.nextLine();
                            System.out.println("ERROR: Please input an Integer.");
                        }

                    }
                    if(mIndex > 6 || mIndex <= 0)
                        System.out.println("ERROR: Please input a valid number within the choices.");
                }while (mIndex > 6 || mIndex <= 0);

                switch(mIndex)
                {/*
                    case 1:
                        rvm.setStartingSlots(rvm.getCurrentSlots());
                        m.setCurrentSlots(rvm.getCurrentSlots());
                        m.restockItem();
                        rvm.setCurrentSlots(m.getCurrentSLots());
                        rvm.resetRestockSale();
                        rvm.resetRestockListOfSoldItems();
                        break;
                    case 2:
                        m.setPrice();
                        rvm.setCurrentSlots(m.getCurrentSLots());
                        break;
                    case 3:
                        m.replenishMoney();
                        rvm.setMoney(m.getMoney());
                        break;
                    case 4:
                        m.collectMoney();
                        rvm.setMoney(m.getMoney());
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        rvm.displayTransactions();
                        System.out.println("Enter any number to continue: ");
                        break;
                    case 6:
                        mFlag = false;
                        break;*/

    public static class Driver
    {


        public static void main (String args[])
        {
            /*model.Item model.Ice = new model.Item(0, 30, "model.Ice");
            model.Item Milk = new model.Item(80, 25, "Evaporated milk");
            model.Item VanillaIC = new model.Item(111, 25, "Vanilla ice cream");
            model.Item model.RiceKrispie = new model.Item(7, 10, "Rice krispie");
            model.Item model.Banana = new model.Item(8, 10, "model.Banana");
            model.Item model.Coconut = new model.Item(17, 15, "model.Coconut");
            model.Item model.MungBeans = new model.Item(12, 15, "Mung beans");
            model.Item model.Yam = new model.Item(15, 15, "model.Yam");
            //https://www.nutritionix.com/i/nutritionix/halo-halo-1-cup/56ba1309ef6b82185c64dd98

            model.ItemSlot IceSlots = new model.ItemSlot(model.Ice, 5);
            model.ItemSlot MilkSlots = new model.ItemSlot(Milk, 5);
            model.ItemSlot VanillaICSlots = new model.ItemSlot(VanillaIC, 5);
            model.ItemSlot RiceKrispieSlots = new model.ItemSlot(model.RiceKrispie, 5);
            model.ItemSlot BananaSlots = new model.ItemSlot(model.Banana, 5);
            model.ItemSlot CoconutSlots = new model.ItemSlot(model.Coconut, 5);
            model.ItemSlot MungBeansSlots = new model.ItemSlot(model.MungBeans, 5);
            model.ItemSlot YamSlots = new model.ItemSlot(model.Yam, 5);

            boolean flag;

            model.Money money1000 = new model.Money(1000, 0);
            model.Money money500 = new model.Money(500, 0);
            model.Money money200 = new model.Money(200, 0);
            model.Money money100 = new model.Money(100, 0);
            model.Money money50 = new model.Money(50, 0);
            model.Money money20 = new model.Money(20, 0);
            model.Money money10 = new model.Money(10, 0);
            model.Money money5 = new model.Money(5, 0);
            model.Money money1 = new model.Money(1, 0);

            ArrayList<model.ItemSlot> slots = new ArrayList<>();
            slots.add(IceSlots);
            slots.add(MilkSlots);
            slots.add(VanillaICSlots);
            slots.add(RiceKrispieSlots);
            slots.add(BananaSlots);
            slots.add(CoconutSlots);
            slots.add(MungBeansSlots);
            slots.add(YamSlots);
            model.Money money[] = {money1000, money500, money200, money100, money50, money20, money10, money5, money1};
            RVM r = new RVM(slots, money);
            model.Maintenance m = new model.Maintenance(slots, money);*/


            /* Some crazy polymorphism: */


            // these are for testing only:
            Item ice = new Ice(5, 0, "model.Ice", false);
            Item evapMilk = new EvapMilk(0, 80, "Evaporated Milk", false);
            Item vanIceCream = new IceCream(25, 111, "Vanilla model.Ice Cream", true, "Vanilla");
            Item riKi = new RiceKrispie(10, 10, "Rice Krispie", false);
            Item banana = new Banana(10, 8, "model.Banana", true);
            Item coco = new Coconut(15, 17, "model.Coconut", true);
            Item mung = new MungBeans(15, 12, "Mung Beans", true);
            Item yam = new Yam(15, 15, "model.Yam", false);

            //model.Maintenance m = new model.Maintenance();

            ItemSlot iceSlot = new ItemSlot(ice);


            //Menu menu = new Menu(r, m);
            //view.MaintenanceFrame maitenanceF = new view.MaintenanceFrame();

            /*
            do
            {
                System.out.print("\033[H\033[2J");
                flag = menu.MainMenu();
            } while (flag == true);*/

        }
    }
}

            /*} while (mFlag == true);

            return true;
        }

        else
        {
            System.out.println("Thank you!");
            return false;
        }
    }*/


