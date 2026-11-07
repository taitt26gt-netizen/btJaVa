public class TestMyPolynomial {
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial p2 = new MyPolynomial(1.0, 1.0, 1.0);

        System.out.println("Polynomial 1: " + p1);
        System.out.println("Degree of p1: " + p1.getDegree());
        System.out.println("Evaluate p1 at x = 2.0: " + p1.evaluate(2.0));

        System.out.println("Polynomial 2: " + p2);

        MyPolynomial sum = p1.add(p2);
        System.out.println("Sum: " + sum);

        MyPolynomial product = p1.multiply(p2);
        System.out.println("Product: " + product);
    }
}