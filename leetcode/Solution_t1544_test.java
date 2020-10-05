public class Solution_t1544_test {
    public static void main(String[] args) {
        // 整体思路是将其转变ASCII码，大小写字母ASCII码差距为32
        // 定义一个flag，来判断是否已经完全排序
        String s = "qFxXfQo";
        boolean flag = false;
        // if (s.length() == 1) {
        // // System.out.println(s);
        // }

        do {
            if (s.length() == 0 || s.length() == 1) { 
                //  此处出现的错误最多，因为此处的当s不断减少，减少到0或1的时候
                //  下面的for循环会进入死循环，所以需要在此处将s减少到0或1的情况单独处理
                System.out.println(s);
                flag = true;
            } else {
                for (int i = 0; i < s.length() - 1; i++) {

                    if (s.length() != 0 && (Math.abs((int) s.charAt(i) - (int) s.charAt(i + 1)) == 32)) {
                        // count++;
                        flag = false;
                        s = s.substring(0, i).concat(s.substring(i + 2, s.length()));
                        break;
                    }
                    // 若存在前后字符大小写则退出循环，将s进行改变,并且使计数器+1
                    // 否则不变，跳出当此循环，进行下一次循环。
                    else {
                        flag = true;
                    }
                }

            }
        } while (!flag);

        System.out.println(s);
    }
}
