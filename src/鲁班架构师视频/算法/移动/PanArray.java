package 算法.移动;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className PanArray
 * @date 2021.02.20
 */
public class PanArray {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        for(int i=0;i<k;i++){
            int temp = nums[len-1];
            for(int j=len-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8};
        rotate(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
