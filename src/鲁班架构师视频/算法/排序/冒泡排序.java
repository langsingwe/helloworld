package 鲁班架构师视频.算法.排序;

import java.util.Arrays;

/**
 * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3、针对所有的元素重复以上的步骤，除了最后一个；
 * 4、重复步骤1~3，直到排序完成。
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(a));
        System.out.println("排序后");
        bubble(a);
        System.out.println(Arrays.toString(a));
    }

    static void bubble(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
