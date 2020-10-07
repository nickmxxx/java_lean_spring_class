public class Solution_t1406_test {
    public static void main(String[] args) {
        int[] stoneValue = {-1,-2,-3};
        int n = stoneValue.length;
        int[] state = new int[n+1];
        //  从后向前进行博弈，从第 n堆开始从后向前，只关心前三个的情况
        //  转移的时候，可以取第i,i+1;i+2堆
        state[n] = 0;
        for(int i = n-1;i>=0;i--){
            state[i] = stoneValue[i]-state[i+1];
        //  至少也要取一个，取一个之后与取两个、三个的作比较
            if(i<n-1){
                state[i] = Math.max(state[i],stoneValue[i]+stoneValue[i+1]-state[i+2]);
            }
            if(i<n-2){
                state[i] = Math.max(state[i],stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-state[i+3]);
            }
        }
        if(state[0] == 0){
            System.out.println("Tie");
        }
        else if(state[0]>0){
            System.out.println("Alice");
        }
        else{
            System.out.println("Bob");
        }
    }
}
