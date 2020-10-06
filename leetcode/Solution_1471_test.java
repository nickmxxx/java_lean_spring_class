import java.util.Arrays;

public class Solution_1471_test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int arr_length = arr.length;
        int num_middle = arr[(arr_length - 1) / 2];
        System.out.println("数组的中位数为：" + num_middle);
        sort_by_strong(arr, num_middle, k);
    }

    private static int[] sort_by_strong(int[] arr, int m, int k) {
        // 对数组进行排序，如果由题意不难看出中位数肯定是最弱的一个，放在第一位
        // 并且可以看出，距离的排序是根据所有数字与中位数m的距离来进行的
        // 对本题，我的思路是不需要进行排序，只需要从后，从前分别出发，
        // 定义index_begin与index_end两个下标，分别记录相应的差值，并进行比较
        int index_begin = 0;
        int index_end = arr.length - 1;
        int i = 0;
        int[] arr_sorted = new int[k];
        do {
            if (Math.abs(arr[index_end] - m) > Math.abs(arr[index_begin] - m)) {
                arr_sorted[i] = arr[index_end];
                // arr_sorted.add(arr[index_end]);
                index_end--;
            } else if (Math.abs(arr[index_end] - m) < Math.abs(arr[index_begin] - m)) {
                arr_sorted[i] = arr[index_begin];
                // arr_sorted.add(arr[index_begin]);
                index_begin++;
            } else {
                arr_sorted[i] = arr[index_end];
                // arr_sorted.add(arr[index_end]);
                index_end--;
            }
            i++;
            k--;
        } while (k > 0);
        for (int j = 0; j < arr_sorted.length; j++) {
            System.out.print(arr_sorted[j]+" ");
        }
        return arr_sorted;
    }
}
