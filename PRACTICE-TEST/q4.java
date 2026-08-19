    /*
    Fruit Into Baskets
    Medium

    Hints
    Company
    There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.



    The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:



    1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.

    2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.

    3) Once reaching a tree with fruit that cannot fit into any basket, stop.



    Return the maximum number of fruits that can be picked.


    Example 1

    Input : fruits = [1, 2, 1]

    Output : 3

    Explanation : We will start from first tree.

    The first tree produces the fruit of kind '1' and we will put that in the first basket.

    The second tree produces the fruit of kind '2' and we will put that in the second basket.

    The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket.

    Hence we were able to collect total of 3 fruits.

    Example 2

    Input : fruits = [1, 2, 3, 2, 2]

    Output : 4

    Explanation : we will start from second tree.

    The first basket contains fruits from second , fourth and fifth.

    The second basket will contain fruit from third tree.

    Hence we collected total of 4 fruits.

    Example 3

    Input : fruits = [1, 2, 3, 4, 5]

    Output:

    2
    Constraints

    1 <= fruits.length <= 105
    0 <= fruits[i] < fruits.length
    */
    import java.util.*;
    public class q4 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();

            }
            System.out.println(maxfruits(arr,n));
        }
        private static int maxfruits(int arr[],int n){
            int left=0;
            int right=0;
            int max=0;
            HashMap<Integer,Integer>map=new HashMap<>();
            while (right<n) {
                int key=arr[right];
                map.put(arr[right],map.getOrDefault(arr[right],0)+1);
                if(map.size()>2){
                    while(map.size()>2){
                        map.put(arr[left],map.get(arr[left])-1);
                        if(map.get(arr[left])==0)
                            map.remove(arr[left]);
                        left++;
                    }
                }
                int curr=right-left+1;
                max=Math.max(max, curr);
                right++;
            }
            return max;

        }

        
    }
