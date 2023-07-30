import java.util.Scanner;

public class Maintenance
{
    public void setNewPrice(Item i)
    {
        int newPrice;
        Scanner s = new Scanner(System.in);

        System.out.println("Insert new price of "+i.getName());
        System.out.println("Current price: "+i.getPrice());
        newPrice = s.nextInt();

        i.setPrice(newPrice);
    }

    public void restockItem(ItemSlot i)
    {
        // some stuff
        /*
         * Notes:
         *  1. Actually add an instance of an item to itemslot n times.
         */
    }

    public void collectMoney() // update parameters if needed.
    {
        // nullify or "delete" n instances of the object.
    }

    public void replenishMoney() // update parameters if needed
    {
        // some stuff

        /*
         * Notes:
         *  1. Add an instance of Money to MoneySlot n times.
         */
    }
}