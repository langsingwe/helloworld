package leetcode;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 * 示例 1：
 *
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 *
 * 示例 2：
 *
 * 输入：num = 6
 * 输出：true
 */
public class T507完美数 {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
        System.out.println(checkPerfectNumber(496));
        System.out.println(checkPerfectNumber(2));
    }

    static boolean checkPerfectNumber(int num) {
        int val = 0;
        for (int i = 1; i < num-1; i++) {
            if (num % i == 0) {
                val += i;
            }
        }
        return val == num;
    }
}
