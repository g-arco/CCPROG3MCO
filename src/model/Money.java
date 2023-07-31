package model;

/**

 * This is the model.Money class. It helps the user pay the RVM and for the RVM to dispense the change.
 */
public class Money
{
    /**
     * value = the value of the denomination (1, 5, 10, 20, 50, etc)
     * quantity = to be used as to store how much of a particular denomination is inside the RVM
     */
    private int value;
    private int quantity;

    /**
     * Constructor method for model.Money
     *
     * @param value = the value of the money
     * @param quantity = the amount (not value) of pieces of money
     */
    public Money(int value, int quantity)
    {
        this.value = value;
        this.quantity = quantity;
    }
    /**
     * getter to get the value of the object of type model.Money
     * @return int value of the value
     */

    public int getValue()
    {
        return value;
    }

    /**
     * getter to get how much money of denomination there is
     * @return int value of the quantity
     */

    public int getQuantity()
    {
        return quantity;
    }

    /**
     * <p> setter to set the quantity of the model.Money class </p>
     * @param quantity = the int value to set the quantity
     */

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


}