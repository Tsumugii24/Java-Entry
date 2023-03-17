import java.util.Scanner;

public class AreaAndLengthInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y, z, Tlength;
        double T_area;

        System.out.print("请输入第一条边边长：");
        x = sc.nextInt();
        System.out.print("请输入第二条边边长：");
        y = sc.nextInt();
        System.out.print("请输入第三条边边长：");
        z = sc.nextInt();

        TriangleInput MyTriangle = new TriangleInput();
        MyTriangle.initTriangleInput(x, y, z);
        if(MyTriangle.isTriangle()){
            Tlength = MyTriangle.getTriangleLength();
            T_area = MyTriangle.getTriangleArea();
            System.out.println("三角形的周长为：" + Tlength);
            System.out.println("三角形的面积为：" + T_area);
        }else{
            System.out.println("三角形构建不成功！");
        }
    }
}

class TriangleInput{
    int a, b, c;
    boolean boo;

    void initTriangleInput(int a1, int b1, int c1){
        a = a1;
        b = b1;
        c = c1;
    }

    boolean isTriangle(){
        boo = a + b > c && a + c > b && b + c > a;
        return boo;
    }

    int getTriangleLength(){
        return a + b + c;
    }

    double getTriangleArea(){
        double Tarea, p;
        p = (double)(a + b + c) / 2.0;
        Tarea = Math.sqrt(p * (p-a) * (p-b) * (p-c));
        return Tarea;
    }
}
