import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean solution1(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
        
    }

    public static boolean solution2(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                return true;
            }
            visited.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {2, 1, 5, 4, 5};
        System.out.println(solution1(nums));
        System.out.println(solution2(nums));
    }
}
