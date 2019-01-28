package store;

public class ProcessSaleController
{
    private Sale sale;
    public ProcessSaleController()
    {
        sale=null;
    }
    public void makeNewSale()
    {
        sale=new Sale();
    }
    public void addItem(String id,int quantity)
    {
        sale.addSaleLineItem(id, quantity);
    }
    public Sale getSale()
    {
        return sale;
    }
    public ProductSpecification getProductSpecification(String id)
    {
        SaleFactory sf=new SaleFactory();
        return sf.getProductSpecification(id);
    }
}