package typeosaurusRexRun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.function.Consumer;

public class JurassicBackground {
	
	private BufferedImage backg;
	
	public JurassicBackground(int sizex, int sizey) {
		backg = new BufferedImage(sizex, sizey, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = backg.createGraphics();
		
		g2d.setColor(new Color(100, 100, 225));
		g2d.fillRect(0, 0, sizex, sizey-200);
		
		g2d.setColor(new Color(200, 150, 100));
		g2d.fillRect(0, sizey-200, sizex, sizey);
		
	}
			
			
	public Consumer<Graphics> drawConsumer() {
		return g -> g.drawImage(backg, 0, 0, null);
	}

}
