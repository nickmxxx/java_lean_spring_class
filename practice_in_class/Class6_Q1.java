import java.util.Scanner;

public class Class6_Q1 {
    public static void main(String[] args) {
        boolean flag = true;
        boolean flag_prematched = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer：");
        long card_number = scanner.nextLong();
        System.out.println("银行卡号的长度为：" + card_number);
        // 调用判断位数的函数,判断位数是否匹配
        getSize(card_number);
        if (getSize(card_number) < 13 || getSize(card_number) > 16) {
            flag = false;
        }
        if (!flag) {
            System.out.println("银行卡号位数错误");
            System.exit(0);
        }
        // 进行银行卡的前缀匹配
        if (!prefixMatched(card_number, 1)) {
            flag = false;
        } else {
            System.out.println("银行卡前缀正确");
        }

        if (!flag) {
            System.out.println("银行卡前缀错误");
            System.exit(1);
        }
        // sumOfDoubleEvenPlace(card_number);
        // sumOfOddPlace(card_number);
        if (!isValid(card_number)) {
            flag = false;
        }
        if (!flag) {
            System.out.println("奇偶位错误");
            System.exit(2);
        }
    }

    // Return true if the card number is valid
    // 判断是否为正确卡号
    public static boolean isValid(long number) {
        System.out.println("偶数位和：" + sumOfDoubleEvenPlace(number));
        System.out.println("奇数位和：" + sumOfOddPlace(number));
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // get the result from step 2
    // 从左到右隔位乘二得到偶数和
    public static int sumOfDoubleEvenPlace(long number) {
        long size = getSize(number);
        String str = String.valueOf(Math.abs(number));
        int sum_double = 0;
        int[] a = new int[(int) (size / 2)];
        for (int i = 0; i < size / 2; i++) {
            a[i] = 2 * (Integer.valueOf(str.charAt(2 * i + 1)).intValue() - 48);
            System.out.print(a[i] + " ");
            a[i] = getDigit(a[i]);
            System.out.print(a[i] + " ");
            sum_double = sum_double + a[i];
        }
        return sum_double;
    }

    // return this number if it is single digit
    // otherwise,return the sum of the two digitals
    // 用来判断加倍后是否为两位数，是则返回和，否则返回原数
    public static int getDigit(int a) {
        if (a >= 10) {
            a = a % 10 + a / 10;
        }
        return a;
    }

    // return sum of odd-place digits in number
    // 返回从左到右奇数位和
    public static int sumOfOddPlace(long number) {
        long size = getSize(number);
        String str = String.valueOf(Math.abs(number));
        int[] a = new int[(int) (size / 2)];
        System.out.println(" ");
        int sum_odd = 0;
        for (int i = 0; i < size / 2; i++) {
            a[i] = 2 * (Integer.valueOf(str.charAt(2 * i)).intValue() - 48);
            System.out.print(a[i] + " ");
            a[i] = getDigit(a[i]);
            System.out.print(a[i] + " ");
            sum_odd = sum_odd+a[i];
        }
        return sum_odd;
    }

    // return true if the digit d is a prefix for number
    // 判断前缀是否匹配，即是否为4，5，6，37
    public static boolean prefixMatched(long number, int d) {
        long prefix_num1 = longPrefix(number, d);
        boolean flag_prematched = false;
        if (prefix_num1 == 4 || prefix_num1 == 5 || prefix_num1 == 6) {
            flag_prematched = true;
        } else if (prefix_num1 == 3) {
            if (longPrefix(number, 2) == 37) {
                flag_prematched = true;
            }
        } else {
            flag_prematched = false;
        }
        return flag_prematched;
    }

    // Return the number of digitals in d
    // 返回数字的位数，应该是13-16位
    public static int getSize(long d) {
        String str = String.valueOf(Math.abs(d));
        // System.out.println("银行卡号的长度为："+str.length());
        return str.length();
    }

    // return the first k number of digits from number. if the number of digits
    // in number is less than k,return number.
    // 获取该号码的前k位，获取前缀
    public static long longPrefix(long number, int k) {
        String str = String.valueOf(Math.abs(number));
        String prefix_str = "";
        for (int i = 0; i < k; i++) {
            prefix_str = prefix_str.concat("" + str.charAt(i));
        }
        long prefix_num = Integer.valueOf(prefix_str).intValue();
        System.out.println("前" + k + "位为：" + prefix_num);
        return prefix_num;
    }
}
