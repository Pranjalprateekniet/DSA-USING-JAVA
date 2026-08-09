import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class contest_470_p1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        }
        int maxFreq = 0;
        int mostFrequentElement = 0;

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    if (entry.getValue() > maxFreq) {
        maxFreq = entry.getValue();
        mostFrequentElement = entry.getKey();
    }
    }
    System.out.println(n-maxFreq);  
}
}