import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] solution(int[] nums, int target) {

        HashMap<Integer, Integer> container = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];
            if (container.containsKey(numberToFind)) {
                return new int[] {container.get(numberToFind), i};
            }
            container.put(nums[i], i);
        }
        
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = new int[] {2, 1, 3, 5, 8};
        int target = 9;
        int[] solutionArr = solution(nums, target);
        System.out.println(Arrays.toString(solutionArr));
    }
}
