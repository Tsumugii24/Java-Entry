public class AreaAndLength {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.initTriangle(3, 4, 5);
        boolean isTriangle = triangle.isTriangle();
        if (isTriangle) {
            int triangleLength = triangle.getTriangleLength();
            double triangleArea = triangle.getTriangleArea();
            System.out.println("Triangle length is: " + triangleLength);
            System.out.println("Triangle area is: " + triangleArea);
        } else {
            System.out.println("Invalid triangle!");
        }
    }
}

class Triangle {
    private int a;
    private int b;
    private int c;
    private boolean boo;

    public void initTriangle(int a1, int b1, int c1) {
        a = a1;
        b = b1;
        c = c1;
    }

    public boolean isTriangle() {
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

    public int getTriangleLength() {
        int Tlen = a + b + c;
        return Tlen;
    }

    public double getTriangleArea() {
        double Tarea;
        double p = (a + b + c) / 2.0;
        Tarea = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Tarea;
    }
}
