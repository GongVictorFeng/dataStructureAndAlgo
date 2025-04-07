import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> externalList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if(twoSum == target) {
                    List<Integer> internalList = new ArrayList<>();
                    internalList.add(nums[i]);
                    internalList.add(nums[left]);
                    internalList.add(nums[right]);
                    externalList.add(internalList);
                    while (left < right && left < nums.length -1 && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && right > 0 && nums[right-1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
                if (twoSum < target) {
                    left++;
                    continue;
                }
                right--;
            }
        }
        return externalList;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution(nums));
    }
}
