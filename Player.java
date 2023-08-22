import java.awt.Image;

import javax.swing.ImageIcon;

public class Player
{
	/*
	 * This class is being used to control the Player in all levels of our game. In this class, we've assigned the UP LEFT DOWN AND RIGHT DIRECTIONS so that player's sprite can change 
	 * as it will be animating itself. Furthermore, we've also incoporated a sleeping sprite which is a small attention to detail you may or may not have noticed as the player 
	 * changes sprites if you're not moving for a certain amount of time which we think is a pretty cool detail. 
	 */
	
	// Initiating the variables used in the class
	private int xPos, yPos;
	private ImageIcon playIcon;
	private String direction = "DOWN";
	private int pos = 0, walk = 1;
	private boolean sleep = false;
	
	// Constructor to set the field values 
	public Player()
	{
		
		// Assigns the X/Y Position of the player 
		xPos = 750;
		yPos = 1000;
		
		// Assigns the image icon assiociated with the player
		playIcon = new ImageIcon("Player/linkDOWN0.png");
	}
	
	// Based on the direction it will first set the isMoving to true which is a boolean value and returns it (as we require in our main to check if the player is or is not moving so we
	// can call the idle timer (as we've incorporated a sleeping sprite to indicate the player may be AFK). Afterwards, we check our direction to make sure the player can move in all 
	// directions as our game is a Top Down. 
	public boolean move(int dir)
	{
		// sets it to true 
		boolean isMoving = true;
		
		// if expression to check the direction, all of this either add subtract to the x or y respectively based on the direciton 
		if (dir == 0)
		{
			xPos -= 6.5;
			direction = "LEFT";
		}
		else if (dir == 1)
		{
			xPos += 6.5;
			direction = "RIGHT";
		}
		else if (dir == 2)
		{
			yPos -= 6.5;
			direction = "UP";
		}
		else
		{	
			yPos += 6.5;
			direction = "DOWN";
		}	
		
		// returns the ismoving to check if it should start the idle timer 
		return isMoving;
	}
	
	// sets the y position of the parameter to the global field 
	public void setY(int y)
	{
		yPos = y;
	}
	
	// sets the x position of the parameter to the global field 
	public void setX(int x)
	{
		xPos = x;
	}
	
	// returns the image icon of the player 
	public ImageIcon getImage()
	{
		return playIcon;
	}
	
	// returns the direction of the player 
	public String returnDir() {
		return direction; 
	}
	
	// checks if the player is idling and if so then it will change the image icon 
	public void idle()
	{
		// pos to check what frame to have 
		if (pos <= 2)
		{	
			playIcon = new ImageIcon("Player/link"+direction+pos+".png");
			pos++;
		}
		else
			pos = 4;
			
	}
	
	// does the smae as the idle as it checks the walking frame 
	public void walk()
	{
		
		// resets the walking frames if it is greater than or equal to 10 
		if (walk >= 10)
			walk = 1;
		
		// sets it to the respective walking 
		playIcon = new ImageIcon("Player/linkWalk"+direction+walk+".png");
		walk++;
		pos = 0;
	}
	
	// same thing above but with the sleep sprite 
	public void resetPos(boolean s)
	{
		sleep = s;
		if (sleep)
		{	
			playIcon = new ImageIcon("Player/link"+direction+0+".png");
			sleep = false;
		}	
	}
	
	// this will return the x value (int)
	public int getX()
	{
		return xPos;
	}
	
	// this will return the y value (int) 
	public int getY()
	{
		return yPos;
	}
}
