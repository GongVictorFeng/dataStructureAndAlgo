public class MaximumProductSubarray {

    public static int solution(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int tempMax = max = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = tempMin;
            max = tempMax;
            result = Math.max(result, max);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, -1};
        System.out.println(solution(nums));
    }
}
