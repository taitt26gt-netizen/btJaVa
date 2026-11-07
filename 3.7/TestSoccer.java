public class TestSoccer {
    public static void main(String[] args) {
        Ball ball = new Ball(10.0f, 10.0f, 0.0f);
        System.out.println("Initial ball position: " + ball);

        Player player1 = new Player(7, 12.0f, 12.0f);

        System.out.println("Is player near the ball? " + player1.near(ball));

        player1.kick(ball);
        System.out.println("New ball position after kick: " + ball);

        player1.move(5.0f, 5.0f);
        player1.jump(2.0f);
        System.out.println("Is player near the ball now? " + player1.near(ball));
    }
}