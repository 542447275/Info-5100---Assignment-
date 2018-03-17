public class LongestContinuousSubsequence {
    public int findLongestLength(int[] nums) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i])
                res = Math.max(res, ++cnt);
            else
                cnt = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestContinuousSubsequence lcs = new LongestContinuousSubsequence();
        int[] nums = {1,3,5,4,7};
        int res = lcs.findLongestLength(nums);
        System.out.println(res);
    }
}