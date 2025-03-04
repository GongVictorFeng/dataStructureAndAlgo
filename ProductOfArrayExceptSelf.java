import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] solution(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        prefixProducts[0] = 1;
        int suffixProduct = 1;

        for (int i=1; i < nums.length; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i-1];
        }

        for (int i = nums.length - 1 ; i >= 0; i--) {
            prefixProducts[i] = prefixProducts[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }
        return prefixProducts;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(nums)));
    }
}
