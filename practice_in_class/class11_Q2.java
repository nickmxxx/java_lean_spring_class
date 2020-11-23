import java.util.ArrayList;
import java.util.Random;

class student {
    private int Score;

    public student() {
        Random rand = new Random();
        this.Score = rand.nextInt(150);
    }

    public int getScore() {
        return this.Score;
    }

}

    class ScoreExceedsMaxValueException extends Exception { // 自定义的类
        ScoreExceedsMaxValueException() {
            super();
        }

        ScoreExceedsMaxValueException(String s) {
            super(s);
        }
    }

public class class11_Q2 {
    public static boolean isScoreValid(student s1) throws ScoreExceedsMaxValueException {
        if (s1.getScore() > 100) {
            throw new ScoreExceedsMaxValueException("分数超过100分，出现异常");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        student test[] = new student[15000];
        for (int i = 0; i < 15000; i++) {
            test[i] = new student();
        }

        double avg_right=0;
        double avg_wrong=0;
        double avg=0;
        int count1=0;
        int count2=0;
        for (int i = 0; i < 15000; i++) {
            try {
                if (isScoreValid(test[i])) {
                    avg_right+=test[i].getScore();
                    avg+=test[i].getScore();
                    count1++;
                }              
            }
            catch(ScoreExceedsMaxValueException e){
                avg_wrong+=test[i].getScore();
                avg+=test[i].getScore();
                count2++;
                System.out.println(e.getMessage());
            }
        }
        System.out.println("正常分数人数: "+count1+" 正常分数平均分: "+ avg_right/count1);
        System.out.println("异常分数人数: "+count2+" 异常分数平均分: "+ avg_wrong/count2);
        System.out.println("平均分: "+ avg/(count1+count2));
    }

}
