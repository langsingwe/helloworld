package leetcode;

/**
 * @Description
 * @ClassName Test1672
 * @Author weilc
 * @Date 2020-11-30
 * @Version 1.0
 */
public class Test1672 {

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0;i<accounts.length;i++) {
            int total = 0;
            for(int j=0;j<accounts[i].length;j++) {
                total += accounts[i][j];
            }
            if(max < total) {
                max = total;
            }
        }
        return max;
    }
}
