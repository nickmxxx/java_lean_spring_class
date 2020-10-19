import java.util.Scanner;

public class Class5_Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer： ");
        int input = scanner.nextInt();
        int[] ISBN = new int[9];
        // System.out.println("");
        System.out.print("The ISBN-10 number is ");
        for (int i = 0; i < 9; i++) {
            ISBN[i] = (int) ((input / (Math.pow(10, 8 - i))) % 10);
            System.out.print(ISBN[i]);
        }
        int last_number = last_ISBN(ISBN);
        if(last_number==10){
            System.out.println("X");
        }
        else{
            System.out.print(last_number);
        }
    }

    private static int last_ISBN(int a[]) {
        int judge = 0;
        for (int i = 1; i <= a.length; i++) {
            judge += i*a[i-1]; 
        }
        judge = judge%11;
        // System.out.println(" ");
        // System.out.println(judge);
        return judge;
    }
}
