package typeosaurusRexRun;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

import javax.imageio.ImageIO;

import lombok.Getter;

public class IEatYouSaurus implements Dino {
	
	@Getter
	double x = 100, prev_x=100;
	double speed = 0.05;
	int timeelapsed = 0;
	
	BufferedImage img = null;
	
	public IEatYouSaurus() {
		try {
			File file = new File("Dino.png");
			System.out.println(file.getAbsolutePath());
		    img = ImageIO.read(file);
		} catch (IOException e) {
			System.out.print(e);
			
		}
	}

	@Override
	public void move() {
		timeelapsed++;

		if (timeelapsed > 100) {
			
			double delta_x = (x - prev_x)/timeelapsed;
			
			double newspeed = ((800 - x) / 1200) - Math.min(delta_x, 0);
			
			speed = Math.max(0.075, newspeed);
			timeelapsed = 0;
			prev_x = x;
		}

		x += speed;

	}

	@Override
	public void back() {
		x-=5;
	}

	@Override
	public void jumpForward() {
		x+=5;
	}

	@Override
	public Consumer<Graphics> drawConsumer() {
		return graphics -> {
			graphics.drawImage(img, (int)x, 400, img.getWidth(), img.getHeight(), null);
		};
	}

}
