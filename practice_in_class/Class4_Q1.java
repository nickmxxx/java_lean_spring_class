import java.util.Scanner;

public class Class4_Q1 {
    public static void main(String[] args) {
        System.out.println("请输入是否生成允许重复数字 0为有重复数字，1为无重复数字");
        Scanner scanner = new Scanner(System.in);
        String num_mode;
        // 模式输入的合法性检测
        do {
            num_mode = scanner.nextLine();
            mode_input_test(num_mode);
            System.out.println("输入生成数字的模式： " + num_mode);
        } while (!mode_input_test(num_mode));

        String ans;

        if (num_mode.charAt(0) == '0') {
            ans = gen_repeated_num();
        } else {
            ans = gen_unrepeated_num();
        }
        System.out.print("生成的数字为：");
        System.out.println(ans);
        guess_judge(ans);
    }

    private static boolean guess_input_test(String s) {
        int count_wrong = 0;
        if ((s.length() == 4)) {
            count_wrong = count_wrong;
        } else {
            count_wrong++;
        }
        for (int i = 0; i < 4; i++) {
            if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
                count_wrong = count_wrong;
            } else {
                count_wrong++;
            }
        }
        if (count_wrong == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void guess_judge(String ans) {
        int count_all_correct = 0;
        int count_num_correct = 0;
        System.out.print("请输入你猜的数字：");
        System.out.println("");
        do {
            count_all_correct = 0;
            count_num_correct = 0;
            int[] matched = new int[4]; // match数组来判断是否已经匹配
            Scanner scanner = new Scanner(System.in);
            String input;
            do {
                System.out.println("请输入一个四位数字！");
                input = scanner.nextLine();
                // System.out.println(input);
            } while (!guess_input_test(input));

            // 进行猜测数字的分解，并查看是否有精确匹配（位置与数字）
            for (int i = 0; i < 4; i++) {
                // guess[i] = (int) ((input / (Math.pow(10, 3 - i))) % 10);
                // System.out.print(guess[i] + " ");
                if (input.charAt(i) == ans.charAt(i)) {
                    count_all_correct++;
                }
            }

            // System.out.println(" ");
            // System.out.println("精确匹配的个数为： " + count_all_correct);
            // 进行猜对的数字匹配
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (((input.charAt(i) == ans.charAt(j)) && (matched[j] == 0))) { // 如果判断正确且该数字未匹配的话
                        count_num_correct++;
                        matched[j] = 1;
                        break;
                    }
                }
            }
            // System.out.println("猜对的数字为： " + count_num_correct);
            if (count_all_correct != 4) {
                System.out.println(count_all_correct + "A" + (count_num_correct - count_all_correct) + "B");
            }
        } while (count_all_correct != 4);
        System.out.println("你很厉害啊！");
    }

    private static boolean mode_input_test(String s) {
        // 输入模式的合法性检测
        int len = s.length();
        char c = s.charAt(0);
        if (len == 1 && (c == '0' || c == '1')) {
            return true;
        } else {
            System.out.println("请输入0或1");
            return false;
        }

    }

    private static String gen_repeated_num() {
        int a;
        int[] ans = new int[4];
        a = (int) (Math.random() * 10001);
        String s = ""+a;
        // System.out.println(a);
        for (int i = 0; i < 4; i++) {
            ans[i] = (int) ((a / (Math.pow(10, 3 - i))) % 10);
            // System.out.print(ans[i] + " ");
        }
        // for (int i = 0; i < 4; i++) {
        //     System.out.print(ans[i] + " ");
        // }
        return s;

    }

    private static String gen_unrepeated_num() {
        int a;
        // int test = 6618;
        int[] ans = new int[4];
        // 产生个十百千位，并赋值给数组ans[]
        int flag = 0;
        // 产生无重复数字的随机数
        String s;
        do {
            int count_repeat = 0;
            a = (int) (Math.random() * 10001);
            System.out.println(a);
            s = "" + a;
            for (int i = 0; i < 4; i++) {
                ans[i] = (int) ((a / (Math.pow(10, 3 - i))) % 10);
                // System.out.print(ans[i] + " ");
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (ans[i] == ans[j]) {
                        count_repeat++;
                    }
                }
            }
            if (count_repeat == 0) { // 无重复数字
                flag = 1;
            }
        } while (flag == 0);

        // System.out.println(a);
        // for (int i = 0; i < 4; i++) {
        //     System.out.print(ans[i] + " ");
        // }
        return s;
    }
}
