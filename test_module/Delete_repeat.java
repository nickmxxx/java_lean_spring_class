import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Delete_repeat {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 5, 6, 7, 2, 5, 5 };
        // 做一份原数据的拷贝
        int[] nums_copy = Arrays.copyOf(nums, nums.length);
        if (nums.length == 0) {
            System.out.println("空数组: ");
        }
        int[] nums_del_repeat = new int[nums.length];
        Set<Integer> set = new HashSet<Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                nums_del_repeat[index++] = nums[i];
            }
        }
        System.out.print("删除重复元素数组后: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums_del_repeat[i]);
        }

        int count = 0; // 记录0的个数
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            if (nums_del_repeat[i] == 0) {
                count++;
            }
        }

        System.out.println("0的个数为: " + count);
        int[] nums_del_0 = new int[nums.length - count];
        // 删除0元素
        for (int i = 0; i < nums_del_0.length; i++) {
            nums_del_0[i] = nums_del_repeat[i];
        }

        System.out.print("删除重复数据后: ");

        for (int i = 0; i < nums_del_0.length; i++) {
            System.out.print(nums_del_0[i]);
        }
        // 寻找数组中的元素的下标
        // for(int i=0; i<nums_del_0.length; i++){
        // re_index[i] = Arrays.binarySearch(nums_copy, nums_del_0[i]);
        // }
        System.out.println();
        int re_index[] = new int[nums_del_0.length];
        for (int j = 0; j < nums_del_0.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums_del_0[j]) {
                    re_index[j] = i;
                }
            }

        }

        for (int i = 0; i < re_index.length; i++) {
            re_index[i] = re_index[i] + 1;
            System.out.print(re_index[i]);
        }
        int target = 9;
        String method_target = new String("23");
        method_target = method_target.concat("675");
        System.out.println();
        System.out.println(Integer.valueOf(method_target).intValue());
        // System.out.println(Integer.valueOf(method_target).intValue());
        int n = re_index.length; // 物品的总数
        int[] dp = new int[target + 1]; // 目标要求
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums_del_0[i] >= 0) { // 目标比当前的硬币值大时寻找匹配
                    dp[j] = dp[j] + dp[j - nums_del_0[i]];
                }
            }
        }
        // 分别输出的为0-target的解法，采用的是递归的方式
        // 首先判断是否当前值是否大于预期值，大于则不使用
        // 小于则从用目标值减去此数值，并向前回溯查看target-nums_del_0[i]
        // 的解决有几种办法，然后将当前数值的解决办法加上
        // target-nums_del_0[i]解决办法即可
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
        }
    }
}
