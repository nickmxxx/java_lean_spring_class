/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 *
 * https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 * algorithms
 * Medium (54.33%)
 * Likes:    12
 * Dislikes: 0
 * Total Accepted:    3.6K
 * Total Submissions: 6.6K
 * Testcase Example:  '[1,1,0,1]'
 *
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 
 * 如果不存在这样的子数组，请返回 0 。
 * 
 * 
 * 
 * 提示 1：
 * 
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 
 * 示例 2：
 * 
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 
 * 示例 3：
 * 
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 
 * 示例 4：
 * 
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 
 * 
 * 示例 5：
 * 
 * 输入：nums = [0,0,0]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 * 
 * 
 */

// @lc code=start
class Solution_t1493 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int ans = 0;
        //  从0的左边开始记录，遇到0，左变右，开始记录右边的值
        //  并于记录的最大值ans进行对比，不断更新。
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                left = right;
                right = 0;
            }
            else{
                right++;
            }
            ans = Math.max(left+right,ans);
        }
        if(ans == nums.length){
            ans = nums.length-1;
        }
        // System.out.println(ans);
        return ans;
    }
}
// @lc code=end

