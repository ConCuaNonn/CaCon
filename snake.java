import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class snake {
    private List<Position> snake;
    private Position apple;
    private int score;
    private int mapWidth;
    private int mapHeight;

    public snake(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        initializeGame();
    }

    private void initializeGame() {
        snake = new ArrayList<>();
        snake.add(new Position(mapWidth / 2, mapHeight / 2));
        generateApple();
        score = 0;
    }

    private void generateApple() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(mapWidth);
            y = rand.nextInt(mapHeight);
        } while (isSnakeOnPosition(x, y));

        apple = new Position(x, y);
    }

    private boolean isSnakeOnPosition(int x, int y) {
        for (Position pos : snake) {
            if (pos.horizontal == x && pos.vertical == y) {
                return true;
            }
        }
        return false;
    }

    public void move(Direction direction) {
        Position head = snake.get(0);
        Position newHead = new Position(head.horizontal, head.vertical);

        switch (direction) {
            case UP:
                newHead.vertical--;
                break;
            case DOWN:
                newHead.vertical++;
                break;
            case LEFT:
                newHead.horizontal--;
                break;
            case RIGHT:
                newHead.horizontal++;
                break;
        }

        if (newHead.horizontal == apple.horizontal && newHead.vertical == apple.vertical) {
            snake.add(0, newHead);
            score++;
            generateApple();
        } else {
            snake.add(0, newHead);
            snake.remove(snake.size() - 1);
        }

        if (checkCollision()) {
            gameOver();
        }
    }

    private boolean checkCollision() {
        Position head = snake.get(0);
        return head.horizontal < 0 || head.horizontal >= mapWidth || head.vertical < 0 || head.vertical >= mapHeight || isSnakeOnPosition(head.horizontal, head.vertical);
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.out.println("Score: " + score);
    }

    public void printGameState() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                Position pos = new Position(x, y);
                if (pos.horizontal == apple.horizontal && pos.vertical == apple.vertical) {
                    System.out.print("A");
                } else if (isSnakeOnPosition(x, y)) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
