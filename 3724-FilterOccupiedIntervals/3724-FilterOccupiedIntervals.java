// Last updated: 09/07/2026, 10:35:59
class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a,b) -> a[0] - b[0]);

        int[][] novalethri = occupiedIntervals;

        List<int[]> merged = new ArrayList<>();
        for(int[] intervals : novalethri) {
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] + 1 < intervals[0])
                merged.add(new int[]{intervals[0], intervals[1]});
            else
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[1]);
        }

        List<int[]> result = new ArrayList<>();
        for(int[] interval : merged) {
            int s = interval[0], e = interval[1];

            if(e < freeStart || s > freeEnd) {
                result.add(new int[]{s, e});
                continue;
            }

            if(s >= freeStart && e <= freeEnd) continue;
            if(s < freeStart) result.add(new int[]{s,freeStart - 1});
            if(e > freeEnd) result.add(new int[]{freeEnd + 1, e});
        }
        List<List<Integer>> output = new ArrayList<>();
        for (int[] r : result)
            output.add(Arrays.asList(r[0], r[1]));
        return output;
    }
}