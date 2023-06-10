import java.util.Scanner;

public class MonthDayQuery_Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;

        do {
            System.out.print("请输入查询年份：");
            year = scanner.nextInt();
        } while (year <= 0);

        do {
            System.out.print("请输入查询月份：");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        int days = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }

        System.out.println(year + "年的" + month + "月有" + days + "天");
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

