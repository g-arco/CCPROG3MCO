/**
 * This is the SVM, the special vending machine where the user can customize their halo-halo.
 */

package model;

import java.util.ArrayList;
import java.util.Scanner;

public class SVM {

    /**
     * itemSlotArrayList = the arraylist of itemslots which contains the items to be sold
     * moneySlotArrayList = the arraylist of moneySlot that will be loaded and dispensed to the user for change
     * totalSales = the total number of sales from all the transactions
     * records = the class that contains the records of sales made and the stock of each itemslot
     */
    private ArrayList<ItemSlot> itemSlotArrayList;
    private ArrayList<MoneySlot> moneySlotArrayList;
    private int totalSales;
    private Record currRecord;

    /**
     * This is a constructor method that instantiates SVM
     * @param itemSlotArrayList = the arraylist containing all the itemslots which contain the items that the SVM will sell
     * @param moneySlotArrayList = the arraylist containing the money which will be dispensed for change or loaded
     * @param currRecord = the current records of the program
     */
    public SVM(ArrayList<ItemSlot> itemSlotArrayList, ArrayList<MoneySlot> moneySlotArrayList, Record currRecord)
    {
        this.itemSlotArrayList = itemSlotArrayList;
        this.moneySlotArrayList = moneySlotArrayList;
        this.totalSales = 0;
        this.currRecord = currRecord;
    }

    /**
     * This method shows the user the available items to sell, asks which ones they want and their quantity, and proceeds with the transactions or cancels it depending on the user.
     */
    public void sellItems(ArrayList<ItemSlot> itemsToBuy)
    {
        Scanner s = new Scanner(System.in);
        int dChoice, dAmount, index;
        ArrayList<ItemSlot> cart = new ArrayList<ItemSlot>();

        cart.clear();


        System.out.println("ITEMS FOR SALE TO CUSTOMIZE HALO-HALO: ");

        do
        {
            for(int i = 0; i < itemSlotArrayList.size(); i++)
            {
                System.out.println("["+i+"] "+itemSlotArrayList.get(i).getName());
                System.out.println("Calories: "+itemSlotArrayList.get(i).getItem().getCalories()+" Stock: "+itemSlotArrayList.get(i).getQuantity());
                System.out.println("Price: "+itemSlotArrayList.get(i).getItem().getPrice());
            }

            System.out.println("Which one do you want to buy?");
            dChoice = s.nextInt();

            if (dChoice >= 0 && dChoice < itemSlotArrayList.size())
            {
                System.out.println("How many?");
                dAmount = s.nextInt();

                if (dAmount > itemSlotArrayList.get(dChoice).getQuantity() || dAmount < 0)
                {
                    System.out.println("INVALID AMOUNT!");
                }

                else if(cart.contains(itemSlotArrayList.get(dChoice)))
                {
                    index = cart.indexOf(itemSlotArrayList.get(dChoice));
                    cart.get(index).setToSell(dAmount);
                }

                else if(cart.add(itemSlotArrayList.get(dChoice)))
                {
                    index = cart.indexOf(itemSlotArrayList.get(dChoice));
                    cart.get(index).setToSell(dAmount);
                }
            }

        } while (dChoice >= 0 && dChoice < itemSlotArrayList.size());

        System.out.println("Would that be all? [1] - Yes [Other Numbers] - No");
        dChoice = s.nextInt();

        if (dChoice == 1 && !cart.isEmpty())
        {
            this.transaction(cart);
        }

        else
        {
            System.out.println("Order cancelled!");
            cart.clear();
        }
    }
    /**
     * This method calculates for the total price of the items that the user chose and accepts input from user the money or cancels the transaction
     * @param chosenItems = the arraylist containing the chosen itemslots which contain the items, their price, and their quantity for computation and dispensing
     */
    private void transaction(ArrayList<ItemSlot> chosenItems)
    {
        int totalPrice = 0, j, payment = 0, input;
        boolean flag = true;
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < chosenItems.size(); i++)
        {
            j = 0;

            do
            {
                totalPrice += chosenItems.get(i).getItem().getPrice();
                j++;
            } while(chosenItems.get(i).getToSell() > j);
        }

        System.out.println("Total Price: "+totalPrice);

        do
        {
            input = s.nextInt();

            if (input <= 0)
            {
                flag = false;
            }

            else
            {
                payment+=input;
            }

        } while(payment < totalPrice && flag);

        if (!flag)
        {
            System.out.println("Transaction cancelled!");
            chosenItems.clear();
        }

        else
        {
            //proceedTransaction(chosenItems);
        }
    }

    /**
     * This method calls the dispense method of the ItemSlot when a transaction is successful
     * @param chosenItems = the list of items that will be dispensed
     * @param withPrep = determines if the string values that will re turned will be in a special or ordinary dispensing manner
     * @return String ArrayList = this will be shon in the processing and dispensing frames
     */
    public ArrayList<String> proceedTransaction(ArrayList<ItemSlot> chosenItems, int withPrep)
    {
        int sold, tempToSell;
        ArrayList<String> dispenseString = new ArrayList<String>();

        if (chosenItems.size()==1)
        {
            for(int i = 0; i < this.itemSlotArrayList.size(); i++)
            {
                    System.out.println(chosenItems.get(0).getItem() == this.itemSlotArrayList.get(i).getItem());
                    if (chosenItems.get(0).getItem() == this.itemSlotArrayList.get(i).getItem())
                    {
                        this.itemSlotArrayList.get(i).dispenseItem();
                        this.itemSlotArrayList.get(i).setToSell(0);
                        this.currRecord.update(this.itemSlotArrayList,this.itemSlotArrayList.get(i).getItem().getPrice(),this.itemSlotArrayList.get(i).getItem());
                    }

            }

            sold =1;
            dispenseString.add(sold+" "+chosenItems.get(0).getItem().getName()+" is being dispensed...");
        }
        else
        {
            for(int i = 0; i < chosenItems.size(); i++)
            {
                this.itemSlotArrayList.get(i).setToSell(chosenItems.get(i).getToSell());
                if (chosenItems.get(i).getToSell() > 0)
                {
                    if (withPrep==2)
                        dispenseString.add(chosenItems.get(i).getToSell()+" "+chosenItems.get(i).getItem().ItemPreparation()+"... ");
                    else
                        dispenseString.add(chosenItems.get(i).getToSell()+" is being dispensed...");
                    do
                    {
                        this.itemSlotArrayList.get(i).dispenseItem();
                        this.currRecord.update(this.itemSlotArrayList,this.itemSlotArrayList.get(i).getItem().getPrice(),this.itemSlotArrayList.get(i).getItem());
                    }while(this.itemSlotArrayList.get(i).getToSell() > 0);
                }

            }

            /*
            for(int i = 0; i < chosenItems.size(); i++)
            {
                System.out.println("Stock: "+chosenItems.get(i).getArrayList().size());
                System.out.println("getItems: "+chosenItems.get(i).getToSell()+" Quantity: "+chosenItems.get(i).getQuantity());
                dispenseString.add(" "+chosenItems.get(i).getItem().ItemPreparation()+"");
            }*/
        }


        return dispenseString;
    }

    /**
     * This method produces change for each and every denomination by counting how many of each is needed given the paid amount
     * @param payment = the payment of the user
     * @param due = the amount to pay
     * @param changeList = moneyslots ArrayList SOLELY for the change
     * @return change = change that will be shown in the dispensing frames
     */
    public ArrayList<MoneySlot> produceChange(int payment, int due, ArrayList<MoneySlot> changeList)
    {

        int totalChange;
        int checkChange, tempQuan;

        totalChange=payment-due;
        System.out.println(totalChange+"++++"+payment+" "+due);

        for (int i = 0; i < this.moneySlotArrayList.size(); i++)
        {
            checkChange = totalChange/changeList.get(i).getValue(); //divides to see if it is divisble
            System.out.println(checkChange+" "+totalChange+" "+changeList.get(i).getValue()+"++++");

            if(checkChange==0)
                totalChange = totalChange%changeList.get(i).getValue(); //not divisible so totalChange remains the same
            else {

                System.out.println(checkChange+" "+this.moneySlotArrayList.get(i).getQuantity()+"++++");
                if(checkChange >= this.moneySlotArrayList.get(i).getQuantity())
                {
                    System.out.println(checkChange+" "+this.moneySlotArrayList.get(i).getQuantity()+"++++");
                    if (i == (changeList.size()-1))
                    {
                        changeList.add(new MoneySlot(new Money(0)));
                        return changeList;
                    }
                    else
                    {
                        changeList.get(i).getReplenished(this.moneySlotArrayList.get(i).getQuantity());//maximizes the money rvm has
                        System.out.println(changeList.get(i).getQuantity()+"++++");
                        checkChange = checkChange-(changeList.get(i).getQuantity()*changeList.get(i).getValue()); //subtract the money it was able to retrive
                    }
                }
                else
                {
                    if (checkChange>0)
                        changeList.get(i).getReplenished(checkChange); //divides to see if it is divisble
                    totalChange = totalChange%changeList.get(i).getValue(); //it is divible by some number so we are left with a few pesos left which we need to dispense
                }

                System.out.println(changeList.get(i).getQuantity());
            }

            System.out.println(changeList.get(i).getQuantity());
        }
        for (int i = 0; i < this.moneySlotArrayList.size(); i++)
        {
            for (int j=0; j < changeList.get(i).getQuantity(); j++)
            {
                this.moneySlotArrayList.get(i).dispense(); //subtracts the money rvm dispenses
            }
        }


        System.out.println("Change:");
        System.out.println("1000 "+changeList.get(0).getQuantity());
        System.out.println("500 "+changeList.get(1).getQuantity());
        System.out.println("200 "+changeList.get(2).getQuantity());
        System.out.println("100 "+changeList.get(3).getQuantity());
        System.out.println("50 "+changeList.get(4).getQuantity());
        System.out.println("20 "+changeList.get(5).getQuantity());
        System.out.println("10 "+changeList.get(6).getQuantity());
        System.out.println("5 "+changeList.get(7).getQuantity());
        System.out.println("1 "+changeList.get(8).getQuantity());


        this.totalSales = due;

        return changeList;
    }


    /**
     * Getters fot this current ItemSlot Array list
     * @return itemSlotArrayList
     */
    public ArrayList<ItemSlot> getItemSlotArrayList() {
        return itemSlotArrayList;
    }

    /**
     * Getters fot this current MoneySlot Array list
     * @return MoneySlotArrayList
     */
    public ArrayList<MoneySlot> getMoneySlotArrayList() {
        return moneySlotArrayList;
    }


}
