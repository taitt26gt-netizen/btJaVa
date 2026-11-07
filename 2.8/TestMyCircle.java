public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle();
        System.out.println(c1);

        MyCircle c2 = new MyCircle(1, 2, 5);
        System.out.println(c2);

        c2.setRadius(10);
        c2.setCenterXY(3, 4);
        System.out.println("Radius is: " + c2.getRadius());
        System.out.println("Center is: " + c2.getCenter());
        System.out.println("Center X is: " + c2.getCenterX());
        System.out.println("Center Y is: " + c2.getCenterY());
        System.out.println("Area is: " + c2.getArea());
        System.out.println("Circumference is: " + c2.getCircumference());

        MyCircle c3 = new MyCircle(new MyPoint(6, 8), 5);
        System.out.println("Distance between c2 and c3: " + c2.distance(c3));
    }
}