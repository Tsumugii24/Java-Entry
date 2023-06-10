public class MonkeyKing {
    public static void main(String[] args) {
        int totalMonkeys = 10; // 猴子的总数
        int count = 0; // 报数计数器
        int[] monkeys = new int[totalMonkeys]; // 存储猴子的数组
        int currentIndex = 0; // 当前猴子的索引

        // 初始化猴子的序号
        for (int i = 0; i < totalMonkeys; i++) {
            monkeys[i] = i + 1;
        }

        System.out.println("猴子退出的顺序：");

        while (totalMonkeys > 1) {
            if (monkeys[currentIndex] != 0) {
                count++;

                if (count == 3) {
                    System.out.print(monkeys[currentIndex] + " ");
                    monkeys[currentIndex] = 0;
                    totalMonkeys--;
                    count = 0;
                }
            }

            currentIndex++;

            if (currentIndex == monkeys.length) {
                currentIndex = 0;
            }
        }

        // 输出剩下的大王
        for (int i = 0; i < monkeys.length; i++) {
            if (monkeys[i] != 0) {
                System.out.println("\n大王是猴子" + monkeys[i]);
                break;
            }
        }
    }
}
