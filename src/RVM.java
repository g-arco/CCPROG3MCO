import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the RVM (acronym for Regular Vending Machine) class. It is where all the transactions are being done.
 */
public class RVM
{
    /**
     * currentSlots = Array list of item slots that will keep track of the inventory and updates whenever a restock happens or when buyer buys an item
     * startingSlots = gets only updated before a restock happens to keep track of previous inventory
     * numOfItemsSold = total number of items sold
     * sale = grand total sum of all bought items
     * listofSoldItems = String array if all total items bought
     * restockSale = total sale after a restock and before another restock so it changes back to 0 for every restock
     * restockListofSoldItems = all items bought after a restock and before another restock so it removes ALL elements for every restock
     * money = rvm money array for change and receives money from user
     * change = money array specifically for change
     */
    private ArrayList<ItemSlot> currentSlots;

    private ArrayList<ItemSlot> startingSlots;
    private int numOfItemsSold;
    private int sale;
    private ArrayList<String> listOfSoldItems;
    private int restockSale;
    private ArrayList<String> restockListOfSoldItems;

    private Money money[];
    private Money change[] = {new Money(1000, 0), new Money(500, 0), new Money(200, 0),
            new Money(100, 0), new Money(50, 0), new Money(20, 0),
            new Money(10, 0), new Money(5, 0), new Money(1, 0)};

    /**
     * The constructor method for RVM. it requires ItemSlot (to hold the Items) and money[] of type Money (to hold Money).
     * @param itemSlot the slots that the RVM will contain or hold
     * @param money the denominations that will serve as the RVM's tracker of the denominations and amount
     */
    public RVM(ArrayList<ItemSlot> itemSlot, Money money[])
    {
        this.currentSlots = new ArrayList<ItemSlot>();
        initializeSlots(this.currentSlots, itemSlot);

        this.numOfItemsSold = 0;

        this.startingSlots = new ArrayList<ItemSlot>();
        initializeSlots(this.startingSlots, itemSlot);

        this.listOfSoldItems = new ArrayList<String>();
        this.sale = 0;

        this.restockListOfSoldItems = new ArrayList<String>();
        this.restockSale = 0;

        this.money=money;
    }
    /**
     * Initializes the quantity of each element in change to 0.
     */
    public void initializeChange()
    {
        for(int i=0; i < 9; i++)
            this.change[i].setQuantity(0);
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
     * Setter for the Money array
     *
     * @param money array to set the Money[] attribute
     */

    public void setMoney(Money[] money) {

        this.money = money;
    }

    /**
     * sets the arraylist currentSlot attribute with the currentSlots parameter.
     * @param currentSlots the arraylist to set the currentSlot attribute
     */

    public void setCurrentSlots(ArrayList<ItemSlot> currentSlots)
    {
        this.currentSlots.clear();
        initializeSlots(this.currentSlots,currentSlots);
    }
    /**
     * getter to return the arraylist of currentSlots
     * @return currentSlots
     */

    public ArrayList<ItemSlot> getCurrentSlots() 
    {
        return this.currentSlots;
    }
    /**
     * Method to reset the arraylist restockListOfSoldItems
     */
    public void resetRestockListOfSoldItems() {
        this.restockListOfSoldItems.clear();
    }

    /**
     * Method to set RestockSale back to 0
     */
    public void resetRestockSale() {
        this.restockSale = 0;
    }

    /**
     * Method to check if the given item is out of stock or not
     * @param item = for checking if the passed item exists in the RVM
     * @return true if item is found and its stock is not 0. False if otherwise.
     */
    public boolean pickItem(Item item)
    {
        int placeholder, noException;

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < currentSlots.size(); i++)
        {
            if (currentSlots.get(i).getItem() == item && currentSlots.get(i).getNumItems() != 0)
            {
                return true;
            }
            else if (currentSlots.get(i).getItem() == item && currentSlots.get(i).getNumItems() == 0)
            {
                System.out.println("Sorry, this item is out of stock!");
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
                return false;
            }
        }
        return false;
    }
    /**
     * This method accepts Money and dispenses the Item and change.
     * @param item = the Item to be dispensed and to be used as a reference for the price
     * @param paidMoney = the total money that the user inputs
     * @return = true if the transaction is successful, false if the machine has insufficient change.
     */

    public boolean payRVM(Item item, int paidMoney)
    {
        Scanner s = new Scanner(System.in);
        int placeholder,noException;
        initializeChange(); //all change money is set to 0

        for (int i = 0; i < currentSlots.size(); i++)
        {
            if (currentSlots.get(i).getItem() == item)
            {
                if (paidMoney >= currentSlots.get(i).getItem().getPrice())
                {
                    if(paidMoney > item.getPrice())
                    {
                        int extraM = paidMoney - item.getPrice(); //total change

                        for (int j = 0; j < this.change.length; j++)
                        {
                            this.change[j].setQuantity(extraM/this.change[j].getValue()); //divides to see if it is divisble
                            if(this.change[j].getQuantity()==0)
                                extraM = extraM%this.change[j].getValue(); //not divisible so extraM remains the same
                            //System.out.print(this.change[j].getQuantity()+" "+this.money[j].getQuantity());
                            //System.out.println(this.change[j].getQuantity() > this.money[j].getQuantity());

                            if(this.change[j].getQuantity() > this.money[j].getQuantity())
                            {
                                if (j == (this.change.length-1))
                                {
                                    System.out.println("Vending Machine has insufficient change.");
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

                                    return false;
                                }
                                else
                                {
                                    this.change[j].setQuantity(this.money[j].getQuantity()); //maximizes the money rvm has
                                    extraM = extraM-(this.change[j].getQuantity()*this.change[j].getValue()); //subtract the money it was able to retrive
                                }


                            }
                            else if (this.change[j].getQuantity() > 0)
                            {
                                extraM = extraM%this.change[j].getValue(); //it is divible by some number so we are left with a few pesos left which we need to dispense
                                this.money[j].setQuantity(this.money[j].getQuantity()-this.change[j].getQuantity() ); //subtracts the money rvm dispenses
                            }

                        }

                        /*for (int j = this.money.length-1; j >= 0; j--)
                        {
                            System.out.println(this.money[j].getValue()+"  "+this.money[j].getQuantity());

                        }*/

                        System.out.println("Dispensing Change: ");
                        for (int j = this.change.length-1; j >= 0; j--)
                        {
                            if (this.change[j].getQuantity() != 0)
                                System.out.println("    +"+this.change[j].getQuantity()+" of "+this.change[j].getValue()+" pesos");
                        }

                    }

                    System.out.println("Dispensing Item...");
                    this.sale += item.getPrice();
                    this.listOfSoldItems.add(item.getName());
                    this.restockSale += item.getPrice();
                    this.restockListOfSoldItems.add(item.getName());
                    this.numOfItemsSold++;
                    this.currentSlots.get(i).setBoughtNumItems();
                    //System.out.println(this.currentSlots.get(i).getNumItems());
                    //System.out.println(this.startingSlots.get(i).getNumItems());

                    return true;

                }
                else
                    System.out.println("Insufficient money.");
            }
        }
        return false;
    }
    /**
     * Just prints "Item cancelled..."
     */
    public void cancelItem(){
        System.out.println("Item cancelled...");
    }

    /**
     *  Shows the int value of calories of a given Item
     * @param item = the Item whose calorie count is to be checked.
     */
    public void showCalories(Item item){
        System.out.println(item.getName()+" Calories: "+item.getCalories());
    }

    /**
     * This method returns the money attribute
     * @return = money attribute
     */
    public Money[] getMoney() {
        return this.money;
    }

    /**
     *  This method displays the pertinent information such as the list of sold items, total sales, and the stock values of each ItemSlot.
     */
    public void displayTransactions()
    {
        int placeholder,noException;
        Scanner s = new Scanner(System.in);

        System.out.println("LIST OF SOLD ITEMS (SINCE LAST RESTOCK): ");
        for (int i = 0; i < restockListOfSoldItems.size(); i++)
        {
            System.out.println("["+(i+1)+"] - "+restockListOfSoldItems.get(i));
        }
        if (restockListOfSoldItems.size() == 0)
            System.out.println("[NO ITEMS SOLD]");
        System.out.println("TOTAL SALES (SINCE LAST RESTOCK): PHP "+restockSale);

        System.out.println("STARTING/LAST RESTOCK INVENTORY: ");
        for (int i = 0; i < this.startingSlots.size(); i++)
        {
            System.out.print("["+i+"] - ");
            System.out.print(this.startingSlots.get(i).getItem().getName());
            System.out.print(" PHP ");
            System.out.print(this.startingSlots.get(i).getItem().getPrice());
            System.out.print(" Calories: ");
            System.out.print(this.startingSlots.get(i).getItem().getCalories());
            System.out.print(" Availability: ");
            System.out.println(this.startingSlots.get(i).getNumItems());
        }

        System.out.println("CURRENT/LAST RESTOCK INVENTORY: ");
        for (int i = 0; i < this.currentSlots.size(); i++)
        {
            System.out.print("["+i+"] - ");
            System.out.print(this.currentSlots.get(i).getItem().getName());
            System.out.print(" PHP ");
            System.out.print(this.currentSlots.get(i).getItem().getPrice());
            System.out.print(" Calories: ");
            System.out.print(this.currentSlots.get(i).getItem().getCalories());
            System.out.print(" Availability: ");
            System.out.println(this.currentSlots.get(i).getNumItems());        }

        System.out.println("===================================================================");

        System.out.println("LIST OF SOLD ITEMS (GRAND TOTAL): "+numOfItemsSold);
        for (int i = 0; i < listOfSoldItems.size(); i++)
        {
            System.out.println("["+(i+1)+"] - "+listOfSoldItems.get(i));
        }
        if (restockListOfSoldItems.size() == 0)
            System.out.println("[NO ITEMS SOLD]");
        System.out.println("TOTAL SALES (GRAND TOTAL): PHP "+sale);

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
    }

    /**
     * This method sets the startingSlots according to the arraylist passed.
     * @param startingSlots = the arraylist of type ItemSlot to set startingSlots.
     */

    public void setStartingSlots(ArrayList<ItemSlot> startingSlots) {
        this.startingSlots.clear();
        initializeSlots(this.startingSlots, startingSlots);

    }
}