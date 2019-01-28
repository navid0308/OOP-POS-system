package store;

import java.util.LinkedList;

public class SaleFactory
{
    private LinkedList<ProductSpecification> psList;
    private static SaleFactory instance;
    IVATCalculator vatCalculator;
    
    public SaleFactory()
    {
        //vatCalculator=new BDVATAdapter();
        vatCalculator=new MyVATCalculator();
        psList=new LinkedList<>();
        ProductSpecification ps1=new ProductSpecification();
        ps1.setId("123");
        ps1.setName("Apple");
        ps1.setDescription("This is a red colored fruit");
        ps1.setPrice(15);
        psList.add(ps1);
        ProductSpecification ps2=new ProductSpecification();
        ps2.setId("234");
        ps2.setName("Orange");
        ps2.setDescription("This is an orange colored fruit");
        ps2.setPrice(10);
        psList.add(ps2);
    }
    public ProductSpecification getProductSpecification(String id)
    {
        for(int i=0;i<psList.size();i++)
        {
            ProductSpecification item=psList.remove();
            psList.add(item);
            if(id.equalsIgnoreCase(item.getId()))
            {
                return item;
            }
        }
        return null;
    }
    
    public static synchronized SaleFactory getInstance(){
        if(instance == null){
            instance = new SaleFactory();
        }
        return instance;
    }
    
    public IVATCalculator getVATCalculator() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(vatCalculator == null){
            String className = System.getProperty(vatCalculator.getClass().getName());//IVATCalculator is NOT a class
            vatCalculator = (IVATCalculator) Class.forName(className).newInstance();//its an interface, hence null pointer
        }                                                                           //exception. try and figure it out
        return vatCalculator;
    }
}