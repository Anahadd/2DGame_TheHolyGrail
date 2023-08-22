import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * CPT NAME: THE HOLY GRAIL 
 * NAMES: ANAHAD & MAIMUR
 * TEACHER: MR. CONWAY 
 * COURSE CODE: ICS3U1
 * DATE: JAN 20 2022
 * BRIEF OVERIEW/OBJECTIVES OF GAME:  In this top-down adventure game, the player takes on the role of a brave warrior on a mission to save the world from a powerful sorcerer who
 * has enslaved the people. The fate of the world rests in the player's hands as they wield weapons to defeat evil monsters and save their fellow humans. The objective of the 
 * game is to embark on a perilous journey through different regions of the world, facing off against various enemies in order to reach the sorcerer's stronghold. Along the way, 
 * the player will encounter NPCs who will give them quests and information about the world and its history. The player's ultimate goal is to defeat the enemies in epic battles 
 * and restore peace to the land. In order to do this, the player will need to defeat various enemies and collect a Holy Grail, which will close a portal and stop the enemies 
 * from capturing the planet. The player will have 3 lives in total and will have to defeat 60 enemies in the first level to advance to the second (and also interact with an NPC). 
 * The enemies in the game include wizards, which shoot fireballs on a random timer and follow the player, and slimes, which follow the player constantly and deal damage. The 
 * player will have access to two weapons: a shuriken, which can be used to kill the wizard by pressing SPACE, and a sword, which can be used by mouse clicking or pressing to 
 * kill slimes/landmines. Throughout the first level, the player will also encounter landmines, which can be removed by the player. Additionally, the player will need to help 
 * out the fellow civilians and wipe all enemies off the planet. In the second level, the player must visit houses to capture The Holy Grail which stops new enemies from 
 * coming in from the PORTAL. This Holy Grail is generated randomly in one of the houses. In this program, we use complex code such as a Camera, Multiple Enemies, 4 Directions, 
 * Displaying HP, etc - which we believe is far greater than the mere average, as it took a lot of time compiling all of this. 
 *  
 *  
 * DETAILS: 
 *  
 * CONTROLS/MOVEMENTS: 
 * 
 * TO MOVE: 
 * W - UP 
 * A - LEFT
 * S - DOWN 
 * D - RIGHT 
 * 
 * TO SHOOT TO KILL WIZARDS: SPACE (RMB SHERIKEN ONLY GOES UP) 
 * TO KILL SLIMES/LANDMINES: MOUSE CLICK WHILE IN ANY DIRECTION 
 * 
 * The health is displayed on top of the respective enemy/player/object in game. 
 * 
 * HOW WE ACHIEVED CERTAIN CONCEPTS AHEAD OF THIS COURSE: 
 * 
 * 1. CAMERA: The Camera is one of the biggest things in this game as it allows for it to have a "professional" feel. This concept was accomplished through YouTube Tutorials and 
 * some guidance from others - as we needed the CameraX, CameraY to set things relative to so it would appear as though the JFrame seems to be moving following the Player. 
 * What is the math behind it? Well, let us take a look. It is mainly accomplished through these main lines of code: 
 * 
 * cameraX = Math.max(0, Math.min(play.getX() - (cameraWidth / 2), background.getIconWidth() - cameraWidth));
 * cameraY = Math.max(0, Math.min(play.getY() - (cameraHeight) / 2, background.getIconHeight() - cameraHeight)); 
 * 
 * EXPLANATION: This code sets the position of a camera in a 2D game. The camera is used to display a portion of the game world on the screen, and this code determines where the 
 * camera should be positioned based on the location of the player character (play) and the size of the background image. The Math.max() and Math.min() functions are used to 
 * constrain the camera's position within the boundaries of the background image. The Math.max() function returns the larger of two values, and the Math.min() function returns 
 * the smaller of two values. cameraX is set to the larger of 0 and the minimum of (play.getX() - (cameraWidth / 2)) and (background.getIconWidth() - cameraWidth) cameraY is 
 * set to the larger of 0 and the minimum of (play.getY() - (cameraHeight) / 2) and (background.getIconHeight() - cameraHeight) For example, if the player's x-coordinate is 
 * 100, the camera width is 200, and the background image width is 800, the camera's x-coordinate would be set to 100 - (200 / 2) = 50. However, if the background image width 
 * is only 600, the camera's x-coordinate would be set to the minimum of 50 and (600 - 200) = 400. In simpler terms, this code sets the position of the camera to be always 
 * centered on the player (play.getX() and play.getY()) but making sure that the camera doesn't go outside the boundaries of the background image (background.getIconWidth() 
 * and background.getIconHeight())
 * 
 * g2.drawImage(background.getImage(), 0, 0, cameraWidth, cameraHeight, cameraX, cameraY, cameraX + cameraWidth, cameraY + cameraHeight, this);
 * ALSO: This code is used to display a portion of an image (background.getImage()) on the screen, by drawing it with a Graphics object (g2). The image is drawn starting at 
 * coordinates (0, 0) with a width and height of cameraWidth and cameraHeight, and is positioned within the camera's viewport (cameraX, cameraY, cameraX + cameraWidth, 
 * cameraY + cameraHeight). The first four parameters passed to the drawImage() method are the source coordinates and dimensions of the image to be drawn. The next four 
 * parameters passed to the drawImage() method are the destination coordinates and dimensions of the image on the screen. In simpler terms, this code takes a part of the 
 * background image, the part that the camera is currently looking at (cameraX, cameraY, cameraWidth and cameraHeight) and draws it on the screen starting at coordinates 
 * (0,0) which is the top left corner of the screen.
 * 
 * LINK(S): 
 * 
 * 2. MULTIPLE ENEMIES: Our game, we created a class called "Enemy" that defined the properties and methods of the enemy, such as position, health, and attack power. 
 * To create multiple enemies, we used a for loop to create instances of the Enemy class. In each iteration of the loop, we assigned a random x and y position to each enemy, 
 * using the Math.random() method. We also stored each enemy object in an array, so that we could easily update and render them on the screen. In the game's update method, 
 * we used another loop to move and render each enemy on the screen, depending on their properties and the players' actions. This allowed us to easily handle the behavior 
 * and interactions of multiple enemies in the game. It's also worth noting that we got this from your notes - but we understand the concept throughly now. 
 * LEVEL 1 OBJECTIVE/RUNDOWN: In the first level of the game, the player will see 3 enemies: Wizards, Landmines, & Slimes. All of which have unique abilities. In this level, 
 * the player must get 60 kills in order to advance to the second level. Wizards die by sherikens, and landmines/slimes die by the sword swings. You may also notice that 
 * this level utilizes the CameraX, and CameraY. Furthermore, there seems to be an infinite amount of enemies coming in - this is done by setting the location of the "same" 
 * enemies to random values within the Frame and resetting the health to make them look like they're spawning isntead of making a spawner. After defeating 60 enemies, the 
 * player must collide with the NPC in order to have a quick chat. The NPC seems to be suspicious of the player and wants to confirm if they're an ally, and prompts them a 
 * JOP question (which checks off some of the requirements). IF correct, it will take the user to the next room which is our (2nd level). 
 * LEVEL 2 OBJECTIVE/RUNDOWN: In this level, you must collect "The Holy Grail" from one of the three abandoned houses (to holy grail is randomly generated in one of those 3) and
 * afterwards return it to the NPC in the corner. In this, you are also being attacked by the same enemies in level 1 and must be careful! After, returning it to the NPC he will 
 * ask you a couple of question to which you answer correctly and then the NPC will prompt the user to the end of the game while also alluding to a sequel. 
 * How we incorporated required concepts in our code: 
 * Input/Output - This concept of asking the user for input and getting output is used in NPC 1 which asks the user for their name and stores it (also using it in the future). 
 * Another example is seen with NPC 2 who asks the user for the code (which is created based on the name) in order to identify if the player is an ally or not, we're outputting
 * results depending on the values as well. 
 * IF Statements - We use a lot of IF Statements in our program. But one of the most important ones occur with the intersections, and checking if the player's intersect the 
 * various masks as there are so many. To see an example, go to line 526. Throughout our code, we've also used IF statements to change masks, to make enemies be located somewhere
 * else, to change masks, to boundary check, to check the movement, etc. These are all examples of IF STATEMENTS. 
 * Random Numbers - We use random numbers to randomly generate the positions of the slimes/wizards/landmines. See Lines 272, 359, etc - as we gen a lot of random values. 
 * FOR LOOP: We use a for loop to create the several objects for each of the following classes - Wizard, Enemy, Fireball, and Mines. This can be seen in the constructor itself
 * WHILE LOOP: We use multiple while loops, one of them being for the JOptionPane as the player continues to answer until they get it right. 3
 * STRING CLASS METHODS: We use the String Methods such as .length and .charAt from the String Class to have the password of the player in our second level. See line 924. 
 * TRY-CATCH: The try catch statement is used to make sure the player doesn't input an invalid input that would crash the program as seen in line 862. 
 * REGULAR EXPRESSIONS: The regex is used in line 843 in order to confirm the player's password. 
 * Arrays: We use multiple arrays for the objects of the multiple enemies seen in line 152, 153, 153, 155, etc. 
 * Self-made method in main: The pause alert method is an example, it is a void and it is used to move all the enemies locations and masks off the screen and to locations of 10000. 
 * It is invoked 3 times. 
 * 1 Additional Class is the Enemy Class which is used to spawn the enemies such as the slime. 
 * JOptionPane Class is used with both of the NPCS in level 1/2.  
 * We use Jframes/animations throughout the game (with our player etc etc) 
 * Collsion Detection is being used throughout the game with the sword, the masks of all the enemies, etc. 
 */

public class Level extends JPanel implements ActionListener, KeyListener, MouseListener
{
	
	/*
	 * This is our fields which we use in the program. This includes values such as our Timers, our Boolean expressions, our Positions, etc. We set some of these values here, 
	 * although we can do that in the constructor. 
	 */
	
	private Timer t, idle, walk, hit, resetAttack, expHit, wizardAttack;
	private Player play;
	private interact item;
	private boolean left = false, right = false, up = false, down = false, cool_down = true, mineHit = false, done = false, slimeHit = false;
	private boolean isMoving = false, hasItem = false, questionSet1 = true, isFiredU = false;
	private int cameraX, cameraY, cameraWidth, cameraHeight, npcCount = 1, textboxCount = 1;
	private int killCount = 0, currentEvent = 1, scene = 1, goldNuggetRoom, goldX, goldY;
	private Rectangle2D bgColor, blackRec, greenRec, playerHit, mineCheck, expCheck, swordR, swordL, swordU, shriken, swordD, slimeHealth, eventMask1, zone1, zone2, zone3, zone4, zone5, zone6, goldNugget;
	private Ellipse2D[] wizRadius, fireballMask;
	private boolean text = false, mainMenuScreen = true;
	private ImageIcon swordRight, swordLeft, swordUp, swordDown, enemySlime, death, mine, exp, gameOver, gold, wiz, projectile; 
	private boolean attackR, attackD, attackL, attackU; 
	private int HP, bullXU, bullYU, bullXD, bullYD; 
	private Enemy[] enemy;
	private mines[] mineArr;
	private fireball[] wizFire;
	private Timer[] wizRandomAt; 
	private wiz[] wizards; 
	private Rectangle2D[] masks, hpMask, backhp, mineMask, hpMine, backMine, wizMask, wizHp, wizBgHp;
	private Random rand;
	private int enemyKills, index; 
	private ImageIcon background, mainMenu;
	
	public static void main(String[] args)
	{
		// Calls Constructor
		new Level();
	}

	public Level()
	{	
		// these are the object for the classes which runs their constructor consequently 
		play = new Player(); 
		rand = new Random();
		item = new interact();

		// this sets all of the attacking values to false as we use this boolean expression to animate the swords 
		attackR = false; attackD = false; attackL = false; attackU = false;  

		// the bullet x and y positions are called this as they bullet shoots up, we're also setting them to 0 along with the enemy kills 
		bullXU = 0; bullYU = 0; bullXD = 0; bullYD = 0; enemyKills = 0; 

		// this is our camera attributes and how big our camera is 
		cameraX = 800; cameraY = 900; cameraWidth = 1000; cameraHeight = 800; 
		
		// this is where the holy grail is being set (in the constructor as a temporary storage) 
		goldX = -100;
		goldY = -100;

		// this sets the player's HP to 40 as we need it to draw the hp of the player 
		HP = 40; 
		
		// this random value will determine which room the golden nugget is in as they're 4 options 
		goldNuggetRoom = (int)(Math.random()*3+3);
		
		// these essentially just set the masks to random values as we're just init them 
		bgColor = new Rectangle2D.Double(0, 0, 2000, 2000); 
		blackRec = new Rectangle2D.Double(0, 0, 40, 40); 
		greenRec = new Rectangle2D.Double(0, 0, HP, 40); 
		playerHit = new Rectangle2D.Double(0, 0, play.getImage().getIconWidth(), play.getImage().getIconHeight()); 
		expCheck = new Rectangle2D.Double(0, 0, 0, 0);
		swordR = new Rectangle2D.Double(0, 0, 0, 0); 
		swordD = new Rectangle2D.Double(0, 0, 0, 0); 
		swordU = new Rectangle2D.Double(0, 0, 0, 0); 
		swordL = new Rectangle2D.Double(0, 0, 0, 0); 
		eventMask1 = new Rectangle2D.Double(720 - cameraX, 1350 - cameraY, 64, 16);
		zone1 = new Rectangle2D.Double(0, 0, 0, 0);
		zone2 = new Rectangle2D.Double(0, 0, 0, 0);
		zone4 = new Rectangle2D.Double(0, 0, 0, 0);
		zone5 = new Rectangle2D.Double(0, 0, 0, 0);
		zone6 = new Rectangle2D.Double(0, 0, 0, 0);
		goldNugget = new Rectangle2D.Double(0, 0, 0, 0);
		shriken = new Rectangle2D.Double(0, 0, 0, 0); 
		
		// this is used in order to make sure our events are being heard 
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();

		// the following are used to set the image icons respective to the values ex. background is the background of the level. 
		background = new ImageIcon("Map/game"+scene+".png");
		swordRight = new ImageIcon("swordRIGHT.gif"); 
		swordLeft = new ImageIcon("swordLEFT.gif");
		swordUp = new ImageIcon("swordUP.gif"); 
		swordDown = new ImageIcon("swordDOWN.gif"); 
		enemySlime = new ImageIcon("ffd111449ac7168 (1) (1).gif");
		death = new ImageIcon("skullgif.gif"); 
		mine = new ImageIcon("R__1_-removebg-preview.png"); 
		exp = new ImageIcon("giphy.gif"); 
		gameOver = new ImageIcon("Untitled design.png"); 
		projectile = new ImageIcon("unnamed-removebg-preview (1).png"); 
		gold = new ImageIcon("NPC/gold.png");
		mainMenu = new ImageIcon("Purple Neon Game Presentations (7).gif"); 

		// this is used to create our jframe and assign it unique properities such as its size, relativity, title, etc. 
		JFrame frame = new JFrame();
		frame.setContentPane(this);
		frame.setSize(1000, 800);
		frame.setTitle("The Holy Grail!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		setLayout(null);

		// this init our timers that we use in our game, some of which control actions such as the explosions, walking animation, idling animation, etc. 
		t = new Timer(16, this);
		idle = new Timer(3000, this);
		walk = new Timer(128, this);
		hit = new Timer(1250, this); 
		expHit = new Timer(1000, this); 
		resetAttack = new Timer(300, this); 
		wizardAttack = new Timer(3000, this);


		// the following include the arrays for the several objects in our game such as our slimes, wizards, and landmines. 
		enemy = new Enemy[6];
		masks = new Rectangle2D[6]; 
		hpMask = new Rectangle2D[6];
		backhp = new Rectangle2D[6];
		mineMask = new Rectangle2D[6]; 
		hpMine = new Rectangle2D[6]; 		
		backMine = new Rectangle2D[6];
		mineArr = new mines[6]; 
		
		wizards = new wiz[4]; 
		wizMask = new Rectangle2D[4]; 
		wizRadius = new Ellipse2D[4]; 
		wizFire = new fireball[4]; 
		fireballMask = new Ellipse2D[4]; 
		wizRandomAt = new Timer[4];
		wizHp = new Rectangle2D[4]; 
		wizBgHp = new Rectangle2D[4]; 
		

		// this for loop will set the values for the respective masks and the enemies
		for (int i = 0; i < enemy.length; i++)
		{
			enemy[i] = new Enemy();
			
			// sets the enemies random location 
			enemy[i].setLocation(rand.nextInt(600) + 300, rand.nextInt(900) + 300);
			
			// sets the mask location to the enemy 
			masks[i] = enemy[i].mask(cameraX, cameraY);
			
			// sets the hp/bghp to the enemy
			hpMask[i] = enemy[i].hp(cameraX, cameraY); 
			backhp[i] = enemy[i].bg(cameraX, cameraY); 
		}
		
		// this also does the same above but for the land mines 
		for (int k = 0; k < mineArr.length; k++) {
			
			mineArr[k] = new mines(); 
			mineArr[k].setLocation(rand.nextInt(1000) + 300, rand.nextInt(1000) + 500); 
			mineMask[k] = mineArr[k].returnMask(cameraX, cameraY); 
			hpMine[k] = mineArr[k].hp(cameraX, cameraY);
			backMine[k] = mineArr[k].hp(cameraX, cameraY); 	
		}
		
		// this also does the same but for the wizards 
		for (int k = 0; k < wizards.length; k++) {

			wizards[k] = new wiz(); 
			wizards[k].setLocation(rand.nextInt(600) + 300, rand.nextInt(900) + 300); 
			wizMask[k] = wizards[k].returnMask(cameraX, cameraY); 
			wizRadius[k] = wizards[k].returnRadius(cameraX, cameraY); 

			wizFire[k] = new fireball(); 
			
			// this sets the wizards fireball's location to 10000 10000
			wizFire[k].setLocation(10000, 10000); 
			
			// this will return the mask of the fireball 
			fireballMask[k] = wizFire[k].returnMask(cameraX, cameraY); 

			// this will set the hp/bghp relative to the wizard
			wizHp[k] = wizards[k].hp(cameraX, cameraY); 
			wizBgHp[k] = wizards[k].bg(cameraX, cameraY); 

			// we created a timer class as we wanted the wizards to shoot at different times 
			wizRandomAt[k] = new Timer(k * 2000, this);
			wizRandomAt[k].start();
		}
	
		
		t.start();
		idle.start();
		walk.start();
	}

	public void actionPerformed(ActionEvent e) 
	{
		

		if (e.getSource() == t) {

			if (left && play.getX() > 0)
				isMoving = play.move(0);
			else if (right && play.getX() + play.getImage().getIconWidth() <= background.getIconWidth())
				isMoving = play.move(1);
			else if (up && play.getY() > 0)
				isMoving = play.move(2);
			else if (down && play.getY() + play.getImage().getIconHeight() <= background.getIconHeight())
				isMoving = play.move(3);
			else
				isMoving = false;

			cameraX = Math.max(0, Math.min(play.getX() - (cameraWidth / 2), background.getIconWidth() - cameraWidth));
			cameraY = Math.max(0, Math.min(play.getY() - (cameraHeight) / 2, background.getIconHeight() - cameraHeight));


			shriken = new Rectangle2D.Double(bullXU - cameraX, bullYU - cameraY, projectile.getIconWidth(), projectile.getIconHeight());

			if (isFiredU) {

				bullYU -= 5; 

				
				if (bullYU < 0) {
					isFiredU = false; 
				}
				
			}
		
			// update direction of enemies as well as masks/hp displays
			for (int i = 0; i < enemy.length; i++)
			{
				if (play.getX() < enemy[i].getX())
				{
					enemy[i].setX("LEFT"); 
				}

				if (play.getX() > enemy[i].getX()) {
					enemy[i].setX("RIGHT");
				}
				if (play.getY() < enemy[i].getY()) {
					enemy[i].setY("UP");
				}

				if (play.getY() > enemy[i].getY()) {
					enemy[i].setY("DOWN"); 
				}

				if (enemy[i].enemyHealth() > 0) 
				{					
					masks[i] = enemy[i].mask(cameraX, cameraY);
					hpMask[i] = enemy[i].hp(cameraX, cameraY);
					backhp[i] = enemy[i].bg(cameraX, cameraY); 
				}
				else 
				{
					enemy[i].resetH(); 
					enemy[i].setLocation(rand.nextInt(1000) + 800, rand.nextInt(1000) + 800);	
					enemyKills++; 
				}

				if (playerHit.intersects(masks[i])) {
					slimeHit = true;
					hit.start();
				}
			}
			
		
			for (int i = 0; i < wizards.length; i++) {

				wizRadius[i] = wizards[i].returnRadius(cameraX, cameraY); 
				wizMask[i] = wizards[i].returnMask(cameraX, cameraY); 

				if (wizRadius[i].intersects(playerHit)) {
					wizards[i].followPlayer(play.getX() - rand.nextInt(25), play.getY() - rand.nextInt(200) - 200); 
				}

	
			}

			for (int i = 0; i < wizards.length; i++) { 

				if (shriken.intersects(wizMask[i])) {
					wizards[i].decreaseHealth();  
				}
				
				wizHp[i] = wizards[i].hp(cameraX - 12, cameraY + 15);
				wizBgHp[i] = wizards[i].bg(cameraX - 12, cameraY + 15);
				
				if (fireballMask[i].intersects(playerHit)) {
					HP -= 9; 
					wizFire[i].setLocation(5000, 5000); 
					fireballMask[i] = wizFire[i].returnMask(100000, 100000); 
				}

				if (shriken.intersects(wizMask[i])) {
					wizards[i].decreaseHealth();  
				}
				
				wizHp[i] = wizards[i].hp(cameraX - 12, cameraY + 15);
				wizBgHp[i] = wizards[i].bg(cameraX - 12, cameraY + 15); 

			}
			
			for (int i = 0; i < wizards.length; i++) {
				if (wizards[i].health() > 0) 
				{					
					wizMask[i] = wizards[i].returnMask(cameraX, cameraY);
					wizHp[i] = wizards[i].hp(cameraX, cameraY);
					wizBgHp[i] = wizards[i].bg(cameraX, cameraY); 
				}
				else 
				{
					wizards[i].resetH(); 
					wizards[i].setLocation(rand.nextInt(700), rand.nextInt(500));	
					enemyKills++; 
				}
			}
			
			if (enemyKills >= 4 && currentEvent == 1)
			{	
				textboxCount = 3;
				currentEvent = 2;
			}
			else if (hasItem)
			{
				currentEvent = 4;
				goldX = -6;
				goldY = -6;
			}

			// update mask of mines 
			for (int k = 0; k < mineArr.length; k++) {

				if (mineArr[k].health() > 0) {
					mineMask[k] = mineArr[k].returnMask(cameraX, cameraY); 
					hpMine[k] = mineArr[k].hp(cameraX, cameraY);
					backMine[k] = mineArr[k].bg(cameraX, cameraY); 
				}
				else {
					mineMask[k] = mineArr[k].returnMask(100000, 100000); 
					hpMine[k] = mineArr[k].hp(100000, 100000);
					backMine[k] = mineArr[k].bg(100000, 100000); 
					
				}

				// checks for collision with mask 
				if (playerHit.intersects(mineMask[k])) {

					// sets mine to explosion 
					mineArr[k].setImageExplosion();
					hpMine[k] = mineArr[k].hp(100000, 100000);
					backMine[k] = mineArr[k].bg(100000, 100000); 
					mineHit = true; 
					index = k; 
					expHit.start();
				}

				if (swordU.intersects(mineMask[k]) || swordD.intersects(mineMask[k]) || swordL.intersects(mineMask[k]) || swordR.intersects(mineMask[k])) 
				{
					// decreases mine health 
					mineArr[k].decreaseHealth(); 

					if (mineArr[k].health() <= 0) {
						mineArr[k].setLocation(10000, 10000);
					}
				}
			}
			
			if (playerHit.intersects(eventMask1) && killCount <= 60 && currentEvent == 1)
			{
				down = false;
				play.setY(1300);
			}
			
			if (scene == 2)
			{	
				zone1 = new Rectangle2D.Double(326 - cameraX, 369, 16, 16);
				zone2 = new Rectangle2D.Double(902 - cameraX, 369, 16, 16);
				zone3 = new Rectangle2D.Double(1475 - cameraX, 369, 16, 16);
				
				goldX = -100;
				goldY = -100;
				
				if (playerHit.intersects(zone1))
				{
					scene = 3;
					background = new ImageIcon("Map/game"+scene+".png");
					
					play.setX(450);
					play.setY(600);
					
					pauseAlert();
					zone4 = new Rectangle2D.Double(450, 690, 48, 48);
					
				}
				else if (playerHit.intersects(zone2))
				{
					scene = 4;
					background = new ImageIcon("Map/game"+scene+".png");
					
					play.setX(500);
					play.setY(650);
					
					pauseAlert();
					zone5 = new Rectangle2D.Double(500, 680, 48, 48);
				}
				else if (playerHit.intersects(zone3))
				{	
					scene = 5;
					background = new ImageIcon("Map/game"+scene+".png");
					
					play.setX(500);
					play.setY(620);
					
					pauseAlert();
					zone6 = new Rectangle2D.Double(500, 670, 48, 48);
				}
			}
			
			if (scene == 3)
			{	
				if (playerHit.intersects(zone4))
				{
					System.out.println("HIT");
					scene = 2;
					background = new ImageIcon("Map/game"+scene+".png");
					zone4 = new Rectangle2D.Double(0, 0, 0, 0);
					play.setX(326);
					play.setY(389);
				}
				if (scene == goldNuggetRoom)	{
					goldX = 720;
					goldY = 650;
					
					goldNugget = new Rectangle2D.Double(720 - cameraX, 650 - cameraY, gold.getIconWidth(), gold.getIconHeight());
				}
			}
			else if (scene == 4)
			{
				if (playerHit.intersects(zone5))
				{	
					scene = 2;
					background = new ImageIcon("Map/game"+scene+".png");
					zone5 = new Rectangle.Double(0, 0, 0, 0);
					play.setX(902);
					play.setY(389);
				}
				if (scene == goldNuggetRoom)	{
					goldX = 720;
					goldY = 300;
					
					goldNugget = new Rectangle2D.Double(720 - cameraX, 300 - cameraY, 48, 48);
				}	
			}
			else if (scene == 5)
			{
				if (playerHit.intersects(zone6))
				{
					scene = 2;
					background = new ImageIcon("Map/game"+scene+".png");
					zone6 = new Rectangle.Double(0, 0, 0, 0);
					play.setX(1475);
					play.setY(400);
				}
				if (scene == goldNuggetRoom)	{
					goldX = 317;
					goldY = 247;
					
					goldNugget = new Rectangle2D.Double(317 - cameraX, 247 - cameraY, 48, 48);
				}	
			}
		}
		if (playerHit.intersects(goldNugget))
		{
			goldX = -100;
			goldY = -100;
			hasItem = true;
			textboxCount = 9;
		}
		else if (e.getSource() == idle)	{
			if (!isMoving)
				play.idle();
			else
				play.walk();

		}
		else if (e.getSource() == walk)	{
			if (isMoving)
				play.walk();
			else
				play.resetPos(false);
		}

		if (attackR) {
			swordR = new Rectangle2D.Double(play.getX() - cameraX + 45, play.getY() - cameraY, 50, 75); 
		}
		else {
			swordR = new Rectangle2D.Double(0, 0, 0, 0); 
		}

		if (attackL) {
			swordL = new Rectangle2D.Double(play.getX() - cameraX - 45, play.getY() - cameraY, 50, 75); 
		}
		else {
			swordL = new Rectangle2D.Double(0, 0, 0, 0); 
		}

		if (attackD) {
			swordD = new Rectangle2D.Double(play.getX() - cameraX, play.getY() - cameraY + 50, 50, 75); 
		}
		else {
			swordD = new Rectangle2D.Double(0, 0, 0, 0); 
		}

		if (attackU) {
			swordU = new Rectangle2D.Double(play.getX() - cameraX, play.getY() - cameraY - 50, 50, 75); 
		}
		else {
			swordU = new Rectangle2D.Double(0, 0, 0, 0); 
		}

		if (e.getSource() == hit) {

			for (int k = 0; k < mineMask.length; k++) {
				if (playerHit.intersects(masks[k])) {
					HP -= 3; 
					hit.stop(); 
				}
			}
		}
		if (e.getSource() == resetAttack) {
			attackR = false; attackL = false; attackU = false; attackD = false; 
			resetAttack.stop();
		}


		if (e.getSource() == expHit) { 

			if (mineHit) {

				if (playerHit.intersects(mineMask[index])) {
					HP -= 7.5; 
					mineHit = false;
				}
				
				mineArr[index].setLocation(10000, 10000);
				mineMask[index] = mineArr[index].returnMask(100000, 100000); 

			}
			
			
			
			expHit.stop();
		

		}
		
		for (int i = 0; i < wizards.length; i++) { 

			// error seems to be that wizRandomAt is not even running for some reason?? 
			if (e.getSource() == (wizRandomAt[i])) { 
				wizFire[i].setLocation(wizards[i].getX(), wizards[i].getY()); 

			}
			
			wizFire[i].moveDown();
			fireballMask[i] = wizFire[i].returnMask(cameraX, cameraY); 

			if (fireballMask[i].intersects(playerHit)) {
				HP -= 9; 
				wizFire[i].setLocation(5000, 5000); 
				fireballMask[i] = wizFire[i].returnMask(100000, 100000); 
			}
		}

		repaint();
	}	
	public void pauseAlert() {
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].setLocation(10000, 10000); 
			masks[i] = enemy[i].mask(10000, 10000);
			hpMask[i] = enemy[i].hp(100000, 10000);
			backhp[i] = enemy[i].bg(100000, 10000);
			
			mineArr[i] = new mines();
			mineArr[i].setLocation(100000, 100000);
			mineMask[i] = mineArr[i].returnMask(10000, 100000);
			hpMine[i] = mineArr[i].hp(100000, 100000);
			backMine[i] = mineArr[i].hp(100000, 100000);
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = true;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			right = true;
		else if (e.getKeyCode() == KeyEvent.VK_W)
			up = true;
		else if (e.getKeyCode() == KeyEvent.VK_S)	
			down = true;
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			if (isFiredU == false) {

				bullXU = play.getX() + 15; 
				bullYU = play.getY();

				isFiredU = true; 
			} 
		}

	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = false;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			right = false;
		else if (e.getKeyCode() == KeyEvent.VK_W)
			up = false;
		else if (e.getKeyCode() == KeyEvent.VK_S)
			down = false;

		play.resetPos(true);
	}


	public void mouseClicked(MouseEvent e) {

		if (isMoving == false) {

			if (play.returnDir() == "RIGHT" && attackR == false) {
				attackR = true; 
			}
			else if (play.returnDir() == "LEFT" && attackL == false) {
				attackL = true; 
			}
			else if (play.returnDir() == "UP" && attackU == false) {
				attackU = true; 
			}
			else if (play.returnDir() == "DOWN" && attackD == false){
				attackD = true; 
			}
		}
		
		resetAttack.start();
		
		if (text)
		{
			textboxCount++;
		}
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseReleased(MouseEvent e) {
		swordR = new Rectangle2D.Double(10000 - cameraX, 10000 - cameraY, 0, 0); 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void paint(Graphics g)
	{

		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(new Color(50, 50, 50));
		g2.fill(bgColor);

		
		
		
		if (HP > 0) {
			g2.drawImage(background.getImage(), 0, 0, cameraWidth, cameraHeight, cameraX, cameraY, cameraX + cameraWidth, cameraY + cameraHeight, this);

			playerHit = new Rectangle2D.Double(play.getX() - cameraX, play.getY() - cameraY, play.getImage().getIconWidth(), play.getImage().getIconHeight()); 
			g2.drawImage(play.getImage().getImage(), play.getX() - cameraX, play.getY() - cameraY, this); 

			// Set the font
			Font f = new Font("Serif", Font.BOLD, 12);
			g2.setFont(f);

			g2.drawString("KILLS: " + enemyKills, play.getX() - cameraX, play.getY() - cameraY - 18); 

			if (attackR) {
				g2.drawImage(swordRight.getImage(), play.getX() - cameraX + 10, play.getY() - cameraY, this); 
			}
			else if (attackL) {
				g2.drawImage(swordLeft.getImage(), play.getX() - cameraX - 75, play.getY() - cameraY - 10, this);
			}
			else if (attackD) {
				g2.drawImage(swordDown.getImage(), play.getX() - cameraX, play.getY() - cameraY + 15, this);
			}
			else if (attackU) {
				g2.drawImage(swordUp.getImage(), play.getX() - cameraX, play.getY() - cameraY - 55, this);
			}

			for (int i = 0; i < enemy.length; i++)
			{

				if (enemy[i].enemyHealth() > 0) {
					g2.drawImage(enemy[i].getImg().getImage(), enemy[i].getX() - cameraX, enemy[i].getY() - cameraY, this);

				}	
			}

			for (int i = 0; i < mineArr.length; i++) {
				g2.drawImage(mineArr[i].getImg().getImage(), mineArr[i].getX() - cameraX, mineArr[i].getY() - cameraY, this);
			}


			for (int i = 0; i < enemy.length; i++)
			{

				g2.setColor(new Color(50, 50, 50));
				blackRec = new Rectangle2D.Double(play.getX() - cameraX + 5, play.getY() - cameraY - 15, 40, 10); 
				g2.fill(blackRec);
				g2.setColor(new Color(0, 255, 0));
				greenRec = new Rectangle2D.Double(play.getX() - cameraX + 5, play.getY() - cameraY - 15, HP, 10); 
				g2.fill(greenRec);


				if (swordR.intersects(masks[i]) || swordL.intersects(masks[i]) || swordU.intersects(masks[i]) || swordD.intersects(masks[i])) {
					enemy[i].decreaseHealth(); 
				}

				g2.setColor(new Color(50, 50, 50));
				g2.fill(backhp[i]);
				g2.fill(backMine[i]);

				g2.setColor(new Color(0, 255, 0));
				g2.fill(hpMask[i]);
				g2.fill(hpMine[i]);

			}
			for (int i = 0; i < wizards.length; i++) {
				g2.drawImage(wizards[i].getImg().getImage(), wizards[i].getX() - cameraX, wizards[i].getY() - cameraY, this);

				g2.fill(wizHp[i]); 
				g2.fill(wizBgHp[i]);
			}

			for (int i = 0; i < wizFire.length; i++) { 
				g2.drawImage(wizFire[i].getImg().getImage(), wizFire[i].getX() - cameraX, wizFire[i].getY() - cameraY, this); 
			
			}

			if (isFiredU) {
				g2.drawImage(projectile.getImage(), bullXU - cameraX, bullYU - cameraY, this); 
			}
			

		}
		else {

			// we can add a restart button here. 
			g2.drawImage(gameOver.getImage(), 0, 0, this);

		}

		if (playerHit.intersects(item.npcHitBox(npcCount, cameraX, cameraY)) && (currentEvent == 1 || currentEvent == 2))
		{
			if (currentEvent == 1)
			{
				g2.drawImage(item.textBox(textboxCount).getImage(), this.getWidth()/2 - cameraX, 1200 - cameraY, this);
				text = true;
				t.stop(); idle.stop(); walk.stop(); hit.stop(); resetAttack.stop(); expHit.stop();
				if (textboxCount > 2)
				{	
					text = false;
					t.start(); idle.start(); walk.start(); hit.start(); resetAttack.start(); expHit.start();
				}	
			}
			else if (currentEvent == 2)
			{
				g2.drawImage(item.textBox(textboxCount).getImage(), this.getWidth()/2 - cameraX, 1200 - cameraY, this);
				text = true;
				t.stop(); idle.stop(); walk.stop(); hit.stop(); resetAttack.stop(); expHit.stop();
				if (textboxCount > 4)
				{	
					text = false;
					
					int score = 0;
					String answer;
//					while (true)
//					{
					if (questionSet1)
					{	
						questionSet1 = false;
						answer = JOptionPane.showInputDialog(null, "__", "Quiz!", JOptionPane.QUESTION_MESSAGE); 
						
						textboxCount = 6;
						scene = 2;
						npcCount = 2;
						currentEvent = 3;
						background = new ImageIcon("Map/game"+scene+".png");
						t.start(); idle.start(); walk.start(); hit.start(); resetAttack.start(); expHit.start();
						play.setY(this.getHeight() / 2);
						
					}
					
					//JOPtionpane, regex, string class, while loop
					
				}
				else
					System.out.println("hits");
			}
				
		}
		else if (playerHit.intersects(item.npcHitBox(npcCount, cameraX, cameraY)) && scene == 2 )	{
			if (currentEvent == 3)	{
				text = true;
				g2.drawImage(item.textBox(textboxCount).getImage(), 245, 630, this);
				t.stop(); idle.stop(); walk.stop(); hit.stop(); resetAttack.stop(); expHit.stop();
				if (textboxCount > 8)	{
					text = false;
					currentEvent = 4;
					t.start(); idle.start(); walk.start(); hit.start(); resetAttack.start(); expHit.start();
				}
			}
			else if (scene == 2 && hasItem) {
				text = true;
				g2.drawImage(item.textBox(textboxCount).getImage(), 245, 630, this);
				t.stop(); idle.stop(); walk.stop(); hit.stop(); resetAttack.stop(); expHit.stop();
				if (textboxCount > 10)	{
					text = false;
					t.start(); idle.start(); walk.start(); hit.start(); resetAttack.start(); expHit.start();
				}
			}
		}
		if (!(scene == 3  || scene == 4 || scene == 5))
			g2.drawImage(item.npc(npcCount).getImage(), item.npcXPos(npcCount) - cameraX, item.npcYPos(npcCount) - cameraY, this);
		else
			g2.drawImage(item.npc(npcCount).getImage(), -100, -1, this);
		
		if (!hasItem)
			g2.drawImage(gold.getImage(), goldX - cameraX, goldY - cameraY, this);
		
		g2.fill(zone1);
		g2.fill(zone2);
		g2.fill(zone4);
		eventMask1 = new Rectangle2D.Double(720 - cameraX, 1360 - cameraY, 64, 16);
		g2.fill(eventMask1);
//		g2.fill(goldNugget);

		
		
	}

}
