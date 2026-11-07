public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + v1 + ",v2=" + v2 + ",v3=" + v3 + "]";
    }

    public double getPerimeter() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        return side1 + side2 + side3;
    }

    public void printType() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);

        double eps = 1e-4;
        boolean eq12 = Math.abs(side1 - side2) < eps;
        boolean eq23 = Math.abs(side2 - side3) < eps;
        boolean eq31 = Math.abs(side3 - side1) < eps;

        if (eq12 && eq23) {
            System.out.println("equilateral");
        } else if (eq12 || eq23 || eq31) {
            System.out.println("isosceles");
        } else {
            System.out.println("scalene");
        }
    }
}