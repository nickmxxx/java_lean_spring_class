/*
 * @lc app=leetcode.cn id=1406 lang=java
 *
 * [1406] 石子游戏 III
 *
 * https://leetcode-cn.com/problems/stone-game-iii/description/
 *
 * algorithms
 * Hard (54.84%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    2.9K
 * Total Submissions: 5.3K
 * Testcase Example:  '[1,2,3,7]'
 *
 * Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
 * 
 * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子
 * 。比赛一直持续到所有石头都被拿走。
 * 
 * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0
 * 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
 * 
 * 假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回
 * "Tie" 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：values = [1,2,3,7]
 * 输出："Bob"
 * 解释：Alice 总是会输，她的最佳选择是拿走前三堆，得分变成 6 。但是 Bob 的得分为 7，Bob 获胜。
 * 
 * 
 * 示例 2：
 * 
 * 输入：values = [1,2,3,-9]
 * 输出："Alice"
 * 解释：Alice 要想获胜就必须在第一个回合拿走前三堆石子，给 Bob 留下负分。
 * 如果 Alice 只拿走第一堆，那么她的得分为 1，接下来 Bob 拿走第二、三堆，得分为 5 。之后 Alice 只能拿到分数 -9
 * 的石子堆，输掉比赛。
 * 如果 Alice 拿走前两堆，那么她的得分为 3，接下来 Bob 拿走第三堆，得分为 3 。之后 Alice 只能拿到分数 -9
 * 的石子堆，同样会输掉比赛。
 * 注意，他们都应该采取 最优策略 ，所以在这里 Alice 将选择能够使她获胜的方案。
 * 
 * 示例 3：
 * 
 * 输入：values = [1,2,3,6]
 * 输出："Tie"
 * 解释：Alice 无法赢得比赛。如果她决定选择前三堆，她可以以平局结束比赛，否则她就会输。
 * 
 * 
 * 示例 4：
 * 
 * 输入：values = [1,2,3,-1,-2,-3,7]
 * 输出："Alice"
 * 
 * 
 * 示例 5：
 * 
 * 输入：values = [-1,-2,-3]
 * 输出："Tie"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= values.length <= 50000
 * -1000 <= values[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution_t1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        String[] res = { "Tie", "Alice", "Bob" };
        int[] state = new int[n + 1];
        // 从后向前进行博弈，从第 n堆开始从后向前，只关心前三个的情况
        // 转移的时候，可以取第i,i+1;i+2堆
        state[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            state[i] = stoneValue[i] - state[i + 1];
            // 至少也要取一个，取一个之后与取两个、三个的作比较
            if (i < n - 1) {
                state[i] = Math.max(state[i], stoneValue[i] + stoneValue[i + 1] - state[i + 2]);
            }
            if (i < n - 2) {
                state[i] = Math.max(state[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - state[i + 3]);
            }
        }
        if (state[0] == 0) {
            return res[0];
        } else if (state[0] > 0) {
            return res[1];
        } else {
            return res[2];
        }
    }
}
// @lc code=end
