package typeosaurusRexRun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.function.Consumer;

public class JurassicBackground implements GameDrawable {
	
	private BufferedImage backg;
	int groundLevel;
	
	public JurassicBackground(int sizex, int sizey, int groundLevel) {
		backg = new BufferedImage(sizex, sizey, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = backg.createGraphics();
		
		g2d.setColor(new Color(100, 100, 225));
		g2d.fillRect(0, 0, sizex, groundLevel);
		
		g2d.setColor(new Color(200, 150, 100));
		g2d.fillRect(0, groundLevel, sizex, sizey);
		
		
		this.groundLevel = groundLevel;
	}
			
			
	public Consumer<Graphics> drawConsumer() {
		return g -> {
			g.drawImage(backg, 0, 0, null);
			drawTree(400, groundLevel, (Graphics2D)g);
		};
	}
	
	void drawTree(int x, int y, Graphics2D g2d) {
		
		g2d.setColor(new Color(100, 100, 0));
		
		g2d.drawLine(x, y, x, y-48);
		g2d.setColor(Color.green.darker().darker().darker());
		for(int i = 0; i<20; i++) {
			g2d.drawLine(x-i, y-48+2*i, x+i, y-48+2*i);
		} 
		
	}

}
