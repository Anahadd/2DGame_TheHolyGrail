import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class interact {
	
	/*
	 * This class is used to create and manage interactions between the player and non-playable characters (NPCs) in a game. It contains several fields, including an ImageIcon 
	 * called "textIcon" which represents a text box that appears when the player interacts with an NPC, an ImageIcon called "npc" which represents the appearance of the NPC, 
	 * and several int variables that store the X and Y positions of different NPCs. The class also contains a Rectangle2D object called "box" which is used as a hitbox for the 
	 * NPCs. The class has several methods. The constructor creates an instance of the class and initializes the position of the NPCs. The textBox method sets the text icon to a 
	 * certain image depending on the argument passed to the method. The npc method sets the NPC icon to a certain image depending on the argument passed to the method. The 
	 * npcXPos and npcYPos methods set and return the X and Y positions of the NPCs, respectively. The npcHitBox method creates a hitbox for the NPCs based on their position 
	 * and the camera's position.
	 */

	
	// Fields 
	private ImageIcon textIcon, one;
	private ImageIcon npc;
	private int npc1X, npc1Y, npc2X, npc2Y, npcX, npcY;
	private Rectangle2D box;
	
	
	// Constructor to assign values to the various NPCs and assigning the textbox. 
	public interact()
	{
		// Setting the images 
		textIcon = new ImageIcon("Textbox/1.png");
		npc = new ImageIcon("NPC/1_1.png");
		
		// setting the x, y of npc 1
		npc1X = 730;
		npc1Y = 1360;
		
		// setting the x, y of npc2 
		npc2X = 300;
		npc2Y = 520;
		
		npcX = npc1X;
		npcY = npc1Y;
		
		// this will set the box ex. the collision mask 
		box = new Rectangle2D.Double(npc1X, npc1Y, textIcon.getIconWidth(), textIcon.getIconHeight());
	}
	
	// this will return the texboox based on the value of a (used as an incrementor) 
	public ImageIcon textBox(int a)
	{
		// assigns/returns the value 
		textIcon = new ImageIcon("Textbox/"+a+".png");
		return textIcon;
	}
	
	// this will change the npc depending on the 'a' incrementator as we have more than 1 NPC in the game 
	public ImageIcon npc(int a)
	{
		// if to see if its npc num 1 
		if (a == 1)
			npc = new ImageIcon("NPC/1_1.png");
		
		// other its gonna b npc num 2 
		else if (a == 2)
			npc = new ImageIcon("NPC/2_1.png");
		
		// then we return the npc image icon 
		return npc;
	}
	
	// this will also the do the same but instead set the npcs x and y values based on which npc and then return the value of the x (get/set)  
	public int npcXPos(int a)
	{
		// if its a it does npc1x, and npc1y 
		if (a == 1)		{
			npcX = npc1X;
			npcY = npc1Y;
		}
		
		// otherwise if its npc 2 then it does npc2x and 2y
		else if (a == 2)	{
			npcX = npc2X;
			npcY = npc2Y;
		}
		
		// which afterwards it returns the npcX position 
		return npcX;
	}
	
	// this is a get method that will get the y position based on which npc similiar to code above
	public int npcYPos(int a)
	{
		if (a == 1)
			npcY = npc1Y;
		else if (a == 2)
			npcY = npc2Y;
		return npcY;
	}
	
	// this will do the same and set the collision mask based on mask 1 or 2. 
	public Rectangle2D npcHitBox(int a, int camX, int camY)
	{
		if (a == 1)
			box = new Rectangle2D.Double(npc1X - camX, npc1Y - camY, npc.getIconWidth(), npc.getIconHeight());
		else if (a == 2)
			box = new Rectangle2D.Double(npc2X - camX, npc2Y - camY, npc.getIconWidth(), npc.getIconHeight());
		return box;
			 
	}
}
