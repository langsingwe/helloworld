package leetcode;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 */
public class T1154一年中的第几天 {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2003-03-01"));
        System.out.println(dayOfYear("2004-03-01"));
    }

    public static int dayOfYear(String date) {
        int count = 0;
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        for (int i = 0; i < Integer.parseInt(month) - 1; i++) {
            count += amount[i];
        }
        if (Integer.parseInt(month) > 2 && Integer.parseInt(year) % 4 == 0) {
            count++;
        }
        count += Integer.parseInt(day);
        return count;
    }
}
