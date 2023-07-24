public class IceCream extends Item
{
    private String flavor;

    public IceCream(int price, int calories, String name, boolean soldAlone, String flavor)
    {
        super(price, calories, name, soldAlone);
        this.flavor = flavor;
    }

    public void ItemPreparation()
    {
        System.out.println(name+" is being scooped...");
    }
}