public class Solution_t1539_test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        int count = 0;
        int i = 1;
        int j = 0;
        do{
            if(i<=arr[arr.length-1] && i == arr[j]){
                j++;  //    j表示数组中已存在的个数
            }
            else{
                count++;    // count表示数组中没有的数字个数
            }
            i++;
        }while(count != k);
        System.out.println(i-1);
    }
}
