package model;

import java.util.ArrayList;
import java.util.Scanner;

public class SVM {

    private ArrayList<ItemSlot> itemSlotArrayList;
    private ArrayList<MoneySlot> moneySlotArrayList;
    private int totalSales;
    private Record currRecord;

    public SVM(ArrayList<ItemSlot> itemSlotArrayList, ArrayList<MoneySlot> moneySlotArrayList, Record currRecord)
    {
        this.itemSlotArrayList = itemSlotArrayList;
        this.moneySlotArrayList = moneySlotArrayList;
        this.totalSales = 0;
        this.currRecord = currRecord;
    }

    // YOU MAY WANT TO ADAPT THIS FOR GUI BUT FOR NOW, CLI IS JUST FOR TESTING
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

    public ArrayList<MoneySlot> produceChange(int payment, int due, ArrayList<MoneySlot> changeList)
    {
        /*
        int oneThousand = 0, fiveHundred = 0, twoHundred = 0, oneHundred = 0, fifty = 0, twenty = 0, ten = 0, five = 0, one = 0;

        oneThousand = change/1000;
        change %= 1000;

        fiveHundred = change/500;
        change %= 500;

        twoHundred = change/200;
        change %= 200;

        oneHundred = change/100;
        change %= 100;

        fifty = change/50;
        change %= 50;

        twenty = change/20;
        change %= 20;

        ten = change/10;
        change %= 10;

        five = change/5;
        change %= 5;

        one = change;*/

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

        //dispenseChange(oneThousand, fiveHundred, twoHundred, oneHundred, fifty, twenty, ten, five, one);

        this.totalSales = due;

        return changeList;
    }

    public void dispenseChange(int oneThousand, int fiveHundred, int twoHundred, int oneHundred, int fifty, int twenty, int ten, int five, int one)
    {
        int amounts[] = {one, five, ten, twenty, fifty, oneHundred, twoHundred, fiveHundred, oneThousand};
        int loop = 0;

        for(int i = 0; i < 9; i++)
        {
            loop = 0;

            if(amounts[i] > 0)
            {
                do
                {
                    moneySlotArrayList.get(i).dispense();
                    loop++;
                } while (loop < amounts[i]);
            }
        }

        for(int i = 0; i < 9; i++)
            System.out.println(moneySlotArrayList.get(i).getQuantity());
    }

    public ArrayList<ItemSlot> getItemSlotArrayList() {
        return itemSlotArrayList;
    }

    public ArrayList<MoneySlot> getMoneySlotArrayList() {
        return moneySlotArrayList;
    }
    /*
        int change = payment - due; //total change

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

                        for (int j = this.money.length-1; j >= 0; j--)
                        {
                            System.out.println(this.money[j].getValue()+"  "+this.money[j].getQuantity());

                        }

        System.out.println("Dispensing Change: ");
        for (int j = this.change.length-1; j >= 0; j--)
        {
            if (this.change[j].getQuantity() != 0)
                System.out.println("    +"+this.change[j].getQuantity()+" of "+this.change[j].getValue()+" pesos");
        }*/

}
