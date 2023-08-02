package model;

/**

 * This is the Money class. It helps the user pay the RVM and for the RVM to dispense the change.
 */
public class Money
{
        /**
         * value = integer value that denotes the denomination of the money.
         */
        private int value;

        /**
         * Constructor method to initialize MoneyS
         * @param value = integer value that denotes the denomination of the money.
         */
        public Money (int value)
        {
            this.value = value;
        }

        /**
         * A getter to get the value of the MoneyS
         *
         * @return value = that denotes the denomination of the money.
         */
        public int getValue()
        {
            return this.value;
        }

}