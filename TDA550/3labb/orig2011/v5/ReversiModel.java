package orig2011.v5;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A somewhat defective implementation of the game Reversi. The purpose
 * of this class is to illustrate shortcomings in the game framework.
 * 
 * @author evensen
 * 
 */
public class ReversiModel implements GameModel {


	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	/** A Matrix containing the state of the gameboard. */
	private final GameTile[][] gameboardState;

	/** The size of the state matrix. */
	private final Dimension gameboardSize = Constants.getGameSize();

	@Override
	public void addObserver(PropertyChangeListener observer) {
		pcs.addPropertyChangeListener(observer);
	}

	@Override
	public void removeObserver(PropertyChangeListener observer) {
		pcs.removePropertyChangeListener(observer);
	}

	public enum Direction {
			EAST(1, 0),
			SOUTHEAST(1, 1),
			SOUTH(0, 1),
			SOUTHWEST(-1, 1),
			WEST(-1, 0),
			NORTHWEST(-1, -1),
			NORTH(0, -1),
			NORTHEAST(1, -1),
			NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Direction(final int xDelta, final int yDelta) {
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

	public enum Turn {
		BLACK,
		WHITE;

		public static Turn nextTurn(final Turn t) {
			return t == BLACK ? WHITE : BLACK;
		}
	}

	public enum PieceColor {
		BLACK,
		WHITE,
		EMPTY;

		public static PieceColor opposite(final PieceColor t) {
			return t == BLACK ? WHITE : BLACK;
		}
	}

	/** Graphical representation of a coin. */
	private static final GameTile blackTile = new RoundTile(Color.BLACK,
			Color.BLACK, 1.0, 0.8);
	private static final GameTile whiteTile = new RoundTile(Color.BLACK,
			Color.WHITE, 1.0, 0.8);
	private static final GameTile blankTile = new SquareTile(Color.BLACK,
			new Color(0, 200, 0), 2.0);
	private static final GameTile whiteGridTile = new CompositeTile(blankTile,
			whiteTile);
	private static final GameTile blackGridTile = new CompositeTile(blankTile,
			blackTile);
	private static final GameTile cursorRedTile = new CrossTile(Color.RED, 2.0);
	private static final GameTile cursorBlackTile = new RoundTile(Color.RED,
			new Color(0, 50, 0), 2.0, 0.8);
	private static final GameTile cursorWhiteTile = new RoundTile(Color.RED,
				new Color(210, 255, 210), 2.0, 0.8);

	private Turn turn;
	private Position cursorPos;
	private final PieceColor[][] board;
	private int whiteScore;
	private int blackScore;
	private final int width;
	private final int height;
	private boolean gameOver;

	public ReversiModel() {
		this.gameboardState =
				new GameTile[this.gameboardSize.width][this.gameboardSize.height];
		this.width = Constants.getGameSize().width;
		this.height = Constants.getGameSize().height;
		this.board = new PieceColor[this.width][this.height];

		// Blank out the whole gameboard...
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				setGameboardState(i, j, blankTile);
				this.board[i][j] = PieceColor.EMPTY;
			}
		}

		setTurn(Turn.BLACK);

		// Insert the four starting bricks.
		int midX = this.width / 2 - 1;
		int midY = this.height / 2 - 1;
		this.board[midX][midY] = PieceColor.WHITE;
		setGameboardState(midX, midY, whiteGridTile);
		this.board[midX + 1][midY + 1] = PieceColor.WHITE;
		setGameboardState(midX + 1, midY + 1, whiteGridTile);
		this.board[midX + 1][midY] = PieceColor.BLACK;
		setGameboardState(midX + 1, midY, blackGridTile);
		this.board[midX][midY + 1] = PieceColor.BLACK;
		setGameboardState(midX, midY + 1, blackGridTile);

		// Set the initial score.
		setScore(2,2);

		this.gameOver = false;

		// Insert the collector in the middle of the gameboard.
		setCursorPosition(new Position(midX, midY));
		updateCursor();
	}

	/**
	 * Return whether the specified position is empty. If it only consists
	 * of a blank tile, it is considered empty.
	 *
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty, false otherwise.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return this.board[pos.getX()][pos.getY()] == PieceColor.EMPTY;
	}

	/**
	 * Update the direction of the collector
	 * according to the users keypress.
	 *
	 * @throws GameOverException
	 */
	private Direction updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				return Direction.WEST;
			case KeyEvent.VK_UP:
				return Direction.NORTH;
			case KeyEvent.VK_RIGHT:
				return Direction.EAST;
			case KeyEvent.VK_DOWN:
				return Direction.SOUTH;
			case KeyEvent.VK_SPACE:
				tryPlay();
				return Direction.NONE;
			default:
				// Do nothing if another key is pressed
				return Direction.NONE;
		}
	}

	private void tryPlay() {
		if (isPositionEmpty(this.cursorPos)) {
			GameTile t;
			if (this.turn == Turn.BLACK) {
				t = blackGridTile;
			} else {
				t = whiteGridTile;
			}
			if (canTurn(this.turn, this.cursorPos)) {
				turnOver(this.turn, this.cursorPos);
				setGameboardState(this.cursorPos, t);
				this.board[this.cursorPos.getX()][this.cursorPos.getY()] =
						(this.turn == Turn.BLACK
								? PieceColor.BLACK
								: PieceColor.WHITE);
				System.out.println("Bong! White: " + this.whiteScore
						+ "\tBlack: " + this.blackScore);
				setTurn(Turn.nextTurn(this.turn));
			}
			if (!canTurn(this.turn)) {
				if (!canTurn(Turn.nextTurn(this.turn))) {
					this.gameOver = true;
					return;
				}
				setTurn(Turn.nextTurn(this.turn));

			}
		}

	}

	private void turnOver(final Turn turn, final Position cursorPos) {
		if (isPositionEmpty(cursorPos)) {
			PieceColor myColor =
					(turn == Turn.BLACK ? PieceColor.BLACK : PieceColor.WHITE);
			PieceColor opponentColor = PieceColor.opposite(myColor);
			int blackResult = (turn == Turn.BLACK) ? 1 : -1;
			int whiteResult = -blackResult;

			int newWhiteScore = this.blackScore += Math.max(0, blackResult);
			int newBlackScore = this.whiteScore += Math.max(0, whiteResult);
			setScore(newWhiteScore, newBlackScore);

			for (int i = 0; i < 8; i++) {
				Direction d = Direction.values()[i];
				int xDelta = d.getXDelta();
				int yDelta = d.getYDelta();
				int x = cursorPos.getX() + xDelta;
				int y = cursorPos.getY() + yDelta;
				boolean canTurn = false;
				while (x >= 0 && x < this.width && y >= 0 && y < this.height) {
					if (this.board[x][y] == opponentColor) {
						canTurn = true;
					} else if (this.board[x][y] == myColor && canTurn) {
						// Move backwards to the cursor, flipping bricks
						// as we go.
						x -= xDelta;
						y -= yDelta;
						while (!(x == cursorPos.getX() && y == cursorPos.getY())) {
							this.board[x][y] = myColor;
							setGameboardState(x, y,
									myColor == PieceColor.BLACK ? blackGridTile
											: whiteGridTile);
							x -= xDelta;
							y -= yDelta;
							this.blackScore += blackResult;
							this.whiteScore += whiteResult;
						}
						break;
					} else {
						break;
					}
					x += xDelta;
					y += yDelta;
				}
			}
		}
	}

	private boolean canTurn(final Turn turn) {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				if (canTurn(turn, new Position(x, y))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean canTurn(final Turn turn, final Position cursorPos) {
		if (isPositionEmpty(cursorPos)) {
			PieceColor myColor =
					(turn == Turn.BLACK ? PieceColor.BLACK : PieceColor.WHITE);
			PieceColor opponentColor = PieceColor.opposite(myColor);
			for (int i = 0; i < 8; i++) {
				Direction d = Direction.values()[i];
				int xDelta = d.getXDelta();
				int yDelta = d.getYDelta();
				int x = cursorPos.getX() + xDelta;
				int y = cursorPos.getY() + yDelta;
				boolean canTurn = false;
				while (x >= 0 && x < this.width && y >= 0 && y < this.height) {
					if (this.board[x][y] == opponentColor) {
						canTurn = true;
					} else if (this.board[x][y] == myColor && canTurn) {
						return true;
					} else {
						break;
					}
					x += xDelta;
					y += yDelta;
				}
			}
		}
		return false;
	}

	/**
	 * Get the current player's color
	 */
	public Turn getTurnColor() {
		return this.turn;
	}

	/**
	 * Accessor to black's current score.
	 *
	 * @return black's score
	 */
	public int getBlackScore() {
		return this.blackScore;
	}

	/**
	 * Accessor to white's current score.
	 *
	 * @return white's score
	 */
	public int getWhiteScore() {
		return this.whiteScore;
	}

	/**
	 * Get next position of the collector.
	 */
	private Position getNextCursorPos(final Direction dir) {
		return new Position(this.cursorPos.getX()
					+ dir.getXDelta(),
					this.cursorPos.getY() + dir.getYDelta());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameTile getGameboardState(Position pos) {
		return getGameboardState(pos.getX(), pos.getY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameTile getGameboardState(int x, int y) {
		return gameboardState[x][y];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dimension getGameboardSize() {
		return gameboardSize;
	}

	/**
	 * This method is called repeatedly so that the
	 * game can update its state.
	 *
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		if (!this.gameOver) {
			Position nextCursorPos = getNextCursorPos(updateDirection(lastKey));
			Dimension boardSize = getGameboardSize();
			int nextX =
					Math.max(0,
							Math.min(nextCursorPos.getX(), boardSize.width - 1));
			int nextY =
					Math.max(
							0,
							Math.min(nextCursorPos.getY(), boardSize.height - 1));
			nextCursorPos = new Position(nextX, nextY);
			removeCursor(this.cursorPos);
			setCursorPosition(nextCursorPos);
			updateCursor();
		} else {
			throw new GameOverException(this.blackScore - this.whiteScore);
		}
	}

	private void removeCursor(final Position oldCursorPos) {
		GameTile t = getGameboardState(this.cursorPos);
		if (t instanceof CompositeTile) {
			CompositeTile c = (CompositeTile) t;
			// Remove the top layer, if it is the cursor.
			if (c.getTop() == cursorRedTile ||
					c.getTop() == cursorWhiteTile ||
					c.getTop() == cursorBlackTile) {
				setGameboardState(oldCursorPos, c.getBottom());
			}
		}
	}

	private void updateCursor() {
		GameTile t = getGameboardState(this.cursorPos);
		GameTile cursoredTile;
		if (canTurn(this.turn, this.cursorPos)) {
			if (this.turn == Turn.BLACK) {
				cursoredTile = new CompositeTile(t, cursorBlackTile);
			} else {
				cursoredTile = new CompositeTile(t, cursorWhiteTile);
			}
		} else {
			cursoredTile = new CompositeTile(t, cursorRedTile);
		}
		setGameboardState(this.cursorPos, cursoredTile);
	}

	/**
	 * Sets gameboardState
	 * @param pos Position to use
	 * @param tile New GameTile
     */
	private void setGameboardState(Position pos, GameTile tile){
		setGameboardState(pos.getX(), pos.getY(), tile);
	}

	/**
	 * Sets gameboardState
	 * @param x x postion
	 * @param y y position
	 * @param tile new GameTile
     */
	private void setGameboardState(int x, int y, GameTile tile){
		GameUtils.setGameboardState(gameboardState, x, y, tile);
		pcs.firePropertyChange("gameboardstate", null, gameboardState);
	}

	/**
	 * Sets the new score
	 * @param whiteScore new score for white
	 * @param blackScore new score for black
     */
	private void setScore(int whiteScore, int blackScore){
		int oldScoreWhite = this.whiteScore;
		int oldScoreBlack = this.blackScore;

		this.blackScore = blackScore;
		this.whiteScore = whiteScore;

		pcs.firePropertyChange("White score", oldScoreWhite, this.whiteScore);
		pcs.firePropertyChange("Black score", oldScoreBlack, this.blackScore);

	}

	/**
	 * Sets new player turn
	 * @param newTurn the new player turn
     */
	private void setTurn(Turn newTurn){
		Turn oldTurn = this.turn;
		this.turn = newTurn;
		pcs.firePropertyChange("Turn", oldTurn, this.turn);
	}

	/**
	 * Sets new cursor position
	 * @param pos
     */
	private void setCursorPosition(Position pos){
		Position oldPos = this.cursorPos;
		this.cursorPos = pos;
		pcs.firePropertyChange("Mouse", oldPos, this.cursorPos);

	}

}
