package leetcode;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test300
 * @date 2021.03.02
 */
public class Test300 {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }

    static int lengthOfLIS(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
