public class SearchInRotatedSortedArray {

    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                    continue;
                }
                left = mid + 1;
                continue;
            }
            if (nums[mid] < target && target < nums[left]) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(solution(nums, target));
    }
}
