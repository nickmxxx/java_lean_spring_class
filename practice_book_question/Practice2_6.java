import java.util.Scanner;

public class Practice2_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println(input);
        int sum = 0;
        while(input!=0){
            sum+=input%10;
            input = input/10;  
        }
        System.out.println(sum);
    }
}
// 编写程序，读取一个在 0 和 1000 之间的整数，并将该整数的各位数字
// 相加。例如：整数是 932 , 各位数字之和为 14。
// 提示：利用操作符 X 分解数字，然后使用操作符 / 去掉分解出来的數字。例如：932X10
// — 2 ,
// 932/10=930 下面是一个运行示例：
// Enter a number between 0 and 1000: 999
// The sum of the digits is 27