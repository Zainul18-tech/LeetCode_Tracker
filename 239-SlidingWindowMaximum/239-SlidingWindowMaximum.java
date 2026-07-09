// Last updated: 09/07/2026, 10:37:44
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() &&
                    nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                ans[index++] = nums[dq.peek()];
            }
        }

        return ans;
    }
}