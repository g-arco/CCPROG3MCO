import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocPrintJob;
/**
 * This is the Maintenance class. It restocks ItemSlots, indirectly changes the price of Items, and collects and replenishes Money.
 */
public class Maintenance
{

    private ArrayList<ItemSlot> currentSlots = new ArrayList<>();
    private int totalSlots;
    private Money totalmoney[];

    /**
     * This is the constructor method of Maintenance. It needs an Array List of ItemSlots (for easier modification) and Money (for updating).
     * @param itemSlot the item slot array to be copied
     * @param money RVM's money array
     */
    public Maintenance(ArrayList<ItemSlot> itemSlot, Money money[])
    {
        this.currentSlots = new ArrayList<ItemSlot>();
        initializeSlots(this.currentSlots, itemSlot);
        this.totalmoney = money;
    }

    /**
     * This method transfers contents from an arraylist to a target
     * @param targetSlot the arraylist that will receive the contents
     * @param itemSlot the arraylist that will provide the contents
     */

    public void initializeSlots(ArrayList<ItemSlot> targetSlot, ArrayList<ItemSlot> itemSlot)
    {
        for (int i =0; i < itemSlot.size(); i++)
        {
            ItemSlot temp;
            temp = new ItemSlot(itemSlot.get(i).getItem(),itemSlot.get(i).getNumItems());
            targetSlot.add(temp);
        }
    }
    /**
     * This method adds more slots to the Maintenance class' Array List attribute of type ItemSlot
     *
     * @param itemslot the ItemSlot to be added
     */
    public void addMoreSlots(ItemSlot itemslot)
    {
        currentSlots.add(itemslot);
        totalSlots += 1;
    }

    /**
     * This method restocks the numItems of ItemSlots. It will not input if value is invalid or maximum has been reached.
     */
    public void restockItem()
    {
        Scanner s = new Scanner(System.in);
        int inputIndex, inputQuantity, i;
        int noException, placeholder;

        System.out.println("Which item slot do you want to restock?");
        for(i = 0; i < currentSlots.size(); i++)
        {
            System.out.print("["+i+"] - " );
            System.out.println(currentSlots.get(i).returnItemName());
        }
        
        do
        {
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
                    System.out.println("ERROR: Please input an Integer.");
                }

            }

            if (!(inputIndex >=0 && inputIndex < i))
                System.out.println("ERROR: Please input a valid number in the choices.");
        } while (!(inputIndex >=0 && inputIndex < i));

        System.out.println("How many pieces will you insert?");

        inputQuantity = 0;
        noException = 0;

        do {
            while(noException == 0)
            {
                try
                {
                    inputQuantity = s.nextInt();
                    noException = 1;
                }
                catch (Exception e)
                {
                    s.nextLine();
                    System.out.println("ERROR: Please input an Integer.");
                }

            }
            if(inputQuantity < 0)
                System.out.println("ERROR: Please input a positive integer");
        }while(inputQuantity < 0);


        // I changed this so that it will "pause"
        if(currentSlots.get(inputIndex).getNumItems()+inputQuantity > 10 )
        {
            System.out.println("Sorry, maximum capacity is 10.");
            System.out.println("Input any integer to continue: ");
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
        }
        else
            currentSlots.get(inputIndex).getRestocked(inputQuantity);
    }

    /**
     *  This method asks user for an input (choosing which item to change price) and then indirectly sets the price. Rejects input if it is non-positive.
     */
    public void setPrice()
    {
        Scanner s = new Scanner(System.in);
        int inputIndex, inputPrice, i;
        int noException;

        System.out.println("Which item do you want to set the price?");
        
        for(i = 0; i < currentSlots.size(); i++)
        {
            System.out.print("["+i+"] - " );
            System.out.println(currentSlots.get(i).returnItemName());
        }

        do
        {
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
                    System.out.println("ERROR: Please input an Integer.");
                }

            }
            if (!(inputIndex >=0 && inputIndex < i))
                System.out.println("ERROR: Please input a valid number in the choices.");
        } while (!(inputIndex >= 0 && inputIndex < i));

        System.out.println("What will be its new price?");

        inputPrice = -1;
        noException = 0;

        while(noException == 0)
        {
            try
            {
                inputPrice = s.nextInt();
                noException = 1;
            }
            catch (Exception e)
            {
                s.nextLine();
                System.out.println("ERROR: Please input an Integer.");
            }

        }

        if (inputPrice > 0)
            currentSlots.get(inputIndex).getItem().changePrice(inputPrice);
        else if (inputPrice == 0)
        {
            System.out.println("ERROR: Price must be not equal to zero.");
            System.out.println("Input any integer to continue.");
            i = 0;
            noException = 0;

            while(noException == 0)
            {
                try
                {
                    i = s.nextInt();
                    noException = 1;
                }
                catch (Exception e)
                {
                    s.nextLine();
                    System.out.println("ERROR: Please input an Integer.");
                }

            }


        }
        else
        {
            System.out.println("ERROR: Price must be positive.");
            System.out.println("Input any integer to continue.");
            i = 0;
            noException = 0;

            while(noException == 0)
            {
                try
                {
                    i = s.nextInt();
                    noException = 1;
                }
                catch (Exception e)
                {
                    s.nextLine();
                    System.out.println("ERROR: Please input an Integer.");
                }

            }
        }
    }

    /**
     * Setter that copies the given currentSlots to this.currentSlots
     * @param currentSlots the Item Slots that will be copied into maintenance's current slots
     */
    public void setCurrentSlots(ArrayList<ItemSlot> currentSlots) {
        this.currentSlots.clear();
        initializeSlots(this.currentSlots,currentSlots);
    }

    /**
     *  This method simulates the collection of money by setting all the quantity of the Money class to 0 indirectly.
     */
    public void collectMoney()
    {
        for(int i=0; i < 9; i++)
            this.totalmoney[i].setQuantity(0);
    }

    /**
     *  This method replenishes money by going through each denomination, asking the user if they want to refill it and if yes, accepts the amount to be added.
     */
    public void replenishMoney()
    {
        Scanner s = new Scanner(System.in);
        int toReplenish, addMoney;
        int noException;

        for(int i=0; i < 9; i++)
        {
            System.out.println("Replenish? [1] Yes [2] No");
            System.out.println("["+(i+1)+"] - PHP "+this.totalmoney[i].getValue()+"  Quantity:"+this.totalmoney[i].getQuantity());


            do {
                toReplenish = 0;
                noException = 0;
                while(noException == 0)
                {
                    try
                    {
                        toReplenish = s.nextInt();
                        noException = 1;
                    }
                    catch (Exception e)
                    {
                        s.nextLine();
                        System.out.println("ERROR: Please input an Integer.");
                    }

                }
                if (toReplenish!=1 && toReplenish!=2)
                    System.out.println("ERROR: Please input [1] or [2]");
            }while (toReplenish!=1 && toReplenish!=2);



            if (toReplenish == 1)
            {
                do {
                    System.out.println("How much do you want to add?");
                    addMoney = 0;
                    noException = 0;

                    while(noException == 0)
                    {
                        try
                        {
                            addMoney = s.nextInt();
                            noException = 1;
                        }
                        catch (Exception e)
                        {
                            s.nextLine();
                            System.out.println("ERROR: Please input an Integer.");
                        }

                    }
                    if (addMoney <=0)
                        System.out.println("ERROR: Please input a POSITIVE integer.");
                }while(addMoney <= 0);


                this.totalmoney[i].setQuantity(this.totalmoney[i].getQuantity()+addMoney); // bugged but I already fixed it
            }

        }

    }
    /**
     * This returns the ArrayList of CurrentSlots
     * @return the current slots
     */
    public ArrayList<ItemSlot> getCurrentSLots()
    {
        return this.currentSlots;
    }

    /**
     * This getter returns the total money array.
     * @return the money array.
     */
    public Money[] getMoney()
    {
        return this.totalmoney;
    }

}