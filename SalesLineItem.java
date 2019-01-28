package store;
public class SalesLineItem
{
    private ProductSpecification ps;
    private int quantity;
    
    public SalesLineItem(String id,int quant)
    {
        SaleFactory sf=new SaleFactory();
        setQuantity(quant);
        setProductSpecification(sf.getProductSpecification(id));
    }
    public void setQuantity(int QUANTITY)
    {
        this.quantity=QUANTITY;
    }
    public void setProductSpecification(ProductSpecification PS)
    {
        this.ps=PS;
    }
    public ProductSpecification getProductSpecification()
    {
        return ps;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public int getSubTotal()
    {
        return quantity*ps.getPrice();
    }
}