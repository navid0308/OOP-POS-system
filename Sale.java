package store;

import java.util.LinkedList;

public class Sale
{
    private final LinkedList <SalesLineItem> sli;
    private IVATCalculator ivac;
    public Sale()
    {
        sli=new LinkedList<>();
    }
    public LinkedList get()
    {
        return sli;
    }
    public void addSaleLineItem(String id,int quantity)
    {
        boolean added=false;
        for(int i=0;i<sli.size();i++)
        {
            SalesLineItem temp=sli.remove();
            ProductSpecification temp2=temp.getProductSpecification();
            if(temp2!=null&&temp2.getId().equalsIgnoreCase(id))
            {
                added=true;
                temp.setQuantity(temp.getQuantity()+quantity);
            }
            sli.add(temp);
        }
        if(!added)
        {
            SalesLineItem item=new SalesLineItem(id,quantity);
            sli.add(item);
        }
    }
    public int getTotal()
    {
        int total=0;
        for(int i=0;i<sli.size();i++)
        {
            SalesLineItem item=sli.remove();
            total+=item.getSubTotal();
            sli.add(item);
        }
        return total;
    }
    
    public int getGrandTotal() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        return this.getTotal() + this.getVATAmount();
    }
    
    public int getVATAmount() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ivac = SaleFactory.getInstance().getVATCalculator();
        return ivac.getVATAmount(this.getTotal());
    }
}