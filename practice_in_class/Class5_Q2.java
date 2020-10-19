import java.util.Scanner;

public class Class5_Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数：");
        int line = scanner.nextInt();
        long[] num = new long[line];
        for (int i = 0; i < line; i++) {
            num[i] = (long) Math.pow(2, i);
            // System.out.printf("%-4f", num[i]);
        }
        for (int i = 0; i < line; i++) {
            for(int j = 0; j<line-i;j++){
                System.out.printf("%-10s", " ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-20d", num[j]);
            }
            for (int j = 0; j < i; j++) {
                System.out.printf("%-20d", num[i-j-1]);
            }
            System.out.println("");
        }
    }
}
