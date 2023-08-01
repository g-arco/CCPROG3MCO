package model;

/**

 * This is the Money class. It helps the user pay the RVM and for the RVM to dispense the change.
 */
public class Money
{
        private int value;

        public Money (int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

}