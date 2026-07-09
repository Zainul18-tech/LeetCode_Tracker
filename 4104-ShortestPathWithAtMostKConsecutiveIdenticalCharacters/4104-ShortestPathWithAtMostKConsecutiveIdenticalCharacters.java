// Last updated: 09/07/2026, 10:35:46
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }
        
        // State: (node, lastChar, runLength)
        Map<Long, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int startChar = labels.charAt(0) - 'a';
        int startRun = 1;
        
        if (startRun > k) {
            return -1; // not reachable given constraints (k >= 1), but kept as safety check
        }
        
        long startState = encodeState(0, startChar, startRun, k);
        dist.put(startState, 0);
        pq.offer(new int[]{0, 0, startChar, startRun});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0];
            int node = cur[1];
            int lastChar = cur[2];
            int runLen = cur[3];
            
            long stateKey = encodeState(node, lastChar, runLen, k);
            Integer bestKnown = dist.get(stateKey);
            if (bestKnown == null || curDist > bestKnown) {
                continue; // stale entry
            }
            
            if (node == n - 1) {
                return curDist;
            }
            
            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                int nextChar = labels.charAt(next) - 'a';
                
                int newRun = (nextChar == lastChar) ? runLen + 1 : 1;
                
                if (newRun > k) {
                    continue;
                }
                
                int newDist = curDist + weight;
                long newStateKey = encodeState(next, nextChar, newRun, k);
                
                Integer existing = dist.get(newStateKey);
                if (existing == null || newDist < existing) {
                    dist.put(newStateKey, newDist);
                    pq.offer(new int[]{newDist, next, nextChar, newRun});
                }
            }
        }
        
        return -1;
    }
    
    private long encodeState(int node, int lastChar, int runLen, int k) {
        return ((long) node * 27 + lastChar) * (k + 1) + runLen;
    }
}