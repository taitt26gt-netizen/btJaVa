public class TestPoint2D3D {
    public static void main(String[] args) {
        Point2D p2 = new Point2D(1.5f, 2.5f);
        System.out.println(p2);

        Point3D p3 = new Point3D(1.1f, 2.2f, 3.3f);
        System.out.println(p3);

        p3.setXYZ(5.0f, 6.0f, 7.0f);
        System.out.println("X: " + p3.getX());
        System.out.println("Y: " + p3.getY());
        System.out.println("Z: " + p3.getZ());
        System.out.println(p3);
    }
}