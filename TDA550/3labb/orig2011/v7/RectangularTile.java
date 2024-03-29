package orig2011.v7;


import java.awt.*;


/**
 * A rectangular tile manages painting of a
 * filled rectangle in a specified area of the screen.
 * 
 * Whenever the object should paint itself,
 * it is told what size and position that
 * should be used to paint it.
 */
public class RectangularTile implements GameTile {

	/** The color of the rectangle */
	private final Color color;

	/**
	 * Creates a rectangular game tile.
	 * 
	 * @param color
	 *            the color of the rectangle.
	 */
	public RectangularTile(final Color color) {
		this.color = color;
	}

	/**
	 * Draws itself in a given graphics context, position and size.
	 * 
	 * @param g
	 *            graphics context to draw on.
	 * @param x
	 *            pixel x coordinate of the tile to be drawn.
	 * @param y
	 *            pixel y coordinate of the tile to be drawn.
	 * @param d
	 *            size of this object in pixels.
	 */
	@Override
	public void draw(final Graphics g, final int x, final int y,
			final Dimension d) {
		g.setColor(this.color);
		g.fillRect(x, y, d.width, d.height);
	}
}
