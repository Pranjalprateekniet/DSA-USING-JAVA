public class hashsetprac {
 public static void main(String[] args) {
    int c=0;int lon=1;
    for(int x : set){
        if(set.contains(x-1)){
            continue;
        }
        else{
            int y=x;
            c=1;
            while(set.contains(y+1)){
                c++;
                y++;
            }
        }
        lon=Math.max(c, lon);
    }
 }
    
}