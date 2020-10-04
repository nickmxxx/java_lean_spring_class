public class Solution_t1582_test {
    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        int[] flag_row = new int[mat.length];   // mat.length为行数，flag_row记录矩阵每一行0的数目
        int[] flag_col = new int[mat[0].length];// mat[0].length为列数,flag_col记录矩阵每一列0的数目
        int special_num = 0;                    //记录特殊数的个数
        for (int i = 0; i < mat.length; i++) { // 以行为基准，统计每一行的1的个数
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    flag_row[i]++;
                }
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1) {
                    flag_col[i]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && flag_row[i] == 1 && flag_col[j] == 1) {
                    special_num++;
                }
            }
        }
        System.out.println("特殊数的个数为 " + special_num);
    }
}
