// gradeDemo gradeMaths VIP_gradeMaths KB
public class gradeDemo {

    public static void main(String[] args) {
        gradeMaths g[] = new gradeMaths[4];
        g[0] = new gradeMaths("信息一班", 3);
        g[1] = new gradeMaths("信息二班", 2);
        g[2] = new VIP_gradeMaths("信息三班", 2);
        g[3] = new VIP_gradeMaths("信息四班", 2);

        gradeMaths.outclassnum();

        String id;
        while (true) {
            System.out.println("请输入班号：");
            id = KB.scan();
            boolean classFound = false;
            for (gradeMaths grade : g) {
                if (grade.cnum.equals(id)) {
                    classFound = true;
                    grade.run();
                    break;
                }
            }
            if (!classFound) {
                System.out.println("班号不存在，请重新输入！");
            }

            System.out.println("是否还有用户? 输入N以退出系统");
            String str = KB.scan();
            if (str.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
