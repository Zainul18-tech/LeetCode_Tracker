// Last updated: 09/07/2026, 10:36:14
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(a.getKey(),b.getKey()));
        for(int ele : costs){
            hm.put(ele,hm.getOrDefault(ele,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            pq.offer(entry);
        }
        int cnt = 0;
        while(!pq.isEmpty() && coins > 0){
            Map.Entry<Integer,Integer> entry = pq.poll();
            if(coins >= entry.getKey()){
                int iceCnt = Math.min(coins / entry.getKey(),entry.getValue());
                coins -= iceCnt * entry.getKey();
                cnt += iceCnt;
            }
        }
        return cnt;
    }
}