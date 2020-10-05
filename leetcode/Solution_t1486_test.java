public class Solution_t1486_test {
    public static void main(String[] args) {
        int n = 1;
        int start = 7;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^=  nums[i];
        }
        System.out.println(ans);
    }
}
