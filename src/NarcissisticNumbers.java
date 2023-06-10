public class NarcissisticNumbers {
    public static void main(String[] args) {
        int count = 0; // 计数器，记录已输出的水仙花数个数

        for (int i = 100; i < 1000; i++) {
            int digit1 = i / 100; // 百位数
            int digit2 = (i / 10) % 10; // 十位数
            int digit3 = i % 10; // 个位数

            int sumOfCubes = digit1 * digit1 * digit1 + digit2 * digit2 * digit2 + digit3 * digit3 * digit3;

            if (sumOfCubes == i) {
                System.out.print(i + " ");
                count++;

                if (count % 2 == 0) {
                    System.out.println(); // 输出两个水仙花数后换行
                }
            }
        }
    }
}
