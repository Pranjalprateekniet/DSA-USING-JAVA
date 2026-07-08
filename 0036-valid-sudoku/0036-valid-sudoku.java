class Solution {
    public boolean isValidSudoku(char[][] arr) {
        int n=arr.length;
        for(int i=0;i<9;i++){
            int hash[]=new int[10];
            for(int j=0;j<9;j++){
                char ch=arr[i][j];
                if(ch=='.')
                    continue;
                int index = ch - '0';
                if(hash[index]>0)
                    return false;
                hash[index]++;
            }
        }
        for(int i=0;i<9;i++){
            int hash[]=new int[10];
            for(int j=0;j<9;j++){
                char ch=arr[j][i];
                if(ch=='.')
                    continue;
                int index=ch-'0';
                if(hash[index]>0)
                    return false;
                hash[index]++;

            }
        }
        for(int sr=0;sr<9;sr+=3){
            for(int sc=0;sc<9;sc+=3){
                int hash[]=new int[10];
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        char ch=arr[sr+i][sc+j];
                        if(ch=='.')
                            continue;
                        int index=ch-'0';
                        if(hash[index]>0)
                            return false;
                        hash[index]++;
                    }
                }
            }
        }
        return true;
    }
}