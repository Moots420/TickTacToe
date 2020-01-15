
public class Launcher {

	public static int resX;
	public static int resY;
	public static void main(String[] args) {
	    resX = 600;
	    resY = 600;
	    
		Engine En = new Engine("Game title",(int)resX,(int) resY);
		En.start();
	}
}
