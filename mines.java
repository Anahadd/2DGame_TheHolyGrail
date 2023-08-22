import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class mines {

	/*
	 * This is the Miner class and it is being used to display the mines in the room which are stationary and explode on contact with the player. This class helps with the 
	 * several objects we have and is a direct application of the new note you released (as we're applying our knowledge of it). In this class, we return masks, decrease health 
	 * and change the image icon to the exploding one. 
	 */
	
	// Initiating the variables used in the class
	private ImageIcon mines; 
	private int xPos, yPos; 
	private Random rnd; 
	private Rectangle2D mask, minesHP, minesBg; 
	private Level lvl; 
	private int HP;

	// Constructor to set the field values 
	public mines() {
		
		// Image Icon for the mine 
		mines = new ImageIcon("R__1_-removebg-preview.png");
		
		// Temporarily setting the X/Y Position
		xPos = 500; 
		yPos = 500; 
		
		// Setting the HP for the mine 
		HP = 40; 
	}
	
	// This will set the location for the mines which is being randomly generated each time the level is being run 
	public void setLocation(int x, int y)
	{
		// setting those random values to the x/y position
		xPos = x;
		yPos = y;
	}
	
	// This will return the xposition value 
	public int getX()
	{
		return xPos;
	}
	
	// this will return the mines hp 
	public int health() { 
		return HP; 
	}
	
	// this will decrease the mines hp and return it (as we've hit the mine) 
	public int decreaseHealth() { 
		return HP -= 0.5; 
	}
	
	// this will set the mine to an exploding image as once we've stepped on it, it will explode and consequently play this
	public void setImageExplosion() {
		mines = new ImageIcon("giphy.gif"); 
	}
	
	// this method essentially returns the mask of the mines relative to the camerax, and cameray and it updates it (as we're using it in a timer). 
	public Rectangle2D returnMask(int camX, int camY) {
		
		// sets the mask to those values (of the mineX, mineY) 
		mask = new Rectangle2D.Double(getX() - camX, getY() - camY, mines.getIconWidth(), mines.getIconHeight());
		
		// returns that value so it can be used in main 
		return mask;
	}
	
	// draws the hp rectangle on top of the mine 
	public Rectangle2D hp(int camX, int camY) {
		
		// sets the rectangle on top of the mine 
		minesHP = new Rectangle2D.Double(getX() - camX + 10, getY() - camY + 20, HP, 10); 
		
		// returns that value so it can be used in main 
		return minesHP;  
	}
	
	// draws the black background rectangle on top of the mine 
	public Rectangle2D bg(int camX, int camY) { 
		
		// retuns the mine's black background behind the green one so it appears as though that's the health the mine once had (if swong at)
		return minesBg = new Rectangle2D.Double(getX() - camX + 10, getY() - camY + 20, 40, 10);
	}
	
	// returns the y 
	public int getY()
	{
		return yPos;
	}
	
	// returns the image 
	public ImageIcon getImg()
	{
		return mines;
		
	}
	
	

	
	
}
