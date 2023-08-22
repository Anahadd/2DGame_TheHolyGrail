import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy {

	/* 
	 * 
	 * OVERVIEW OF THE CLASS: This is the Slime Enemy Class in the game, which we use to create several slimes in an array (using your note). This enemy follows the player 
	 * throughout the game and inflicts damage based on touch. It also has a health bar with it, and gets killed if the health is 0 or below. How does it follow? Well, 
	 * we use a method to update the X, Y position based on if the X is less than the players than we add (which is repeated for the rest of the directions). See setX, and setY.  
	 *  
	* RESPAWN --> Essentially, in order to respawn enemies all I did was set the location of the enemy in the room such that it is always following the player so technically 
	* the player isn't killing the enemy but rather pushing it off the screen so it appears as though a new enemy is being spawned (this is more effective than creating a 
	* traditional spawner using an ArrayList). 
	* 
	* RETURNING MASKS --> Each new object of this class has its own unique class, therefore, I had to return the masks of each and create a method for that, which is titled 
	* ReturnMask and it takes the parameter of CamX, and CamY as we need to keep everything relative to those camera values in our game. 
	* 
	* HEALTH --> Each enemy has a health of 40 in total (which is just 40 pixels) and the decreaseHealth method simply returns the value of the health being decreased and also 
	* the enemyHealth which is being used in an if expression in the main class to check if the enemy is still "alive" otherwise we'll have to move it away (setLocation). 
	* 
	*/
	
	
	/*
	 * Initiate the variables used in this class such as, the image, positons of the object, the random class, masks (hp, background behind hp, and the hitbox of slime), and HP
	 */
	private ImageIcon slime; 
	private int xPos, yPos; 
	private Rectangle2D mask, hpSlime, bg; 
	private int HP;
	
	// Constructor, assigning the fields to values 
	public Enemy() {
		
		// Setting ImageIcon to slime 
		slime = new ImageIcon("com-gif-maker-1--unscreen.gif");

		// Setting the X, Y positions, although this can be any value. 
		xPos = 500; 
		yPos = 500; 
		
		// HP to 40 as the HP is consistent throughout the game, but the amount of damage isn't. 
		HP = 40; 
		
	}
	
	// Enemy Health returns the HP 
	public int enemyHealth() { 
		// returns the hp variable 
		return HP; 
	}
	
	// This resets the health of the enemy and we use this when we "respawn" the enemies to act as if there are new enemies being spawned with fresh health.
	public int resetH() {
		// returns the reset hp 
		return HP = 40; 
	}
	
	// This is the damage inflicted on the slime
	public int decreaseHealth() {
		// returns hp being subtracted by the dmg 
		return HP -= 0.05; 
	}
	
	// Setting method which sets the x and y positons in the setLocation method used in the main clas
	public void setLocation(int x, int y)
	{
		// assigning xPos, yPos to the variables passed in to the method. 
		xPos = x;
		yPos = y;
	}
	
	// This returns the x positon of the slime
	public int getX()
	{
		// returns xpos of the slime
		return xPos;
	}
	// this returns the y positon of the slime 
	public int getY()
	{
		// returns ypos of the slime 
		return yPos;
	}
	// this is a get method and it returns the image icon of the slime 
	public ImageIcon getImg()
	{
		return slime;
	}
	
	// this is basically acting like a follow method which directs the slime to follow the X positon of the player (as if the player has a lesser X positon) than the slime should go to the left
	public void setX(String i) {
		
		// this is the random speed which is being generated from (1, 6) 
		int speed = (int)(Math.random() * 5 + 1);
		
		// this indicates whether or not the player's direction is left, if so go left
		if (i == "LEFT") {
			// moves it to the left by speed 
			xPos -= speed;
		}

		// this does the same thing but with right 
		else if (i == "RIGHT") {
			// adds to the xpostion to go to the right
			xPos += speed; 
		}
	}
	
	// this will return the mask which is the rectangle2d of the slime using 2 parameters which is the cameraX, and cameraY. 
	public Rectangle2D mask(int camX, int camY) {
		
		// assigning mask relative to the object that is calling it and returning the value to collsion check 
		mask = new Rectangle2D.Double(getX() - camX, getY() - camY, slime.getIconWidth(), slime.getIconHeight());
		
		// returns the mask 
		return mask;
	}

	// Returns the HP on top of the slime (which just tells the player how much HP that specific slime has) 
	public Rectangle2D hp(int camX, int camY) {
		
		// this will set it such that the HP bar appears above the slime 
		hpSlime = new Rectangle2D.Double(getX() - camX + 10, getY() - camY - 10, HP, 10); 
		
		// this will return the value 
		return hpSlime;  
	}
	
	// This is the black rectangle which is used to contrast the HP so player can easily see what the HP was out of. 
	public Rectangle2D bg(int camX, int camY) { 
		// returns it in one line making sure its on top at the same spot as the other hp mask
		return bg = new Rectangle2D.Double(getX() - camX + 10, getY() - camY - 10, 40, 10);
	}

	// This will set the Y of the player according to the i variable 
	public void setY(String i) {
		
		// random speed 
		int speed = (int)(Math.random() * 5 + 1);
		
		// increments based on the string value as we want it to go closer to the player 
		if (i == "DOWN") {
			// adds speed to the yPos
			yPos += speed;
		}
		// if top is false then we know the closest will be this
		else if (i == "UP") {
			// subtracts speed to the yPos
			yPos -= speed; 
		}
	}
}
