import java.util.Calendar;

class MyDate {
    private int year;
    private int month;
    private int day;
    public Calendar now = Calendar.getInstance();

    public MyDate() {
        this.year = now.get(Calendar.YEAR);
        this.month = now.get(Calendar.MONTH);
        this.day = now.get(Calendar.DAY_OF_MONTH);
        // System.out.println(this.year + " " + this.month + " " + this.day);
    }

    public MyDate(long timesince1970) {
        setDate(timesince1970);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    };

    public void setDate(long timesince1970) {
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        now.setTimeInMillis(timesince1970);
        // System.out.println(dateFormat.format(now.getTime()));
    }

}

public class Class9_Q1 {
    public static void main(String[] args) {
        MyDate mydate = new MyDate();
        System.out.println(mydate.now.getTime());
        long timesince1970 = System.currentTimeMillis();
        System.out.println("从1970年至今流逝的毫秒数" + timesince1970);
        MyDate mydate2 = new MyDate(timesince1970);
        System.out.println(mydate.now.getTime());
        long time1 = 2147483648000L;
        MyDate mydate3 = new MyDate(time1);
        System.out.println(mydate3.now.getTime());
        long time2 = 561555550000L;
        MyDate mydate4 = new MyDate(time2);
        System.out.println(mydate4.now.getTime());
    }

}
