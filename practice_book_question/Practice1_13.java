public class Practice1_13 {
    public static void main(String[] args) {
        double x, y;
        double a = 3.4, b = 50.2, e = 44.5, c = 2.1, d = 0.55, f = 5.9;
        x = (e * d - b * f) / (a * d - b * c);
        y = (a * f - e * c) / (a * d - b * c);
        System.out.println("x= " + x);
        System.out.println("y= " + y);
    }
}
// 1.13 (代教：求解 2 x 2 线性方程）可以使用Cramer 规则解下面的 2 x 2 线性方程组：
// ax + by= e 一
// ed -bf tf -ec
// cx+ dy= f ad -be
// y
// ad -be
// 编写程序.求解以下方程组并显示：t 和_v 的值。
// 3.4x + 50.2>- =44.5
// 2.1x +0.55^= 5.9