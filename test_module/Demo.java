public class Demo {
    public static void main(String[] args) {
        int a;
        // int test = 6618;
        int[] ans = new int[4];
        // 产生个十百千位，并赋值给数组ans[]
        int flag = 0;
        do{
            int count_repeat = 0;
            a = (int) (Math.random() * 10001);
            System.out.println(a);
            for (int i = 0; i < 4; i++) {
                ans[i] = (int) ((a / (Math.pow(10, 3 - i))) % 10);
            // System.out.print(ans[i] + " ");
            }
            for(int i=0; i<3;i++){
                for(int j=i+1; j<4; j++){
                    if(ans[i]==ans[j]){
                        count_repeat++;
                    }
                }
            }
            if(count_repeat==0){    //无重复数字
                flag = 1;
            }
        }while(flag==0);
        System.out.println(a);
        for(int i=0; i<4; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
