import java.util.Scanner;

public class Class2_Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: (e.g., 2012): ");
        int year = scanner.nextInt();
        System.out.print("Enter month: 1-12: ");
        int month = scanner.nextInt();
        System.out.print("Enter the day of the month: 1-31: ");
        if(month>13||month<0){           //判断是否为异常月份
                System.out.println("请输入正常月份");
				System.exit(1);
        }
        int day = scanner.nextInt();

        int[]big_month = {1,3,5,7,8,10,12};
        int[]small_momth = {4,6,9,11};
        for(int i = 0; i < big_month.length; i++)
        {
            if(month == big_month[i]){
                if(day>31||day<=0){
                    System.out.println("请输入正常天数");
                    System.exit(2);
                }
            }
        }
        for(int i = 0; i<small_momth.length; i++){
            if(month == small_momth[i]){
                if(day>30||day<=0){
                    System.out.println("请输入正常天数");
                    System.exit(2);
                }
            }
        }
        if((year%4 == 0&&year%100 != 0)||year%400 == 0){
         //年份能够被4整除且不能被100整除或者能被400整除是闰年
            if(month==2&&(day>=30||day<=0)){
                System.out.println("请输入正常天数");
                System.exit(2);
            }
        }
        else{
            if(month==2&&(day>=29||day<=0)){
                System.out.println("请输入正常天数");
                System.exit(2);
            }
        }
        int m;
        if(month == 1|| month==2){
            m = month+12;
            year = year-1;
        }
        else{
            m = month;
        }
        int k = year%100;
        int j = Math.abs(year/100);
        int q = day;
        int h = (q + (26*(m + 1))/10 + k/4 + k + j/4 + 5*j )%7;
        String[] weekday = new String[7];
        weekday[0] = "Saturday";
        weekday[1] = "Sunday";
        weekday[2] = "Monday";
        weekday[3] = "Tuesday";
        weekday[4] = "Wednesday";
        weekday[5] = "Thursday";
        weekday[6] = "Friday";
        System.out.print("Day of the week is " + weekday[h]);
    }
}
