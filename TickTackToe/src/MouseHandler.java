import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener{
public boolean leftClick,justPressed;
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON1 && leftClick == false) {
	    	   leftClick = true;
	    	  
	       }	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON1) {
	    	   leftClick = false;
	    	 
	    	
	       }	
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
