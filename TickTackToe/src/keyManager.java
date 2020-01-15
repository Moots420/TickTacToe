

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyManager implements KeyListener {
private boolean[] keys, justPressed,cantPress;
public boolean up,down,left,right,shift,eKey,f,space,e;

	public keyManager() {

		keys = new boolean[256];
		cantPress = new boolean[keys.length];
		justPressed = new boolean[keys.length];
		
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode ==  0 || keyCode == keys.length)
		return false;
		
		return justPressed[keyCode];
		}
	
	
public void tick() {
	
	for(int i =0; i<keys.length; i++) {
		if(cantPress[i] && !keys[i]) {
			cantPress[i] = false;
		}else if(justPressed[i]) {
			cantPress[i] = true;
			justPressed[i] = false;
		}
		if(!cantPress[i] && keys[i]) {
			justPressed[i] = true;
					
		}
	
	}

	e = keys[KeyEvent.VK_E];
	f = keys[KeyEvent.VK_F];
	up = keys[KeyEvent.VK_W];
	down = keys[KeyEvent.VK_S];
	left = keys[KeyEvent.VK_A];
	right = keys[KeyEvent.VK_D];
	shift = keys[KeyEvent.VK_SHIFT];
	eKey = keys[KeyEvent.VK_E];
	space = keys[KeyEvent.VK_SPACE];
	
}


	public boolean[] getJustPressed(KeyEvent e) {
	return justPressed;
}
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	
	}


	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}

