package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeModel extends GameModel {

    public enum Directions {
        EAST(1, 0),
        WEST(-1, 0),
        NORTH(0, -1),
        SOUTH(0, 1),
        NONE(0, 0);

        private final int xDelta;
        private final int yDelta;

        Directions(final int xDelta, final int yDelta) {
            this.xDelta = xDelta;
            this.yDelta = yDelta;
        }

        public int getXDelta() {
            return this.xDelta;
        }

        public int getYDelta() {
            return this.yDelta;
        }
    }

    /** Graphical representation of a food. */
    private static final GameTile FOOD_TILE = new RoundTile(new Color(255, 215,
            0),
            new Color(255, 255, 0), 2.0);

    /** Graphical representation of the snake body part*/
    private static final GameTile SNAKE_TILE = new RoundTile(Color.BLACK,
            Color.RED, 2.0);

    /** Graphical representation of a blank tile. */
    private static final GameTile BLANK_TILE = new GameTile();

    /** A list containing the positions of all body parts. */
    private List<Position> body = new ArrayList<Position>();

    /** The position of the snake. */
    private Position snakePos;

    /** The direction of the snake. */
    private Directions direction = Directions.NORTH;

    /** The number of food eaten. */
    private int score;

    public SnakeModel(){
        Dimension size = getGameboardSize();

        //Sets gameboard to empty
        for(int i = 0; i < size.width; i++){
            for (int j = 0; j < size.height; j++) {
                setGameboardState(i, j, BLANK_TILE);
            }
        }

        // Insert the Snake in the middle of the gameboard.
        this.snakePos = new Position(size.width / 2, size.height / 2);
        body.add(this.snakePos);
        setGameboardState(body.get(0), SNAKE_TILE);

        //Insert first food.
        addFood();

    }

    private void addFood(){
        Random r = new Random();
        Position foodPos;
        Dimension size = getGameboardSize();

        do{
            foodPos = new Position(r.nextInt(size.width), r.nextInt(size.height));
        }while (!isPositionEmpty(foodPos));
        setGameboardState(foodPos, FOOD_TILE);

    }

    private boolean isPositionEmpty(Position pos){
        return getGameboardState(pos) == BLANK_TILE;
    }

    private void updateDirection(final int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                if(this.direction != Directions.EAST) {
                    this.direction = Directions.WEST;
                }
                break;
            case KeyEvent.VK_UP:
                if(this.direction != Directions.SOUTH) {
                    this.direction = Directions.NORTH;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(this.direction != Directions.WEST) {
                    this.direction = Directions.EAST;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(this.direction != Directions.NORTH) {
                    this.direction = Directions.SOUTH;
                }
                break;
            default:
                // Don't change direction if another key is pressed
                break;
        }
    }

    private Position getNextSnakePos() {
        return new Position(
                this.snakePos.getX() + this.direction.getXDelta(),
                this.snakePos.getY() + this.direction.getYDelta());
    }

        public void gameUpdate(int lastKey) throws GameOverException {
            updateDirection(lastKey);
            // Erase the last position.

            setGameboardState(body.get(0), BLANK_TILE);
            // Change collector position.
            this.snakePos = getNextSnakePos();

            if (isOutOfBounds(this.snakePos)) {
                throw new GameOverException(this.score);
            }
            if (getGameboardState(this.snakePos) == FOOD_TILE){
                body.add(this.snakePos);
                addFood();
                score++;
            }
            // Draw collector at new position.
            setGameboardState(this.snakePos, SNAKE_TILE);


            // Remove the coin at the new collector position (if any)


            // Check if all coins are found


            // Remove one of the coins


            // Add a new coin (simulating moving one coin)


        }

    private boolean isOutOfBounds(Position pos){
        Dimension size = getGameboardSize();
        return size.width < pos.getX() || pos.getX() < 0 || size.width < pos.getY() || pos.getY() < 0;
    }
}