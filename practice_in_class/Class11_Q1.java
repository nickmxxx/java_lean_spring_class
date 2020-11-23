import java.util.InputMismatchException;
import java.util.Scanner;

public class Class11_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            int t = 10;
            int b = t/0;
        } catch (ArithmeticException a) {
            System.out.println(a.getMessage());
        }

        try {
            String s = null;
            String s1 = s.toLowerCase();
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        }

        try {
            String number1 = input.nextLine();
            int n1 = Integer.parseInt(number1);
        } 
        catch (NumberFormatException num) {
            System.out.println(num.getMessage());
        }

        try {
            int number2 = input.nextInt();
        } 
        catch (InputMismatchException i) {
            System.out.println(i.getMessage());
        }
    }

}
