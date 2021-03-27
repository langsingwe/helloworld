package 算法.查找;

import java.util.Arrays;

/**
 * @Description
 * @ClassName FindWebsite
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class FindWebsite {

    public static void main(String[] args) {
        String[] arr = {"www.baidu.com", "www.huawei,com", "www.sitech.com", "www.pic.com"};
        String key = "www.baidu.com";
        System.out.println(find(arr, key));
    }

    public static boolean find(String[] arr, String key) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, key);
        if (index >= 0) {
            return true;
        }
        return false;
    }
}
