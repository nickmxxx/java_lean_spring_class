import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1560 lang=java
 *
 * [1560] 圆形赛道上经过次数最多的扇区
 *
 * https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track/description/
 *
 * algorithms
 * Easy (56.98%)
 * Likes:    10
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 10.3K
 * Testcase Example:  '4\n[1,3,1,2]'
 *
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n
 * 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区
 * rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 * 
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 * 
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：n = 4, rounds = [1,3,1,2]
 * 输出：[1,2]
 * 解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
 * 1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
 * 其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。
 * 
 * 示例 2：
 * 
 * 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * 输出：[2]
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 7, rounds = [1,3,5,7]
 * 输出：[1,2,3,4,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= n <= 100
 * 1 <= m <= 100
 * rounds.length == m + 1
 * 1 <= rounds[i] <= n
 * rounds[i] != rounds[i + 1] ，其中 0 <= i < m
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {

        int[] rounds_copy = (int[]) Arrays.copyOf(rounds, rounds.length);
        // 此处为将原始数据进行处理，如果前一个大于后一个数字，则将其加n之后取模操作即可
        for (int i = 1; i < rounds.length; i++) {
            if (rounds_copy[i - 1] > rounds_copy[i]) {
                 for(int j=i;j<rounds.length;j++){
                    rounds[j] = rounds[j]+n;
                }
            }
        }

        // for (int i = 0; i < rounds.length; i++) {
        //     System.out.print(rounds[i]);
        // }
        int[] count = new int[n];
        // 边界处理进行初始化，将第一个刚开始进行计数
        count[(rounds[0] - 1)]++;
        for (int i = 0; i < rounds.length - 1; i++) {
            for (int j = rounds[i] + 1; j <= rounds[i + 1]; j++) {
                count[(j - 1) % n]++;
            }
        }
        // System.out.println("");
        List<Integer> ans = new ArrayList<>();
        int[] index_num = max_index(count);
        // int[] req = new int[index_num[index_num.length - 1]];
        // int req_num = 0;
        for(int i=0;i<index_num.length-1;i++){
            if(index_num[i]==1){
                // req[req_num] = i+1;
                ans.add(i+1);
                // req_num++;
            }
        }
        // System.out.println("");
        // for(int i=0;i<req.length;i++){
        //     System.out.print(req[i]);
        // }
        return ans;

    }
    private static int[] max_index(int[] a) {
        int[] index_find = new int[a.length+1];
        int max = a[0];
        for(int i =1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }     
        }
        // System.out.println(max);
        for(int i=0;i<a.length;i++){
            if(a[i]==max){
                index_find[i] = 1;
                index_find[a.length]++; //将最大值的个数保存在最后一个数组值中
            }
        }
        // for(int i = 0;i<index_find.length;i++){
        //     System.out.print(index_find[i]);
        // }
        return index_find;
    }
}
// @lc code=end

