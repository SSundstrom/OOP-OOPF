package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.*;

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
    private static final HeadTile SNAKE_HEAD_TILE = new HeadTile();
    private static final GameTile SNAKE_BODY_TILE_X = new BodyTileHorizontal(new Color(32, 83, 32), Color.red);
    private static final GameTile SNAKE_BODY_TILE_Y = new BodyTileVertical(new Color(32, 83, 32), Color.red);


    /** Graphical representation of a blank tile. */
    private static final GameTile BLANK_TILE = new GameTile();

    /** A list containing the positions of all body parts. */
    private Queue<Position> body = new LinkedList<>();

    /** The position of the snake. */
    private Position snakePos;

    /** The direction of the snake. */
    private Directions direction = Directions.NORTH;

    /** The number of food eaten. */
    private int score;

    /**
     * Intizialing the gameboard. Puts the player in the middle and add the first food to the board.
     */
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
        setGameboardState(body.poll(), SNAKE_HEAD_TILE);

        //Insert first food.
        addFood();

    }

    /**
     * Adds food to a random position on the gameboard, if it is possible.
     */
    private void addFood(){
        Random r = new Random();
        Position foodPos;
        Dimension size = getGameboardSize();

        do{
            foodPos = new Position(r.nextInt(size.width), r.nextInt(size.height));
        }while (!isPositionEmpty(foodPos));
        setGameboardState(foodPos, FOOD_TILE);

    }

    /**
     * Checks if the position is empty.
     * @param pos to be checked.
     * @return true if the position is empty.
     */
    private boolean isPositionEmpty(Position pos){
        return getGameboardState(pos) == BLANK_TILE;
    }

    /**
     * Sets the direction for the next movement.
     * @param key ID for a specific direction
     */
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

    /**
     * Calculates and returns the next position.
     * @return the next position for the Snake
     */
    private Position getNextSnakePos() {
        return new Position(
                this.snakePos.getX() + this.direction.getXDelta(),
                this.snakePos.getY() + this.direction.getYDelta());
    }

    /**
     * Updates the snakes body to emulate movement.
     */
    private void moveSnake(){
        body.add(this.snakePos);
        if(this.direction == Directions.EAST || this.direction == Directions.WEST) {
            setGameboardState(this.snakePos,SNAKE_BODY_TILE_X);
        } else {
            setGameboardState(this.snakePos,SNAKE_BODY_TILE_Y);
        }
        this.snakePos = getNextSnakePos();
    }

    /**
     * This method is called repeatedly so that the
     * game can update its state.
     *
     * @param lastKey The most recent keystroke.
     * @throws GameOverException Will end the game and display the score.
     */
        public void gameUpdate(int lastKey) throws GameOverException {
            updateDirection(lastKey);
            moveSnake();

            if(this.score == (int)(getGameboardSize().getWidth() * getGameboardSize().getHeight()) - 1){
                System.out.println("You won!");
                throw new GameOverException(this.score);
            }
//             Checks so game is not over
            if (isOutOfBounds(this.snakePos) || getGameboardState(this.snakePos) == SNAKE_BODY_TILE_X || getGameboardState(this.snakePos) == SNAKE_BODY_TILE_Y) {
                throw new GameOverException(this.score);
            }

            // Snake eats
            if (getGameboardState(this.snakePos) == FOOD_TILE){
                score++;
                if (this.score != (int)(getGameboardSize().getWidth() * getGameboardSize().getHeight()) - 1) {
                    addFood();
                }
            } else {
                setGameboardState(body.peek(), BLANK_TILE);
                body.remove();

            }
            // Draw snake at new position.
            setGameboardState(this.snakePos, SNAKE_HEAD_TILE);
        }

    /**
     * Checks if the snake is going out of bounds.
     * @param pos the position the snake is trying to go to.
     * @return true if the snake is not out of bounds.
     */
    private boolean isOutOfBounds(Position pos){
        return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
                || pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
    }
}