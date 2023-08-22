import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class fireball {

	/*
	 * This is the Fireball class, and it is being used to create the fireball for the wizards which spawns randomly for each object of the Wizard. In this class, 
	 * we utilize methods that will help make our code in main more clean and efficent - this includes returning masks for the object in the fireball array,
	 * and much more. 
	 */
	
	// Initiate the fields used
	private ImageIcon fire; 
	private int xPos, yPos, HP; 
	private Ellipse2D fireMask; 
	private Player play;
	
	// Constructor, assigning the fields to values 
	public fireball() {
		
		// Setting ImageIcon to the fire  
		fire = new ImageIcon("270-2701567_fireball-clipart-8-bit-png-download-removebg-preview (1).png");
		
		// Assigning temporary values so Null Expcetion won't happen 
		xPos = 500; 
		yPos = 500; 
		
	}
	
	// This method will set the values of the X Position of the fireball to the given parameters (which is typically the wizards x/y) 
	public void setLocation(int x, int y)
	{
		// assigns the values
		xPos = x;
		yPos = y;
	}
	
	// get method which returns the value of int  
	public int getX()
	{
		return xPos;
	}
	
	// once again, another get method which returns the y value 
	public int getY()
	{
		return yPos;
	}
	
	// another get method which returns the image icon 
	public ImageIcon getImg()
	{
		return fire;
	}

	// this method essentially returns the mask of the projectile relative to the camerax, and cameray and it updates it (as we're using it in a timer). 
	public Ellipse2D returnMask(int cameraX, int cameraY) {
		// returns the ellipse 
		return fireMask = new Ellipse2D.Double(getX() - cameraX, getY() - cameraY, fire.getIconWidth(), fire.getIconHeight());
	}	
	
	// this will make sure the projectile moves down
	public void moveDown() {
		yPos += 5; 
	}
	
	// this will reset the values so the wizard can shoot again. 
	public void resetVal(int x, int y) {
		
		// if expression to check if the fireball is out of the map
		if (yPos > 1250) {
			xPos = x; 
			yPos = y; 
		}
	}
}