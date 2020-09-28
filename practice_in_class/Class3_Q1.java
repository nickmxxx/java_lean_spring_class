import java.util.Scanner;

public class Class3_Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字： ");
        int input = scanner.nextInt();
        for (int i = 1; i <= input; i++) {
            for (int space = 1; space <= 2*(input - i); space++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" " + (Math.abs(i-j)+1));
                // System.out.println(" ");
            }
            System.out.println("");
        }
    }
}
