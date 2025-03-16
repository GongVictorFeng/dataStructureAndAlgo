public class FindMinimunInRotatedArray {

    public static int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int min = nums[left];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                min = Math.min(nums[left], min);
                break;
            }
            int mid = (left + right) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        
    }
}
