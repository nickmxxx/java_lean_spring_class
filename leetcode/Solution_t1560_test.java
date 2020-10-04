public class Solution_t1560_test {
    public static void main(String[] args) {
        int n = 4;
        int[] rounds = { 1, 3, 1, 2 };
        for (int i = 1; i < rounds.length - 1; i++) {
            if (rounds[i - 1] > rounds[i]) {
                rounds[i] = rounds[i] + n;
            }
        }
        for (int i = 0; i < rounds.length; i++) {
           System.out.print(rounds[i]);
        }
        int[] count = new int[n];
        // 将rounds拆分，从1~2，2~3，... n-1~n 没出现一次则加1
        // 共有n-1个间隔 特别注意的是rounds[i]<round[i-1]的情况
        // 此时取模即可 即将问题转化为n进制
        // for (int i = 0; i < n; i++) {
        //     for (int j = rounds[i] + 1; j <= rounds[i + 1]; j++) {
        //         count[(rounds[i] - 1) % n]++;
        //     }
        // }

    }
}
