
public class Algorithm {
    public static void main(String[] args) {
        // 打印1000以内各位数字之和能被3整除的自然数，结果每行输出10个数
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            int sum = 0;
            int n = i;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum % 5 == 0) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

}
