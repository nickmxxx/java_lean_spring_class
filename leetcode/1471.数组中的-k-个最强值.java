import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1471 lang=java
 *
 * [1471] 数组中的 k 个最强值
 *
 * https://leetcode-cn.com/problems/the-k-strongest-values-in-an-array/description/
 *
 * algorithms
 * Medium (52.72%)
 * Likes:    11
 * Dislikes: 0
 * Total Accepted:    5.1K
 * Total Submissions: 9.7K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个整数数组 arr 和一个整数 k 。
 * 
 * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
 * 
 * 
 * |arr[i] - m| > |arr[j] - m|
 * |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
 * 
 * 
 * 请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
 * 
 * 中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) /
 * 2) 的元素。
 * 
 * 
 * 例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m
 * = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
 * 例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m =
 * ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值为 3 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = [1,2,3,4,5], k = 2
 * 输出：[5,1]
 * 解释：中位数为 3，按从强到弱顺序排序后，数组变为 [5,1,4,2,3]。最强的两个元素是 [5, 1]。[1, 5] 也是正确答案。
 * 注意，尽管 |5 - 3| == |1 - 3| ，但是 5 比 1 更强，因为 5 > 1 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = [1,1,3,5,5], k = 2
 * 输出：[5,5]
 * 解释：中位数为 3, 按从强到弱顺序排序后，数组变为 [5,5,1,1,3]。最强的两个元素是 [5, 5]。
 * 
 * 
 * 示例 3：
 * 
 * 输入：arr = [6,7,11,7,6,8], k = 5
 * 输出：[11,8,6,6,7]
 * 解释：中位数为 7, 按从强到弱顺序排序后，数组变为 [11,8,6,6,7,7]。
 * [11,8,6,6,7] 的任何排列都是正确答案。
 * 
 * 示例 4：
 * 
 * 输入：arr = [6,-3,7,2,11], k = 3
 * 输出：[-3,11,2]
 * 
 * 
 * 示例 5：
 * 
 * 输入：arr = [-7,22,17,3], k = 2
 * 输出：[22,17]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 10^5
 * -10^5 <= arr[i] <= 10^5
 * 1 <= k <= arr.length
 * 
 * 
 */

// @lc code=start
class Solution_t1471 {
    public int[] getStrongest(int[] arr, int k) {
        // int[] arr = {1,2,3,4,5};
        // int k = 2;
        Arrays.sort(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        int arr_length = arr.length;
        int num_middle = arr[(arr_length - 1) / 2];
        // System.out.println("数组的中位数为：" + num_middle);
        return sort_by_strong(arr, num_middle, k);
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
        // for (int j = 0; j < arr_sorted.length; j++) {
        //     System.out.print(arr_sorted[j]+" ");
        // }
        return arr_sorted;
    }
}
// @lc code=end

