// Last updated: 09/07/2026, 10:35:41
class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int maxTotalValue(int[] value, int[] decay, int m) {
        int n = value.length;
        long[] val = new long[n];
        long[] dec = new long[n];
        for (int i = 0; i < n; i++) {
            val[i] = value[i];
            dec[i] = decay[i];
        }
        
        // Binary search on threshold T: find largest T such that 
        // count of selections with gain >= T (across all indices) >= m
        // gain range: from min possible (very negative) to max value[i]
        long lo = Long.MIN_VALUE / 2, hi = 0;
        for (long v : val) hi = Math.max(hi, v);
        
        // We only care about non-negative gains (negative gains are never picked)
        lo = 0;
        
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2; // bias toward higher mid since we want largest T
            long cnt = totalCountAtLeast(val, dec, mid, m);
            if (cnt >= m) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        
        long T = lo; // largest threshold such that count(gain >= T) >= m
        
        // Now compute sum of all selections with gain > T, plus fill remainder with gain == T
        long totalSum = 0;
        long countStrictlyGreater = 0;
        long sumStrictlyGreater = 0;
        
        for (int i = 0; i < n; i++) {
            long[] res = countAndSumAtLeast(val[i], dec[i], T + 1); // gain >= T+1, i.e., > T
            countStrictlyGreater += res[0];
            sumStrictlyGreater = (sumStrictlyGreater + res[1]) % MOD;
        }
        
        long remaining = m - countStrictlyGreater; // number of selections needed at exactly gain == T
        
        totalSum = sumStrictlyGreater;
        if (remaining > 0) {
            totalSum = (totalSum + (T % MOD) * (remaining % MOD)) % MOD;
        }
        
        return (int) ((totalSum % MOD + MOD) % MOD);
    }
    
    // Returns total count of selections (across all indices) with gain >= T, capped check against m for early exit isn't needed here, just sum counts
    private long totalCountAtLeast(long[] val, long[] dec, long T, long mCap) {
        long total = 0;
        for (int i = 0; i < val.length; i++) {
            long cnt = countAtLeast(val[i], dec[i], T);
            total += cnt;
            if (total > mCap) {
                // early exit not strictly necessary but helps avoid overflow on huge counts
                return total; 
            }
        }
        return total;
    }
    
    // Count how many t (t=1,2,3,...) satisfy: val - dec*(t-1) >= T
    // val - dec*(t-1) >= T  =>  dec*(t-1) <= val - T  =>  t-1 <= (val-T)/dec (if dec > 0)
    private long countAtLeast(long val, long dec, long T) {
        if (val < T) return 0;
        long diff = val - T;
        long maxStepsMinus1 = diff / dec; // floor division, dec >= 1 always per constraints
        long cnt = maxStepsMinus1 + 1; // t ranges 1..(maxStepsMinus1+1)
        return cnt;
    }
    
    // Returns {count, sum mod MOD} of selections with gain >= T for a single index
    private long[] countAndSumAtLeast(long val, long dec, long T) {
        long cnt = countAtLeast(val, dec, T);
        if (cnt == 0) return new long[]{0, 0};
        
        // Sum of arithmetic sequence: val, val-dec, val-2*dec, ..., val-(cnt-1)*dec
        // Sum = cnt*val - dec*(0+1+...+(cnt-1)) = cnt*val - dec*cnt*(cnt-1)/2
        long cntMod = cnt % MOD;
        long valMod = ((val % MOD) + MOD) % MOD;
        long decMod = ((dec % MOD) + MOD) % MOD;
        
        long term1 = (cntMod * valMod) % MOD;
        
        long cntMinus1 = (cnt - 1) % MOD;
        // (cnt * (cnt-1) / 2) mod MOD -- need modular inverse of 2, or handle parity
        long pairProd;
        if (cnt % 2 == 0) {
            pairProd = ((cnt / 2) % MOD) * ((cnt - 1) % MOD) % MOD;
        } else {
            pairProd = (cnt % MOD) * (((cnt - 1) / 2) % MOD) % MOD;
        }
        
        long term2 = (decMod * pairProd) % MOD;
        
        long sum = ((term1 - term2) % MOD + MOD) % MOD;
        return new long[]{cnt, sum};
    }
}