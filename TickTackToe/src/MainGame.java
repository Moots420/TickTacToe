import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainGame {
private keyManager keyM;
private Handler handler;
private Rectangle[] slots = new Rectangle[9];
private int currentPlayer;
private int[] slotState = new int[9];
private int mouseX, mouseY;
private Rectangle mousePosition;
private boolean gameOver, tieGame;
private Font font16,font20;;
//private ArrayList<Rectangle> slots = new ArrayList<>();
public MainGame(keyManager keyM, Handler handler) {
	font16 =FontLoader.loadFont("pixel.ttf", 16);
	font20 =FontLoader.loadFont("pixel.ttf", 20);
	this.keyM = keyM;
	this.handler = handler;
	gameOver = false;
	setSlots();
	newGame();
	
	
}
public void tick() {
	if(gameOver == true) {
	//	System.out.println("GAMEOVER Press SPACEBAR");
		if(handler.getKeyMngr().space) {
		newGame();
		}
		
	}
	
if(handler.getMouseMngr().leftClick) {
	if(!gameOver) {
	checkSlot();
	}
	checkGameOver();
}
mouseX =  MouseInfo.getPointerInfo().getLocation().x - handler.getDisp().getFrame().getX()-8;
mouseY =  MouseInfo.getPointerInfo().getLocation().y - handler.getDisp().getFrame().getY()-32;


}

public void newGame() {
	gameOver = false;
	tieGame = false;
    for (int i = 0; i <slotState.length; i++){
   	 slotState[i] = 0;
    }
    currentPlayer = handler.getRandomNumber(1, 2);
    System.out.println("It's player"+currentPlayer+"'s Turn");
	
	
}

public void setSlots() {
	slots[0] = new Rectangle(0,0,200,200);
	slots[1] = new Rectangle(200,0,200,200);
	slots[2] = new Rectangle(400,0,200,200);
	slots[3] = new Rectangle(0,200,200,200);
	slots[4] = new Rectangle(200,200,200,200);
	slots[5] = new Rectangle(400,200,200,200);
	slots[6] = new Rectangle(0,400,200,200);
	slots[7] = new Rectangle(200,400,200,200);
	slots[8] = new Rectangle(400,400,200,200);
}
public void checkSlot() {
	
		Rectangle mousePosition = new Rectangle(mouseX,mouseY,10,10);
	
	for (int i = 0; i<slots.length; i++) {
		if(slots[i].intersects(mousePosition)) {
			if(slotState[i] == 0) {
		slotState[i] = currentPlayer;
		changeSlot(i);
			}

		}
		
	}
	
	
}
public void checkGameOver(){
	
	if(slotState[0] == slotState[1] && slotState[1] == slotState[2]&& slotState[0] != 0) {
		System.out.println("Player"+slotState[0]+ "Wins");
		gameOver = true;
		
	}else if(slotState[3] == slotState[4] && slotState[4] == slotState[5]&& slotState[3] != 0) {
		System.out.println("Player"+slotState[3]+ "Wins");
		gameOver = true;
	}else if(slotState[6] == slotState[7] &&slotState[7] == slotState[8]&& slotState[6] != 0) {
		System.out.println("Player"+slotState[6]+ "Wins");
		gameOver = true;
		
	}else if(slotState[0] == slotState[4] &&  slotState[4] == slotState[8]&& slotState[0] != 0) {
		System.out.println("Player"+slotState[0]+ "Wins");
		gameOver = true;
	}else if(slotState[2] == slotState[4] && slotState[4] == slotState[6]&& slotState[2] != 0) {
		System.out.println("Player"+slotState[2]+ "Wins");
		gameOver = true;
	}else if(slotState[0] == slotState[3] && slotState[3] == slotState[6]&& slotState[0] != 0) {
		System.out.println("Player"+slotState[2]+ "Wins");
		gameOver = true;
	}else if(slotState[1] == slotState[4] && slotState[4] == slotState[7]&& slotState[1] != 0) {
		System.out.println("Player"+slotState[2]+ "Wins");
		gameOver = true;
	}else if(slotState[2] == slotState[5] && slotState[5] == slotState[8]&& slotState[2] != 0) {
		System.out.println("Player"+slotState[2]+ "Wins");
		gameOver = true;
		
	}else if(
		slotState[0] != 0 &&
		slotState[1] != 0 &&
		slotState[2] != 0 &&
		slotState[3] != 0 &&
		slotState[4] != 0 &&
		slotState[5] != 0 &&
		slotState[6] != 0 &&
		slotState[7] != 0 &&
		slotState[8] != 0 
		)
		{
		System.out.println("It's a Draw");
	    gameOver = true;
	    tieGame = true;
	
}
	
}

public void changeSlot(int i){
	
	if(slotState[i] != 0) {
		
		slotState[i] = currentPlayer;
		if(currentPlayer == 1) {
			currentPlayer = 2;
			System.out.println("It's player"+currentPlayer+"'s Turn");
		}else if(currentPlayer == 2) {
			currentPlayer = 1;
			System.out.println("It's player"+currentPlayer+"'s Turn");
		}
		
		
	}
	
}

	
	public void render(Graphics g) {
		
		Text.drawString(g, "Player"+currentPlayer, 300, 25, true, Color.BLACK, font16);
		if(gameOver == true) {
			g.setColor(new Color(150,150,200));
			g.fillRect(0, 200, 600, 200);
			if(!tieGame) {
			Text.drawString(g, "Player"+currentPlayer+" Wins!",300,250, true, Color.BLACK, font20);
			} else {
				Text.drawString(g, "IT WAS A TIE!",300,250, true, Color.BLACK, font20);
				
			
			}
			Text.drawString(g, "GAME OVER PRESS SPACE",300,300, true, Color.RED, font20);
		}
		
		//Draw Board
		g.fillRect(mouseX, mouseY, 10, 10);
		
		for (int i = 0;i < slots.length; i++) {
			 if ( i % 2 == 0 ) {
		g.setColor(Color.GREEN);
			 } else {
				 g.setColor(Color.BLUE);
			 }
		if(slotState[i] == 1) {
			g.setColor(Color.RED);
			g.drawLine(slots[i].x, slots[i].y,slots[i].x+200 , slots[i].y+200);
			g.drawLine(slots[i].x+200, slots[i].y,slots[i].x , slots[i].y+200);
		}else if(slotState[i] == 2) {
			g.setColor(Color.GREEN);
			g.drawOval(slots[i].x,slots[i].y, 200, 200);
			
		}
		//g.fillRect(slots[i].x, slots[i].y, slots[i].width, slots[i].height);
			
		}
		g.setColor(Color.BLACK);
		g.drawLine(200,0, 200, 600);
		g.drawLine(400,0, 400, 600);
		g.drawLine(0,200, 600, 200);
		g.drawLine(0,400, 600, 400);
		
	}
	
}
