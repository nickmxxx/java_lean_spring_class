/*
 * @lc app=leetcode.cn id=1449 lang=java
 *
 * [1449] 数位成本和为目标值的最大数字
 *
 * https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/description/
 *
 * algorithms
 * Hard (38.47%)
 * Likes:    25
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 4.9K
 * Testcase Example:  '[4,3,2,5,6,7,2,5,5]\n9'
 *
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * 
 * 
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 
 * 
 * 由于答案可能会很大，请你以字符串形式返回。
 * 
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "997"
 * 也是满足要求的数字，但 "7772" 是较大的数字。
 * ⁠数字     成本
 * ⁠ 1  ->   4
 * ⁠ 2  ->   3
 * ⁠ 3  ->   2
 * ⁠ 4  ->   5
 * ⁠ 5  ->   6
 * ⁠ 6  ->   7
 * ⁠ 7  ->   2
 * ⁠ 8  ->   5
 * ⁠ 9  ->   5
 * 
 * 
 * 示例 2：
 * 
 * 输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * 输出："85"
 * 解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * 
 * 
 * 示例 3：
 * 
 * 输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * 输出："0"
 * 解释：总成本是 target 的条件下，无法生成任何整数。
 * 
 * 
 * 示例 4：
 * 
 * 输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * 输出："32211"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 * 
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] nums_del_repeat = new int[cost.length];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < cost.length; i++) {
            if (set.add(cost[i])) {
                nums_del_repeat[index++] = cost[i];
            }
        }
        int count = 0; // 记录0的个数
        // System.out.println();

        for (int i = 0; i < cost.length; i++) {
            if (nums_del_repeat[i] == 0) {
                count++;
            }
        }

        // System.out.println("0的个数为: " + count);
        int[] nums_del_0 = new int[cost.length - count];
        // 删除0元素
        for (int i = 0; i < nums_del_0.length; i++) {
            nums_del_0[i] = nums_del_repeat[i];
        }
        int re_index[] = new int[nums_del_0.length];
        for (int j = 0; j < nums_del_0.length; j++) {
            for (int i = 0; i <cost.length; i++) {
                if (cost[i] == nums_del_0[j]) {
                    re_index[j] = i;
                }
            }
        }
        // System.out.print("删除重复数据后的下标:");
        for (int i = 0; i < re_index.length; i++) {
            re_index[i] = re_index[i] + 1;
        }
        // System.out.println("");

        for (int i = 1; i < re_index.length; i++) {
            for (int j = 0; j < re_index.length - i; j++) {
                if (re_index[j] > re_index[j + 1]) {
                    int temp = re_index[j];
                    re_index[j] = re_index[j + 1];
                    re_index[j + 1] = temp;
                    int temp1 = nums_del_0[j];
                    nums_del_0[j] = nums_del_0[j + 1];
                    nums_del_0[j + 1] = temp1;
                }
            }
        }
        
        String[] res = new String[target + 1];
        // System.out.println();
        res[0] = "";
        for (int i = 0; i < re_index.length; i++) {
            for (int j = nums_del_0[i]; j <= target; j++) {
                if (res[j - nums_del_0[i]] != null) {
                    res[j] = max(re_index[i] + res[j - nums_del_0[i]], res[j]);
                }
            }
        }
       return res[target] == null ? "0" : res[target];
    }
    private static String max(String s1, String s2) {
        if (s1 == null && s2 == null)
            return null;
        if (s2 == null || s1.length() > s2.length())
            return s1;
        if (s1 == null || s1.length() < s2.length())
            return s2;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i))
                return s2;
            else if (s1.charAt(i) > s2.charAt(i))
                return s1;
        }
        return s1;
    }
}
// @lc code=end

