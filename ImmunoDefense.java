
//Audrey Cui
//ImmunoDefense.java

//ImmunoDefense is a tower defense type of game
//The objective is protect the person from invading bacteria by strategically placing WBCs along the track 
import java.awt.*; 		 

import javax.swing.*;

import java.awt.event.*;    import java.awt.geom.Ellipse2D;

import javax.swing.event.*;
public class ImmunoDefense extends JFrame //the frame for the menu
{
    static JFrame frame;
    public static void main (String [] args) //this is the main
    {
   	 ImmunoDefense mango = new ImmunoDefense();
    }
    
    public ImmunoDefense ()  //the constructor
    {
    	
    	//creates the frame
   	 frame = new JFrame("ImmunoDefense");
   	 frame.setSize( 300, 500 );
   	 frame.setLocation ( 50, 50 );
   	 frame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
   	 frame.setResizable( false );
   	 Menu welcome = new Menu();
   	 frame.add(welcome);
   	 frame.setVisible( true );
    }
    class Menu extends JPanel implements MouseListener
    {
    	//The menu contains two buttons: start, background information.
        Rectangle startRect, instRect;
        Color buttonColor;
        Font theFont;
        Image titlepic, billy;
        Timer titleTimer;
        int billyX1, billyY1, billyX2, billyY2;
        public Menu() //the constructor
        {
        	billyX1= billyY1 = billyX2= billyY2 = 0;
        	billyX1=50;
        	billyX2= 200;
        	buttonColor = new Color(200, 200, 220);
        	startRect = new Rectangle (20, 270, 260, 75);
        	instRect = new Rectangle (20, 370, 260, 75);
        	theFont = new Font("Serif", Font.BOLD, 30);
    		 titlepic = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/titlepic.gif").getImage();
    		 billy = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/billybacteria.gif").getImage();
    		 
    		 titleMover tm = new titleMover();
    		 titleTimer = new Timer (3, tm);
    		 titleTimer.start();
    		 addMouseListener(this);
       //	 ImmunoDefense.frame.getContentPane().add(east, BorderLayout.EAST);
        }
        
        public void paintComponent (Graphics h) //paintcomponent for the menu
        {
        	super.paintComponent(h);
        	setBackground(Color.gray);
        	h.drawImage(billy, billyX1, billyY1, 30, 30, null);
        	h.drawImage(billy, billyX2, billyY2, 30, 30, null);
        	h.setColor(buttonColor);
        	h.fillRect(20, 270, 260, 75);
        	h.fillRect(20, 370, 260, 75);
        	h.setFont(theFont);
        	h.setColor(Color.gray);
        	h.drawString("Start!", 110,  315);
        	h.drawString("How to Play", 70, 415);
        	h.drawImage(titlepic, 20, 20, 300, 200, null);
        	
        }
        
        class titleMover implements ActionListener //animates the bacteria on the menu page
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		if (billyY1<250) billyY2 = billyY1+250;
        		if (billyY1>500)
        		{
        			billyY1=0;
        			billyX1=(int)((Math.random()*150)+0);
        		}
        		if (billyY2>500)
        		{
        			billyY2=0;
        			billyX2=(int)((Math.random()*150)+150);
        		}
        		billyY1++;
        		billyY2++;
        		repaint();
        	}
        	
        }
        public void mouseClicked(MouseEvent e) //mouseClicked method, checks to see if the start button or the instructions button is pressed
        {
        	if (startRect.contains(e.getX(), e.getY()))
        	{
        		chooseTrack papaya = new chooseTrack();
        		titleTimer.stop();
        		frame.setVisible(false);
        	}
        	else if (instRect.contains(e.getX(), e.getY()))
        	{
        		instListener grape = new instListener();
        		titleTimer.stop();
        		frame.setVisible(false);
        	}
        }
        
        //unused MouseListener methods
        public void mouseEntered (MouseEvent e){}
        public void mouseExited (MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        
        class instListener extends JFrame 
        {   
        	//shows the frame with the background information on each of the immune cells
        	//actionlistener for the background info button
       	 JFrame inst;
       	 JPanel howToPlay;
       	 Color pink;
       	 Font font;
       	 JButton next1, next2, next3;
       	 public instListener()//when the bg info button is pressed, the info is displayed
       	 {
       		 pink = new Color(250, 150, 150);
       		 font = new Font("Serif", Font.BOLD, 30);
       		 
       		 inst = new JFrame ("ImmunoDefense How To Play");
       		 inst.setSize( 400, 600 );
       		 inst.setLocation ( 50, 50 );
       		 inst.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
       		 inst.setResizable( true );
       		 HowToPlay howto = new HowToPlay();
       		 inst.add(howto);
       		 
       		
       		inst.setVisible(true);
       	 }
       	 
       	 class HowToPlay extends JPanel implements MouseListener //displays the instructions on how to play
       	 {
       		 JButton next1;
       		 Image instScreenShot;
       		 Rectangle backButt;
       		 public HowToPlay()
       		 {
       		   	  instScreenShot = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/Instructions2.png").getImage();
       		   	  backButt = new Rectangle(10, 5, 75, 25);
       		   	  addMouseListener(this);
       		 }
       		 
       		 public void paintComponent(Graphics g) //paintcomponent for the class HowToPlay
       		 {
       			 super.paintComponent(g);
       			 g.drawImage(instScreenShot, 0, 0, 400, 580, null);
       			 g.setColor(new Color(200, 200, 220));
       			 g.fillRect(10, 5, 75, 25);
       			 g.setColor(Color.gray);
       			 g.setFont(new Font("Serif", Font.BOLD, 20));
       			 g.drawString("Back", 25, 25);
       		 }
       		 public void mouseClicked (MouseEvent e)
       		 {
       			 if (backButt.contains(e.getX(), e.getY())) 
       				 {
       				 	ImmunoDefense id = new ImmunoDefense();
       				 	inst.setVisible(false);
       				 }
       		 }
             public void mouseEntered (MouseEvent e){}
             public void mouseExited (MouseEvent e){}
             public void mouseReleased(MouseEvent e){}
             public void mousePressed(MouseEvent e){}
       	 }
       	
        }
        
    }
}

class chooseTrack extends JFrame //frame for choosing the track
{
	JFrame chooseFrame;
	public chooseTrack()
	{
		chooseFrame = new JFrame ("Choose a track");
		chooseFrame.setSize(600, 400);
		chooseFrame.setLocation(50, 50);
		chooseFrame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		chooseFrame.setResizable( true );
	   	 choosePan pineapple = new choosePan();
	   	chooseFrame.add(pineapple);
	   	chooseFrame.setVisible( true );
	}
	
	class choosePan extends JPanel implements MouseListener //panel that gives the player a brief intro and lets them choose the track
	{
		Color bgColor, bloodVesselColor;
		Rectangle rect1, rect2;
		Image track1, track2;
		public choosePan() //the constructor
		{
	   	 	bgColor = new Color(255, 192, 200);
	   	 	bloodVesselColor = new Color(192, 5, 23);
	   	 	rect1 = new Rectangle(75, 185, 175, 175);
	   	 	rect2 = new Rectangle(350, 185, 175, 175);
	    	track1 = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/track1.png").getImage();
	    	track2 = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/track2.png").getImage();
			addMouseListener(this);
		}
		
		public void paintComponent (Graphics g)  //the paintcomponent
		{
			super.paintComponent(g);
			setBackground(new Color(200, 200, 220));
			g.setColor(Color.gray);
			g.setFont(new Font("Serif", Font.BOLD, 15));
			g.drawString("You are an MVHS teacher. When you are handing out your dreaded tests, some kid pulls ", 10, 20);
			g.drawString("the paper from your hand too quickly. You yell, NO CURVE FOR YOU before realizing", 10, 40);
			g.drawString("that you got a paper cut. For some reason, that paper is harboring the potentially lethal", 10, 60);
			g.drawString("bacteria", 10, 80);
			g.setFont(new Font("Serif", Font.ITALIC, 15));
			g.drawString("Billy bufandis", 70, 80);
			g.setFont(new Font("Serif", Font.BOLD, 15));
			g.drawString(", which invades your blood stream. Thank goodness you've got", 155, 80);
			g.drawString("your immune system.", 10, 100);
			
			g.setFont(new Font("Serif", Font.BOLD, 20));
			g.drawString("Select a track to begin!", 10, 150);

			g.drawImage(track1, 75, 185, 175, 175, null);
			g.drawImage(track2, 350, 185, 175, 175, null);
			g.setColor(Color.gray);
			g.drawRect(75, 185, 175, 175);
			g.drawRect(350, 185, 175, 175);
		}
		
		public void mouseClicked(MouseEvent e) //depending on which track the user
		{
			if (rect1.contains(e.getX(), e.getY())) 
			{
				game gm = new game(1); 
				chooseFrame.setVisible(false);
			}
			else if (rect2.contains(e.getX(), e.getY())) 
			{
				game gm= new game(2);
				chooseFrame.setVisible(false);
			}
				
		}
		 public void mouseEntered (MouseEvent e){} //unused mouselistener methods
		 public void mouseExited (MouseEvent e){}
		 public void mouseReleased(MouseEvent e){}
		 public void mousePressed(MouseEvent e){}
	}
}
class game extends JFrame //frame for the game panel
{
    static JFrame gameFrame;
   
    public game(int num) //constructor of the class game; creates the frame
    {
   	 gameFrame = new JFrame ("ImmunoDefense Game");
   	 gameFrame.setSize( 800, 800 );
   	 gameFrame.setLocation ( 50, 50 );
   	 gameFrame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
   	 gameFrame.setResizable( true );
   	 gamePan banana = new gamePan (num);
   	 gameFrame.add(banana); //adds the game panel onto the game frame
   	 gameFrame.setVisible( true );
    }
}
    
class gamePan extends JPanel implements MouseListener, MouseMotionListener //the actual game panel
{
    Image path, brain, coin, baso, neutro, macro, bacteria;
    Color aqua, bgColor, bloodVesselColor;
    Font smolFont, largeFont;
    int lives, money, xMouse, yMouse, level;
    Ellipse2D basoArea, neutroArea, macroArea; 
    int xBaso, yBaso, xBac, yBac, xNeutro, yNeutro, xMacro, yMacro, bacteriaDistance, bacteriaHealth, numBacteria, startingBacHealth;
    boolean basoDragging, neutroDragging, macroDragging, moveable, firstTime, notEnoughMoney, startYesNo, bacteriaDead, inRange, levelComplete, gameEnd;
    Rectangle startRect, exitRect, menuRect, menuBar;
    Timer bacteriaTimer, basophilTimer;
    final int bacArrayNum = 20;
    final int [][] basoCoordinates = new int [bacArrayNum][2];		//arrays containing the xy coordinates of the WBCs
    final int [][] neutroCoordinates = new int [bacArrayNum][2];
    int [] neutroLives = new int[bacArrayNum];
    final int [][] macroCoordinates = new int [bacArrayNum][2];
    int [][] bacteriaCoordinates = new int [bacArrayNum][2];		// array containing the xy coordinates of the bacteria invaders
    int [] bacHealthInt = new int[bacArrayNum];						//array with the amount of health left for each of the bacteria
    double [] bacHealthDouble = new double[bacArrayNum];
    boolean [] bacDead = new boolean [bacArrayNum];					//boolean array for whether or not the bacteria is dead
    int bcx, ncx, mcx;
    int first, addMoney, deathReward, lastAlive;
    double bacteriaHealthDouble;
    int tracknum;
    
    public gamePan(int num) //constructor for the game panel
    {
    	path = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/gamepath.jpg").getImage();
    	brain = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/brain.jpeg").getImage();
    	coin = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/actualcoin.gif").getImage();
    	baso = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/baso.gif").getImage();
    	neutro = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/neutro.gif").getImage();
    	macro = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/macro.gif").getImage();
    	macro = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/macro.gif").getImage();
    	bacteria = new ImageIcon("/Users/audreycui01/Documents/workspace/ImmunoDefense/src/ImmunoDefense_Images/billybacteria.gif").getImage();

    	basoDragging = neutroDragging = macroDragging = false;
    	
    	xBaso = 595; //XY coordinates of the basophil
    	yBaso = 210;
    	bcx=ncx=mcx=0; 
    	xNeutro = 595; //XY coordinates of the neutrophil
    	yNeutro = 290;
    	xMacro = 595;
    	yMacro = 370;
    	xBac =-100; //XY coordinates of the bacteria invader
    	yBac=-100;
    	bacteriaDistance = 0;
    	bacteriaHealth= 30;
    	bacteriaHealthDouble=30;
    	tracknum=num;
    	
   	 	aqua = new Color(200, 200, 220);
   	 	bgColor = new Color(255, 192, 200);
   	 	bloodVesselColor = new Color(192, 5, 23);
   	 	smolFont = new Font("Serif", Font.BOLD, 20);
   	 	largeFont = new Font("Serif", Font.BOLD, 40);
   	 	exitRect = new Rectangle(450, 45, 120, 35);
   	 	menuRect = new Rectangle(450, 5, 120, 35);
   	 	menuBar = new Rectangle(585, 0, 220, 590);
   	 	
   	 	deathReward=20;
   	 	level = 0;
   	 	lives = 10;
   	 	if (tracknum==1)money = 1200; //money starts at 1200 for track 1
   	 	else if (tracknum==2) money= 1800; //money starts at 1800 for track 2
   	 	numBacteria =10;
   	 	moveable = false; 
   	 	notEnoughMoney=false;
   	 	startYesNo = false;
   	 	bacteriaDead=false;
   	 	addMoney = 0; 
   	 	inRange = false;
   	 	levelComplete = false; 
   	 	gameEnd = false;
   	 	
   	 	if (tracknum==1) //initializes the xy coordinates of the bacteria
   	 	{
   	 		bacteriaCoordinates[0][0] = 0;
   	 		for (int i=0; i<numBacteria; i++)
   	 		{
   	 			bacteriaCoordinates[i][0]=bacteriaCoordinates[0][0]-60*(i);
   	 			bacteriaCoordinates[i][1]=135;
   	 			bacHealthInt[i]= 30;
   	 			bacHealthDouble[i] = 30;
   	 		}
   	 	}
   	 	else if (tracknum==2)
   	 	{
   	 	bacteriaCoordinates [0][0] =556;
	 		bacteriaCoordinates[(numBacteria/2)][0]=0;
	 		for (int i=0; i<numBacteria; i++)
	 		{
	 	
	 			if (i>=numBacteria/2) 
	 			{
	 				bacteriaCoordinates [i][0] = bacteriaCoordinates[numBacteria/2][0]-60*(i-numBacteria/2);
	 				bacteriaCoordinates [i][1] = 135;
	 			}
	 			else if (i<numBacteria/2)
	 			{
	 				bacteriaCoordinates [i][0] = bacteriaCoordinates [0][0]+60*i;
	 				bacteriaCoordinates [i][1] = 235;
	 			}
	 			
   	 			bacHealthInt[i]=30;
   	 			bacHealthDouble[i]=30;
   	 			//System.out.println(i+" " + bacteriaCoordinates[i][0] + " "+ bacteriaCoordinates[i][1]);
   	 		
   	 		}
   	 	}
   	 	
   	 	bacteriaMover bm = new bacteriaMover(); //timer for the bacteria invaders
    	bacteriaTimer = new Timer(5, bm);
   // 	basophilMover bpm = new basophilMover();
    //	basophilTimer = new Timer(2, bpm);
    	
    	
    	addMouseListener(this);
    	addMouseMotionListener(this);
    }
    
    public void paintComponent (Graphics g) //paintcomponent 
    {
   	 super.paintComponent(g);
   	 
   	 setBackground(bgColor);
   	 g.setColor(bloodVesselColor);
   	 if (tracknum==1)  //paints the first track option
   	 {
   		 g.fillRect(0, 100, 500, 100);
   		 g.fillRect(400, 200, 100, 250);
   		 g.fillRect(100, 350, 400, 100);
   		 g.fillRect(100, 400, 100, 250);
   		 g.fillRect(100, 600, 800, 100);
   	 }
   	 else if (tracknum==2) //paints the second track option
   	 {
   		 g.fillRect(0, 100, 250, 100);
   		 g.fillRect(150, 100, 100, 550);
   		 g.fillRect(150, 600, 300, 100);
   		 g.fillRect(350, 200, 250, 100);
   		 g.fillRect(350, 200, 100, 500);
   		 g.fillRect(350, 600, 460, 100);
   	 }
   	 
   	 g.setColor(aqua);
   	 g.fillRect(585, 0, 220, 590);
   	 g.setColor(Color.gray);
   	 g.fillRect (585, 100, 220, 20);
   	 
   	 g.setFont(smolFont);
   	 g.drawString("Welcome to", 595, 20);
   	 g.setFont(largeFont);
   	 g.drawString("Immuno-", 595, 50);
   	 g.drawString("Defense!", 595, 90);
   	 g.drawImage(coin, 595, 140, 40, 40, null);
   	 g.setFont(smolFont);
   	 g.drawString("Money: "+money, 650, 165); //draws how much money left
   	 
   	 g.drawImage(baso, 595, 210, 60, 60, null); //draws each of the WBCs and their costs
   	 g.drawString("Basophil", 675, 230);
   	 g.drawString("Cost: 600", 675, 255);
   	 g.drawImage(neutro, 595, 290, 60, 60, null);
   	 g.drawString("Neutrophil", 675, 310);
   	 g.drawString("Cost: 200", 675, 335);
   	 g.drawImage(macro, 595, 370, 65, 65, null);
   	 g.drawString("Macrophage", 675, 390);
   	 g.drawString("Cost: 1000", 675, 415);
   	 
   	 g.fillRect (585, 455, 220, 20);
   	 g.setFont(largeFont);
   	 g.drawString("Lives: " + lives, 595, 530); //number of lives left (starts at 10 lives)
   	
  

   	 if (moveable==false)  //ensures that the immune cells cannot be moved after they are put down on the track
   		 {
   		 	basoArea = new Ellipse2D.Double(595, 210, 60, 60);
   		 	neutroArea = new Ellipse2D.Double(595, 290, 60, 60);
   		 	macroArea = new Ellipse2D.Double(595, 370, 65, 65);
   		 }
   	 else 
   		 {
   		 	basoArea = new Ellipse2D.Double(xBaso, yBaso, 60, 60);
   		 	neutroArea = new Ellipse2D.Double(xNeutro, yNeutro, 60, 60);
   		 	macroArea = new Ellipse2D.Double(xMacro, yMacro, 65, 65);
   		 }
   	 
   	 
   	 int bleb=0;
   	 int b=0;
   	 int n=0;
   	 int m=0;
   	    	
    int k =-1;
   
   	 	//paints all of the immune cells that were put on the track
   		 do {
   			 	k = -1;
   			 	inRange=false;
   			 	bleb = basoCoordinates[b][0];
   			 	g.drawImage(baso, bleb, basoCoordinates[b][1], 60, 60, null);   
   			 	//System.out.println(bleb + ", " + basoCoordinates [b][1]);
   	   			
   			 	while(inRange == false && startYesNo == true)
   			 	{
   			 		k++;
   			 		if (k==numBacteria-1) 
   			 		{
   			 			inRange=true;
   			 			//calculates the distance between the immune cell and the bacteria
   	   			 		bacteriaDistance = (int)Math.sqrt(Math.pow(basoCoordinates[b][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(basoCoordinates[b][1]+30-(bacteriaCoordinates[k][1]+15), 2));
   			 		}
   			 		else{
   			 		bacteriaDistance = (int)Math.sqrt(Math.pow(basoCoordinates[b][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(basoCoordinates[b][1]+30-(bacteriaCoordinates[k][1]+15), 2));
   			 		if (bacteriaDistance <100) inRange = true;
   			 		}
   			 	}
   			 	
   			 if (bacteriaDistance>0 && bacteriaDistance<100 && bacDead[k]==false && levelComplete ==false) 
    			{
   				 	//if the bacteria is within the immune cell's range, the immune cell is able to "extend a psuedopod" towards the bacteria. (represents phagocytosis) 
   				 	//this lowers the bacteria's health
    				if (bleb!=0) g.drawLine(bleb+30, basoCoordinates[b][1]+30, bacteriaCoordinates[k][0]+15, bacteriaCoordinates[k][1]+15);
    				bacHealthDouble[k]-=0.25;
    				bacHealthInt[k]= (int)bacHealthDouble[k]; //bacteriaHealthDouble, which is a double, is casted into an int
    				if (bacHealthInt[k]==0)			//if the bacteria dies (health = 0), then the player earns 100 monetary units
    					{
    						bacDead[k]=true;
    						money+=deathReward;
    					}
    			}
   			 	b++;
   		 	} while (bleb!=0);
   		 
   		 g.setColor(Color.MAGENTA);
   		 bleb =0;
   		 
   		g.setFont(smolFont);
   		do { 
   			k=-1;
   			inRange = false;
      		 bleb = neutroCoordinates[n][0];
      		if (neutroLives[n]<10)
      		{
      			g.drawImage(neutro, bleb, neutroCoordinates[n][1], 60, 60, null);
      			g.drawString(""+(10-neutroLives[n]), bleb+10, neutroCoordinates[n][1]-5);
      		}
      		 
      		while(inRange == false && startYesNo == true)
			 	{
      				k++;
      				if (k==numBacteria-1) 
      					{
      						inRange = true;
      				 		bacteriaDistance = (int)Math.sqrt(Math.pow(neutroCoordinates[n][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(neutroCoordinates[n][1]+30-(bacteriaCoordinates[k][1]+15), 2));
      					}
      				else {
			 		bacteriaDistance = (int)Math.sqrt(Math.pow(neutroCoordinates[n][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(neutroCoordinates[n][1]+30-(bacteriaCoordinates[k][1]+15), 2));
			 		if (bacteriaDistance <75) inRange = true;
      				}
			 	}
      		
  			 if (bacteriaDistance>0 && bacteriaDistance<75 && bacDead[k]==false && neutroLives[n]<10 && startYesNo==true && levelComplete==false) 
   			{
   				if (bleb!=0) g.drawLine(bleb+30, neutroCoordinates[n][1]+30, bacteriaCoordinates[k][0]+15, bacteriaCoordinates[k][1]+15);
   				bacHealthDouble[k]-=0.1;
				bacHealthInt[k]= (int)bacHealthDouble[k];
				if (bacHealthInt[k]==0) 
					{
						bacDead[k]=true;
						money+=deathReward;
						neutroLives[n]++;
					}
   			}
      		 n++;
      	 } while (bleb!=0);
   		
   		bleb =1;
   		
   		g.setColor(Color.blue);
   		do {
   			inRange = false;
   	   		k=-1;
     		 bleb = macroCoordinates[m][0];
     		 g.drawImage(macro, bleb, macroCoordinates[m][1], 65, 65, null);
     		 
     		while(inRange == false&&startYesNo==true)
		 	{
  				k++;
  				if (k==numBacteria-1) 
  					{
  						inRange = true;
  				 		bacteriaDistance = (int)Math.sqrt(Math.pow(macroCoordinates[m][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(macroCoordinates[m][1]+30-(bacteriaCoordinates[k][1]+15), 2));
  					}
  				else 
  				{
		 		bacteriaDistance = (int)Math.sqrt(Math.pow(macroCoordinates[m][0]+30-(bacteriaCoordinates[k][0]+15), 2)+Math.pow(macroCoordinates[m][1]+30-(bacteriaCoordinates[k][1]+15), 2));
		 		if (bacteriaDistance <150) inRange = true;
  				}
		 	}     		//System.out.println(macroCoordinates[m][0] + ", " +macroCoordinates[m][1]);

       		if (bacteriaDistance>0 && bacteriaDistance<150 && bacDead[k]==false && macroCoordinates[m][0]!=0 && levelComplete==false) 
   			{
   				if (bleb!=0) g.drawLine(bleb+30, macroCoordinates[m][1]+30, bacteriaCoordinates[k][0]+15, bacteriaCoordinates[k][1]+15);
   				bacHealthDouble[k]-=0.4;
				bacHealthInt[k]= (int)bacHealthDouble[k];
				if (bacHealthInt[k]==0)
					{
						bacDead[k]=true;
						money+=deathReward;
					}
   			}
     		 m++;
         	//System.out.println("xyMacro: " + xMacro + ", "+yMacro);

     	 } while (bleb!=0);
   		
   		int t=0;
   		while(bacDead[t]==true && startYesNo == true)
   		{
   			if (t==numBacteria-1) 
   				{
   					bacteriaTimer.stop();
   					//marker();
   					levelComplete = true;
   				//	if (startYesNo==true)money+=level+99;
   					startYesNo=false;
   					repaint();
   				}
   			t++;
   		}
   		g.setColor(Color.gray);
   		g.fillRect(0, 0, 180, 70); //when pressed, the bacteria starts moving down the track. 
      	g.setColor(aqua);
      	
      	
      	if (lives ==0)
      	{
      		g.setFont(largeFont);
      		bacteriaTimer.stop();
      		g.drawString("You died.", 10, 50);
      		gameEnd = true;
      		
      	}
      	else if (levelComplete==false && level !=0)
      		{
      			g.setFont(largeFont);
      			 g.drawString("Level " + level, 20, 50);
      		}
      	else 
      		{	
      			g.setFont(smolFont);
      			if (level==0) g.drawString("Start Level 1!", 20, 40);
      			else if (level==10) 
      				{
      					g.drawString("You win! :D", 20, 40);
      					gameEnd = true;
      				}
      			else 
      			{
      				g.drawString("Next Level!", 20, 40); 
      				g.setColor(Color.gray);
      				g.drawString((level-1)*10+100 +" Money Awarded", 200, 40);
      				if (addMoney==0) 
      				{
      					money+= (level-1)*10+100;
      					addMoney++;
      				}
      			}
      		}
       	g.setColor(Color.gray);
       	startRect = new Rectangle (0,0,180,70); 
       	
       	
       	if (startYesNo==true) //draws out the bacteria and each bacterium's health bar
       	{
       		if (tracknum==1)
       		{
       			for (int i=0; i<numBacteria; i++)
       			{
       				if (bacDead[i]==false && bacteriaCoordinates[i][0]>0)
       				{
       				
       					g.drawImage(bacteria, bacteriaCoordinates[i][0], bacteriaCoordinates[i][1], 30, 30, null);
       					g.setColor(Color.WHITE);
       					g.fillRect(bacteriaCoordinates[i][0], bacteriaCoordinates[i][1]-7, 25+5*level, 4);
       					g.setColor(Color.GRAY);
       					g.fillRect(bacteriaCoordinates[i][0], bacteriaCoordinates[i][1]-7, bacHealthInt[i], 4);
       					g.setColor(aqua);
       				}
       			}
       		}
       		
       		else if (tracknum==2)
       		{
       			for (int i=0; i<numBacteria; i++)
       			{
       				if (bacDead[i]==false && bacteriaCoordinates[i][0]>0 && (bacteriaCoordinates[i][0]<556 || (bacteriaCoordinates[i][0]>555 && bacteriaCoordinates [i][1]>400)))
       				{
       				
       					g.drawImage(bacteria, bacteriaCoordinates[i][0], bacteriaCoordinates[i][1], 30, 30, null);
       					g.setColor(Color.WHITE);
       					g.fillRect(bacteriaCoordinates[i][0], bacteriaCoordinates[i][1]-7, 25+5*level, 4);
       					g.setColor(Color.GRAY);
       					g.fillRect(bacteriaCoordinates[i][0], bacteriaCoordinates[i][1]-7, bacHealthInt[i], 4);
       					g.setColor(aqua);
       				}
       			}
       		}
       	}
       	
       	g.setColor(Color.gray);
       	g.fillRect(450, 5, 120, 35);		//main menu button
       	g.fillRect(450, 45, 120, 35);		//exit button
       	g.setColor(aqua);
       	g.setFont(smolFont);
       	g.drawString("Main Menu", 458, 28);
       	g.drawString("Exit", 495, 68);
       	
    }
    
    class bacteriaMover implements ActionListener { //animates the bacteria
        public void actionPerformed(ActionEvent e) {
        
        if (tracknum==1)
        {
        	//System.out.println(bacteriaCoordinates[numBacteria-1]);
        	for (int i=0; i<numBacteria; i++)
            {
              if (bacteriaCoordinates[i][0]<=435 && bacteriaCoordinates[i][1] == 135) bacteriaCoordinates[i][0]++;	//allows the bacteria to make turns along the track
              else if (bacteriaCoordinates[i][1]<=390 && bacteriaCoordinates[i][0]==436)  bacteriaCoordinates[i][1]++;
              else if (bacteriaCoordinates[i][0]>=135 && bacteriaCoordinates[i][1]==391) bacteriaCoordinates[i][0]--;
              else if (bacteriaCoordinates[i][1]<=635 && bacteriaCoordinates[i][0]==134) bacteriaCoordinates[i][1]++;
              else if (bacteriaCoordinates[i][0]<=800) 
            	  {
            	  bacteriaCoordinates[i][0]++;
            	  	if (bacteriaCoordinates[i][0]==800 )
            	  	{
            	  		if (bacDead[i] == false)lives--;
            	  		if (bacteriaCoordinates[numBacteria-1][0]==800) 
            	  			{
            	  				//if the last bacteria makes it to the end of the track and there are still lives left, the level ends
            	  				levelComplete=true;
            	  				startYesNo = false;
            	  				repaint();
            	  				money +=(level-1)*10+100;
            	  				bacteriaTimer.stop();
            	  				
            	  			}
            	  	}
            	  }
            }
        }
        	
        else if (tracknum==2)
        {
        	//System.out.println(bacteriaCoordinates[0][0]+" "+bacteriaCoordinates[0][1]);
        	for (int i=0; i<numBacteria; i++)
            {
        		
        		if (i>= (numBacteria/2) /*|| (numBacteria%2==0 && i==numBacteria-1)*/)
        		{
        			 if (bacteriaCoordinates[i][0]<=185 && bacteriaCoordinates[i][1] == 135) bacteriaCoordinates[i][0]++;	//allows the bacteria to make turns along the track
                     else if (bacteriaCoordinates[i][1]<=635 && bacteriaCoordinates[i][0]==186)  bacteriaCoordinates[i][1]++;
        		}
        		else if (i<(numBacteria/2))
        		{
        			if (bacteriaCoordinates[i][0]>=385 && bacteriaCoordinates[i][1] == 235) bacteriaCoordinates[i][0]--;	//allows the bacteria to make turns along the track
                    else if (bacteriaCoordinates[i][1]<=635 && bacteriaCoordinates[i][0]==384) bacteriaCoordinates[i][1]++;
        		}
        		
        		if (bacteriaCoordinates[i][1]==636)
        		{
        			 bacteriaCoordinates[i][0]++;
             	  	if (bacteriaCoordinates[i][0]==800)
             	  	{
             	  		if (bacDead[i]==false)lives--;
             	  		if (bacteriaCoordinates[numBacteria-1][0]==800) 
             	  			{
             	  				//if the last bacteria makes it to the end of the track and there are still lives left, the level ends
             	  				levelComplete=true;
             	  				startYesNo = false;
             	  				repaint();
             	  				money +=(level-1)*10+100;
             	  				addMoney=1;
             	  				bacteriaTimer.stop();
             	  				
             	  			}
             	  	}
        		}
    
        	
            }
        }
            repaint();
        }
    }
    
    public void newLevel() //resets the bacteria's health & position and starts the next level
    {
    	level++;
		numBacteria = level+9; 
		//System.out.println(numBacteria);
		bacteriaCoordinates[0][0] = 0;
		if (tracknum==1) 	//if the user had picked the first track, all of the bacteria start from the left
   	 	{
   	 		bacteriaCoordinates[0][0] = 0;
   	 		for (int i=0; i<numBacteria; i++)
   	 		{
   	 			bacteriaCoordinates[i][0]=bacteriaCoordinates[0][0]-60*(i);
   	 			bacteriaCoordinates[i][1]=135;
   	 			bacHealthInt[i]= 30+5*(level-1);
   	 			bacHealthDouble[i] = 30+5*(level-1);
   	 			bacDead[i]=false;
   	 		}
   	 	}
   	 	else if (tracknum==2) 	//if the user had picked the second track, half the bacteria start from the left, half start from the right
   	 	{
   	 		bacteriaCoordinates [0][0] =556;
   	 		bacteriaCoordinates[(numBacteria/2)][0]=0;
   	 		for (int i=0; i<numBacteria; i++)
   	 		{
   	 	
   	 			if (i>=numBacteria/2) 
   	 			{
   	 				bacteriaCoordinates [i][0] = bacteriaCoordinates[numBacteria/2][0]-60*(i-numBacteria/2);
   	 				bacteriaCoordinates [i][1] = 135;
   	 			}
   	 			else if (i<numBacteria/2)
   	 			{
   	 				bacteriaCoordinates [i][0] = bacteriaCoordinates [0][0]+60*i;
   	 				bacteriaCoordinates [i][1] = 235;
   	 			}
   	 			bacHealthInt[i]= 25+5*(level);
	 			bacHealthDouble[i] = 25+5*(level);
	 			bacDead[i]=false;
   	 			//System.out.println(i+" " + bacteriaCoordinates[i][0] + " "+ bacteriaCoordinates[i][1]);
   	 		
   	 		}
   	 	}
		
		bacteriaTimer.start();
    }
   
    public void mouseMoved(MouseEvent e) //called when the mouse is moved
    {
    	xMouse = e.getX(); //gets xy coordinates of the mouse
    	yMouse = e.getY();
    	repaint();
    }
  
    public void mousePressed(MouseEvent e) //called when the mouse is pressed
    {
    	xMouse = e.getX();
    	yMouse = e.getY();
    	if (basoArea.contains(xMouse, yMouse) && money>=600) basoDragging = true; 
    	else if (neutroArea.contains(xMouse, yMouse) && money>=200) neutroDragging = true;
    	else if (macroArea.contains(xMouse, yMouse) && money>=1000) macroDragging = true;    	   	
    	repaint();
    }
    
    
    public void mouseDragged(MouseEvent e) //called when the mouse is dragged
    {
    	moveable=true;
    	if (basoDragging==true)
    	{
    		xBaso = e.getX()-30;
    		yBaso = e.getY()-30;
    		xMouse = e.getX();
        	yMouse = e.getY();
    	}
    	else if (neutroDragging==true)
    	{
    		xNeutro = e.getX()-30;
    		yNeutro = e.getY()-30;
    		xMouse = e.getX();
        	yMouse = e.getY();
    	}
    	else if (macroDragging==true)
    	{
    		xMacro = e.getX()-30;
    		yMacro = e.getY()-30;
    		xMouse = e.getX();
        	yMouse = e.getY();
        	//System.out.println("xyMacro: " + xMacro + ", "+yMacro);
    	}
		repaint();
    }
   
    public void mouseClicked(MouseEvent evt) //called when the mouse is clicked
    {
    	if (startRect.contains(xMouse, yMouse) && gameEnd == false) //if the user clicked the start rectangle, the bacteria starts moving across the track
    		{
    			if (level==0 || levelComplete == true)
    			{
    				startYesNo=true;
    				levelComplete = false;
    				addMoney= 0;
    				newLevel();
    			}
    			
    		}
    	else if (exitRect.contains(xMouse, yMouse)) System.exit(0); //exits the game
    	else if (menuRect.contains(xMouse, yMouse)) 
    	{
    		ImmunoDefense yam = new ImmunoDefense(); //returns to the main menu by calling its frame's constructor
    		game.gameFrame.setVisible(false);
    		
    	}
    }
    

    public void mouseReleased(MouseEvent evt)  //called when the mouse is released
    {
    	basoDragging = neutroDragging = macroDragging = false;
    	
    	if (moveable==true && (menuBar.contains(xMouse+30, yMouse)==false) ){
    	if (basoArea.contains(xMouse, yMouse) && money >= 600) //when an immune cell is added to the track, it becomes immovable
    		{									// and its xy coordinates are added to the array basoCoordinates
    			basoCoordinates [bcx][0] = xBaso;
    			basoCoordinates [bcx][1] = yBaso;
    			bcx++;
    			money-=600;					//money is subtracted
    		}
    	
    	else if (neutroArea.contains (xMouse, yMouse) && money>=200)
    	{
    		neutroCoordinates[ncx][0] = xNeutro; //xy coordinates of neutrophils are added to an array
    		neutroCoordinates[ncx][1] = yNeutro;
    		ncx++;
    		money-=200;			//money is subtracted
    	}

   
    	else if (macroArea.contains (xMouse, yMouse) && money >= 1000)
    	{
        	//System.out.println("xyMacro adf: " + xMacro + ", "+yMacro);
        	//marker();
    		macroCoordinates[mcx][0] = xMacro; //xy coordinates of macrophages are added to the array
    		macroCoordinates[mcx][1] = yMacro;
    		mcx++;
    		money-=1000; //money is subtracted
    	}

    	}
    	moveable = false;
    } 
    
    public void mouseEntered(MouseEvent e){ }  //unused mouselistener methods 
    
    public void mouseExited(MouseEvent e) { }
    
    public void marker() //prints out "here" (for debugging purposes)
    {
    	System.out.println("here");
    }
}
 

