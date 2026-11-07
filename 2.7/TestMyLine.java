public class TestMyLine {
    public static void main(String[] args) {
        MyLine l1 = new MyLine(0, 0, 3, 4);
        System.out.println(l1);
        System.out.println("Length: " + l1.getLength());
        System.out.println("Gradient: " + l1.getGradient());

        MyPoint p1 = new MyPoint(1, 2);
        MyPoint p2 = new MyPoint(4, 6);
        MyLine l2 = new MyLine(p1, p2);
        System.out.println(l2);
        System.out.println("Begin X: " + l2.getBeginX());
        System.out.println("End Y: " + l2.getEndY());
    }
}