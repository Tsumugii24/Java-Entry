import java.util.Random;
import java.util.Scanner;

// 定义谜语游戏接口
interface PuzzleGame {
    void guess();
    void playAgain();
}

public class Game implements PuzzleGame {
    private String[] puzzles = {
            "远看山有色，近听水无声。",
            "五座山。"
            // 添加更多的谜语...
    };

    private String[] answers = {
            "画",
            "手"
            // 添加更多的谜底...
    };

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private boolean continuePlaying = true;

    public void guess() {
        int index = random.nextInt(puzzles.length); // 随机选取一个谜面
        String puzzle = puzzles[index];
        String answer = answers[index];

        int attempt = 1;
        while (attempt <= 3) {
            System.out.println("谜面：" + puzzle + " 请输入谜底。");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase(answer)) {
                System.out.println("猜谜成功！祝贺你");
                break;
            } else {
                System.out.println("猜谜错误，请重新输入谜底！");
                attempt++;
            }
        }

        System.out.println("谜面：" + puzzle + " 谜底：" + answer);
    }

    public void playAgain() {
        System.out.println("是否继续玩，N:退出系统");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("N")) {
            continuePlaying = false;
            System.out.println("游戏结束！");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        while (game.continuePlaying) {
            game.guess();
            game.playAgain();
        }
    }
}

