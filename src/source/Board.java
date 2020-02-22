package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import source.actor.Cherry;
import source.actor.Monster;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int width = 600;
	private static int height = 700;
	private static int lines = 7;
	private static int columns = 6;
	private static int scale = 100;
	private static int centeringValue = 20;
	private Rectangle[][] structure = new Rectangle[lines][columns];
	private Monster monster;
	private List<Cherry> cherries = new ArrayList<>();
	private static int cherryId = 0;
	private Cherry[] selectedCherries = new Cherry[5];
	

	public Board() {
		for (int i = 0; i < lines; i++) {
			int y = i * height / lines;
			for (int j = 0; j < columns; j++) {
				int x = j * width / columns;
				structure[i][j] = new Rectangle(x, y, width / columns, height / lines);
			}
		}
		addMouseListener(new ClickAction());
	}

	public void setBoard(String levelNumString) {
		try {
			FileReader fileReader = new FileReader(
					".\\src\\resource\\level" + levelNumString);
			BufferedReader bReader = new BufferedReader(fileReader);
			String line = bReader.readLine();
			int row = Character.getNumericValue(line.charAt(0));
			int col = Character.getNumericValue(line.charAt(1));
			monster = new Monster();
				monster.setRow(row);
				monster.setCol(col);
			System.out.println("Monster: " + monster.getRow() + " " + monster.getCol());

			line = bReader.readLine();
			while(line != null) {
				row = Character.getNumericValue(line.charAt(0));
				col = Character.getNumericValue(line.charAt(1));
				Cherry cherry = new Cherry();
					cherry.setRow(row);
					cherry.setCol(col);
				System.out.println("Cherry: " + cherry.getRow() + " " + cherry.getCol());
				cherries.add(cherry);
				
				line = bReader.readLine();
			}
			bReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void clearBoard() {
		monster = null;
		cherries.clear();
		cherryId = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawBoard(g);
		drawComponents(g);
	}

	private void drawBoard(Graphics g) {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				g.setColor(selectColor(i, j));
				g.fillRect(structure[i][j].x, structure[i][j].y, structure[i][j].width, structure[i][j].height);
			}
		}

	}

	private void drawComponents(Graphics g) {
		if(monster.getImage() != null) {
			monster.draw(g, monster.getCol() * scale + centeringValue, monster.getRow() * scale + centeringValue);
			System.out.println("Monster has been drawn! (" + monster.getRow() + ", " + monster.getCol() + ")");
		}
		for(Cherry c : cherries) {
			if(c.getImage() != null) {
				c.draw(g, c.getCol() * scale + centeringValue, c.getRow() * scale + centeringValue);
				System.out.println("Cherry has been drawn! (" + c.getRow() + ", " + c.getCol() + ")");
			}
			
		}
		
	}
	
	private Color selectColor(int i, int j) {
		if(i % 2 == 0) {
			if(j % 2 == 0) {
				return Color.GREEN;
			} else {
				return Color.BLACK;
			}
		} else {
			if(j % 2 == 0) {
				return Color.BLACK;
			} else {
				return Color.GREEN;
			}
		}
	}

	private class ClickAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// int numOfCherries = cherries.size();
			int col = e.getX()/100;
			int row = e.getY()/100;
			System.out.println("Col: " + col + "Row: " + row);
			
				System.out.println("Cherry id: " + cherryId);
				for(Cherry c : cherries) {
					if(col == c.getCol() && row == c.getRow()) {
						if(cherryId < 5) {
							cherryId++;
						}
						System.out.println("Cherry Col: " + c.getCol() + "Row: " + c.getRow());
						BufferedImage img = null;
						try {
							img = ImageIO.read(new File(
									".\\src\\resource\\" + String.valueOf(cherryId) + ".png"));

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						if(img != null) {
							c.setImage(img);
							repaint();
						}
					
						selectedCherries[cherryId] = c;
					}
				}
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		
	}

}
