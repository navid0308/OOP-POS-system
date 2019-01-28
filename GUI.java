package store;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.*;
public class GUI{
    private static ProcessSaleController psc;
    private static final JFrame myFrame=new JFrame("Sale");
    private static final JButton newSale=new JButton("New Sale");
    private static final JButton addItem=new JButton("Add Item");
    private static final JLabel itemID=new JLabel("Item ID:");
    private static final JLabel quantity=new JLabel("Quantity");
    private static final JTextField id=new JTextField();
    private static final JTextField q=new JTextField();
    private static final JPanel full=new JPanel();
    private static final JPanel display=new JPanel();
    
    public void startGUI(){
        psc=new ProcessSaleController();
        psc.makeNewSale();
        addAction();
        
        display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
        full.setLayout(new BoxLayout(full,BoxLayout.Y_AXIS));
        display.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        full.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        id.setPreferredSize(new Dimension(150,20));
        q.setPreferredSize(new Dimension(150,20));
        
        display.add(newSale);
        
        JPanel temp=new JPanel();
        temp.add(itemID);
        temp.add(id);
        display.add(temp);
        
        JPanel temp2=new JPanel();
        temp2.add(quantity);
        temp2.add(q);
        display.add(temp2);
        
        display.add(addItem);
        
        full.add(display);
        
        myFrame.add(full);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationByPlatform(true);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
    public void addAction()
    {
        newSale.addActionListener((ActionEvent e) -> {
            full.removeAll();
            id.setText(null);
            q.setText(null);
            full.add(display);
            myFrame.pack();
            psc.makeNewSale();
        });
        
        addItem.addActionListener((ActionEvent e) -> {
            if(id.getText().equalsIgnoreCase("") || q.getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null,"INVALID INPUT");
            else
            {
                if(psc.getProductSpecification(id.getText())!=null)
                {
                    psc.addItem(id.getText(),Integer.parseInt(q.getText()));
                    update();
                }
            }
        });
    }
    private void update()
    {
        full.removeAll();
        full.add(display);
        Sale sale=psc.getSale();
        
        full.add(createTable());
        
        LinkedList<SalesLineItem> sli=sale.get();
        
        for(int i=0;i<sli.size();i++)
        {
            SalesLineItem temp=sli.remove();
            sli.add(temp);
            ProductSpecification ps=temp.getProductSpecification();
            
            full.add(getRow(ps.getId(),ps.getName(),Integer.toString(temp.getQuantity()),Integer.toString(ps.getPrice()),Integer.toString(temp.getSubTotal())));
        }
        full.add(getRow("","","","Total",Integer.toString(sale.getTotal())));
        try
        {
            full.add(getRow("","","","VAT",Integer.toString(sale.getVATAmount())));
            full.add(getRow("","","","Grand Total",Integer.toString(sale.getGrandTotal())));
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException e){}
        myFrame.pack();
    }
    private JPanel createTable()
    {
        JPanel table=new JPanel();
        table.setLayout(new GridLayout(1,5));
        JLabel base[]=new JLabel[5];
        base[0]=new JLabel("SL#");
        base[1]=new JLabel("Item Name");
        base[2]=new JLabel("Quantity");
        base[3]=new JLabel("Unit Cost");
        base[4]=new JLabel("Sub Total");
        addToTable(base,table);
        return table;
    }
    private JPanel getRow(String s1,String s2,String s3,String s4,String s5)
    {
        JPanel ROW=new JPanel();
        ROW.setLayout(new GridLayout(1,5));
        
        JLabel [] info=new JLabel[5];
        info[0]=new JLabel(s1);
        info[1]=new JLabel(s2);
        info[2]=new JLabel(s3);
        info[3]=new JLabel(s4);
        info[4]=new JLabel(s5);
        addBorders(info);
        addToTable(info,ROW);
        return ROW;
    }
    private void addToTable(JLabel label[],JPanel panel)
    {
        for(int i=0;i<5;i++)
        {
            panel.add(label[i]);
        }
    }
    private void addBorders(JLabel info[])
    {
        for(int i=0;i<5;i++)
        {
            if(info[i].getText()!=null&&!info[i].getText().equalsIgnoreCase(""))
                info[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
}
