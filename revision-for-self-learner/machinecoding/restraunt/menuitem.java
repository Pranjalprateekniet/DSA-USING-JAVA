package machinecoding.restraunt;

public class menuitem {
    private int id;
    private String itemname;
    private double price;
    public menuitem(int id, String itemname,double price){
        this.id=id;
        this.itemname=itemname;
        this.price=price;
    }
    public int getid(){
        return id;
    }
    public String getitemname(){
        return itemname;
    }
    public double getprice(){
        return price;
    }
    private void setprice(double price)
    {
        this.price=price;
    }
    public void display(){
        System.out.println(id+" | "+itemname+" | Rs."+price);
    }
}
