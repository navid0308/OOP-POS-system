package store;
public class ProductSpecification
{
    private String id;
    private String name;
    private String description;
    private int price;
    public ProductSpecification()
    {
        this.id=null;
        this.name=null;
        this.description=null;
        this.price=0;
    }
    public void setId(String X)
    {
        this.id=X;
    }
    public void setName(String X)
    {
        this.name=X;
    }
    public void setDescription(String X)
    {
        this.description=X;
    }
    public void setPrice(int X)
    {
        this.price=X;
    }
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public int getPrice()
    {
        return price;
    }
}