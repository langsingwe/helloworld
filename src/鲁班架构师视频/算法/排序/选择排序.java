package 鲁班架构师视频.算法.排序;

import java.util.Arrays;

/**
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(a));
        System.out.println("排序后");
        select(a);
        System.out.println(Arrays.toString(a));
    }

    static void select(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
