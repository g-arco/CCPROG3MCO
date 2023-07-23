import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import java.io.*;
/**
 * This Menu class is really just a way to implement the program and declutter the Driver class by only having the method MainMenu loop.
 */
public class Menu
{
    RVM rvm;
    Maintenance m;

    /**
     * Constructor method to initialize Menu
     * @param rvm the vending machine itself
     * @param m maintenance class
     */
    public Menu (RVM rvm, Maintenance m)
    {
        this.rvm = rvm;
        this.m = m;
    }

    /**
     * The main menu where classes start interacting with each other as well as for the user to input and output.
     * @return true if any method other than quit is called. returns false if user decides to quit, terminating the loop in Driver.
     */

    public boolean MainMenu()
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
                System.out.println("[-1] - Maintenance Mode");
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

                    /*for (int j = rvm.getMoney().length-1; j >= 0; j--)
                    {
                        System.out.println(rvm.getMoney()[j].getValue()+"  "+rvm.getMoney()[j].getQuantity());

                    }*/

                    for (moneyArrIndex = 0; moneyArrIndex < moneyarr.size(); moneyArrIndex++)
                    {
                        for(int j=0; j < 9; j++)
                        {
                            if (moneyarr.get(moneyArrIndex) == rvm.getMoney()[j].getValue())
                                rvm.getMoney()[j].setQuantity(rvm.getMoney()[j].getQuantity()+1);
                        }
                    }

                    /*for (int j = rvm.getMoney().length-1; j >= 0; j--)
                    {
                        System.out.println(rvm.getMoney()[j].getValue()+"  "+rvm.getMoney()[j].getQuantity());

                    }*/
                }
                else
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
                System.out.println("[2] - Set Price of an Item");
                System.out.println("[3] - Replenish Money");
                System.out.println("[4] - Collect Money");
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
                {
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
                        break;
                }

            } while (mFlag == true);

            return true;
        }

        else
        {
            System.out.println("Thank you!");
            return false;
        }
    }

}
