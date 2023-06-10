import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入年份和月份（例如：2020/6）：");
        String input = scanner.nextLine();

        // 解析输入的年份和月份
        String[] tokens = input.split("/");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);

        // 创建Calendar对象
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // 设置为指定年份和月份的第一天

        // 输出日历标题
        System.out.println(year + "年" + month + "月日历");
        System.out.println("日  一  二 三 四  五 六");

        // 输出日期
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 获取指定日期的星期几
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取指定月份的最大天数

        // 输出第一行之前的空格
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   ");
        }

        // 输出日期
        for (int day = 1; day <= maxDayOfMonth; day++) {
            if (day < 10) {
                System.out.print(" ");
            }
            System.out.print(day);

            // 判断是否为星期六，是则换行
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            } else {
                System.out.print(" ");
            }

            // 日期加1
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
