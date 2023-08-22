import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class wiz {

	/*
	 * This is a class in the Java programming language that represents an enemy wizard in a game. The class contains several fields including an ImageIcon called "wizIcon" 
	 * which represents the image of the wizard, an int called "xPos" and "yPos" to store the position of the wizard, a Random object called "rnd", and several Rectangle2D 
	 * objects called "mask", "minesHP", and "minesBg" that are used to create hitboxes and health bars for the wizard. It also includes an Ellipse2D object called "wizBound" 
	 * that creates a bounding radius for the wizard. The class also includes several methods. The constructor creates a new instance of the wizard and sets its initial 
	 * position. The setLocation and getX and getY methods are used to set and retrieve the position of the wizard. The health() and decreaseHealth() methods are used to get 
	 * and decrease the health of the wizard. The returnMask, hp, bg, and returnRadius methods are used to create the hitboxes and health bars for the wizard. The followPlayer 
	 * method is used to make the wizard move towards the player. The resetH method resets the health of the wizard to its initial value. Furthermore, the wizard enemy follows
	 * the player by going above it and shoot fireballs based on a timer. 
	 */
	
	// Initiating the variables used in the class
	private ImageIcon wizIcon; 
	private int xPos, yPos; 
	private Random rnd; 
	private Rectangle2D mask, minesHP, minesBg; 
	private Player play; 
	private int HP = 40;
	private Ellipse2D wizBound; 

	// Constructor to set the field values 
	public wiz() {
		
		// Sets the image icon of the wizard
		wizIcon = new ImageIcon("wiz (2).png");
		
		// Temporarily sets the x/y Position of the wizard 
		xPos = 500; 
		yPos = 500; 
	}
	
	// Sets the location of the player based on the parameters
	public void setLocation(int x, int y)
	{
		// assigns those values
		xPos = x;
		yPos = y;
	}
	
	// returns the x value of the wizard using a get method 
	public int getX()
	{
		return xPos;
	}
	
	// returns the health of the wizard 
	public int health() { 
		return HP; 
	}
	
	// returns the decreased health of the player 
	public int decreaseHealth() { 
		return HP -= 0.0001; 
	}
	
	// returns the mask based on the cameraX, and cameraY of the wizard
	public Rectangle2D returnMask(int camX, int camY) {
		mask = new Rectangle2D.Double(getX() - camX, getY() - camY, wizIcon.getIconWidth(), wizIcon.getIconHeight());
		return mask;
	}
	
	// returns the hp (similiar to all of the other classes, would be repitive to the other comments)
	public Rectangle2D hp(int camX, int camY) {
		minesHP = new Rectangle2D.Double(getX() - camX + 10, getY() - camY + 20, HP, 10); 
		return minesHP;  
	}
	
	// returns the bg (similiar to all of the other classes, would be repitive to the other comments)
	public Rectangle2D bg(int camX, int camY) { 
		return minesBg = new Rectangle2D.Double(getX() - camX + 10, getY() - camY + 20, 40, 10);
	}
	
	// returns the y pos 
	public int getY()
	{
		return yPos;
	}
	
	// returns the image icon 
	public ImageIcon getImg()
	{
		return wizIcon;
	}

	// this is unique as it will check if the player is within a certain radius of the player before following it (to add complexity into our game) 
	public Ellipse2D returnRadius(int cameraX, int cameraY) {
		return wizBound = new Ellipse2D.Double(getX() - cameraX - 500, getY() - cameraY - 500, wizIcon.getIconWidth() + 900, wizIcon.getIconHeight() + 900);
	}
	
	// the wizard will follow the player based on the given X/Y int (which will be set to a value above the player)
	public void followPlayer(int X, int Y) { 
		
		/*
		 * These if expressions are used to move the wizard towards the player's position. The first if statement checks if the player's X position is less than the wizard's X 
		 * position, if so, the wizard's X position is decremented by 2. The second if statement checks if the player's X position is greater than the wizard's X position, if so,
		 * the wizard's X position is incremented by 2. The third if statement checks if the player's Y position is less than the wizard's Y position, if so, the wizard's Y 
		 * position is decremented by 1.5. The fourth if statement checks if the player's Y position is greater than the wizard's Y position, if so, the wizard's Y position is 
		 * incremented by 1.5. In other words, the wizard will move towards the player in the x and y axis by a certain amount depending on the player's position.
		 */
		
		if (X < getX())
		{
			xPos -= 2; 
		}

		if (X > getX()) {
			xPos += 2;
		}
		
		if (Y < getY()) {
			yPos -= 1.5;
		}

		if (Y > getY()) {
			yPos += 1.5; 
		}
	}

	// Resets the HP 
	public void resetH() {
		HP = 40; 
	}

	
	
}
