// Last updated: 09/07/2026, 10:35:35
class Solution {
    private int digitSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int squareSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
    
    public boolean checkGoodInteger(int n) {
        return (squareSum(n) - digitSum(n)) >= 50;
    }
}