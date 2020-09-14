public class Practice1_7 {
    public static void main(String[] args) {
        final int Times = 10;
        int flag = 1; 
        double pi_cal = 0;
        for (int i = 0; i < Times; i++) {
            pi_cal += flag * 1. / (2 * i + 1);
            flag = -flag;
    }
    System.out.println(4*pi_cal);
}
}
