package machinecoding.restraunt;

import java.util.ArrayList;

public class Restraunt {
    private ArrayList<menuitem>menu;
    private ArrayList<order>orders;
    private int nextorderid;
    public Restraunt(){
        menu=new ArrayList<>();
        orders=new ArrayList<>();
        nextorderid=1;
    }
    public void addmenuitem(menuitem item){
        for(int i=0;i<menu.size();i++){
            if(menu.get(i).getid()==item.getid()){
                System.out.println("ID already exists");
                return;
            }
        }
        menu.add(item);
        System.out.println("Item added");
    }
    public void viewmenu(){
        if(!menu.isEmpty()){
            System.out.println("Menu is empty.");
            return;
        }
    }
    public menuitem findmenuitem(int id){
        for(int i=0;i<menu.size();i++){
            if(menu.get(i).getid()==id);
                return menu.get(i);
        }
    return null;
    }
}
