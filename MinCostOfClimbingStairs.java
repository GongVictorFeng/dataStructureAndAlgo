public class MinCostOfClimbingStairs {

    public static int solution(int[] costs) {
        // int index = costs.length;
        // return Math.min(dpWithoutMemorization(costs, index -1), dpWithoutMemorization(costs, index -2));

        // int[] computed = new int[costs.length];
        // computed[0] = costs[0];
        // computed[1] = costs[1];
        // for (int i = 2; i < computed.length; i++) {
        //     computed[i] = -1;
        // }
        // return Math.min(dpTopDown(costs, computed, index -1), dpTopDown(costs, computed, index -2));
        // return dpDownTop(costs, computed);
        return optimazation(costs);
    }

    private static int  dpWithoutMemorization(int[] costs, int index) {
        if (index <= 1) {
            return costs[index];
        }
        return Math.min(dpWithoutMemorization(costs, index -1), dpWithoutMemorization(costs, index -2)) + costs[index];
    }

    private static int dpTopDown(int[] costs, int[] computed, int index) {
        if(computed[index] != -1) {
            return computed[index];
        }
        computed[index] = Math.min(dpTopDown(costs, computed, index -1), dpTopDown(costs, computed, index -2)) + costs[index];
        return computed[index];
    }

    private static int dpDownTop(int[] costs, int[] computed) {
        for (int i = 2; i < costs.length; i++) {
            computed[i] = Math.min(computed[i-2], computed[i-1]) + costs[i];
        }
        return Math.min(computed[costs.length-1], computed[costs.length-2]);
    }

    private static int optimazation(int[] costs) {
        int firstValue = costs[0];
        int secondValue = costs[1];
        for (int i = 2; i < costs.length; i++) {
            int tempt = Math.min(firstValue, secondValue) + costs[i];
            firstValue = secondValue;  
            secondValue = tempt;
        }
        return Math.min(firstValue, secondValue);
    }
    public static void main(String[] args) {
        int[] costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        
        System.out.println(solution(costs));
    }
}
