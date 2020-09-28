import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution_t1449_test {
    public static void main(String[] args) {
        Solution_t1449_test solution_t1449 = new Solution_t1449_test();
        int a[] = { 4, 3, 2, 5, 6, 7, 2, 5, 5 };
        int target = 9;
        solution_t1449.solution(a, target);
    }

    public String solution(int[] nums,int target){
        //  因为当出现从重复数字的时候肯定取后面的数字来提高组成的数字大小
        // 首先去除重复数字，以提高效率,定义两个数组,一个记录筛选数字之前的原始的下标,一个保留筛选后的数组

        int[] re_index_nums = delete_repeat(nums);
        int[] new_nums = new int[re_index_nums.length];
        for(int i=0;i<new_nums.length;i++){
            new_nums[i] = nums[re_index_nums[i]];
        }
 
        for(int i=0;i<new_nums.length;i++){
            System.out.print(new_nums[i]);
        }
        System.out.println();
        for(int i=0;i<re_index_nums.length;i++){
            re_index_nums[i] = re_index_nums[i]+1;
        }
        for(int i=0; i<re_index_nums.length;i++){
            System.out.print(re_index_nums[i]);
        }
        String s = null;

        return s;
    }

    public int[] delete_repeat(int[] nums){
        if(nums.length == 0){
            System.out.println("空数组: ");
        }
        int[] nums_del_repeat = new int[nums.length];
        Set<Integer> set = new HashSet<Integer>();
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(set.add(nums[i])){
                nums_del_repeat[index++] = nums[i];
            }
        }    
    System.out.print("删除重复元素数组后: ");
    for(int i=0; i<nums.length;i++){
        System.out.print(nums_del_repeat[i]);
    }

    int count = 0; //  记录0的个数
    System.out.println();

    for(int i=0; i<nums.length;i++){
        if(nums_del_repeat[i]==0){
            count++;
        }
    }

    System.out.println("0的个数为: " + count);
    int[] nums_del_0 = new int[nums.length-count];
    //  删除0元素
    for(int i=0; i<nums_del_0.length; i++){
        nums_del_0[i] = nums_del_repeat[i];
    }

    System.out.print("删除重复数据后: ");

    for(int i=0; i<nums_del_0.length; i++){
        System.out.print(nums_del_0[i]);
    }
    //  寻找数组中的元素的下标
    // for(int i=0; i<nums_del_0.length; i++){
    //     re_index[i] = Arrays.binarySearch(nums_copy, nums_del_0[i]);
    // }
    System.out.println();
    int re_index[] = new int[nums_del_0.length];
    for(int j=0; j<nums_del_0.length;j++){
        for(int i = 0; i<nums.length;i++){
                if(nums[i]==nums_del_0[j]){
                    re_index[j]=i;
                }
            }
        
    }
    
    for(int i=0;i<re_index.length;i++){
        System.out.print(re_index[i]);
    }
    System.out.println();
    return re_index;
    }
}
