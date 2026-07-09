// Last updated: 09/07/2026, 10:36:40
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0&&n==1){
            return 1;
        }
        int[] a = new int[n+1];
        for(int[] t :trust){
            a[t[0]]--;
            a[t[1]]++;
        }
        for(int t=0;t<n+1;t++){
            if(a[t]==n-1)
            return t;
        }
        return -1;
    }
}