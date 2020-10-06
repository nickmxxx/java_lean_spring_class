public class Solution_t1493_test {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
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
        System.out.println(ans);
    }
}