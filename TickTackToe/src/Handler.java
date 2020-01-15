import java.util.Random;

public class Handler {
private keyManager keyMngr;
private Engine engine;
private MainGame Game;
private Display disp;
private MouseHandler mouseMngr;
public Handler() {
	
}

public MouseHandler getMouseMngr() {
	return mouseMngr;
}

public void setMouseMngr(MouseHandler mouseMngr) {
	this.mouseMngr = mouseMngr;
}
public int getRandomNumber(int min, int max) {
	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt(max-min + 1) + min;
	
	
}

//Getters and Setters
public Display getDisp() {
	return disp;
}
public void setDisp(Display disp) {
	this.disp = disp;
}
public Engine getEngine() {
	return engine;
}
public void setEngine(Engine engine) {
	this.engine = engine;
}

public MainGame getGame() {
	return Game;
}
public void setGame(MainGame game) {
	Game = game;
}
public keyManager getKeyMngr() {
	return keyMngr;
}
public void setKeyMngr(keyManager keyMngr) {
	this.keyMngr = keyMngr;
}

}
