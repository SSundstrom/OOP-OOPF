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
    private static final GameTile FOOD_TILE = new RoundTile(Color.BLACK, Color.RED, 2.0, 0.5);

    /** Graphical representation of the snake body part*/
    private static final GameTile SNAKE_HEAD_TILE = new RoundTile(Color.BLACK, Color.LIGHT_GRAY ,2.5, 0.8);
    private static final GameTile SNAKE_BODY_TILE = new RoundTile(Color.BLACK, Color.DARK_GRAY, 2.5, 0.6);

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
        score = 0;
        direction = Directions.NORTH;
        //Sets gameboard to empty
        for(int i = 0; i < size.width; i++){
            for (int j = 0; j < size.height; j++) {
                setGameboardState(i, j, BLANK_TILE);
            }
        }

        // Insert the Snake in the middle of the gameboard.
        this.snakePos = new Position(size.width / 2, size.height / 2);
        body.add(this.snakePos);
        setGameboardState(body.get(0), SNAKE_HEAD_TILE);

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

    private void moveSnake(){
        setGameboardState(body.get(body.size() - 1), BLANK_TILE);
        for (int i = body.size() - 1; 0 < i; i--) {
            body.set(i, body.get(i - 1));
            setGameboardState(body.get(i), SNAKE_BODY_TILE);
        }
        this.snakePos = getNextSnakePos();
        body.set(0, this.snakePos);
    }

        public void gameUpdate(int lastKey) throws GameOverException {
            updateDirection(lastKey);
            //Position to the last element if eats.
            Position lastPos = new Position(body.get(body.size() - 1).getX(), body.get(body.size() - 1).getY());
            // Erase the last position and move positions to snake
            moveSnake();
            // Checks so game is not over
            if (isOutOfBounds(this.snakePos) || getGameboardState(this.snakePos) == SNAKE_BODY_TILE) {
                throw new GameOverException(this.score);
            }
            // Snake eats
            if (getGameboardState(this.snakePos) == FOOD_TILE){
                body.add(lastPos);
                setGameboardState(lastPos, SNAKE_BODY_TILE);
                addFood();
                score++;
            }
            if(score == (int)(getGameboardSize().getWidth() * getGameboardSize().getHeight())){
                System.out.println("You won!");
                throw new GameOverException(this.score);
            }
            // Draw snake at new position.
            setGameboardState(this.snakePos, SNAKE_HEAD_TILE);
        }

    private boolean isOutOfBounds(Position pos){
        return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
                || pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
    }
}