package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.05.08
 */
public class Test {
    public static void main(String[] args) {
        int count = 0;
        String S = "AAB";
        String T = "ABC";
        String[] sArr = S.split("");
        Map<String, Integer> sMap = new HashMap<>();
        for (String c : sArr) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }
        String[] tArr = T.split("");
        for (String s : tArr) {
            if (sMap.containsKey(s) && sMap.get(s) != 0) {
                count++;
                sMap.put(s, sMap.get(s) - 1);
            }
        }

        System.out.println(count);

    }

    int solution(String S, String T) {
        int count = 0;
        String[] sArr = S.split("");
        Map<String, Integer> sMap = new HashMap<>();
        for (String c : sArr) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }
        String[] tArr = T.split("");
        for (String s : tArr) {
            if (sMap.containsKey(s) && sMap.get(s) != 0) {
                count++;
                sMap.put(s, sMap.get(s) - 1);
            }
        }
        return count;
    }
}
