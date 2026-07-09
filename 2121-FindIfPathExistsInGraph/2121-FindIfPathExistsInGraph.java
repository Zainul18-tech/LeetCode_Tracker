// Last updated: 09/07/2026, 10:36:12
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;

        for (int[] e : edges) {
            union(a, e[0], e[1]);
        }
        return find(a, source) == find(a, destination);
    }
    private int find(int[] a, int x) {
        while (a[x] != x) {
            a[x] = a[a[x]];
            x = a[x];
        }
        return x;
    }
    private void union(int[] a, int c, int b) {
        int rootA = find(a, c);
        int rootB = find(a, b);
        if (rootA != rootB) a[rootA] = rootB;
    }
}