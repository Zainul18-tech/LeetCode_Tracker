// Last updated: 09/07/2026, 10:35:32
class Solution {
    public int maxDistance(String moves) {
        int u =0,d=0,l=0,r=0,wild=0;
        for(char c: moves.toCharArray()){
            if(c=='U') u++;
            else if(c=='D') d++;
            else if(c=='L') l++;
            else if(c=='R') r++;
            else wild++;
        }
        int v = Math.abs(u-d);
        int h = Math.abs(l-r);
        return v+h+wild;
    }
}