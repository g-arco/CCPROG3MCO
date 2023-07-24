public class Coconut extends Item
{
    public Coconut(int price, int calories, String name, boolean soldAlone)
    {
        super(price, calories, name, soldAlone);
    }

    public void ItemPreparation()
    {
        System.out.println(name+" is being placed...");
    }
}