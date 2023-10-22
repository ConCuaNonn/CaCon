import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        snake game = new snake(10, 10);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            game.printGameState();
            System.out.print("Enter direction (W/A/S/D): ");
            String input = scanner.next();

            snake.Direction direction = null;
            switch (input.toUpperCase()) {
                case "W":
                    direction = snake.Direction.UP;
                    break;
                case "S":
                    direction = snake.Direction.DOWN;
                    break;
                case "A":
                    direction = snake.Direction.LEFT;
                    break;
                case "D":
                    direction = snake.Direction.RIGHT;
                    break;
                default:
                    System.out.println("Invalid input. Use W/A/S/D.");
                    continue;
            }

            game.move(direction);
        }

    }
}