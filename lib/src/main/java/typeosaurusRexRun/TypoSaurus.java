package typeosaurusRexRun;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.function.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;

import lombok.*;

@AllArgsConstructor
public class TypoSaurus implements Dino {
	
	@Getter
	double x = 100;
	double speed = 0.05;
	
	BufferedImage img = null;
	
	public TypoSaurus() {
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
		x+=speed;
		speed += 0.0001;
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
