import java.util.Scanner;

public class VIP_gradeMaths extends gradeMaths {
    int maxk;
    int mink;
    String sno[];

    public VIP_gradeMaths(String clanum, int snum) {
        super(clanum, snum);
        sno = new String[snum];
    }

    void inputs() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < snum; i++) {
            System.out.println("请输入" + (i + 1) + "号学生学号：");
            String id = s.nextLine();
            if (checkDuplicateID(id)) {
                System.out.println("此学号已存在，请重新输入新学号！");
                i--;
            } else {
                sno[i] = id;
            }
        }
    }

    boolean checkDuplicateID(String id) {
        for (String studentID : sno) {
            if (studentID != null && studentID.equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    void maxgrade() {
        super.maxgrade();
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == maxg) {
                maxk = i + 1;
                break;
            }
        }
    }

    @Override
    void mingrade() {
        super.mingrade();
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == ming) {
                mink = i + 1;
                break;
            }
        }
    }

    @Override
    void search() {
        System.out.println("班级" + cnum + "共有" + snum + "位学生");
        System.out.println("最高分：" + maxk + "号学生成绩为" + maxg);
        System.out.println("最低分：" + mink + "号学生成绩为" + ming);
        System.out.println("平均分:" + avggra);
    }

    void run() {
        inputs();
        super.run();
    }
}
