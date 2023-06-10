import java.util.Arrays;
import java.util.Scanner;

public class gradeMath {
    static int classnum; // 班级个数
    int cnum; // 班号
    int snum; // 学生数
    int[] grade; // 全班成绩

    // 构造方法,初始化班号和人数
    gradeMath(int cnum, int snum) {
        classnum++; // 班级数加1
        this.cnum = cnum; // 获得班号
        this.snum = snum; // 获得班级人数
        grade = new int[snum]; // 创建成绩数组
    }

    // 输入成绩
    void inputGrades() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < snum; i++) {
            System.out.print("请输入第 " + (i + 1) + " 位学生的成绩：");
            int score = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            while (score < 0 || score > 100) {
                System.out.println("成绩输入错误，成绩范围【0，100】，请重新输入！");
                System.out.print("请输入第 " + (i + 1) + " 位学生的成绩：");
                score = scanner.nextInt();
                scanner.nextLine(); // 读取换行符
            }

            grade[i] = score;
        }
    }

    // 求最高分
    int maxGrade() {
        int max = grade[0];
        for (int i = 1; i < snum; i++) {
            if (grade[i] > max) {
                max = grade[i];
            }
        }
        return max;
    }

    // 求最低分
    int minGrade() {
        int min = grade[0];
        for (int i = 1; i < snum; i++) {
            if (grade[i] < min) {
                min = grade[i];
            }
        }
        return min;
    }

    // 求平均成绩
    float avgGrade() {
        int sum = 0;
        for (int i = 0; i < snum; i++) {
            sum += grade[i];
        }
        return (float) sum / snum;
    }

    // 查询班级人数
    int getClassSize() {
        return snum;
    }

    // 成绩排序
    void sortGrades() {
        int[] sortedGrade = Arrays.copyOf(grade, snum);
        Arrays.sort(sortedGrade);

        System.out.println("班级 " + cnum + " 学生成绩从高到低排序：");
        for (int i = snum - 1; i >= 0; i--) {
            System.out.print(sortedGrade[i] + " ");
        }
        System.out.println();
    }

    // 菜单选项
    void menu() {
        System.out.println("===== 班级" + cnum + "统计菜单选项 =====");
        System.out.println("1. 求最高分");
        System.out.println("2. 求最低分");
        System.out.println("3. 求平均成绩");
        System.out.println("4. 查询班级人数");
        System.out.println("5. 成绩由高到低排序");
        System.out.println("6. 返回");
        System.out.println("7. 退出");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入你的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    System.out.println("班级" + cnum + "的最高分：" + maxGrade());
                    break;
                case 2:
                    System.out.println("班级" + cnum + "的最低分：" + minGrade());
                    break;
                case 3:
                    System.out.println("班级" + cnum + "的平均成绩：" + avgGrade());
                    break;
                case 4:
                    System.out.println("班级" + cnum + "的班级人数：" + getClassSize());
                    break;
                case 5:
                    sortGrades();
                    break;
                case 6:
                    return;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("无效的选择");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入班级总数：");
        int totalClasses = scanner.nextInt();

        if (totalClasses < 1) {
            System.out.println("班级总数不能小于1");
            return;
        }

        gradeMath[] classes = new gradeMath[totalClasses];

        for (int i = 0; i < totalClasses; i++) {
            System.out.print("\n请输入班级 " + (i + 1) + " 的学生数：");
            int students = scanner.nextInt();

            if (students < 1) {
                System.out.println("学生数不能小于1");
                return;
            }

            classes[i] = new gradeMath(i + 1, students);
            classes[i].inputGrades();
        }

        while (true) {
            System.out.print("\n选择要统计的班级：");
            int selectedClass = scanner.nextInt();

            if (selectedClass < 1 || selectedClass > totalClasses) {
                System.out.println("无效的班级选择");
                continue;
            }

            classes[selectedClass - 1].menu();
        }
    }
}
