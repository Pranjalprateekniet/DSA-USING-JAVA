package machinecoding.restraunt;

import java.util.ArrayList;
import java.util.List;
public class order {
    private int id;
    private List<menuitem>items;
    private String status;

    public order(int id){
        this.id=id;
        items=new ArrayList<>();
        status="PENDING";
    }
    public int getid(){
        return id;
    }
    public String getStatus(){
        return status;
    }
    public boolean additem(menuitem item,int quantity){
        if(!status.equals("PENDING")|| quantity<=0)
            return  false;
        for(int i=0;i<quantity;i++){
            menuitem copy=new menuitem(item.getid(), item.getitemname(), item.getprice());
            items.add(copy);
        }
        return true;
    }
    public void completeorder(){
        if(status.equals("PENDING") && !items.isEmpty())
            status="COMPLETED";
        else
            System.out.println("Order cannot be completed.");
    }
    public void display(){
        System.out.println("Order id: "+id);
        System.out.println("Status: "+status);
        for(int i=0;i<items.size();i++){
            items.get(i).display();
    }
    System.out.println("Total bill = "+calculateBill());
    }

    
}
