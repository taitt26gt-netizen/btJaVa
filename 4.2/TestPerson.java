public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person("John Doe", "123 Main St");
        System.out.println(p);

        Student s = new Student("Alice", "456 Elm St", "Computer Science", 2, 1500.0);
        System.out.println(s);

        Staff st = new Staff("Bob", "789 Oak St", "High School", 3500.0);
        System.out.println(st);
    }
}