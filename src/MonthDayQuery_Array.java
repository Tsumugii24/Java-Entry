import java.util.Scanner;

public class MonthDayQuery_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;

        do {
            System.out.print("请输入年份：");
            year = scanner.nextInt();
        } while (year <= 0);

        do {
            System.out.print("请输入月份：");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = daysInMonth[month - 1];

        if (month == 2 && isLeapYear(year)) {
            days = 29;
        }

        System.out.println(year + "年的" + month + "月有" + days + "天");
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

