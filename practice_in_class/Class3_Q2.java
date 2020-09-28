import java.util.Scanner;

public class Class3_Q2 {
    public static void main(String[] args) {
        int a;
        // int test = 6618;
        int[] ans = new int[4];
        // 产生个十百千位，并赋值给数组ans[]
        int flag = 0;
        //  产生无重复数字的随机数
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
    
        System.out.println(" ");
        // 判断是否完全匹配
        int count = 0; // 记录用的回合数
        int count_all_correct = 0;
        int count_num_correct = 0;
        do {
            count_all_correct = 0;
            count_num_correct = 0;
            count++;
            int[] matched = new int[4]; // match数组来判断是否已经匹配
            int[] guess = new int[4];
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你猜的数字：");
            int input = scanner.nextInt();
            if(input>10000||input<0){
                System.out.println("请输入一个四位数");
                System.exit(1);
            }
            // 进行猜测数字的分解，并查看是否有精确匹配（位置与数字）
            for (int i = 0; i < 4; i++) {
                guess[i] = (int) ((input / (Math.pow(10, 3 - i))) % 10);
                // System.out.print(guess[i] + " ");
                if (guess[i] == ans[i]) {
                    count_all_correct++;
                }
            }

            // System.out.println(" ");
            // System.out.println("精确匹配的个数为： " + count_all_correct);
            // 进行猜对的数字匹配
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((guess[i] == ans[j] && (matched[j] == 0))) { // 如果判断正确且该数字未匹配的话
                        count_num_correct++;
                        matched[j] = 1;
                        break;
                    }
                }
            }
            // System.out.println("猜对的数字为： " + count_num_correct);
            if(count_all_correct!=4){
                System.out.println(count + ": " + count_all_correct + "A" + count_num_correct + "B");
            }
        } while (count_all_correct != 4);
        System.out.println("你很厉害啊！");
    }
}
