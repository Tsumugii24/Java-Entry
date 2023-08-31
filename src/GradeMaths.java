import java.util.Scanner;

public class GradeMaths {
    int snum;
    static int classnum;
    String cnum;
    int grade[];
    int maxg;
    int ming;
    float avggra;

    GradeMaths(String clanum, int snum) {
        classnum++;
        cnum = clanum;
        this.snum = snum;
    }

    static void outclassnum() {
        System.out.println("学院共有" + classnum + "个班级，成绩情况如下：");
    }

    void inputg() {
        grade = new int[snum];
        Scanner s = new Scanner(System.in);
        System.out.println("请输入班级" + cnum + "的成绩：");
        int i;
        for (i = 0; i < snum; i++) {
            System.out.println("请输入" + (i + 1) + "号学生成绩：");
            grade[i] = s.nextInt();
        }
    }

    void maxgrade() {
        maxg = grade[0];
        for (int i = 1; i < grade.length; i++) {
            if (grade[i] > maxg) {
                maxg = grade[i];
            }
        }
    }

    void mingrade() {
        ming = grade[0];
        for (int i = 1; i < grade.length; i++) {
            if (grade[i] < ming) {
                ming = grade[i];
            }
        }
    }

    void avggrade() {
        float sum = 0;
        for (int i = 0; i < grade.length; i++) {
            sum = sum + grade[i];
        }
        avggra = sum / grade.length;
    }

    void search() {
        System.out.println("班级" + cnum + "共有" + snum + "位学生");
        System.out.println("其中" + "最高分:" + maxg + ", 最低分:" + ming + ", 平均分:" + avggra);
    }

    void run() {
        inputg();
        maxgrade();
        mingrade();
        avggrade();
        search();
    }
}
