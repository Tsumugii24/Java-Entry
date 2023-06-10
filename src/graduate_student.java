// 定义信息管理接口Istudent
interface Istudent {
    void setFee(double fee);  // 设置学费
    double getFee();  // 获取学费
}

// 定义信息管理接口Iteacher
interface Iteacher {
    void setPay(double pay);  // 设置工资
    double getPay();  // 获取工资
}

// 研究生类Graduate实现接口Istudent和Iteacher
class Graduate implements Istudent, Iteacher {
    public String name;  // 姓名
    private String sex;  // 性别
    private int age;  // 年龄
    private double fee;  // 每学期学费
    private double pay;  // 月工资

    // 构造方法
    public Graduate(String name, String sex, int age, double fee, double pay) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.fee = fee;
        this.pay = pay;
    }

    // 实现接口Istudent中的方法
    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    // 实现接口Iteacher中的方法
    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    // 计算是否需要贷款
    public void calculateLoan() {
        double annualIncome = pay * 12;  // 年收入
        double totalFee = fee * 2;  // 总学费

        if (annualIncome - totalFee < 2000) {
            System.out.println(name + " must be provided a loan.");
        } else {
            System.out.println(name + " mustn't be provided a loan.");
        }
    }
}

public class graduate_student {
    public static void main(String[] args) {
        // 创建一个姓名为"zhangsan"的研究生对象
        Graduate zhangsan = new Graduate("zhangsan", "male", 25, 10000, 1500);

        // 输出学费和月工资
        System.out.println(zhangsan.name + " 学费：" + zhangsan.getFee() + " 月工资：" + zhangsan.getPay());

        // 统计是否需要贷款
        zhangsan.calculateLoan();

        // 重新设置学费和月工资
        System.out.println("重新设置学费和月工资");
        zhangsan.setFee(5000);
        zhangsan.setPay(1200);

        // 输出学费和月工资
        System.out.println(zhangsan.name + " 学费：" + zhangsan.getFee() + " 月工资：" + zhangsan.getPay());

        // 统计是否需要贷款
        zhangsan.calculateLoan();
    }
}
