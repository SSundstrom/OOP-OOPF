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
    private final List<Position> body = new ArrayList<Position>();

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
        setGameboardState(this.snakePos, SNAKE_TILE);

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

        public void gameUpdate(int lastKey) throws GameOverException {
            updateDirection(lastKey); //TODO make this method

            // Erase the previous position.
            setGameboardState(this.snakePos, BLANK_TILE);
            // Change collector position.
            this.snakePos = getNextSnakePos(); //TODO make this metod

            if (isOutOfBounds(this.snakePos)) {
                throw new GameOverException(this.score);
            }
            // Draw snake at new position.
            setGameboardState(this.snakePos, SNAKE_TILE);

            // Remove the food at the new collector position (if any)
            if (true) {
                //TODO add a new body part to list 'body'
                this.score++;
            }
            Dimension tmp = getGameboardSize();
            int isMax = tmp.width * tmp.height;
            if (this.body.size() == isMax ) {
                throw new GameOverException(this.score);
            }
        }

    private boolean isOutOfBounds(Position pos){
        Dimension size = getGameboardSize();
        return size.width < pos.getX() || pos.getX() < 0 || size.width < pos.getY() || pos.getY() < 0;
    }
}