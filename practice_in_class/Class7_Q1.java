import java.util.Random;
import java.util.Scanner;

public class Class7_Q1 {
    public static void main(String[] args) {
        boolean flag_continue = true;
        Scanner scanner = new Scanner(System.in);
        do {
            String[] words = { "banana", "telecommunication", "programming", "bupt" };
            // 随机选出一个词
            Random r = new Random();
            int word_pick = r.nextInt(3);
            System.out.println("选取的单词为：" + words[word_pick]);
            StringBuffer word_ans = new StringBuffer(words[word_pick]);
            int word_len = word_ans.length();
            int[] word_matched = new int[word_len];
            StringBuffer word_guess = new StringBuffer("");
            for (int i = 0; i < word_len; i++) {
                word_guess = word_guess.append("*");
            }
            boolean flag_true = false;
            int count_error = 0;

            do {
                int true_count = 0;
                System.out.println("");
                System.out.println("" + word_guess);
                System.out.println("(Guess) Enter a letter in word " + word_guess);
                String a = scanner.nextLine();
                System.out.println(a);
                char input = a.charAt(0);
                boolean intheword = false;
                boolean isrepeated = false;
                for (int i = 0; i < word_len; i++) {
                    if (input == word_ans.charAt(i) && word_matched[i] == 0) {
                        word_matched[i] = 1;
                        word_guess.setCharAt(i, input);
                    }
                    if (input == word_ans.charAt(i)) {
                        intheword = true;
                    }
                }
                if (!intheword) {
                    count_error++;
                    System.out.println(input + " is not in the word");
                }
                for (int i = 0; i < word_len; i++) {
                    if (word_matched[i] == 1) {
                        true_count++;
                    }
                }
                if (true_count == word_len) {
                    flag_true = true;
                    System.out.println("The word is " + word_ans + " You missed " + count_error + " time");
                }
            } while (!flag_true);
            System.out.println("Do you want to guess another word? Enter y or n");
            String s = scanner.nextLine();
            if(s.charAt(0)=='y')
            {
                flag_continue = true;
            }
            if(s.charAt(0)=='n'){
                flag_continue = false;
            }
        } while (flag_continue == true);
    }
}
