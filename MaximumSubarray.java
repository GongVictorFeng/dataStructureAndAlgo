public class MaximumSubarray {
    public static int solution(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // check if the subarray should include the current elements, if the current element bigger than the sum of the subarray, restart the subarray.
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    public static int solution2(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dpTopDown(nums, nums.length -1, dp);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int dpTopDown(int[] nums, int index, int[] dp) {
        if (index == 0) {
            dp[0] = nums[0];
            return nums[0];
        }

        int current;
        if (dp[index -1] != Integer.MIN_VALUE) {
            current =dp[index -1];
        }

        current = dpTopDown(nums, index -1, dp);
        dp[index] = current < 0 ? nums[index] : current + nums[index];
        return dp[index];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution2(nums));
    } 
}
