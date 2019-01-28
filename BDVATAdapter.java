package store;
public class BDVATAdapter implements IVATCalculator {
    BDVATCalculator bdvc = new BDVATCalculator();
    public int getVATAmount(int saleTotal){
        return (int) bdvc.calculateVATAmount(saleTotal);
    }
}
