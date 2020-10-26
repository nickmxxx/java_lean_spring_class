
public class Class7_Q2 {
    public static void main(String[] args){
        int i=1;
        int index = 0;
        while (index < 100){
            i += 1;
            if (pd(i)==1){
                index += 1;
                System.out.print(""+i+" ");
                if (index%10 == 0)
                    System.out.println("");
            }
        }
    }
    // 0不是 1是
    static int pd(int num){
        // 判断回文数 两位数以上再判断
        String s = ""+num;
        int l=0;
        int r=s.length()-1;
        while (l<r){
            if (s.charAt(l)==s.charAt(r)){
                l += 1;
                r -= 1;
            }
            else
                return 0;
        }
        // 判断素数
        for (int i=2; i<num-1; i++){
            if (num % i ==0)
                return 0;
        }

        return 1;
    }
}