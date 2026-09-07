class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        long[] last = new long[26];

        long total = 1;

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            long newTotal = (total * 2) % MOD;

            newTotal = (newTotal - last[index] + MOD) % MOD;

            last[index] = total;

            total = newTotal;
        }

        return (int) ((total - 1 + MOD) % MOD);
    }
}