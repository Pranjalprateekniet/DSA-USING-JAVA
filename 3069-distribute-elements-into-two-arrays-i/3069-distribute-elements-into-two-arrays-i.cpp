class Solution {
public:
    vector<int> resultArray(vector<int>& arr) {
        vector<int>arr1={arr[0]};
        vector<int >arr2={arr[1]};
        for(int i=2;i<arr.size();i++){
            if(arr1.back()>arr2.back())
                arr1.push_back(arr[i]);
            else
                arr2.push_back(arr[i]);
        }
        arr1.insert(arr1.end(),arr2.begin(),arr2.end());
        return arr1;
    }
};