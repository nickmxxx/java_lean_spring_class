import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_t1560_test {
    public static void main(String[] args) {
        // 将rounds拆分，从1~2，2~3，... n-1~n 没出现一次则加1
        // 共有n-1个间隔 特别注意的是rounds[i]<round[i-1]的情况
        // 此时取模即可 即将问题转化为n进制
        int n = 7;
        int[] rounds = {1,3,5,7};
        int[] rounds_copy = (int[]) Arrays.copyOf(rounds, rounds.length);
        // 此处为将原始数据进行处理，如果前一个大于后一个数字，则将其加n之后取模操作即可
        for (int i = 1; i < rounds.length; i++) {
            if (rounds_copy[i - 1] > rounds_copy[i]) {
                 for(int j=i;j<rounds.length;j++){
                    rounds[j] = rounds[j]+n;
                }
            }
        }

        for (int i = 0; i < rounds.length; i++) {
            System.out.print(rounds[i]);
        }
        int[] count = new int[n];
        // 边界处理进行初始化，将第一个刚开始进行计数
        count[(rounds[0] - 1)]++;
        for (int i = 0; i < rounds.length - 1; i++) {
            for (int j = rounds[i] + 1; j <= rounds[i + 1]; j++) {
                count[(j - 1) % n]++;
            }
        }
        System.out.println("");
        List<Integer> ans = new ArrayList<>();
        int[] index_num = max_index(count);
        // int[] req = new int[index_num[index_num.length-1]];
        // int req_num = 0;
        for(int i=0;i<index_num.length-1;i++){
            if(index_num[i]==1){
                // req[req_num] = i+1;
                ans.add(i+1);
                // req_num++;
            }
        }
        System.out.println("");
        System.out.println(ans);

   }

    private static int[] max_index(int[] a) {
        int[] index_find = new int[a.length+1];
        int max = a[0];
        for(int i =1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }     
        }
        System.out.println(max);
        for(int i=0;i<a.length;i++){
            if(a[i]==max){
                index_find[i] = 1;
                index_find[a.length]++; //将最大值的个数保存在最后一个数组值中
            }
        }
        for(int i = 0;i<index_find.length;i++){
            System.out.print(index_find[i]);
        }
        return index_find;
    }
}
