public class TestMyComplex {
    public static void main(String[] args) {
        MyComplex c1 = new MyComplex(1.1, 2.2);
        MyComplex c2 = new MyComplex(3.3, 4.4);

        System.out.println("Number 1 is: " + c1);
        System.out.println("Is " + c1 + " a pure real number? " + c1.isReal());
        System.out.println("Is " + c1 + " a pure imaginary number? " + c1.isImaginary());

        System.out.println("Number 2 is: " + c2);
        System.out.println("Is " + c2 + " a pure real number? " + c2.isReal());
        System.out.println("Is " + c2 + " a pure imaginary number? " + c2.isImaginary());

        System.out.println(c1 + " is " + (c1.equals(c2) ? "" : "NOT ") + "equal to " + c2);

        MyComplex sum = c1.addNew(c2);
        System.out.println(c1 + " + " + c2 + " = " + sum);
    }
}