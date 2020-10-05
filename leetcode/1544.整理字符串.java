/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 *
 * https://leetcode-cn.com/problems/make-the-string-great/description/
 *
 * algorithms
 * Easy (47.30%)
 * Likes:    12
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 18.4K
 * Testcase Example:  '"leEeetcode"'
 *
 * 给你一个由大小写英文字母组成的字符串 s 。
 * 
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 * 
 * 
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
 * 
 * 
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * 
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * 
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "s"
 * 输出："s"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 * 
 * 
 */

// @lc code=start
class Solution_t1544 {
    public String makeGood(String s) {
               // 整体思路是将其转变ASCII码，大小写字母ASCII码差距为32
        // 定义一个flag，来判断是否已经完全排序
        // 整体思路是将其转变ASCII码，大小写字母ASCII码差距为32
        // 定义一个flag，来判断是否已经完全排序
        // String s = "qFxXfQo";
        boolean flag = false;
        // if (s.length() == 1) {
        // // System.out.println(s);
        // }

        do {
            if (s.length() == 0 || s.length() == 1) {
                // System.out.println(s);
                flag = true;
            } else {
                for (int i = 0; i < s.length() - 1; i++) {

                    if (s.length() != 0 && (Math.abs((int) s.charAt(i) - (int) s.charAt(i + 1)) == 32)) {
                        // count++;
                        flag = false;
                        s = s.substring(0, i).concat(s.substring(i + 2, s.length()));
                        break;
                    }
                    // 若存在前后字符大小写则退出循环，将s进行改变,并且使计数器+1
                    // 否则不变，跳出当此循环，进行下一次循环。
                    else {
                        flag = true;
                    }
                }

            }
        } while (!flag);

        // System.out.println(s);
        return s;
    }
}
// @lc code=end

