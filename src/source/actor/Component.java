package source.actor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Component {
	protected int row;
	protected int col;
	protected ActorType type;
	protected BufferedImage image;
	
	public Component() {

	}
	
	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
		
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public ActorType getType() {
		return type;
	}

	public void setType(ActorType type) {
		this.type = type;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
