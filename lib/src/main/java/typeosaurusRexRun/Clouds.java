package typeosaurusRexRun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import lombok.Getter;

public class Clouds implements GameDrawable {
	
	private List<Cloud> clouds;
	
	public Clouds() {
		clouds = new ArrayList<Clouds.Cloud>();
		
		for (int i = 0; i < 15; i++) {
			clouds.add(new Cloud());
		}
	}

	@Override
	public Consumer<Graphics> drawConsumer() {
		// TODO Auto-generated method stub
		return g -> {
			clouds.forEach(cl -> g.drawImage(
					cl.getBimg(), (int)cl.getPx(), cl.getPy(), 
					cl.getBimg().getWidth(), cl.getBimg().getHeight(), null));
		};
	}
	
	public void update() {
		clouds.forEach(c -> c.update());
	}
	
	@Getter
	class Cloud {
		double px;
		int py;
		
		double speed = 0;
		
		BufferedImage bimg;
		
		private Cloud() {
			px = new Random().nextInt(800);
			py = new Random().nextInt(350);
			
			speed = 0.1 + py/2000.0;
			
			bimg = new BufferedImage(48, 32, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bimg.createGraphics();
			g2d.setColor(new Color(0, 0, 0, 0));
			g2d.fillRect(0, 0, bimg.getWidth(), bimg.getHeight());
			
			g2d.setColor(new Color(255, 255, 255, 35));
			
			for(int i=0; i<15; i++) {
				int lobesize = new Random().nextInt(30);
				g2d.fillRect(new Random().nextInt(bimg.getWidth()-lobesize), 
						new Random().nextInt(bimg.getHeight()-lobesize),
						lobesize, lobesize);
			}
			
		}
		
		void update() {
			px -= speed;
			
			if (px < -100) {
				px = 800;
			}
		}
		
	}

}
