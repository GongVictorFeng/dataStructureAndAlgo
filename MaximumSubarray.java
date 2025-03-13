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
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution(nums));
    } 
}
