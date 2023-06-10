public class NumberPyramid {
    public static void main(String[] args) {
        int rows = 5; // 金字塔的行数

        for (int i = 0; i < rows; i++) {
            // 打印每一行前的空格
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print("  ");
            }

            // 打印左半部分数字
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num += 2;
            }

            // 打印右半部分数字
            num -= 4;
            for (int j = 0; j < i; j++) {
                System.out.print(num + " ");
                num -= 2;
            }

            System.out.println(); // 换行
        }
    }
}
